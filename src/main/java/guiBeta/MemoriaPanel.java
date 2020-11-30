package guiBeta;

import configBanco.Conexao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.PhysicalMemory;
import oshi.hardware.VirtualMemory;

public class MemoriaPanel extends SuperVisorJpanel {

    static Conexao config = new Conexao();

    private static final long serialVersionUID = 1L;

    private static final String memoriaFisica = "Memória física";
    private static final String memoriaVirtual = "Memória virtual (Swap)";

    private static final String utilizando = "Utilizando";
    private static final String disponivel = "Disponível";

    public MemoriaPanel(SystemInfo si) {
        super();
        init(si.getHardware().getMemory());
    }

    private void init(GlobalMemory memoria) {
        DefaultPieDataset memFisDados = new DefaultPieDataset();
        DefaultPieDataset memVirtDados = new DefaultPieDataset();
        updateDatasets(memoria, memFisDados, memVirtDados);

        JFreeChart memFis = ChartFactory.createPieChart(memoriaFisica, memFisDados, true, true, false);
        JFreeChart memVirt = ChartFactory.createPieChart(memoriaVirtual, memVirtDados, true, true, false);
        configurePlot(memFis);
        configurePlot(memVirt);
        memFis.setSubtitles(Collections.singletonList(new TextTitle(updatePhysTitle(memoria))));
        memVirt.setSubtitles(Collections.singletonList(new TextTitle(updateVirtTitle(memoria))));

        GridBagConstraints pmConstraints = new GridBagConstraints();
        pmConstraints.weightx = 1d;
        pmConstraints.weighty = 1d;
        pmConstraints.fill = GridBagConstraints.BOTH;
        GridBagConstraints vmConstraints = (GridBagConstraints) pmConstraints.clone();
        vmConstraints.gridx = 1;
        GridBagConstraints textConstraints = new GridBagConstraints();
        textConstraints.gridy = 1;
        textConstraints.gridwidth = 2;
        textConstraints.fill = GridBagConstraints.BOTH;

        JPanel MemoriaPanel = new JPanel();
        MemoriaPanel.setLayout(new GridBagLayout());
        MemoriaPanel.add(new ChartPanel(memFis), pmConstraints);
        MemoriaPanel.add(new ChartPanel(memVirt), vmConstraints);

        JTextArea textArea = new JTextArea(60, 20);
        textArea.setText(updateMemoryText(memoria));
        MemoriaPanel.add(textArea, textConstraints);

        add(MemoriaPanel, BorderLayout.CENTER);

        Timer timer = new Timer(Config.REFRESH_SLOW, e -> {
            updateDatasets(memoria, memFisDados, memVirtDados);
            memFis.setSubtitles(Collections.singletonList(new TextTitle(updatePhysTitle(memoria))));
            memVirt.setSubtitles(Collections.singletonList(new TextTitle(updateVirtTitle(memoria))));
            textArea.setText(updateMemoryText(memoria));
        });
        timer.start();
    }

    private static String updatePhysTitle(GlobalMemory memoria) {
        return memoria.toString();
    }

    private static String updateVirtTitle(GlobalMemory memoria) {
        return memoria.getVirtualMemory().toString();
    }

    private static String updateMemoryText(GlobalMemory memoria) {
        StringBuilder sb = new StringBuilder();
        List<PhysicalMemory> pmList = memoria.getPhysicalMemory();
        for (PhysicalMemory pm : pmList) {
            sb.append('\n').append(pm.toString());
        }
        return sb.toString();
    }

    private static void updateDatasets(GlobalMemory memoria, DefaultPieDataset physMemData,
            DefaultPieDataset virtMemData) {
        physMemData.setValue(utilizando, (double) memoria.getTotal() - memoria.getAvailable());
        physMemData.setValue(disponivel, memoria.getAvailable());

        VirtualMemory memoriaVirtual = memoria.getVirtualMemory();
        virtMemData.setValue(utilizando, memoriaVirtual.getSwapUsed());
        virtMemData.setValue(disponivel, (double) memoriaVirtual.getSwapTotal() - memoriaVirtual.getSwapUsed());

        inserirDadosMemFisica(memoria, physMemData);
//        inserirDadosMemVirtual(memoria, virtMemData);
    }

    private static void configurePlot(JFreeChart grafico) {
        PiePlot plot = (PiePlot) grafico.getPlot();
        plot.setSectionPaint(utilizando, Color.decode("#eb4d4b"));
        plot.setSectionPaint(disponivel, Color.decode("#44bd32"));
        plot.setExplodePercent(utilizando, 0.10);
        plot.setSimpleLabels(true);

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0}: {1} ({2})",
                new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(labelGenerator);
    }

    public static void inserirDadosMemFisica(GlobalMemory memoria, DefaultPieDataset physMemData) {

        
        Double valor = (double) (physMemData.getValue(disponivel)) * 100
                / memoria.getTotal();

        // Coloca o insert em uma String
        String insertSql = String.format("INSERT INTO Registros VALUES (null, null, '%s', '%%', 1, 2);", valor.toString());

        // Conecta no banco e passa o insert como query SQL
        try (Connection connection = new Conexao().getConnection();
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            // Executa o insert
            prepsInsertProduct.execute();

//            System.out.println("Inserção feita com sucesso de memória!\n");
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void inserirDadosMemVirtual(GlobalMemory memoria, DefaultPieDataset virtMemData) {
//
//        // Coloca o insert em uma String
//        String insertSql = String.format("INSERT INTO Registro VALUES "
//                + "('%.1f', '%%', null, 1, 4)",
//                (double) (virtMemData.getValue(disponivel)) * 100
//                / memoria.getVirtualMemory().getSwapTotal());
//
//        // Conecta no banco e passa o insert como query SQL
//        try (Connection connection = DriverManager.getConnection(config.connectionUrl);
//                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {
//
//            // Executa o insert
//            prepsInsertProduct.execute();
//
//            // Confirma a execução
//            System.out.println("Inserção feita com sucesso!\n");
//
//        } // Handle any errors that may have occurred.
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

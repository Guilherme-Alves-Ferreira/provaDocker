package guiBeta;

import configBanco.Conexao;
import static guiBeta.MemoriaPanel.config;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

public class DiscoPanel extends SuperVisorJpanel {

    private static final long serialVersionUID = 1L;

    private static final String utilizando = "Utilizado";
    private static final String disponivel = "Disponível";

    public DiscoPanel(SystemInfo si) {
        super();
        init(si.getOperatingSystem().getFileSystem());
    }

    private void init(FileSystem fs) {
        List<OSFileStore> fileStores = fs.getFileStores();
        DefaultPieDataset[] fsData = new DefaultPieDataset[fileStores.size()];
        JFreeChart[] fsCharts = new JFreeChart[fsData.length];

        JPanel fsPanel = new JPanel();
        fsPanel.setLayout(new GridBagLayout());
        GridBagConstraints fsConstraints = new GridBagConstraints();
        fsConstraints.weightx = 1d;
        fsConstraints.weighty = 1d;
        fsConstraints.fill = GridBagConstraints.BOTH;

        int modBase = (int) (fileStores.size() * (Config.GUI_HEIGHT + Config.GUI_WIDTH)
                / (Config.GUI_WIDTH * Math.sqrt(fileStores.size())));
        for (int i = 0; i < fileStores.size(); i++) {
            fsData[i] = new DefaultPieDataset();
            fsCharts[i] = ChartFactory.createPieChart(null, fsData[i], true, true, false);
            configurePlot(fsCharts[i]);
            fsConstraints.gridx = i % modBase;
            fsConstraints.gridy = i / modBase;
            fsPanel.add(new ChartPanel(fsCharts[i]), fsConstraints);
        }
        updateDatasets(fs, fsData, fsCharts);

        add(fsPanel, BorderLayout.CENTER);

        Timer timer = new Timer(15000, e -> {
            if (!updateDatasets(fs, fsData, fsCharts)) {
                ((Timer) e.getSource()).stop();
                fsPanel.removeAll();
                init(fs);
                fsPanel.revalidate();
                fsPanel.repaint();
            }
        });
        timer.start();
    }

    private static boolean updateDatasets(FileSystem fs, DefaultPieDataset[] fsData, JFreeChart[] fsCharts) {
        List<OSFileStore> fileStores = fs.getFileStores();
        if (fileStores.size() != fsData.length) {
            return false;
        }
        int i = 0;
        for (OSFileStore store : fileStores) {
            fsCharts[i].setTitle(store.getName());
            List<TextTitle> subtitles = new ArrayList<>();
            if (SystemInfo.getCurrentPlatformEnum().equals(PlatformEnum.WINDOWS)) {
                subtitles.add(new TextTitle(store.getLabel()));
            }
            long usable = store.getUsableSpace();
            long total = store.getTotalSpace();
            subtitles.add(new TextTitle(
                    "Disponível: " + FormatUtil.formatBytes(usable) + "/" + FormatUtil.formatBytes(total)));
            fsCharts[i].setSubtitles(subtitles);
            fsData[i].setValue(utilizando, (double) total - usable);

            if (i == 0) {
                Timer timer = new Timer(Config.REFRESH_SLOW, e -> {
                    inserirDadosDisco(store);

                });
                timer.start();
            }

            fsData[i].setValue(disponivel, usable);
            i++;
        }
        return true;
    }

    private static void configurePlot(JFreeChart chart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint(utilizando, Color.decode("#eb4d4b"));
        plot.setSectionPaint(disponivel, Color.decode("#44bd32"));
        plot.setExplodePercent(utilizando, 0.10);
        plot.setSimpleLabels(true);

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0}: {1} ({2})",
                new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(labelGenerator);
    }

    public static void inserirDadosDisco(OSFileStore store) {

        long total = store.getTotalSpace();
        long utilizando = store.getUsableSpace();
        
        Double valor = (double) Math.round((total - utilizando) * 100 / total);
        // Coloca o insert em uma String
        String insertSql = String.format("INSERT INTO Registros VALUES "
                + "(null, null, '%s', '%%', 1, 3);", valor.toString());

        // Conecta no banco e passa o insert como query SQL
        try (Connection connection = new Conexao().getConnection();
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            // Executa o insert
            prepsInsertProduct.execute();

            // Confirma a execução
            System.out.println("Inserção feita DISCO!\n");
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

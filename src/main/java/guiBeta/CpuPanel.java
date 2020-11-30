package guiBeta;

import configBanco.Conexao;
import static guiBeta.MemoriaPanel.config;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;

public class CpuPanel extends SuperVisorJpanel {

    private static final long serialVersionUID = 1L;

    private long[] oldTicks;
    private long[][] oldProcTicks;

    public CpuPanel(SystemInfo si) {
        super();
        CentralProcessor cpu = si.getHardware().getProcessor();
        oldTicks = new long[TickType.values().length];
        oldProcTicks = new long[cpu.getLogicalProcessorCount()][TickType.values().length];
        init(cpu);
    }

    private void init(CentralProcessor processor) {

        GridBagConstraints sysConstraints = new GridBagConstraints();
        sysConstraints.weightx = 1d;
        sysConstraints.weighty = 1d;
        sysConstraints.fill = GridBagConstraints.BOTH;

        GridBagConstraints procConstraints = (GridBagConstraints) sysConstraints.clone();
        procConstraints.gridx = 1;

        // Pegando valor do uso total do sistema
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        DynamicTimeSeriesCollection sysData = new DynamicTimeSeriesCollection(1, 60, new Second());
        sysData.setTimeBase(new Second(date));
        sysData.addSeries(floatArrayPercent(cpuData(processor)), 0, "Uso total do sitema");
        JFreeChart systemCpu = ChartFactory.createTimeSeriesChart("Uso da CPU pelo sistema", "Tempo", "% CPU", sysData, true,
                true, false);

        // Pegando valores por cpu
        double[] procUsage = procData(processor);
        DynamicTimeSeriesCollection procData = new DynamicTimeSeriesCollection(procUsage.length, 60, new Second());
        procData.setTimeBase(new Second(date));
        for (int i = 0; i < procUsage.length; i++) {
            procData.addSeries(floatArrayPercent(procUsage[i]), i, "cpu" + i);
        }
        JFreeChart procCpu = ChartFactory.createTimeSeriesChart("Uso por processador", "Tempo", "% CPU", procData, true,
                true, false);

        JPanel cpuPanel = new JPanel();
        cpuPanel.setLayout(new GridBagLayout());
        cpuPanel.add(new ChartPanel(systemCpu), sysConstraints);
        cpuPanel.add(new ChartPanel(procCpu), procConstraints);

        add(cpuPanel, BorderLayout.CENTER);

        Timer timer = new Timer(700 ,e -> {
            sysData.advanceTime();
            sysData.appendData(floatArrayPercent(cpuData(processor)));
            procData.advanceTime();
            int newest = procData.getNewestIndex();
            double[] procUsageData = procData(processor);
            for (int i = 0; i < procUsageData.length; i++) {
                procData.addValue(i, newest, (float) (100 * procUsageData[i]));
            }
        });
        timer.start();
        
        Timer timer2 = new Timer(Config.REFRESH_SLOW, e -> {
            if (f[0] != 0) // VALOR PARA MANDAR NO BANCO
                inserirDadosCpu(f);
        });
        timer2.start();
    }

    private static float[] f = new float[1];

    private static float[] floatArrayPercent(double d) {
        f[0] = (float) Math.round(100d * d);
        return f;
    }

    private double cpuData(CentralProcessor proc) {
        double d = proc.getSystemCpuLoadBetweenTicks(oldTicks);
        oldTicks = proc.getSystemCpuLoadTicks();
        return d;
    }

    private double[] procData(CentralProcessor proc) {
        double[] p = proc.getProcessorCpuLoadBetweenTicks(oldProcTicks);
        oldProcTicks = proc.getProcessorCpuLoadTicks();
        return p;
    }

    public static void inserirDadosCpu(float[] f) {

        // Coloca o insert em uma String
        String insertSql = "INSERT INTO Registros VALUES (null, null, '12', '%', 1, 1);";

        // Conecta no banco e passa o insert como query SQL
        try (Connection connection = new Conexao().getConnection();
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            // Executa o insert
            prepsInsertProduct.execute();

            // Confirma a execução
            System.out.println("Inserção feita com sucesso de cpu!\n");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float[] getF() {
        return f;
    }
    
    
}

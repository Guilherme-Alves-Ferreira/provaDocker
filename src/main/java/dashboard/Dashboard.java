package dashboard;

import api.ApiOshi;
import guiBeta.MemoriaPanel;
import guiBeta.SuperVisorAplication;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;
import oshi.util.FormatUtil;

public class Dashboard extends javax.swing.JFrame {

    Gerenciador gerenciadorDados = new Gerenciador();

    ApiOshi api = new ApiOshi();
    SystemInfo si = new SystemInfo(); // Instanciando objeto SystemInfo
    HardwareAbstractionLayer hal = si.getHardware(); //Criando o objeto hal para adquirir mais facilmente os dados do hardware
    CentralProcessor processor = hal.getProcessor(); //Instânciando objeto CentralProcessor
    GlobalMemory memory = hal.getMemory();//MEMÓRIA
    OperatingSystem os = si.getOperatingSystem();//SO
    List<GraphicsCard> gpu = hal.getGraphicsCards();//GPU
    List<HWDiskStore> disco = hal.getDiskStores(); //DISCO

    List<String> listaExibicao = new ArrayList<>();

    public Dashboard() {
        initComponents();
        jTAContent.setEditable(false);
    }

    public void exibeInfo() {
        
         jTAContent.setText(null);
       
        for (String item : listaExibicao) {
            jTAContent.setText( jTAContent.getText() + item + "\n");
        }

    }

    public void limparLista() {
        listaExibicao.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jpAtencao = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblAtencao = new javax.swing.JLabel();
        jpEstavel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblEstavel = new javax.swing.JLabel();
        jpRisco = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblRisco = new javax.swing.JLabel();
        btnCPU = new javax.swing.JButton();
        btnMemoria = new javax.swing.JButton();
        btnDisco = new javax.swing.JButton();
        bntSO = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAContent = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(16, 40, 66));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\guilh\\OneDrive\\Documentos\\grupo-05-adsa-20201\\projetoSupervisor\\src\\main\\java\\imagem\\LogoSpervisor.png")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jpAtencao.setBackground(new java.awt.Color(251, 197, 49));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ATENÇÃO");

        lblAtencao.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblAtencao.setForeground(new java.awt.Color(255, 255, 255));
        lblAtencao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtencao.setText("-");

        javax.swing.GroupLayout jpAtencaoLayout = new javax.swing.GroupLayout(jpAtencao);
        jpAtencao.setLayout(jpAtencaoLayout);
        jpAtencaoLayout.setHorizontalGroup(
            jpAtencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAtencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblAtencao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAtencaoLayout.setVerticalGroup(
            jpAtencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAtencaoLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jpAtencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblAtencao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jpEstavel.setBackground(new java.awt.Color(106, 176, 76));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ESTÁVEIS");

        lblEstavel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblEstavel.setForeground(new java.awt.Color(255, 255, 255));
        lblEstavel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstavel.setText("-");

        javax.swing.GroupLayout jpEstavelLayout = new javax.swing.GroupLayout(jpEstavel);
        jpEstavel.setLayout(jpEstavelLayout);
        jpEstavelLayout.setHorizontalGroup(
            jpEstavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEstavelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblEstavel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jpEstavelLayout.setVerticalGroup(
            jpEstavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEstavelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpEstavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblEstavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jpRisco.setBackground(new java.awt.Color(235, 77, 75));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("RISCO");

        lblRisco.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblRisco.setForeground(new java.awt.Color(255, 255, 255));
        lblRisco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRisco.setText("-");

        javax.swing.GroupLayout jpRiscoLayout = new javax.swing.GroupLayout(jpRisco);
        jpRisco.setLayout(jpRiscoLayout);
        jpRiscoLayout.setHorizontalGroup(
            jpRiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRiscoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRisco, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jpRiscoLayout.setVerticalGroup(
            jpRiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRiscoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpRiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblRisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnCPU.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCPU.setText("CPU");
        btnCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPUActionPerformed(evt);
            }
        });

        btnMemoria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMemoria.setText("MEMÓRIA");
        btnMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemoriaActionPerformed(evt);
            }
        });

        btnDisco.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDisco.setText("DISCO");
        btnDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscoActionPerformed(evt);
            }
        });

        bntSO.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bntSO.setText("S.O");
        bntSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSOActionPerformed(evt);
            }
        });

        btnInfo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnInfo.setText("GRÁFICOS");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAtualizar.setText("Atualizar dados");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jTAContent.setColumns(20);
        jTAContent.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTAContent.setLineWrap(true);
        jTAContent.setRows(5);
        jTAContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jTAContent.setCaretColor(new java.awt.Color(204, 0, 0));
        jTAContent.setMargin(new java.awt.Insets(15, 15, 15, 15));
        jScrollPane2.setViewportView(jTAContent);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("EXIBINDO:");

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntSO, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpRisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAtencao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpEstavel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpRisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpAtencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpEstavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCPU)
                            .addComponent(btnMemoria)
                            .addComponent(btnDisco)
                            .addComponent(bntSO)
                            .addComponent(btnInfo)
                            .addComponent(btnAtualizar))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscoActionPerformed

        limparLista();
        lblTitulo.setText("DISCO");//Renomeando título
        listaExibicao.add(disco.toString()); // Add info de disco
        exibeInfo();
    }//GEN-LAST:event_btnDiscoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        gerenciadorDados.recuperarDados(1, lblEstavel);
        gerenciadorDados.recuperarDados(2, lblAtencao);
        gerenciadorDados.recuperarDados(3, lblRisco);

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPUActionPerformed

        limparLista();
        lblTitulo.setText("CPU");//Renomeando título
        listaExibicao.add(String.format("Detalhes do processador: \n %s\n", processor.toString())); //detalhesCPU
        listaExibicao.add(String.format("\nFrequência máxima: %s \n", FormatUtil.formatHertz(processor.getMaxFreq()))); //frequência máx

        long[] freqns = processor.getCurrentFreq();//frequência atual
        listaExibicao.add("Frequência atual por processador: \n"); // Frequência recente de cada processador
        for (Integer i = 0; i < freqns.length; i++) {
            listaExibicao.add(String.format(" | %dº - %s", i, FormatUtil.formatHertz(freqns[i])));
        }
        exibeInfo();
    }//GEN-LAST:event_btnCPUActionPerformed

    private void btnMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemoriaActionPerformed

        listaExibicao.clear();
        lblTitulo.setText("MEMÓRIA");//Renomeando título   
        listaExibicao.add(String.format("Espaço disposnível/utilizado: \n%s\n", memory.toString())); //MEMÓRIA    
        listaExibicao.add(String.format("\nMemórias físicas: %s \n", memory.getPhysicalMemory())); //detalhes memorias físicas
        listaExibicao.add(String.format("\nMemórias virtuais: %s", memory.getVirtualMemory())); //detalhes memorias virtuais
        exibeInfo();

        if (memory.getAvailable() > memory.getTotal() * 0.8) {

        }
    }//GEN-LAST:event_btnMemoriaActionPerformed

    private void bntSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSOActionPerformed

        listaExibicao.clear();
        lblTitulo.setText("SISTEMA OPERACIONAL");//Renomeando título
        listaExibicao.add(String.format("Sistema Operacional: %s\n", os.toString()));
        listaExibicao.add(String.format("\nVersão do sistema: %s\n", os.getVersionInfo()));
        listaExibicao.add(String.format("\nSessões: %s\n", os.getSessions()));
        listaExibicao.add(String.format("\nServiços: %s\n", os.getServices()));
        exibeInfo();
    }//GEN-LAST:event_bntSOActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed

        listaExibicao.clear();
        lblTitulo.setText("GRÁFICOS");//Renomeando título
        jTAContent.setText("Carregando gráficos...");
        
        SuperVisorAplication superVisor = new SuperVisorAplication();
        superVisor.init();
        SwingUtilities.invokeLater(superVisor::setVisible);
        
        jTAContent.setText("Gráficos carregados!");

    }//GEN-LAST:event_btnInfoActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSO;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCPU;
    private javax.swing.JButton btnDisco;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnMemoria;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAContent;
    private javax.swing.JPanel jpAtencao;
    private javax.swing.JPanel jpEstavel;
    private javax.swing.JPanel jpRisco;
    private javax.swing.JLabel lblAtencao;
    private javax.swing.JLabel lblEstavel;
    private javax.swing.JLabel lblRisco;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables

}

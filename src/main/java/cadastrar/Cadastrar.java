package cadastrar;

import java.awt.Color;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import configBanco.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import login.TelaLoginFuncional;

public class Cadastrar extends javax.swing.JFrame {

    Conexao config = new Conexao();

    
    TelaLoginFuncional linkLogin = new TelaLoginFuncional();
    
    public void cadastrarUsuario() {
        // Coloca o insert em uma String
        String insertSql = String.format("INSERT INTO CadastroFuncionario "
                + "(nomeFuncionario, email, senha, fkFaculdade) "
                + "VALUES ('%s', '%s', '%s', null)",
                lblNome.getText(), lblEmail.getText(), lblSenha.getText());

        // Conecta no banco e passa o insert como query SQL
        try (Connection connection = DriverManager.getConnection(config.connectionUrl);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            // Executa o insert
            prepsInsertProduct.execute();

            // Confirma a execução
            System.out.println("Inserção feita com sucesso!\n");

        } // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Cadastro realizado");
        
        verificarCadastro();
    }

    public void verificarCadastro() {
        try (Connection connection = DriverManager.getConnection(config.connectionUrl);
                Statement statement = connection.createStatement();) {

            ResultSet resultSet;

            // Cria e depois executa uma query feita por colunas, 
            // mas * funciona da mesma forma e poupa tempo.
            String selectSql = String.format("SELECT * FROM CadastroFuncionario"
                    + " WHERE email = '%s'", lblEmail.getText());
            
            resultSet = statement.executeQuery(selectSql);

            // Exibe o resultado do select
            while (resultSet.next()) {
                System.out.println(String.format("Nome: %s\nE-mail: %s\nSenha: %s\n",
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cadastrar() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblImagemLogo = new javax.swing.JLabel();
        lblImagemNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNome = new javax.swing.JTextField();
        lblDataNasc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bntCadastrar = new javax.swing.JToggleButton();
        lblEmail = new javax.swing.JTextField();
        lblConfiSenha = new javax.swing.JTextField();
        lblConfiEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JTextField();
        lblImagem1 = new javax.swing.JLabel();
        lblImagem2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(16, 40, 66));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\guilh\\OneDrive\\Documentos\\grupo-05-adsa-20201\\API\\apiCorreta\\src\\main\\java\\imagem\\logo3.1.png")); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\guilh\\OneDrive\\Documentos\\grupo-05-adsa-20201\\API\\apiCorreta\\src\\main\\java\\imagem\\LogoSpervisor.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(200, 200, 200)
                .addComponent(lblImagemLogo)
                .addGap(208, 208, 208)
                .addComponent(lblImagemNome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagemLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lblImagemNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(java.awt.Color.white);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 51));
        jLabel6.setText("Informações Pessoais");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome completo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Data de Nascimento:");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(204, 204, 204));
        lblNome.setText("Ex: João da Silva");
        lblNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblNomeActionPerformed(evt);
            }
        });

        lblDataNasc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDataNasc.setForeground(new java.awt.Color(204, 204, 204));
        lblDataNasc.setText("dd/mm/aaa");
        lblDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblDataNascActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 51));
        jLabel9.setText("Informações de Conta ");

        jLabel11.setText("______________________________________________________________________________________________________________________________");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("E-mail");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Confirmar E-mail");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Senha:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Confirmar senha:");

        bntCadastrar.setBackground(new java.awt.Color(255, 102, 0));
        bntCadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bntCadastrar.setText("CADASTRAR");
        bntCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(204, 204, 204));
        lblEmail.setText("exemplo@supervisor.com");
        lblEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblEmailActionPerformed(evt);
            }
        });

        lblConfiSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblConfiSenha.setForeground(new java.awt.Color(204, 204, 204));
        lblConfiSenha.setText("#minhasenha123");
        lblConfiSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblConfiSenhaActionPerformed(evt);
            }
        });

        lblConfiEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblConfiEmail.setForeground(new java.awt.Color(204, 204, 204));
        lblConfiEmail.setText("exemplo@supervisor.com");
        lblConfiEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblConfiEmailActionPerformed(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(204, 204, 204));
        lblSenha.setText("#minhasenha123");
        lblSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSenhaActionPerformed(evt);
            }
        });

        lblImagem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\guilh\\OneDrive\\Documentos\\grupo-05-adsa-20201\\API\\apiCorreta\\src\\main\\java\\imagem\\computador.png")); // NOI18N

        lblImagem2.setIcon(new javax.swing.ImageIcon("C:\\Users\\guilh\\OneDrive\\Documentos\\grupo-05-adsa-20201\\API\\apiCorreta\\src\\main\\java\\imagem\\dev-computer.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblSenha, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel12))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(lblConfiEmail)
                                    .addComponent(lblConfiSenha))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(lblDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(bntCadastrar)
                        .addGap(124, 124, 124))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addComponent(lblImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConfiEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConfiSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblImagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(bntCadastrar)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSenhaActionPerformed

    private void lblConfiEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblConfiEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblConfiEmailActionPerformed

    private void lblConfiSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblConfiSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblConfiSenhaActionPerformed

    private void lblEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEmailActionPerformed

    private void bntCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarActionPerformed

//        Pattern criterios = Pattern.compile(".+@.+\\.[a-z]+");
//        Matcher achar = criterios.matcher(lblEmail.getText().trim());

//        boolean matchFound = achar.matches();

        String senha = lblSenha.getText();
        String email = lblEmail.getText();

        if ((lblNome.getText().equals("")
                || lblDataNasc.getText().equals("") || lblEmail.getText().equals("")
                || lblConfiEmail.getText().equals("") || lblSenha.getText().equals(" "))) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else if (lblEmail.getText().length() < 8 || !email.equals(lblConfiEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Senha deve ser maior que 8 digitos");
        } else if (lblSenha.getText().length() < 8 || !senha.equals(lblConfiSenha.getText())) {
            JOptionPane.showMessageDialog(null, "Senha deve ser maior que 8 digitos");
        } else {

            cadastrarUsuario();
            linkLogin.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_bntCadastrarActionPerformed

    private void lblDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblDataNascActionPerformed
        bntCadastrar.setContentAreaFilled(false);
        bntCadastrar.setOpaque(true);
        bntCadastrar.setBackground(Color.RED);
    }//GEN-LAST:event_lblDataNascActionPerformed

    private void lblNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bntCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lblConfiEmail;
    private javax.swing.JTextField lblConfiSenha;
    private javax.swing.JTextField lblDataNasc;
    private javax.swing.JTextField lblEmail;
    private javax.swing.JLabel lblImagem1;
    private javax.swing.JLabel lblImagem2;
    private javax.swing.JLabel lblImagemLogo;
    private javax.swing.JLabel lblImagemNome;
    private javax.swing.JTextField lblNome;
    private javax.swing.JTextField lblSenha;
    // End of variables declaration//GEN-END:variables
}

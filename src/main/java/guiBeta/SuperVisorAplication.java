package guiBeta;

import ArquivosLog.ArquivoLog;
import configBanco.Conexao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.WindowConstants;

import oshi.SystemInfo;

public class SuperVisorAplication {

    private JFrame mainFrame;
    private JButton jMenu;
    private JMenuBar menuBar;

    private SystemInfo si = new SystemInfo();
    
    protected static Conexao config = new Conexao();

    static protected ArquivoLog arqLog = new ArquivoLog();

//    public static void main(String[] args) {
//        SuperVisorAplication superVisor = new SuperVisorAplication();
//        superVisor.init();
//        SwingUtilities.invokeLater(superVisor::setVisible);
//    }

    public void setVisible() {
        mainFrame.setVisible(true);
        mainFrame.setForeground(Color.decode("#f5f6fa"));
        jMenu.doClick();
    }

    public void init() {
        // Create the external frame
        mainFrame = new JFrame(Config.GUI_TITLE);
        mainFrame.setSize(Config.GUI_WIDTH, Config.GUI_HEIGHT);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(true);
        mainFrame.setLocationByPlatform(true);
        mainFrame.setLayout(new BorderLayout());
        // Add a menu bar
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.decode("#102842")); // Cor da barra do menu
        menuBar.setBorder(BorderFactory.createMatteBorder(10, 650, 10, 5, Color.decode("#102842")));
        mainFrame.setJMenuBar(menuBar);
        // Create the first menu option in this thread
        jMenu = getJMenu("CPU", 'C', "Uso da CPU", new CpuPanel(si));
        menuBar.add(jMenu);

        // Add later menu items in their own threads
        new Thread(new AddMenuBarTask("Memória", 'M', "Índice de memória", new MemoriaPanel(si))).start();
//        new Thread(new AddMenuBarTask("CPU", 'C', "Uso da CPU", new CpuPanel(si))).start();
        new Thread(new AddMenuBarTask("Disco", 'F', "Uso de disco", new DiscoPanel(si))).start();
        new Thread(new AddMenuBarTask("Processos", 'P', "Processos", new ProcessosJPanel(si))).start();
    }

    private JButton getJMenu(String title, char mnemonic, String toolTip, SuperVisorJpanel panel) {
        JButton button = new JButton(title);
        button.setFont(new java.awt.Font("Dialog", 1, 18));
        button.setForeground(Color.decode("#f5f6fa"));
        button.setBackground(Color.decode("#ef441d"));
        button.setMargin(new Insets(4, 14, 4, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setMnemonic(mnemonic);
        button.setToolTipText(toolTip);
        button.addActionListener(e -> {
            Container contentPane = this.mainFrame.getContentPane();
            if (contentPane.getComponents().length <= 0 || contentPane.getComponent(0) != panel) {
                resetMainGui();
                this.mainFrame.getContentPane().add(panel);
                refreshMainGui();
            }
        });

        return button;
    }

    private void resetMainGui() {
        this.mainFrame.getContentPane().removeAll();
    }

    private void refreshMainGui() {
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }

    /**
     * Runnable class to add a JMenu to the menubar.
     */
    private final class AddMenuBarTask implements Runnable {
        private String title;
        private char mnemonic;
        private String toolTip;
        private SuperVisorJpanel panel;

        private AddMenuBarTask(String title, char mnemonic, String toolTip, SuperVisorJpanel panel) {
            this.title = title;
            this.mnemonic = mnemonic;
            this.toolTip = toolTip;
            this.panel = panel;
        }

        @Override
        public void run() {
            menuBar.add(getJMenu(title, mnemonic, toolTip, panel));
        }
    }
}

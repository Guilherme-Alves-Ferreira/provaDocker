package guiBeta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import oshi.SystemInfo;

public class SuperVisorAplication {

    private JFrame mainFrame;
    private JButton jMenu;
    private JMenuBar menuBar;

    private SystemInfo si = new SystemInfo();

    public static void main(String[] args) {
        SuperVisorAplication superVisor = new SuperVisorAplication();
        superVisor.init();
        SwingUtilities.invokeLater(superVisor::setVisible);
    }

    public void setVisible() {
        mainFrame.setVisible(true);
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
        menuBar.setBackground(Color.decode("#2f3640"));
        mainFrame.setJMenuBar(menuBar);
        // Create the first menu option in this thread
        jMenu = getJMenu("OS & HW Info", 'O', "Hardware & OS índice", new OsHwTextPanel(si));
        menuBar.add(jMenu);
        // Add later menu items in their own threads
        new Thread(new AddMenuBarTask("Memória", 'M', "Índice de memória", new MemoriaPanel(si))).start();
        new Thread(new AddMenuBarTask("CPU", 'C', "Uso da CPU", new CpuPanel(si))).start();
        new Thread(new AddMenuBarTask("Disco", 'F', "Uso de disco", new DiscoPanel(si))).start();
        new Thread(new AddMenuBarTask("Processos", 'P', "Processos", new ProcessosJPanel(si))).start();
    }

    private JButton getJMenu(String title, char mnemonic, String toolTip, SuperVisorJpanel panel) {
        JButton button = new JButton(title);
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

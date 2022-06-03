
import backend.SistakaNG;
import frontend.HomeGUI;
// import frontend.LoginPanel;
import frontend.WelcomePanel;

import javax.swing.*;

public class SistakaNGUI {
    public static void main(String[] args) {
        // Membuat Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SistakaNG");
        SistakaNG.registerStaf();

        HomeGUI homeGUI = new HomeGUI(frame);
        run(homeGUI);

        frame.setVisible(true);

    }

    public static void run(HomeGUI homeGUI) {
        new WelcomePanel(homeGUI);
    }

}

package frontend.staf.ui;

import backend.SistakaNG;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;


public class PeringkatPanel extends SistakaPanel {
    static JTextArea textArea;

    public PeringkatPanel(HomeGUI main) {
        super(main);
        

        this.setLayout(null);
        JLabel peringkatLabel = new JLabel("Peringkat");
        peringkatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        peringkatLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        peringkatLabel.setBounds(223, 112, 137, 39);
        this.add(peringkatLabel);

        textArea = new JTextArea();
        textArea.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        textArea.setBorder(border);
        textArea.setBounds(86, 162, 411, 416);
        this.add(textArea);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                main.setPanel("staf");
            }
        });
        kembaliButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembaliButton.setBounds(247, 610, 89, 33);
        ;
        this.add(kembaliButton);

    }

    public static void setPeringkat() {
        textArea.setText(SistakaNG.handleRankingAnggota());
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

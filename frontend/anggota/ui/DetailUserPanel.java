package frontend.anggota.ui;

// import backend.SistakaNG;
// import backend.pengguna.Anggota;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;


public class DetailUserPanel extends SistakaPanel {
    static JTextArea textArea;

    public DetailUserPanel(HomeGUI main) {
        super(main);
        
        this.setLayout(null);
        JLabel lihatDetailAnggotaLabel = new JLabel("Lihat Detail Anggota");
        lihatDetailAnggotaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lihatDetailAnggotaLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lihatDetailAnggotaLabel.setBounds(94, 11, 396, 62);
        this.add(lihatDetailAnggotaLabel);

        textArea = new JTextArea();
        textArea.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        textArea.setBorder(border);
        textArea.setBounds(105, 69, 373, 581);
        this.add(textArea);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                main.setPanel("anggota");
            }
        });
        kembaliButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembaliButton.setBounds(238, 661, 107, 41);
        this.add(kembaliButton);

    }

    public static void setDetailAnggota(String txt) {
        textArea.setText(txt);
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

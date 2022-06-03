package frontend.anggota.ui;

import frontend.HomeGUI;
import frontend.SistakaPanel;
import backend.pengguna.Anggota;
// import backend.pengguna.Pengguna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;


public class AnggotaHomePanel extends SistakaPanel {
    static JLabel welcomeLabel;

    public AnggotaHomePanel(HomeGUI main) {
        super(main);
        
        this.setLayout(null);

        welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(71, 149, 441, 71);
        this.add(welcomeLabel);

        JButton peminjamanButton = new JButton("Peminjaman");
        peminjamanButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        peminjamanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("peminjaman");
            }
        });
        peminjamanButton.setBounds(0, 231, 584, 60);
        this.add(peminjamanButton);

        JButton pengembalianButton = new JButton("Pengembalian");
        pengembalianButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("pengembalian");
            }
        });
        pengembalianButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pengembalianButton.setBounds(0, 302, 584, 60);
        this.add(pengembalianButton);

        JButton dendaButton = new JButton("Pembayaran Denda");
        dendaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("pembayaran");
            }
        });
        dendaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        dendaButton.setBounds(0, 373, 584, 60);
        this.add(dendaButton);

        JButton detailAnggotaButton = new JButton("Detail Anggota");
        detailAnggotaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Anggota user = (Anggota) main.getUser();
                DetailUserPanel.setDetailAnggota(user.detail());
                main.setPanel("detailUser");
            }
        });
        detailAnggotaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        detailAnggotaButton.setBounds(0, 444, 584, 60);
        this.add(detailAnggotaButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setUser(null);
                main.setPanel("welcome");
            }
        });
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        logoutButton.setBounds(0, 515, 584, 60);
        this.add(logoutButton);
    }

    public static void changeWelcomeLabel(String txt) {
        welcomeLabel.setText(txt);
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }

}

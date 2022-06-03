package frontend;

import backend.SistakaNG;
import backend.pengguna.Anggota;
import backend.pengguna.Mahasiswa;
// import backend.pengguna.Pengguna;
import backend.pengguna.Staf;
import frontend.anggota.ui.AnggotaHomePanel;
import frontend.staf.ui.StafHomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginPanel extends SistakaPanel {
    public LoginPanel(HomeGUI main) {
        super(main);

        this.setLayout(null);

        JLabel label = new JLabel("Masukkan ID Anda untuk Login ke Sistem");
        label.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(10, 262, 564, 65);
        this.add(label);

        JTextField textFieldID = new JTextField();
        textFieldID.setBounds(86, 312, 412, 27);
        this.add(textFieldID);
        textFieldID.setColumns(10);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        loginButton.setBounds(242, 350, 100, 27);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textFieldID.getText();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Harap masukkan ID anda pada kotak di atas!");
                    return;
                }

                if (SistakaNG.handleLogin(id) instanceof Anggota) {

                    main.setUser(SistakaNG.handleLogin(id));
                    textFieldID.setText("");
                    if (SistakaNG.handleLogin(id) instanceof Mahasiswa) {
                        AnggotaHomePanel.changeWelcomeLabel("Selamat Datang Kembali " + main.getUser().getNama());
                    } else {
                        AnggotaHomePanel.changeWelcomeLabel("Selamat Datang Kembali " + main.getUser().getId());
                    }

                    main.setPanel("anggota");
                } else if (SistakaNG.handleLogin(id) instanceof Staf) {
                    main.setUser(SistakaNG.handleLogin(id));
                    textFieldID.setText("");
                    StafHomePanel.changeWelcomeLabel("Selamat Datang Kembali " + main.getUser().getNama());
                    main.setPanel("staf");
                } else {
                    JOptionPane.showMessageDialog(null, "Pengguna dengan ID " + id + " tidak ditemukan");
                }

            }
        });
        this.add(loginButton);

    }

    @Override
    public void refresh() {
        // ignored
    }
}

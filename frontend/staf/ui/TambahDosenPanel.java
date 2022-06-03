package frontend.staf.ui;

import backend.SistakaNG;
import backend.pengguna.Dosen;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;


public class TambahDosenPanel extends SistakaPanel {
    public TambahDosenPanel(HomeGUI main) {
        super(main);
        

        this.setLayout(null);

        JLabel tambahDosenLabel = new JLabel("Tambah Dosen");
        tambahDosenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tambahDosenLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        tambahDosenLabel.setBounds(0, 182, 584, 48);
        this.add(tambahDosenLabel);

        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        namaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        namaLabel.setBounds(268, 230, 46, 14);
        this.add(namaLabel);

        JTextField nama = new JTextField();
        nama.setBounds(90, 255, 410, 25);
        this.add(nama);
        nama.setColumns(10);

        JButton Tambah = new JButton("Tambah");
        Tambah.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Tambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (nama.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Tidak dapat menambahkan dosen silahkan periksa kembali input anda!");
                    return;
                } else {
                    nama.setText("");
                    Dosen dosen = SistakaNG.addDosen(nama.getText());
                    DetailAnggotaPanel.addAnggotaComboBox(dosen.getId());
                    JOptionPane.showMessageDialog(null,
                            "Berhasil menambahkan dosen dengan ID " + dosen.getId());
                }

            }
        });
        Tambah.setBounds(183, 291, 94, 37);
        this.add(Tambah);

        JButton Kembali = new JButton("Kembali");
        Kembali.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Kembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nama.setText("");
                main.setPanel("staf");
            }
        });
        Kembali.setBounds(319, 291, 94, 37);
        this.add(Kembali);
    }
    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

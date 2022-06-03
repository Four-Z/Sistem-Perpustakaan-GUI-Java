package frontend.staf.ui;

import backend.SistakaNG;
import backend.buku.Kategori;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;


public class TambahKategoriPanel extends SistakaPanel {
    public TambahKategoriPanel(HomeGUI main) {
        super(main);
        

        this.setLayout(null);

        JLabel tambahKategoriLabel = new JLabel("Tambah Kategori");
        tambahKategoriLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        tambahKategoriLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tambahKategoriLabel.setBounds(10, 189, 564, 40);
        this.add(tambahKategoriLabel);

        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        namaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        namaLabel.setBounds(274, 240, 46, 14);
        this.add(namaLabel);

        JLabel poinLabel = new JLabel("Poin");
        poinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        poinLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        poinLabel.setBounds(269, 296, 46, 14);
        this.add(poinLabel);

        JTextField nama = new JTextField();
        nama.setBounds(78, 265, 428, 20);
        this.add(nama);
        nama.setColumns(10);

        JTextField poin = new JTextField();
        poin.setColumns(10);
        poin.setBounds(78, 319, 428, 20);
        this.add(poin);

        JButton Tambah = new JButton("Tambah");
        Tambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (nama.getText().isEmpty() || poin.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Tidak dapat menambahkan kategori silahkan periksa kembali input anda!");
                    return;
                } else if (!isNumeric(poin.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Poin harus angka!");
                    return;
                }

                Kategori kategori = SistakaNG.addKategori(nama.getText(), Integer.parseInt(poin.getText()));

                if (kategori == null) {
                    JOptionPane.showMessageDialog(null,
                            "Kategori " + nama.getText() + " sudah pernah ditambahkan!");
                } else {
                    TambahBukuPanel.addKategoriComboBox(kategori.getNama());
                    JOptionPane.showMessageDialog(null,
                            "Kategori " + kategori.getNama() + " dengan poin " + kategori.getPoin()
                                    + " berhasil ditambahkan");
                }

            }
        });
        Tambah.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Tambah.setBounds(175, 362, 103, 40);
        this.add(Tambah);

        JButton Kembali = new JButton("Kembali");
        Kembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetField(nama, poin);
                main.setPanel("staf");
            }
        });
        Kembali.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Kembali.setBounds(309, 362, 103, 40);
        this.add(Kembali);
    }

    public void resetField(JTextField nama, JTextField poin) {
        nama.setText("");
        poin.setText("");
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

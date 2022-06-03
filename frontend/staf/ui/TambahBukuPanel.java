package frontend.staf.ui;

import backend.SistakaNG;
import backend.buku.Buku;
// import backend.buku.Kategori;
// import backend.buku.Peminjaman;
import frontend.HomeGUI;
import frontend.SistakaPanel;
import frontend.anggota.ui.PeminjamanPanel;
import frontend.anggota.ui.PengembalianPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;


public class TambahBukuPanel extends SistakaPanel {
    static JComboBox<String> kategori;

    public TambahBukuPanel(HomeGUI main) {
        super(main);
        

        this.setLayout(null);
        JLabel lblTambahBuku = new JLabel("Tambah Buku");
        lblTambahBuku.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblTambahBuku.setHorizontalAlignment(SwingConstants.CENTER);
        lblTambahBuku.setBounds(10, 128, 564, 25);
        this.add(lblTambahBuku);

        JLabel JudulLabel = new JLabel("Judul");
        JudulLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JudulLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JudulLabel.setBounds(10, 175, 564, 14);
        this.add(JudulLabel);

        JTextField judul = new JTextField();
        judul.setBounds(66, 200, 452, 20);
        this.add(judul);
        judul.setColumns(10);

        JLabel penerbitLabel = new JLabel("Penerbit");
        penerbitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        penerbitLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        penerbitLabel.setBounds(10, 281, 564, 41);
        this.add(penerbitLabel);

        JTextField penulis = new JTextField();
        penulis.setBounds(66, 262, 452, 20);
        this.add(penulis);
        penulis.setColumns(10);

        JLabel kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kategoriLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kategoriLabel.setBounds(10, 333, 564, 41);
        this.add(kategoriLabel);

        JLabel penulisLabel_1 = new JLabel("Penulis");
        penulisLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        penulisLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        penulisLabel_1.setBounds(10, 223, 564, 41);
        this.add(penulisLabel_1);

        JTextField penerbit = new JTextField();
        penerbit.setColumns(10);
        penerbit.setBounds(66, 316, 452, 20);
        this.add(penerbit);

        kategori = new JComboBox<>();
        kategori.setBounds(208, 366, 167, 22);
        this.add(kategori);

        JLabel stokLabel = new JLabel("Stok");
        stokLabel.setHorizontalAlignment(SwingConstants.CENTER);
        stokLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        stokLabel.setBounds(10, 385, 564, 35);
        this.add(stokLabel);

        JTextField stok = new JTextField();
        stok.setColumns(10);
        stok.setBounds(66, 421, 452, 20);
        this.add(stok);

        JButton tambah = new JButton("Tambah");
        tambah.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tambah.setBounds(186, 452, 101, 35);
        tambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (judul.getText().isEmpty() || penulis.getText().isEmpty() || penerbit.getText().isEmpty()
                        || kategori.getSelectedItem() == null || stok.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Periksa kembali input anda!");
                    return;
                } else if (!isNumeric(stok.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Stok harus angka!");
                    return;
                } else if (Integer.parseInt(stok.getText()) <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Stok harus lebih dari 0!");
                    return;
                }

                Buku buku = SistakaNG.addBuku(judul.getText(), penulis.getText(), penerbit.getText(),
                        kategori.getSelectedItem().toString(),
                        Integer.parseInt(stok.getText()));

                if (buku == null) {
                    resetField(judul, penulis, penerbit, kategori, stok);
                    JOptionPane.showMessageDialog(null,
                            "Buku " + judul.getText() + " oleh " + penulis.getText() + " sudah pernah ditambahkan");
                } else {
                    String tempBuku = buku.getJudul() + " oleh " + buku.getPenulis();
                    HapusBukuPanel.addBukuComboBox(tempBuku);
                    DaftarPeminjamPanel.addBukuComboBox(tempBuku);
                    PeminjamanPanel.addBukuComboBox(tempBuku);
                    PengembalianPanel.addBukuComboBox(tempBuku);
                    resetField(judul, penulis, penerbit, kategori, stok);
                    JOptionPane.showMessageDialog(null,
                            "Buku " + buku.getJudul() + " oleh " + buku.getPenulis() + " berhasil ditambahkan!");
                }

            }
        });
        this.add(tambah);

        JButton kembali = new JButton("Kembali");
        kembali.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembali.setBounds(314, 452, 101, 35);
        kembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetField(judul, penulis, penerbit, kategori, stok);
                main.setPanel("staf");
            }
        });
        this.add(kembali);

    }

    public static void addKategoriComboBox(String item) {
        kategori.addItem(item);
    }

    public void resetField(JTextField judul, JTextField penulis, JTextField penerbit, JComboBox<String> kategori,
            JTextField stok) {
        judul.setText("");
        penulis.setText("");
        penerbit.setText("");
        // kategori.setSelectedIndex(-1);
        stok.setText("");
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

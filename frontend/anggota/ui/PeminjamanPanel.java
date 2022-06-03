package frontend.anggota.ui;

import backend.SistakaNG;
import backend.buku.Buku;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.Calendar;
// import java.util.Date;
// import java.util.List;

public class PeminjamanPanel extends SistakaPanel {
    static JComboBox<String> bukuComboBox;

    public PeminjamanPanel(HomeGUI main) {
        super(main);
        
        this.setLayout(null);
        JLabel pinjamBukuLabel = new JLabel("Pinjam Buku");
        pinjamBukuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pinjamBukuLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        pinjamBukuLabel.setBounds(209, 178, 165, 72);
        this.add(pinjamBukuLabel);

        JLabel bukuLabel = new JLabel("Buku");
        bukuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bukuLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        bukuLabel.setBounds(269, 236, 46, 14);
        this.add(bukuLabel);

        bukuComboBox = new JComboBox<>();
        bukuComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        bukuComboBox.setBounds(146, 261, 292, 22);
        this.add(bukuComboBox);

        JLabel tanggalPeminjamanLabel = new JLabel("Tanggal Peminjaman (DD/MM/YYYY)");
        tanggalPeminjamanLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tanggalPeminjamanLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tanggalPeminjamanLabel.setBounds(137, 294, 309, 22);
        this.add(tanggalPeminjamanLabel);

        JTextField tanggalPeminjaman = new JTextField();
        tanggalPeminjaman.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tanggalPeminjaman.setBounds(59, 327, 465, 32);
        this.add(tanggalPeminjaman);
        tanggalPeminjaman.setColumns(10);

        JButton pinjamButton = new JButton("Pinjam");
        pinjamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tanggalPeminjaman.getText() == null || bukuComboBox.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null,
                            "Silakan periksa input anda");
                    return;
                } else if (!isDateValid(tanggalPeminjaman.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Tanggal yang dimasukkan harus dalam format DD/MM/YYYY");
                    return;
                }

                String selectedBook = bukuComboBox.getSelectedItem().toString();
                String[] selectedBookData = selectedBook.split(" oleh ");
                Buku buku = SistakaNG.findBuku(selectedBookData[0], selectedBookData[1]);

                JOptionPane.showMessageDialog(null,
                        SistakaNG.pinjamBuku(buku, tanggalPeminjaman.getText()));

                tanggalPeminjaman.setText("");

            }
        });
        pinjamButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pinjamButton.setBounds(180, 370, 99, 32);
        this.add(pinjamButton);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tanggalPeminjaman.setText("");
                main.setPanel("anggota");
            }
        });
        kembaliButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembaliButton.setBounds(305, 370, 99, 32);
        this.add(kembaliButton);
    }

    public static void addBukuComboBox(String buku) {
        bukuComboBox.addItem(buku);
    }

    public static void deleteBukuComboBox(int index) {
        bukuComboBox.removeItemAt(index);
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

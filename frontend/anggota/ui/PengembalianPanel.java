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
// import java.util.List;


public class PengembalianPanel extends SistakaPanel {
    static JComboBox<String> bukuComboBox;

    public PengembalianPanel(HomeGUI main) {
        super(main);
        
        this.setLayout(null);
        JLabel kembaliBukuLabel = new JLabel("Pengembalian Buku");
        kembaliBukuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kembaliBukuLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        kembaliBukuLabel.setBounds(126, 178, 331, 72);
        this.add(kembaliBukuLabel);

        JLabel bukuLabel = new JLabel("Buku");
        bukuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bukuLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        bukuLabel.setBounds(269, 236, 46, 14);
        this.add(bukuLabel);

        bukuComboBox = new JComboBox<>();
        bukuComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        bukuComboBox.setBounds(146, 261, 292, 22);
        this.add(bukuComboBox);

        JLabel tanggalPengembalianLabel = new JLabel("Tanggal Pengembalian (DD/MM/YYYY)");
        tanggalPengembalianLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tanggalPengembalianLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tanggalPengembalianLabel.setBounds(137, 294, 309, 22);
        this.add(tanggalPengembalianLabel);

        JTextField tanggalPengembalian = new JTextField();
        tanggalPengembalian.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tanggalPengembalian.setBounds(59, 327, 465, 32);
        this.add(tanggalPengembalian);
        tanggalPengembalian.setColumns(10);

        JButton kembalikanButton = new JButton("Kembalikan");
        kembalikanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tanggalPengembalian.getText() == null || bukuComboBox.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null,
                            "Silakan periksa input anda");
                    return;
                } else if (!isDateValid(tanggalPengembalian.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Tanggal yang dimasukkan harus dalam format DD/MM/YYYY");
                    return;
                }

                String selectedBook = bukuComboBox.getSelectedItem().toString();
                String[] selectedBookData = selectedBook.split(" oleh ");
                Buku buku = SistakaNG.findBuku(selectedBookData[0], selectedBookData[1]);

                JOptionPane.showMessageDialog(null,
                        SistakaNG.kembalikanBuku(buku, tanggalPengembalian.getText()));

                tanggalPengembalian.setText("");
            }
        });
        kembalikanButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembalikanButton.setBounds(171, 370, 115, 43);
        this.add(kembalikanButton);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tanggalPengembalian.setText("");
                main.setPanel("anggota");
            }
        });
        kembaliButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembaliButton.setBounds(296, 370, 115, 43);
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

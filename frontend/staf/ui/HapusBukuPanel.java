package frontend.staf.ui;

import backend.SistakaNG;
import backend.buku.Buku;
import frontend.HomeGUI;
import frontend.SistakaPanel;
import frontend.anggota.ui.PeminjamanPanel;
import frontend.anggota.ui.PengembalianPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;


public class HapusBukuPanel extends SistakaPanel {
    static JComboBox<String> bukuComboBox;

    public HapusBukuPanel(HomeGUI main) {
        super(main);
        
        this.setLayout(null);
        JLabel hapusBukuLabel = new JLabel("Hapus Buku");
        hapusBukuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hapusBukuLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        hapusBukuLabel.setBounds(223, 249, 138, 49);
        this.add(hapusBukuLabel);

        JLabel bukuLabel = new JLabel("Buku");
        bukuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bukuLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        bukuLabel.setBounds(269, 296, 46, 14);
        this.add(bukuLabel);

        bukuComboBox = new JComboBox<>();
        bukuComboBox.setBounds(194, 321, 195, 22);
        this.add(bukuComboBox);

        JButton hapusButton = new JButton("Hapus");
        hapusButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        hapusButton.setBounds(194, 355, 96, 32);
        hapusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (bukuComboBox.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Silakan memilih Buku!");
                    return;
                }

                String selectedBook = bukuComboBox.getSelectedItem().toString();
                String[] selectedBookData = selectedBook.split(" oleh ");
                Buku buku = SistakaNG.findBuku(selectedBookData[0], selectedBookData[1]);

                if (buku == null) {
                    JOptionPane.showMessageDialog(null, "Buku " + selectedBookData[0] + " oleh " + selectedBookData[1]
                            + " tidak dapat dihapus karena sedang dipinjam");
                } else {
                    DaftarPeminjamPanel.deleteBukuComboBox(bukuComboBox.getSelectedIndex());
                    PeminjamanPanel.deleteBukuComboBox(bukuComboBox.getSelectedIndex());
                    PengembalianPanel.deleteBukuComboBox(bukuComboBox.getSelectedIndex());
                    deleteBukuComboBox(bukuComboBox.getSelectedIndex());
                    JOptionPane.showMessageDialog(null,
                            "Buku " + buku.getJudul() + " oleh " + buku.getPenulis() + " berhasil dihapus");
                }

            }
        });
        this.add(hapusButton);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembaliButton.setBounds(300, 354, 89, 33);
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // bukuComboBox.setSelectedIndex(-1);
                main.setPanel("staf");
            }
        });
        this.add(kembaliButton);
    }

    public static void addBukuComboBox(String item) {
        bukuComboBox.addItem(item);
    }

    public static void deleteBukuComboBox(int index) {
        bukuComboBox.removeItemAt(index);
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

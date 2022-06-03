package frontend.staf.ui;

import backend.SistakaNG;
import backend.buku.Buku;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;

public class DaftarPeminjamPanel extends SistakaPanel {
    static JComboBox<String> bukuComboBox;
    JTextArea textArea;

    public DaftarPeminjamPanel(HomeGUI main) {
        super(main);

        this.setLayout(null);
        JLabel daftarPeminjamLabel = new JLabel("Lihat Daftar Peminjam");
        daftarPeminjamLabel.setHorizontalAlignment(SwingConstants.CENTER);
        daftarPeminjamLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        daftarPeminjamLabel.setBounds(141, 114, 301, 49);
        this.add(daftarPeminjamLabel);

        JLabel pilihIdLabel = new JLabel("Pilih Buku");
        pilihIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pilihIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pilihIdLabel.setBounds(226, 158, 131, 22);
        this.add(pilihIdLabel);

        bukuComboBox = new JComboBox<>();
        bukuComboBox.setBounds(194, 184, 195, 22);
        this.add(bukuComboBox);

        textArea = new JTextArea();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        textArea.setBorder(border);
        textArea.setEditable(false);
        textArea.setBounds(109, 224, 365, 390);
        this.add(textArea);

        JButton lihatButton = new JButton("Lihat");
        lihatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bukuComboBox.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Silakan memilih buku!");
                } else {
                    String buku = bukuComboBox.getSelectedItem().toString();
                    setDaftarPeminjam(buku);
                }
            }
        });
        lihatButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lihatButton.setBounds(170, 637, 96, 32);
        this.add(lihatButton);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                main.setPanel("staf");
            }
        });
        kembaliButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembaliButton.setBounds(322, 637, 96, 32);
        this.add(kembaliButton);

    }

    public void setDaftarPeminjam(String buku) {
        String[] selectedBookData = buku.split(" oleh ");
        Buku bukuObject = SistakaNG.findBuku(selectedBookData[0], selectedBookData[1]);
        textArea.setText(SistakaNG.daftarPeminjam(bukuObject));
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

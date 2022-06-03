package frontend.staf.ui;

// import backend.SistakaNG;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StafHomePanel extends SistakaPanel {
    static JLabel label;

    public StafHomePanel(HomeGUI main) {
        super(main);
        

        this.setLayout(null);

        label = new JLabel();
        label.setFont(new Font("Tahoma", Font.PLAIN, 22));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(10, 30, 584, 36);
        this.add(label);

        JButton tambahMahasiswa = new JButton("Tambah Mahasiswa");
        tambahMahasiswa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tambahMahasiswa.setBounds(0, 93, 584, 60);
        tambahMahasiswa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("tambahMhs");
            }
        });
        this.add(tambahMahasiswa);

        JButton tambahDosen = new JButton("Tambah Dosen");
        tambahDosen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tambahDosen.setBounds(0, 164, 584, 60);
        tambahDosen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("tambahDosen");
            }
        });
        this.add(tambahDosen);

        JButton tambahKategori = new JButton("Tambah Kategori");
        tambahKategori.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tambahKategori.setBounds(0, 235, 584, 60);
        tambahKategori.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("tambahKategori");
            }
        });
        this.add(tambahKategori);

        JButton tambahBuku = new JButton("Tambah Buku");
        tambahBuku.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tambahBuku.setBounds(0, 306, 584, 60);
        tambahBuku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("tambahBuku");
            }
        });
        this.add(tambahBuku);

        JButton hapusBuku = new JButton("Hapus Buku");
        hapusBuku.setFont(new Font("Tahoma", Font.PLAIN, 15));
        hapusBuku.setBounds(0, 377, 584, 60);
        hapusBuku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("hapusBuku");
            }
        });
        this.add(hapusBuku);

        JButton peringkat = new JButton("3 Peringkat Pertama");
        peringkat.setFont(new Font("Tahoma", Font.PLAIN, 15));
        peringkat.setBounds(0, 448, 584, 60);
        peringkat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PeringkatPanel.setPeringkat();
                main.setPanel("peringkat");
            }
        });
        this.add(peringkat);

        JButton detailAnggota = new JButton("Detail Anggota");
        detailAnggota.setFont(new Font("Tahoma", Font.PLAIN, 15));
        detailAnggota.setBounds(0, 519, 584, 60);
        detailAnggota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("detailAnggota");
            }
        });
        this.add(detailAnggota);

        JButton daftarPeminjam = new JButton("Daftar Peminjaman Buku");
        daftarPeminjam.setFont(new Font("Tahoma", Font.PLAIN, 15));
        daftarPeminjam.setBounds(0, 590, 584, 60);
        daftarPeminjam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setPanel("daftarPeminjam");
            }
        });
        this.add(daftarPeminjam);

        JButton logout = new JButton("Logout");
        logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
        logout.setBounds(0, 661, 584, 60);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setUser(null);
                main.setPanel("welcome");
            }
        });
        this.add(logout);
    }

    public static void changeWelcomeLabel(String txt) {
        label.setText(txt);
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }

}

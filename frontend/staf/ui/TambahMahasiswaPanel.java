package frontend.staf.ui;

import backend.SistakaNG;
// import backend.pengguna.Anggota;
import backend.pengguna.Mahasiswa;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Objects;


public class TambahMahasiswaPanel extends SistakaPanel {
    public TambahMahasiswaPanel(HomeGUI main) {
        super(main);
        

        this.setLayout(null);

        JLabel label = new JLabel("Tambah Mahasiswa");
        label.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(10, 128, 564, 25);
        this.add(label);

        JLabel namaLabel = new JLabel("nama");
        namaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        namaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        namaLabel.setBounds(10, 175, 564, 14);
        this.add(namaLabel);

        JTextField nama = new JTextField();
        nama.setBounds(66, 200, 452, 20);
        this.add(nama);
        nama.setColumns(10);

        JLabel tanggal_lahir_label = new JLabel("Tanggal Lahir (DD/MM/YYYY)");
        tanggal_lahir_label.setHorizontalAlignment(SwingConstants.CENTER);
        tanggal_lahir_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tanggal_lahir_label.setBounds(10, 223, 564, 41);
        this.add(tanggal_lahir_label);

        JTextField tanggalLahir = new JTextField();
        tanggalLahir.setBounds(66, 262, 452, 20);
        this.add(tanggalLahir);
        tanggalLahir.setColumns(10);

        JLabel programStudiLabel = new JLabel("Program Studi");
        programStudiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        programStudiLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        programStudiLabel.setBounds(10, 281, 564, 41);
        this.add(programStudiLabel);

        JComboBox<String> programStudi = new JComboBox<>();
        programStudi.setModel(new DefaultComboBoxModel<String>(new String[] { "SIK", "SSI", "MIK", "MTI", "DIK" }));
        programStudi.setBounds(268, 317, 48, 22);
        this.add(programStudi);

        JLabel angkatanLabel = new JLabel("Angkatan");
        angkatanLabel.setHorizontalAlignment(SwingConstants.CENTER);
        angkatanLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        angkatanLabel.setBounds(10, 342, 564, 35);
        this.add(angkatanLabel);

        JTextField angkatan = new JTextField();
        angkatan.setColumns(10);
        angkatan.setBounds(66, 374, 452, 20);
        this.add(angkatan);

        JButton tambah = new JButton("Tambah");
        tambah.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tambah.setBounds(186, 405, 101, 35);
        tambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Mahasiswa mahasiswa = SistakaNG.addMahasiswa(nama.getText(), tanggalLahir.getText(),
                        programStudi.getSelectedItem().toString(), angkatan.getText());

                if (mahasiswa != null) {
                    resetField(nama, tanggalLahir, programStudi, angkatan);
                    DetailAnggotaPanel.addAnggotaComboBox(mahasiswa.getId());
                    JOptionPane.showMessageDialog(null,
                            "Berhasil menambahkan mahasiswa dengan ID " + mahasiswa.getId());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Tidak dapat menambahkan mahasiswa silahkan periksa kembali input anda!");
                }

            }
        });
        this.add(tambah);

        JButton kembali = new JButton("Kembali");
        kembali.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembali.setBounds(314, 405, 101, 35);
        kembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetField(nama, tanggalLahir, programStudi, angkatan);
                main.setPanel("staf");
            }
        });
        this.add(kembali);
    }

    public void resetField(JTextField nama, JTextField tanggalLahir, JComboBox<String> programStudi,
            JTextField angkatan) {
        nama.setText("");
        tanggalLahir.setText("");
        programStudi.setSelectedIndex(0);
        angkatan.setText("");
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

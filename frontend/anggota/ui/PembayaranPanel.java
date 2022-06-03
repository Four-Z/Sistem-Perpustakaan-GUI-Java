package frontend.anggota.ui;

import backend.SistakaNG;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;


public class PembayaranPanel extends SistakaPanel {
    public PembayaranPanel(HomeGUI main) {
        super(main);
        

        this.setLayout(null);
        JLabel bayarDendaLabel = new JLabel("Bayar Denda");
        bayarDendaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bayarDendaLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        bayarDendaLabel.setBounds(126, 178, 331, 57);
        this.add(bayarDendaLabel);

        JLabel jumlahDendaLabel = new JLabel("Jumlah Denda");
        jumlahDendaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jumlahDendaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jumlahDendaLabel.setBounds(223, 236, 138, 14);
        this.add(jumlahDendaLabel);

        JTextField jumlahDenda = new JTextField();
        jumlahDenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jumlahDenda.setBounds(59, 261, 465, 28);
        this.add(jumlahDenda);
        jumlahDenda.setColumns(10);

        JButton bayarButton = new JButton("Bayar");
        bayarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (jumlahDenda.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Silakan masukkan jumlah bayar!");
                } else if (!isNumeric(jumlahDenda.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Jumlah bayar harus angka!");
                } else {
                    JOptionPane.showMessageDialog(null,
                            SistakaNG.bayarDenda(Long.parseLong(jumlahDenda.getText())));
                }

                jumlahDenda.setText("");
            }
        });
        bayarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        bayarButton.setBounds(172, 300, 115, 43);
        this.add(bayarButton);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jumlahDenda.setText("");
                main.setPanel("anggota");
            }
        });
        kembaliButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembaliButton.setBounds(297, 300, 115, 43);
        this.add(kembaliButton);
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

package frontend.staf.ui;

import backend.SistakaNG;
import backend.pengguna.Anggota;
import frontend.HomeGUI;
import frontend.SistakaPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.ArrayList;
// import java.util.List;


public class DetailAnggotaPanel extends SistakaPanel {
    static JComboBox<String> anggotaComboBox;
    JTextArea textArea;

    public DetailAnggotaPanel(HomeGUI main) {
        super(main);
        
        this.setLayout(null);
        JLabel detailAnggotaLabel = new JLabel("Detail Anggota");
        detailAnggotaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        detailAnggotaLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        detailAnggotaLabel.setBounds(141, 28, 301, 49);
        this.add(detailAnggotaLabel);

        JLabel pilihIdLabel = new JLabel("Pilih ID Anggota");
        pilihIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pilihIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pilihIdLabel.setBounds(226, 70, 131, 22);
        this.add(pilihIdLabel);

        anggotaComboBox = new JComboBox<>();
        anggotaComboBox.setBounds(194, 103, 195, 22);
        this.add(anggotaComboBox);


        textArea = new JTextArea();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        textArea.setBorder(border);
        textArea.setEditable(false);
        textArea.setBounds(112, 136, 360, 512);
        this.add(textArea);

        JButton lihatButton = new JButton("Lihat");
        lihatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (anggotaComboBox.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Silakan memilih ID Anggota!");
                } else {
                    String id = anggotaComboBox.getSelectedItem().toString();
                    setDetailAnggota(id);
                }
            }
        });
        lihatButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lihatButton.setBounds(181, 659, 96, 32);
        this.add(lihatButton);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                main.setPanel("staf");
            }
        });
        kembaliButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kembaliButton.setBounds(309, 659, 96, 32);
        this.add(kembaliButton);

    }

    public void setDetailAnggota(String id) {
        Anggota anggota = SistakaNG.findAnggota(id);
        textArea.setText(anggota.detail());
    }

    public static void addAnggotaComboBox(String anggota) {
        anggotaComboBox.addItem(anggota);
    }

    @Override
    public void refresh() {
        
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}

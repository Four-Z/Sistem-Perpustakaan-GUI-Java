package backend;

import backend.buku.Buku;
import backend.buku.Kategori;
import backend.pengguna.*;

import java.util.ArrayList;
import java.util.Collections;

public class SistakaNG {
    private static ArrayList<Staf> daftarStaf = new ArrayList<>();
    private static ArrayList<Anggota> daftarAnggota = new ArrayList<>();
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();
    private static ArrayList<Kategori> daftarKategori = new ArrayList<>();
    private static Pengguna penggunaLoggedIn;

    public static ArrayList<Staf> getDaftarStaf() {
        return daftarStaf;
    }

    public static void setDaftarStaf(ArrayList<Staf> daftarStaf) {
        SistakaNG.daftarStaf = daftarStaf;
    }

    public static ArrayList<Anggota> getDaftarAnggota() {
        return daftarAnggota;
    }

    public static String[] getDaftarIDAnggota() {
        String daftarAnggota[] = new String[getDaftarAnggota().size()];
        int helper = 0;
        for (Anggota buku : SistakaNG.getDaftarAnggota()) {
            daftarAnggota[helper] = buku.getId();
            helper++;
        }
        return daftarAnggota;
    }

    public static void setDaftarAnggota(ArrayList<Anggota> daftarAnggota) {
        SistakaNG.daftarAnggota = daftarAnggota;
    }

    public static ArrayList<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public static String[] getDaftarJudulDanPenulisBuku() {
        String daftarBuku[] = new String[getDaftarBuku().size()];
        int helper = 0;
        for (Buku buku : SistakaNG.getDaftarBuku()) {
            daftarBuku[helper] = buku.getJudul() + " oleh " + buku.getPenulis();
            helper++;
        }
        return daftarBuku;
    }

    public static void setDaftarBuku(ArrayList<Buku> daftarBuku) {
        SistakaNG.daftarBuku = daftarBuku;
    }

    public static ArrayList<Kategori> getDaftarKategori() {
        return daftarKategori;
    }

    public static String[] getDaftarNamaKategori() {

        String daftarKategori[] = new String[getDaftarKategori().size()];
        int helper = 0;
        for (Kategori ktg : SistakaNG.getDaftarKategori()) {
            daftarKategori[helper] = ktg.getNama();
            helper++;
        }
        return daftarKategori;
    }

    public static void setDaftarKategori(ArrayList<Kategori> daftarKategori) {
        SistakaNG.daftarKategori = daftarKategori;
    }

    public static Pengguna getPenggunaLoggedIn() {
        return penggunaLoggedIn;
    }

    public static void setPenggunaLoggedIn(Pengguna penggunaLoggedIn) {
        SistakaNG.penggunaLoggedIn = penggunaLoggedIn;
    }

    // Method ini digunakan untuk mendaftarkan staf-staf ketika program dijalankan
    public static void registerStaf() {
        String[] listNama = new String[] { "Dek Depe", "Dek DePram", "Dek Sofita", "Winter", "Boo" };
        for (int i = 0; i < listNama.length; i++) {
            Staf staf = new Staf(listNama[i]);
            daftarStaf.add(staf);

            System.out.println("Berhasil menambahkan staf dengan data:");
            System.out.println(staf);
        }
    }

    public static Pengguna handleLogin(String id) {
        // Cek apakah Staf
        if (id.startsWith("STAF")) {
            return findStaf(id);
        } else {
            return findAnggota(id);
        }
    }

    public static Staf findStaf(String id) {
        for (Staf staf : daftarStaf) {
            if (staf.getId().equals(id))
                return staf;
        }
        return null;
    }

    public static Anggota findAnggota(String id) {
        for (Anggota anggota : daftarAnggota) {
            if (anggota.getId().equals(id))
                return anggota;
        }
        return null;
    }

    public static Kategori findKategori(String nama) {
        for (Kategori kategori : daftarKategori) {
            if (kategori.getNama().equalsIgnoreCase(nama))
                return kategori;
        }
        return null;
    }

    public static Buku findBuku(String judul, String penulis) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul) && buku.getPenulis().equalsIgnoreCase(penulis)) {
                return buku;
            }
        }
        return null;
    }

    public static void removeBuku(Buku buku) {
        daftarBuku.remove(buku);
    }

    // Handle Menu Staf

    public static Mahasiswa addMahasiswa(
            String nama,
            String tanggalLahir,
            String programStudi,
            String angkatan) {
        Staf staf = (Staf) penggunaLoggedIn;
        Mahasiswa anggota = staf.tambahMahasiswa(nama, tanggalLahir, programStudi, angkatan);

        if (anggota != null)
            daftarAnggota.add(anggota);
        return anggota;
    }

    public static Dosen addDosen(String nama) {
        Staf staf = (Staf) penggunaLoggedIn;
        Dosen anggota = staf.tambahDosen(nama);

        if (anggota != null)
            daftarAnggota.add(anggota);
        return anggota;
    }

    public static Kategori addKategori(String nama, int poin) {
        Staf staf = (Staf) penggunaLoggedIn;
        Kategori kategori = staf.tambahKategori(nama, poin);

        if (kategori != null)
            daftarKategori.add(kategori);
        return kategori;
    }

    public static Buku addBuku(String judul, String penulis, String penerbit, String kategori, int stok) {
        Staf staf = (Staf) penggunaLoggedIn;
        Buku buku = staf.tambahBuku(judul, penulis, penerbit, kategori, stok);

        if (buku != null)
            daftarBuku.add(buku);
        return buku;
    }

    public static String deleteBuku(Buku buku) {
        Staf staf = (Staf) penggunaLoggedIn;
        return staf.hapusBuku(buku);
    }

    public static String handleRankingAnggota() {
        if (daftarAnggota.size() <= 0)
            return ("Belum ada anggota yang terdaftar pada sistem");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------- Peringkat Anggota ----------\n");
        Collections.sort(daftarAnggota);
        int batas = Math.min(3, daftarAnggota.size());
        for (int i = 0; i < batas; i++) {
            stringBuilder.append(String.format("==== %d ====\n", i + 1));
            stringBuilder.append(daftarAnggota.get(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    public static String daftarPeminjam(Buku buku) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buku.getData());
        stringBuilder.append("\n---------- Daftar Peminjam ----------\n");
        if (buku.getDaftarPeminjam().size() <= 0) {
            stringBuilder.append(String.format("Belum ada anggota yang meminjam buku %s%n", buku.getJudul()));
        } else {
            for (int i = 0; i < buku.getDaftarPeminjam().size(); i++) {
                stringBuilder.append(String.format("-%d%n", i + 1));
                stringBuilder.append(buku.getDaftarPeminjam().get(i)).append("\n");
            }
        }

        return stringBuilder.toString();
    }

    public static String pinjamBuku(Buku buku, String tanggalPeminjaman) {
        Anggota anggota = (Anggota) penggunaLoggedIn;

        if (buku.getStok() <= 0) {
            return String.format("Buku %s oleh %s tidak tersedia%n", buku.getJudul(), buku.getPenulis());
        } else {
            return (anggota.pinjam(buku, tanggalPeminjaman));
        }
    }

    public static String kembalikanBuku(Buku buku, String tanggalPengembalian) {
        Anggota anggota = (Anggota) penggunaLoggedIn;
        return (anggota.kembali(buku, tanggalPengembalian));
    }

    public static String bayarDenda(Long amount) {
        Anggota anggota = (Anggota) penggunaLoggedIn;
        return anggota.bayarDenda(amount);
    }
}

package backend.pengguna;

import backend.buku.Buku;

public interface CanBorrow {
    public String pinjam(Buku buku, String tanggalPeminjaman);
    public String kembali(Buku buku, String tanggalPengembalian);
}

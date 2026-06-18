package tugas;

public class Barang {
    // Atribut barang (Halaman 11)
    private String nama;
    private double harga;
    private int stok;

    // Constructor untuk menginisialisasi atribut (Halaman 11)
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter untuk mengakses atribut dari luar class (Halaman 11)
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Mengubah data objek menjadi teks satu baris dipisah semicolon (;) untuk disimpan ke berkas (Halaman 11)
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Mengembalikan keterangan lengkap barang untuk ditampilkan di layar (Halaman 11)
    public String info() {
        return nama + " | Harga: Rp" + harga + " | Stok: " + stok;
    }
}
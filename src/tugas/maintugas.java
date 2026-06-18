package tugas;

// ==========================================
// Nama : Muhammad Adam Fadillah
// NPM  : [Isi NPM Kamu di Sini]
// ==========================================

public class maintugas {
    public static void main(String[] args) {
        // 1. Menyimpan daftar nama kategori dalam array String ukuran tetap (Halaman 11)
        String[] kategori = {"Elektronik", "Pakaian", "Makanan"};
        System.out.println("=== KATEGORI TOKO ===");
        for (String k : kategori) {
            System.out.println("- " + k);
        }
        System.out.println();

        // 2. Membuat objek Gudang pertama dan mengisi minimal 5 objek Barang (Halaman 11)
        gudang gudangUtama = new gudang("barang.txt");
        System.out.println("=== PROSES INPUT BARANG ===");
        gudangUtama.tambahBarang(new Barang("Laptop Asus", 8500000, 10));
        gudangUtama.tambahBarang(new Barang("Mouse Wireless", 150000, 25));
        gudangUtama.tambahBarang(new Barang("Keyboard Mechanical", 450000, 15));
        gudangUtama.tambahBarang(new Barang("Headset Gaming", 350000, 20));
        gudangUtama.tambahBarang(new Barang("Smartphone", 3000000, 8));
        System.out.println();

        // Menampilkan barang sebelum disimpan
        gudangUtama.tampilkanSemua();
        System.out.println();

        // Menyimpan data barang ke berkas barang.txt (Halaman 11)
        gudangUtama.simpanKeBerkas();
        System.out.println("\n---------------------------------------------\n");

        // 3. Membuat objek Gudang baru yang kosong untuk membuktikan data tersimpan permanen (Halaman 11)
        gudang gudangBaru = new gudang("barang.txt");
        
        // Memuat kembali data dari berkas
        gudangBaru.muatDariBerkas();
        System.out.println();

        // Menampilkan kembali data yang berhasil dimuat (Halaman 11)
        gudangBaru.tampilkanSemua();
        System.out.println();

        // Menampilkan total nilai persediaan (Halaman 11)
        System.out.println("Total Nilai Persediaan: Rp" + gudangBaru.totalNilai());
    }
}
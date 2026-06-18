package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class gudang {
    // Menyimpan banyak objek Barang menggunakan ArrayList (Halaman 11)
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah barang baru ke dalam ArrayList (Halaman 11)
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
        System.out.println("Barang berhasil ditambahkan: " + barang.getNama());
    }

    // Menampilkan semua barang di gudang beserta nomor urut (Halaman 11)
    public void tampilkanSemua() {
        System.out.println("=== DAFTAR BARANG DI GUDANG ===");
        if (daftarBarang.isEmpty()) {
            System.out.println("(Gudang kosong)");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBarang.get(i).info());
            }
        }
    }

    // Menyimpan data dari ArrayList ke berkas teks menggunakan try-with-resources (Halaman 11)
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("Data gudang berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    // Membaca kembali data dari berkas teks ke dalam ArrayList (Halaman 11)
    public void muatDariBerkas() {
        daftarBarang.clear(); // Bersihkan list sebelum memuat data baru
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                // Validasi panjang array hasil split agar terhindar dari ArrayIndexOutOfBoundsException (Halaman 13)
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Data gudang berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    // Menghitung total nilai persediaan (harga dikali stok dari seluruh barang) (Halaman 11)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}
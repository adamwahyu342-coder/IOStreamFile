package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class bukukontak {
    private ArrayList<kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public bukukontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahkontak(kontak kontak) {
        daftar.add(kontak);
    }

    public void tampilkanSemua() {
        for (kontak k : daftar) {
            System.out.println("- " + k.info());
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Data berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // DISESUAIKAN (Soal No. 2): Memecah baris menjadi 3 bagian (length == 3)
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) { // Diubah dari 2 menjadi 3 bagian
                    daftar.add(new kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Data berhasil dimuat.");
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }

    // TAMBAHAN (Soal No. 1): Method untuk mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        for (kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + k.info());
                return; // Berhenti jika sudah ketemu
            }
        }
        System.out.println("Kontak " + nama + " tidak ditemukan.");
    }

    // TAMBAHAN (Soal No. 3): Method untuk menghapus kontak berdasarkan nama
    public void hapusKontak(String nama) {
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak " + daftar.get(i).getNama() + " berhasil dihapus.");
                daftar.remove(i); // Menghapus kontak dari ArrayList
                simpanKeBerkas(); // Memanggil simpanKeBerkas agar perubahan ikut tersimpan di txt
                return;
            }
        }
        System.out.println("Gagal menghapus, kontak " + nama + " tidak ditemukan.");
    }
}
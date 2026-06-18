package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class latihanmandiri1 {
    public static void main(String[] args) {
        
        // --- Soal No 1: Cek keberadaan dan ukuran laporan.txt ---
        System.out.println("=== SOAL 1 ===");
        File laporan = new File("laporan.txt");
        if (laporan.exists()) {
            System.out.println("Berkas ada, ukuran: " + laporan.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }
        System.out.println();

        // --- Soal No 2: Membuat folder baru 'arsip' ---
        System.out.println("=== SOAL 2 ===");
        File folder = new File("arsip");
        if (folder.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Folder 'arsip' gagal dibuat atau sudah ada.");
        }
        System.out.println();

        // --- Soal No 3: Buat berkas 'sementara.txt' lalu hapus ---
        System.out.println("=== SOAL 3 ===");
        File berkasSementara = new File("sementara.txt");
        try {
            berkasSementara.createNewFile();
            System.out.println("Sebelum dihapus, ada? " + berkasSementara.exists());
            
            berkasSementara.delete();
            System.out.println("Sesudah dihapus, ada? " + berkasSementara.exists());
        } catch (IOException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}
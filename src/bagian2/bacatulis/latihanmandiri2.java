package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class latihanmandiri2 {
    public static void main(String[] args) {
        
        // --- Soal No 1 & 2: Tulis 5 hari, lalu append 2 hari lagi ---
        System.out.println("=== SOAL 1 & 2 (Menulis & Menambah Hari) ===");
        String[] hariAwal = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        // Menulis 5 hari pertama (menimpa/membuat baru)
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            for (String h : hariAwal) {
                penulis.println(h);
            }
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

        // Tambah (append) 2 hari lagi dengan parameter true
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
        } catch (IOException e) {
            System.out.println("Gagal menambah hari: " + e.getMessage());
        }

        // Membaca dan menampilkan seluruh isi file hari.txt
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
        System.out.println();

        // --- Soal No 3: Menghitung total baris di dalam hari.txt ---
        System.out.println("=== SOAL 3 (Hitung Jumlah Baris) ===");
        int jumlah = 0;
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            while (pembaca.readLine() != null) {
                jumlah++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
        System.out.println("Jumlah baris di hari.txt: " + jumlah);
    }
}
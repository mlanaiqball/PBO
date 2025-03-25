import java.util.ArrayList;
import java.util.Scanner;

// Class Reservasi dengan penerapan Encapsulation
class Reservasi {
    private String namaPelanggan;
    private String jenisKendaraan;
    private String tanggalReservasi;

    public Reservasi(String namaPelanggan, String jenisKendaraan, String tanggalReservasi) {
        this.namaPelanggan = namaPelanggan;
        this.jenisKendaraan = jenisKendaraan;
        this.tanggalReservasi = tanggalReservasi;
    }

    // Getter dan Setter dengan akses modifier yang sesuai
    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getTanggalReservasi() {
        return tanggalReservasi;
    }

    public void setTanggalReservasi(String tanggalReservasi) {
        this.tanggalReservasi = tanggalReservasi;
    }

    @Override
    public String toString() {
        return "Pelanggan: " + namaPelanggan + ", Kendaraan: " + jenisKendaraan + ", Tanggal: " + tanggalReservasi;
    }
}

// Class utama untuk mengelola reservasi
public class BengkelReservasi {
    private static ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Manajemen Reservasi Bengkel AutoFix ===");
            System.out.println("1. Tambah Reservasi");
            System.out.println("2. Tampilkan Reservasi");
            System.out.println("3. Ubah Reservasi");
            System.out.println("4. Hapus Reservasi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    tambahReservasi();
                    break;
                case 2:
                    tampilkanReservasi();
                    break;
                case 3:
                    ubahReservasi();
                    break;
                case 4:
                    hapusReservasi();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    // Method dengan access modifier protected
    protected static void tambahReservasi() {
        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jenis Kendaraan: ");
        String kendaraan = scanner.nextLine();
        System.out.print("Masukkan Tanggal Reservasi (YYYY-MM-DD): ");
        String tanggal = scanner.nextLine();

        daftarReservasi.add(new Reservasi(nama, kendaraan, tanggal));
        System.out.println("Reservasi berhasil ditambahkan!");
    }

    // Method dengan access modifier public
    public static void tampilkanReservasi() {
        if (daftarReservasi.isEmpty()) {
            System.out.println("Tidak ada reservasi.");
            return;
        }
        System.out.println("\nDaftar Reservasi:");
        for (int i = 0; i < daftarReservasi.size(); i++) {
            System.out.println((i + 1) + ". " + daftarReservasi.get(i));
        }
    }

    protected static void ubahReservasi() {
        tampilkanReservasi();
        System.out.print("Pilih nomor reservasi yang akan diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Clear buffer

        if (index >= 0 && index < daftarReservasi.size()) {
            System.out.print("Masukkan Nama Baru: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan Jenis Kendaraan Baru: ");
            String kendaraan = scanner.nextLine();
            System.out.print("Masukkan Tanggal Baru (YYYY-MM-DD): ");
            String tanggal = scanner.nextLine();

            daftarReservasi.get(index).setNamaPelanggan(nama);
            daftarReservasi.get(index).setJenisKendaraan(kendaraan);
            daftarReservasi.get(index).setTanggalReservasi(tanggal);
            System.out.println("Reservasi berhasil diperbarui!");
        } else {
            System.out.println("Nomor reservasi tidak valid.");
        }
    }

    private static void hapusReservasi() {
        tampilkanReservasi();
        System.out.print("Pilih nomor reservasi yang akan dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Clear buffer

        if (index >= 0 && index < daftarReservasi.size()) {
            daftarReservasi.remove(index);
            System.out.println("Reservasi berhasil dihapus!");
        } else {
            System.out.println("Nomor reservasi tidak valid.");
        }
    }
}

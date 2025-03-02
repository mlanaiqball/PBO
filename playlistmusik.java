import java.util.*;

// Kelas utama untuk sistem playlist musik
class MusicPlaylist {
    private List<Song> songs;
    private Random random;

    // Konstruktor
    public MusicPlaylist() {
        this.songs = new ArrayList<>();
        this.random = new Random();
    }

    // Menambahkan lagu ke playlist
    public void addSong(String title, String artist, String genre) {
        songs.add(new Song(title, artist, genre));
        System.out.println("Lagu berhasil ditambahkan!");
    }

    // Menghapus lagu dari playlist
    public void deleteSong(int index) {
        if (index < 0 || index >= songs.size()) {
            System.out.println("Indeks tidak valid!");
            return;
        }
        System.out.println("Menghapus lagu: " + songs.get(index).getInfo());
        songs.remove(index);
        System.out.println("Lagu berhasil dihapus!");
    }

    // Menampilkan semua lagu dalam playlist
    public void displayPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("\n[Playlist Kosong! Tambahkan lagu terlebih dahulu.]");
            return;
        }
        System.out.println("\n=== Daftar Lagu dalam Playlist ===");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i).getInfo());
        }
    }

    // Memutar lagu secara acak
    public void playRandomSong() {
        if (songs.isEmpty()) {
            System.out.println("\n[Playlist kosong, tambahkan lagu terlebih dahulu!]");
            return;
        }
        Song randomSong = songs.get(random.nextInt(songs.size()));
        System.out.println("\nMemutar lagu secara acak: " + randomSong.getInfo());
    }
    
    // Memutar lagu berdasarkan urutan
    public void playSequentially() {
        if (songs.isEmpty()) {
            System.out.println("\n[Playlist kosong, tambahkan lagu terlebih dahulu!]");
            return;
        }
        System.out.println("\n=== Memutar Lagu Berdasarkan Urutan ===");
        for (Song song : songs) {
            System.out.println("Memutar: " + song.getInfo());
        }
    }
}

// Kelas Song dengan enkapsulasi
class Song {
    private String title;
    private String artist;
    private String genre;

    // Konstruktor
    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    // Mengembalikan informasi lagu
    public String getInfo() {
        return "\"" + title + "\" - " + artist + " [" + genre + "]";
    }
}

// Kelas Main untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlaylist playlist = new MusicPlaylist();
        
        while (true) {
            System.out.println("\n=== Menu Playlist Musik ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Playlist");
            System.out.println("3. Putar Lagu Acak");
            System.out.println("4. Putar Semua Lagu Berurutan");
            System.out.println("5. Hapus Lagu");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul lagu: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan artis: ");
                    String artist = scanner.nextLine();
                    System.out.print("Masukkan genre: ");
                    String genre = scanner.nextLine();
                    playlist.addSong(title, artist, genre);
                    break;
                case 2:
                    playlist.displayPlaylist();
                    break;
                case 3:
                    playlist.playRandomSong();
                    break;
                case 4:
                    playlist.playSequentially();
                    break;
                case 5:
                    playlist.displayPlaylist();
                    System.out.print("Masukkan nomor lagu yang ingin dihapus: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();
                    playlist.deleteSong(index);
                    break;
                case 6:
                    System.out.println("\nTerima kasih telah menggunakan sistem playlist musik!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }
}

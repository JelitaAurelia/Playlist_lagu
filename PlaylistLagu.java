package semester3;

import java.util.Scanner;

public class PlaylistLagu {
    // Kelas Song
    static class Song {
        String title;
        Song next;

        public Song(String title) {
            this.title = title;
            this.next = null;
        }
    }

    // Kelas Playlist
    static class Playlist {
        private Song head;

        public Playlist() {
            this.head = null;
        }

        // Menambah lagu di akhir playlist
        public void addSong(String title) {
            Song newSong = new Song(title);
            if (head == null) {
                head = newSong; // Jika playlist kosong, lagu baru menjadi head
            } else {
                Song current = head;
                while (current.next != null) {
                    current = current.next; // Mencari akhir playlist
                }
                current.next = newSong; // Menambahkan lagu baru di akhir
            }
            System.out.println("Lagu '" + title + "' ditambahkan ke playlist.");
        }

        // Menampilkan semua lagu dalam playlist
        public void displayPlaylist() {
            if (head == null) {
                System.out.println("Playlist kosong.");
                return;
            }
            Song current = head;
            System.out.println("Playlist:");
            while (current != null) {
                System.out.println("- " + current.title);
                current = current.next; // Melanjutkan ke lagu berikutnya
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        String command;

        System.out.println("Playlist Lagu");
        do {
            System.out.print("Masukkan perintah (add/show/exit): ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Masukkan judul lagu: ");
                    String title = scanner.nextLine();
                    playlist.addSong(title);
                    break;
                case "show":
                    playlist.displayPlaylist();
                    break;
                case "exit":
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Perintah tidak dikenali. Silakan coba lagi.");
                    break;
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}

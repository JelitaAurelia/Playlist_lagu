package semester3;

import java.util.Scanner;

public class PlaylistLagu {

    static class Song {
        String title;
        Song next;

        public Song(String title) {
            this.title = title;
            this.next = null;
        }
    }

    static class Playlist {
        private Song head;

        public Playlist() {
            this.head = null;
        }

        public void addSong(String title) {
            Song newSong = new Song(title);
            if (head == null) {
                head = newSong;
            } else {
                Song current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newSong;
            }
            System.out.println("Lagu '" + title + "' ditambahkan ke playlist.");
        }

        public void displayPlaylist() {
            if (head == null) {
                System.out.println("Playlist kosong.");
                return;
            }
            Song current = head;
            System.out.println("Playlist:");
            while (current != null) {
                System.out.println("- " + current.title);
                current = current.next;
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

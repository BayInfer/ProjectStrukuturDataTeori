/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author NAUVAL HILALAH
 */
public class PeminjamanBuku {
    public static void main(String[] args) throws IOException {
        int value;
        // Untuk Case Insert
        int id;
        String Judul;
        String Pengarang;
        String Genre;
        
        // Memasukkan Buku dengan Data Buku
        Tree Buku = new Tree();
        Buku.insert(50, "To Kill a Mockingbird", "Harper Lee","Misteri");
        Buku.insert(25, "Lord of the Rings", "J.R. R.  Tolkien", "Fantasi" );
        Buku.insert(75, "Study in Scarlet", "Arthur Conan Doyle", "Fantasi");
        Buku.insert(12, "The Great Gatsby", "F. Scott Fitzgerald", "Drama");
        Buku.insert(37, "Brave New World", "Aldous Huxley ", "Aksi");
        Buku.insert(43, "Dune", "Frank Herbert", "Sci-Fi");
        Buku.insert(30, "The Martian", "Andy Weir", "Sci-Fi");
        Buku.insert(10, "Hujan", "Tere-Liye", "Romansa");
        Buku.insert(87, "The Deathstalker", "Jan Rekejevik", "Horror");
        Buku.insert(60, "Escape from Alcatraz", "Loki Tom", "Thriller");
        Buku.insert(55, "Negeri Di Ujung Tanduk", "Darwis", "Aksi");
        Buku.insert(22, "Pergi", "Lesmana", "Aksi");
        Buku.insert(65, "Ranah 3 Warna", "Ahmad Fuaidil", "Drama");
        
            System.out.println("==========================================================");
            System.out.println("Selamat Datang Di Perpustakaan Buku Binary Tree");
            System.out.println("==========================================================");
            
            // Pilihan Perintah
            System.out.println("Kembalikan Buku | Pinjam Buku | Cari Buku | List Buku  ");
            
        while (true) {
            
           
            
            
            System.out.print("Masukkan Huruf Pertama Perintah untuk melakukan Perintah : ");
            int choice = getChar();
            switch (choice) {
                
                // Menampilkan Binary Tree
                case 'l':
                    System.out.println("");
                    Buku.displayTree();
                    System.out.println("");
                    break;
                    
                // Memasukkan Buku Baru ke Binary Tree    
                case 'k':
                    System.out.println("");
                    // Memasuukan ID Buku
                    System.out.print("Masukkan ID Buku : ");
                    id = getInt();
                    if (Buku.find(id) != null) {
                        System.out.println("ID Buku ini sudah ada");
                        break;
                    }
                    
                    // Memasukkan Judul Buku
                    System.out.print("Masukkan Judul Buku : ");
                    Judul = getString();
                    // Memasukkan Pengarang Buku
                    System.out.print("Masukkan Pengarang Buku :");
                    Pengarang = getString();
                    // Memasukkan Genre Buku
                    System.out.print("Masukkan Genre Buku :");
                    Genre = getString();
                    
                    // Memasuukan Inputan ke Class Buku
                    Buku.insert(id, Judul, Pengarang, Genre);
                    break;
                    
                // Menemukan Buku Dengan memasukkan id
                case 'c':
                    System.out.println("");
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    System.out.println("");
                    Buku found = Buku.find(value);
                    if (found != null) {
                        System.out.print("ID " +value+ " Ditemukan ");
                        found.displayBuku();
                        System.out.print("\n");
                    } else {
                        System.out.println("Could not find "+ value);
                    }
                    break;
                    
                // Menghapus Buku berdasarkan id
                case 'p':
                    System.out.println("");
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = Buku.delete(value);
                    if (didDelete) {
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Could not delete "+ value);
                    }
                    break;
                
                // Traverse
                case 't':
                    System.out.println("");
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = getInt();
                    Buku.traverse(value);
                    break;
                
                // Mencari Buku dengan ID Terkecil
                case '-':
                    System.out.println("");
                    System.out.print("Min value = ");
                    Buku.findMin().displayBuku();
                    System.out.println();
                    break;
                    
                // Mencari Buku dengan ID Terbesar   
                case '+':
                    System.out.println("");
                    System.out.print("Max value = ");
                    Buku.findMax().displayBuku();
                    System.out.println();
                    break;
                    
                 
            }
        }
    }
    
        public static String getString() throws IOException {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
        return s;
        }
        
        public static char getChar() throws IOException {
            String s = getString();
            return s.charAt(0);
        }
        
        public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
        }
        
        
}

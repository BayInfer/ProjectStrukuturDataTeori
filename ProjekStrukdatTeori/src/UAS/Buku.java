/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;



/**
 *
 * @author NAUVAL HILALAH
 */
public class Buku {
    public int id;
    public String Judul;
    public String Pengarang;
    public String Genre;
    public Buku leftChild;
    public Buku rightChild;
        
            public void displayBuku() {
                System.out.print(
                            
                            "\n"+"========================================"+
                            "\n"+"ID Buku           = "+ id+        
                            "\n"+"Judul Buku        = "+ Judul+
                            "\n"+"Nama Pengarang    = "+ Pengarang+
                            "\n"+"Genre             = "+ Genre+
                            "\n"+"========================================"
                        
                );
                System.out.println("");
            }
}


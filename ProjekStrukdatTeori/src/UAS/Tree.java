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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Tree {
    private Buku root;
    
    public Tree() {
        root = null;
    }
    
    public void displayBuku() {
            root.displayBuku();
        }
    
    
    
    public Buku find(int key) {
        Buku current = root;
            while (current.id != key) {
            if (key < current.id) {
            current = current.leftChild;
            } else {
            current = current.rightChild;
            }
            if (current == null) {
            return null;
            }
        }
        return current;
        }
    
    
    
    
    
    public boolean isDuplicated(int key) {
        return find(key) != null;
    }

    public void insert(int id, String Judul, String Pengarang, String Genre) {
        Buku newBuku = new Buku();
        newBuku.id = id;
        newBuku.Judul = Judul;
        newBuku.Pengarang = Pengarang;
        newBuku.Genre = Genre;
        if (root == null) {
            root = newBuku;
        } else if (isDuplicated(id)) {
            System.out.println("Id node yang dimasukkan sudah ada pada tree");
        } else {
            Buku current = root;
            Buku parent;
            while (true) {
                parent = current;
                if (id < current.id) {
                    current = current.leftChild;
        if (current == null) {
                        parent.leftChild = newBuku;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newBuku;
                        return;
                    }
                }
            }
        }
    }



    
    
        public boolean delete(int key) {
        Buku current = root;
        Buku parent = root;
        boolean isLeftChild = true;
       while (current.id != key) {
        parent = current;
        if (key < current.id) {
        isLeftChild = true;
        current = current.leftChild;
        } else {
        isLeftChild = false;
        current = current.rightChild;
        }
        if (current == null) {
        return false;
        }
        }
        if (current.leftChild == null 
        && current.rightChild == null) {
        if (current == root) {
        root = null;
        } else if (isLeftChild) {
        parent.leftChild = current.leftChild;
        } else {
        parent.rightChild = current.leftChild;
        }
        } else if (current.rightChild == null) {
        if (current == root) {
        root = current.leftChild;
        } else if (isLeftChild) {
        parent.leftChild = current.leftChild;
        } else {
        parent.rightChild = current.leftChild;
        }
        } else if (current.leftChild == null) {
        if (current == root) {
        root = current.rightChild;
        } else if (isLeftChild) {
        parent.leftChild = current.rightChild;
        } else {
        parent.rightChild = current.rightChild;
        }
        } else {
        Buku successor = getSuccessor(current);
        if (current == root) {
        root = successor;
        } else if (isLeftChild) {
        parent.leftChild = successor;
        } else {
        parent.rightChild = successor;
        }
        successor.leftChild = current.leftChild;
        }
        return true;
        }
        
        
        private Buku getSuccessor(Buku delBuku) {
            Buku successorParent = delBuku;
            Buku successor = delBuku;
            Buku current = delBuku.rightChild;
            while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
            }
            if (successor != delBuku.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delBuku.rightChild;
            }
            return successor;
            }
            public void traverse(int traverseType) {
            switch (traverseType) {
            case 1:
            System.out.print("Preorder traversal: ");
            preOrder(root);
            break;
            case 2:
            System.out.print("Inorder traversal: ");
            inOrder(root);
            break;
            case 3:
            System.out.print("Postorder traversal: ");
            postOrder(root);
            break;
            }
            System.out.println();
          }
        
        private void preOrder(Buku localRoot) {
            if (localRoot != null) {
            System.out.print(localRoot.id + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
            }
        }
        
        private void inOrder(Buku localRoot) {
            if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.id + " ");
            inOrder(localRoot.rightChild);
            }
        }
        
        private void postOrder(Buku localRoot) {
            if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.id + " ");
            }
        }
        
        public void displayTree() {
            Stack globalStack = new Stack();
            globalStack.push(root);
            int nBlanks = 32;
            boolean isRowEmpty = false;
            System.out.println(

           "......................................................");
            while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
            System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
            Buku temp = (Buku) globalStack.pop();
            if (temp != null) {
            System.out.print(temp.id);
           localStack.push(temp.leftChild);
           localStack.push(temp.rightChild);
           if (temp.leftChild != null
            || temp.rightChild != null) {
            isRowEmpty = false;
            }
            } else {
           System.out.print("--");
            localStack.push(null);
           localStack.push(null);
            }
            for (int j = 0; j < nBlanks * 2 - 2; j++) {
            System.out.print(' ');
            }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
            globalStack.push(localStack.pop());
            }
            } 
            System.out.println(

           "......................................................");
        }
        
        public Buku findMin() {
        Buku current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    public Buku findMax() {
        Buku current = root;
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current;
    }
 
 
        
}





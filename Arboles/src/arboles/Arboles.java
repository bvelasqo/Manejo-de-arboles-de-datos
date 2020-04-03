/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author Brandon Velasquez
 */
public class Arboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree(50);
        tree.Add(10);
        tree.Add(70);
        tree.Add(9);
        tree.Add(20);
        tree.Add(60);
        tree.Add(75);
        tree.Add(85);
        tree.Add(65);
        tree.Add(40);
        tree.Add(80);
        tree.Add(7);
        tree.Add(8);
        tree.Add(30);
        tree.Add(45);
        tree.Add(90);
        tree.Add(88);
        tree.Add(3);
        tree.Add(4);
        tree.Add(5);
        tree.Add(2);
        tree.Add(1);
        tree.Add(6);
        tree.Add(21);
        tree.Add(22);
        tree.Add(23); 
        tree.Add(43);
        tree.Add(44);
        tree.Add(47);
        tree.Add(48);
        tree.Add(86);
        tree.Add(89);
        tree.Add(64);
        tree.Add(63);
        tree.Add(0);

        System.out.println("Sin borrar");
        tree.inorden();
        tree.delete(2);//
        System.out.println("");
        System.out.println("Borrado");
        tree.inorden();

    }
    
}

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
        // TODO code application logic here

        MaxHeap maxData = new MaxHeap();
        //31,51,53,28,47,22
        maxData.insert(31);
        maxData.insert(51);
        maxData.insert(53);
        maxData.insert(28);
        maxData.insert(47);
        maxData.insert(22);
        System.out.println(maxData.getDataHeap());
        maxData.ExtractMax();
        System.out.println(maxData.getDataHeap());

//        BinarySearchTree pino = new BinarySearchTree(8);
//        try {
//            pino.Add(3);
//            pino.Add(9);    
//            pino.InOrden();
//            pino.Delete(3);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("");
//
//        pino.InOrden();
//        
        BinarySearchTree pino = new BinarySearchTree(10);
        //datos de prueba que se pueden usar en https://visualgo.net/en/bst
        //10,5,3,8,20,7,18,25,23,30,21,24        
        pino.Add(5);
        pino.Add(3);
        pino.Add(8);
        pino.Add(20);
        pino.Add(7);
        pino.Add(18);
        pino.Add(25);
        pino.Add(23);
        pino.Add(30);
        pino.Add(21);
        pino.Add(24);
        System.out.println("");

        System.out.println("Inorden");
        pino.InOrden();
        System.out.println("");
        System.out.println("");
        System.out.println("preorden");
        pino.PreOrden();
        System.out.println("");
        System.out.println("");
        System.out.println("postorden");
        pino.Postorden();
        System.out.println("");
        pino.Delete(20);
        System.out.println("");
        System.out.println("Inorden borrado 20");
        pino.InOrden();
        System.out.println("");
        pino.Delete(5);
        pino.Delete(3);
        pino.Delete(25);
        pino.Delete(30);
        pino.Delete(8);
        System.out.println("");
        System.out.println("Inorden borrados los numeros(5,3,25,30,8)");
        pino.InOrden();
        System.out.println("");
        System.out.println("Hojas");
        System.out.println(pino.CountLeafs());
        System.out.println("Nodos");
        System.out.println(pino.CountNodes());
        System.out.println("Último nivel");
        System.out.println(pino.LastLevel());
        System.out.println("Level order");
        pino.LevelOrder();
        System.out.println("Borrar raiz(55) en otro árbol(55-99)");
        //System.out.println(pino.Search(88));
        BinarySearchTree testDeleteRoot = new BinarySearchTree(55);
        testDeleteRoot.Add(99);
        //borrar
        testDeleteRoot.Delete(55);
        //mostrar el resultado
        testDeleteRoot.InOrden();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.HashMap;
import java.util.PriorityQueue;

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
        System.out.println("Montículo Máximo");
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
        System.out.println("");
        System.out.println("Arbol de búsqueda binaria");
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
        System.out.println("Borrar raiz(55) en otro árbol(55-44)");
        //System.out.println(pino.Search(88));
        BinarySearchTree testDeleteRoot = new BinarySearchTree(55);
        testDeleteRoot.Add(44);        //borrar
        testDeleteRoot.Delete(55);
        //mostrar el resultado
        testDeleteRoot.InOrden();
        System.out.println("");
        System.out.println("");
        System.out.println("GRAFOS");
        System.out.println("");
        Graph g1 = new Graph(7);
        g1.addEdge(5,3);
        g1.addEdge(4,0);
        g1.addEdge(0,1);
        g1.addEdge(6,5);
        g1.addEdge(3,4);
        System.out.println("Matriz de adyacencia");
        System.out.println(g1.showAmatrix());
        System.out.println("Lista de adyacencia");
        System.out.println(g1.showAList());
        System.out.println("Recorrido en profundidad");
        g1.DFS(0);
        System.out.println("");
        System.out.println("Recorrido en anchura");
        g1.BFS(0);
        System.out.println("");
        System.out.println("Recorrido completo");
        g1.RecorrerGrafoEntero();
        System.out.println("");
        System.out.println("Mismas entradas y salidas");
        System.out.println(g1.MismasEntradasYSaalidas());
        System.out.println("Vertices faltantes");
        g1.ArcosFaltantes();
        System.out.println("");
        System.out.println("Grafo dinámico");
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node("A", 9));
        pq.add(new Node("B", 3));
        pq.add(new Node("C", 5));
        System.out.println("Sacado de la cola: "+pq.poll().getNode());
        DGrahp g0 = new DGrahp();
        g0.addNode("A");
        g0.addNode("D");
        g0.addNode("B");
        g0.addNode("C");
        g0.addNode("E");
        g0.addEdge("A", "B", 1);
        g0.addEdge("A", "C", 1);
        g0.addEdge("A", "E", 3);
        g0.addEdge("C", "E", 1);
        g0.showAlist();
        DGrahp g2 = new DGrahp();
        g2.addNode("A");
        g2.addNode("B");
        g2.addNode("C");
        g2.addNode("D");
        g2.addEdge("A", "B", 2);
        g2.addEdge("A", "C", 5);
        g2.addEdge("B", "A", 2);
        g2.addEdge("B", "C", 2);
        g2.addEdge("B", "D", 5);
        g2.addEdge("C", "A", 5);
        g2.addEdge("C", "B", 2);
        g2.addEdge("C", "D", 1);
        g2.addEdge("D", "B", 5);
        g2.addEdge("D", "C", 1);
        g2.showAlist();
        HashMap<String,Node> map=g2.Dijkstra("A");
        for(String node:map.keySet()){
            System.out.println(node + map.get(node).getWeight()+map.get(node).getNode());
        }
        System.out.println("");
        System.out.println("Pruebas de taller de grafos:");
        System.out.println("Punto 1");
        Graph grafoP1 =new Graph(4);
        grafoP1.addEdge(0, 1);
        grafoP1.addEdge(0, 2);
        grafoP1.addEdge(0, 3);
        grafoP1.addEdge(1, 0);
        grafoP1.addEdge(2, 0);
        grafoP1.addEdge(3, 0);
        System.out.println("[[1,2,3],[0],[0],[0]]");
        System.out.println("Recorrido de todo el grafo");
        grafoP1.RecorrerGrafoEntero();
        //punto 2:
         //[[false, true,  false, false],
         //[false, false, true,  false],
          //[true,  false, false, true ],
          //[false, false, true,  false]]
          System.out.println("\n");
          System.out.println("Punto 2");
          System.out.println("Matriz");
          System.out.println("");
          System.out.println("[[false, true,  false, false],");
          System.out.println("[false, false, true,  false],");
          System.out.println("[true,  false, false, true ],");
          System.out.println("[false, false, true,  false]]");
        Graph grafoP2 =new Graph(4);
        grafoP2.addEdge(0, 1);
        grafoP2.addEdge(1, 2);
        grafoP2.addEdge(2, 0);
        grafoP2.addEdge(2, 3);
        grafoP2.addEdge(3, 2);
        System.out.println("");
        System.out.println("Validacion de que tenga mismas entradas que salidas");
        System.out.println(grafoP2.MismasEntradasYSaalidas());
        System.out.println("");
        System.out.println("Punto 3");
        System.out.println("Arcos");
        System.out.println("[[5,3],  [4,0],  [0,1],  [6,5],  [3,4],  [0,3],  [2,0],  [2,1],  [2,6], "
                + "\n [5,1],  [3,2],  [0,5],  [1,3],  [1,4],  [6,3]]");
        Graph grafoP3 = new Graph(7);
        grafoP3.addEdge(5,3);
        grafoP3.addEdge(4,0);
        grafoP3.addEdge(0,1);
        grafoP3.addEdge(6,5);
        grafoP3.addEdge(3,4);
        grafoP3.addEdge(0,3);
        grafoP3.addEdge(2,0);
        grafoP3.addEdge(2,1);
        grafoP3.addEdge(2,6);
        grafoP3.addEdge(5,1);
        grafoP3.addEdge(3,2);
        grafoP3.addEdge(0,5);
        grafoP3.addEdge(1,3);
        grafoP3.addEdge(1,4);
        grafoP3.addEdge(6,3);
        System.out.println("Arcos faltantes");
        grafoP3.ArcosFaltantes();
        
    }   
    
    
}

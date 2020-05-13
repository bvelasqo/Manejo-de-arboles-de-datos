/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Brandon Velasquez
 */
public class Graph {
    private final boolean aMatrix[][];
    private final int totalNodes;
    private final LinkedList<Integer> aList[];
    public Graph(int n){
        totalNodes=n;
        aMatrix=new boolean[n][n];
        aList = new LinkedList[n];
        for (int i = 0; i < totalNodes; i++) {
            aList[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int source, int destination){
        aMatrix[source][destination]=true;
        aList[source].add(destination);
    }
    
    public void deleteEdge(int source, int destination){
        aList[source].remove((Object) destination);
        aMatrix[source][destination]=false;
    }
    
    public void breadthFirst(){
        
    }
    
    public String showAmatrix(){
        String table="";
        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                table+=aMatrix[i][j]?1+"|":0 + "|";
            }
            table+="\n";
        }
        return table;
    }
    public String showAList(){
        String List="";
        for (int i = 0; i < totalNodes; i++) {
            List+= i+": | ";
            for(Integer vertex:aList[i]){
                List+=vertex + " | ";
            }
            List+="\n";
        }
        return List;
    }
    //1. Para un grafo de N nodos conectados bidireccionalmente,
    //retornar la ruta que permite visitar todos sus nodos. Se puede 
    //empezar y finalizar en cualquier nodoy visitarlos múltiples veces.
    ArrayList<String> visitado=new ArrayList<>();
    public void RecorrerGrafoEntero(){
        RecorrerGrafoEntero(0);
    }
    private void RecorrerGrafoEntero(int source){
        if(visitado.size()!=aList.length){
        visitado.add(source+"");
        System.out.print(source+" ");
          for(int vecino:aList[source]){
             if(!visitado.contains(vecino+"")){
                    RecorrerGrafoEntero(vecino);
                    System.out.print(source+" ");
                }
            }
        }
    }
    /*
    3. Dada una cantidad de nodos y una lista de arcos, 
    retornar los arcos faltantes para conectar todos los nodos.
    */
    public void ArcosFaltantes(){
        ArrayList<String> faltantes =new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            for (int j = i; j < totalNodes; j++) {
                boolean existe=false;
                for(int vecinos:aList[i]){
                    if((vecinos==j&&!aList[vecinos].contains(i))
                            ||(aList[j].contains(i))){
                        existe=true;
                    }
                }
                if(!existe&&i!=j){
                    faltantes.add("("+i+","+j+")");
                }
            }
        }
        for(String f:faltantes){
            System.out.print(f+" ");
        }
    }
    //2. Para una matriz de adyacencias de un grafo, determinar si cada nodo 
    //tiene el mismo número de entradas y salidas.
    public boolean MismasEntradasYSaalidas(){
        int con1=0,con2=0;
        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                if(aMatrix[i][j]){
                    con1++;
                }
            }
            for (int j = 0; j < totalNodes; j++) {
                if(aMatrix[j][i]){
                    con2++;
                }
            }
            if(!(con1==con2)){
                return false;
            }
        }
        return true;
    }
    
    
    public void BFS(int source){
        boolean visited[]=new boolean[totalNodes];
        LinkedList<Integer> queue=new LinkedList<>();
        visited[source]=true;
        queue.add(source);
        while(!queue.isEmpty()){
            source=queue.poll();
            System.out.print(source+" ");
            for(int neighbour:aList[source]){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.add(neighbour);
                }
            }
        }
    }
    
    public void DFS(int source){
        boolean visited[]=new boolean[totalNodes];
        DFS(source,visited);
    }
    private void DFS(int source, boolean visited[]){
        visited[source]=true;
        System.out.print(source+" ");
        for (Integer neighbour : aList[source]) {
            if(!visited[neighbour])
                DFS(neighbour,visited);
        }
    }
    
}

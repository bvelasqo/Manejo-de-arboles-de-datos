/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author Brandon Velasquez
 */
public class Graph {
    private boolean aMatrix[][];
    private int totalNodes;
    private LinkedList<Integer> aList[];
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
}

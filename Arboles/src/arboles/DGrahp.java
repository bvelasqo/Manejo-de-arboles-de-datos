/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author Brandon Velasquez
 */
public class DGrahp {
    private final HashMap<String,LinkedList<Node>> aList;

    public DGrahp() {
        aList=new HashMap<>();
    }
    public void addNode(String data){
        aList.putIfAbsent(data, new LinkedList<>());
    }
    
    private String getDataList(String key){
        LinkedList<Node> data;
        data =aList.get(key);
        String b="";
        for(Node n:data){
            b+="("+n.getNode()+","+n.getWeight()+")";
        }
        return b;
    }
    
    public void showAlist(){
        for(String node:aList.keySet()){
            System.out.println(node+":"+getDataList(node));
        }
    }
    
    public void addEdge(String source,String destination,int weight){
        aList.get(source).add(new Node(destination, weight));
    }
    
    public HashMap<String,Node> Dijkstra(String current){
        HashMap<String,Node> map=new HashMap<>();
        Node data;
        for(String node:aList.keySet()){
            if(node.equals(current)){
            data=new Node(null, 0);
            }else{
             data=new Node(null, Integer.MAX_VALUE);
            }
            map.putIfAbsent(node, data);
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int currentWeight,tourWeight;
        pq.add(new Node(current, 0));
        LinkedList<String> visited=new LinkedList<>();
        while(!pq.isEmpty()){
            Node temp=pq.poll();
            current=temp.getNode();
            currentWeight=temp.getWeight();
            for(Node neighbors:getNeighbors(current)){
                if(!visited.contains(neighbors.getNode())){
                    tourWeight=currentWeight+neighbors.getWeight();
                    pq.add(new Node(neighbors.getNode(), tourWeight));
                }
            }
            for(Node n:pq){
                if(n.getWeight()<map.get(n.getNode()).getWeight()){
                    map.put(n.getNode(),new Node(current, n.getWeight()));
                }
            }
            if(!visited.contains(current)){
                visited.add(current);
            }
        }
        return map;
    }
   
    private LinkedList<Node> getNeighbors(String current){
        return aList.get(current);
    }
}

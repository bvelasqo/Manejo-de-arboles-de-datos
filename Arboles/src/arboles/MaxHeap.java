/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.ArrayList;

/**
 *
 * @author Brandon Velasquez */
public class MaxHeap {
    private final ArrayList<Integer> dataHeap;

    public MaxHeap() {
        dataHeap = new ArrayList();
        dataHeap.add(null);
    }
    private void swap(int son, int father){
        int temp=getDataHeap().get(son);
        getDataHeap().set(son, getDataHeap().get(father));
        getDataHeap().set(father, temp);
    }
    
    private int parent(int son){
        return son/2;
    }
    
    public void insert(int element){
        getDataHeap().add(element);
        int i = getDataHeap().size()-1;
        while(i>1&&getDataHeap().get(parent(i))<getDataHeap().get(i)){
            swap(i,parent(i));
        }
    }
    
    private int getLeftChild(int position){
        return 2*position;
    }
    private int getRightChild(int position){
        return (2*position)+1;
    }
    private boolean isleaf(int position){
        int size=dataHeap.size();
        return getLeftChild(position)>size-1;
    }
    
    private  int maxSon(int position){
        if(getRightChild(position)>dataHeap.size()-1)
            return getLeftChild(position);
       else if(dataHeap.get(getLeftChild(position))>dataHeap.get(getRightChild(position)))
            return getLeftChild(position);
        else
            return getRightChild(position);
    }
    
//    private void ExtractMax(int position){
//        if(isleaf(position))
//            return;
//        else if(getDataHeap().get(position)<maxSon(position)){
//            swap(position, maxSon(position));
//            ExtractMax(maxSon(position));
//        }
//    }
    
    public void ExtractMax(){
        dataHeap.set(1, dataHeap.get(dataHeap.size()-1));
        dataHeap.remove(dataHeap.size()-1);
        int position=1;
        while(position<dataHeap.size()-1 && !isleaf(position)){
            int bigBro=dataHeap.get(maxSon(position));
            if(dataHeap.get(position)<bigBro){
                swap(position, maxSon(position));
            }
            position=maxSon(position);
        }
        
    }

    /**
     * @return the dataHeap
     */
    public ArrayList<Integer> getDataHeap() {
        return dataHeap;
    }
}

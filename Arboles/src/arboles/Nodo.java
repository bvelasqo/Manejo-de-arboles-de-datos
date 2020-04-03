/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author Brandon Velasquez
 * @param <T>
 */
public final class Nodo<T> {
    private T data;
    private Nodo<T> left;
    private Nodo<T> right;
    private boolean childPosition;
    
    public Nodo(T data){
        this.data=data;
        left=right=null;
        hasOneChild();
    }
    public boolean isLeaf(){
        return ((getLeft() == null) && (getRight() == null)); 
    }
    
    public boolean hasOneChild(){
        if (getLeft() == null && right != null) {
            childPosition=true;
            return true;
        } else if(getLeft() != null && right == null){
            childPosition=false;
            return true;
        }
        return false;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the left
     */
    public Nodo<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Nodo<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Nodo<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Nodo<T> right) {
        this.right = right;
    }

    /**
     * @return the childPosition
     */
    public boolean isChildPosition() {
        return childPosition;
    }
}

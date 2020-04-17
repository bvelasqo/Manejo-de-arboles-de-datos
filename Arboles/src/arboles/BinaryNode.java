/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author samaniw
 */
public class BinaryNode {

    private int data;
    private BinaryNode left;
    private BinaryNode right;
    private boolean ChildPosition;
    private int level;
    
    public BinaryNode(int data){
        this.data=data;
        left=right=null;
        hasOneChild();
    }
    public boolean isLeaf(){
        return ((getLeft() == null) && (getRight() == null)); 
    }
    
    public boolean hasOneChild(){
        if (getLeft() == null && right != null) {
            ChildPosition=true;
            return true;
        } else if(getLeft() != null && right == null){
            ChildPosition=false;
            return true;
        }
        return false;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the left
     */
    public BinaryNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BinaryNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BinaryNode right) {
        this.right = right;
    }

    /**
     * @return the childPosition
     */
    public boolean isChildPosition() {
        return ChildPosition;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
}

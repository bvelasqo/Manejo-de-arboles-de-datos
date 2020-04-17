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
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;
    private int nodes;
    private int leaves;
    private int altura;

    BinarySearchTree(int raiz) {
        root = new BinaryNode(raiz);
        nodes++;
    }

    BinarySearchTree() {
        root = null;
    }

    public void Add(int data) {
        if (root == null) {
            root = new BinaryNode(data);
            root.setLevel(LastLevel());
            nodes++;
        } else {
            if (search(data) == null) {
                Add(data, root);
                nodes++;
            } else {
                System.out.println("Ya existe ese dato");
            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (currentRoot.getData() > data) {
            if (currentRoot.getLeft() == null) {
                BinaryNode binaryNode = new BinaryNode(data);
                binaryNode.setLevel(currentRoot.getLevel()+1);
                currentRoot.setLeft(binaryNode);
            } else {
                Add(data, currentRoot.getLeft());
            }
        } else {
            if (currentRoot.getRight() == null) {
                BinaryNode binaryNode = new BinaryNode(data);
                binaryNode.setLevel(currentRoot.getLevel()+1);
                currentRoot.setRight(binaryNode);
            } else {
                Add(data, currentRoot.getRight());
            }
        }
    }

    public void InOrden() {
        InOrden(root);
    }

    private void InOrden(BinaryNode currentRoot) {
        if (root == null) {
            System.out.println("Árbol vacío");
        } else if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }
    
    public void PreOrden(){
        PreOrden(root);
    }
    
    private void PreOrden(BinaryNode currentRoot){
        if(root==null)
            System.out.println("Árbol vacío");
        else if(currentRoot != null){
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());
        }
    }
    
    public void Postorden(){
        Postorden(root);
    }
    
    private void Postorden(BinaryNode currentRoot){
        if(root==null)
            System.out.println("Árbol vacío");
        else if(currentRoot != null){
            Postorden(currentRoot.getLeft());
            Postorden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }
    String linea="";
    public String searchLevel(int level){
        searchLevel(level, root);
        String temp=linea;
        linea="";
        return temp;
        
    }
    private void searchLevel(int level, BinaryNode currentRoot){
        if (currentRoot != null) {
        if (currentRoot.getLevel() == level) {
            linea+=currentRoot.getData()+" ";
        }
            searchLevel(level,currentRoot.getLeft());
            searchLevel(level, currentRoot.getRight());
        }
    }
    
    public void LevelOrder(){
        for(int i=0;i<LastLevel()+1;i++){
            System.out.println(searchLevel(i));
        }
    }
    
    public BinaryNode search (int data) {
        return search(data, root);
    }

    private BinaryNode search(int data, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return currentRoot;
        } else if (currentRoot.getData() == data) {
            return currentRoot;
        }
        this.father = currentRoot;
        if (currentRoot.getData() > data) {
            this.position = false;
            return search(data, currentRoot.getLeft());
        } else {
            this.position = true;
            return search(data, currentRoot.getRight());
        }
    }
    
    public int LastLevel() {
        altura = -1;
        LastLevel(root, 0);
        return altura;
    }
    
    private void LastLevel(BinaryNode currentRoot, int nivel) {
        if (currentRoot != null) {
            LastLevel(currentRoot.getLeft(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            LastLevel(currentRoot.getRight(), nivel + 1);
        }
    }
    
    private void LeafNodes(BinaryNode currentRoot) {
        if (currentRoot != null) {
            if (currentRoot.getLeft()== null && currentRoot.getRight()== null) {
                leaves++;
            }
            LeafNodes(currentRoot.getLeft());
            LeafNodes(currentRoot.getRight());
        }
    }

    public void Delete(int data) {
        if (root == null) {
            System.out.println("Árbol vacío");
        } else {
            Delete(data, root);
        }
    }

    private void Delete(int data, BinaryNode currentRoot) {
        BinaryNode v = search(data);
        if(v!=null){
        //SI VA A BORRAR EL UNICO NODO EXISTENTE
        if (v == this.root && v.getLeft() == null && v.getRight() == null) {
            this.root = null;
            return;
        }
        //SI EL NODO ES UNA HOJA
        if (v.isLeaf()) {
            if (position) {
                this.father.setRight(null);
            } else {
                this.father.setLeft(null);
            }
        } //SI TIENE UN SOLO HIJO 
        else if (v.hasOneChild()) {
            //SI ESE HIJO ESTÁ A LA DERECHA
            if (v.isChildPosition()) {
                
                if(root==v){
                    BinaryNode minimum = getMinor(v.getRight());
                    Delete(minimum.getData());
                    v.setData(minimum.getData());
                    minimum.setLevel(v.getLevel());
                }
                //SI EL NODO ESTA A LA DERECHA
                else if (position) {
                    this.father.setRight(v.getRight());
                } else {
                    this.father.setLeft(v.getRight());
                }
                levelDown(v);
                v.setRight(null);

            } else {
                if(root==v){
                    BinaryNode minimum = getMinor(v.getRight());
                    Delete(minimum.getData());
                    v.setData(minimum.getData());
                    minimum.setLevel(v.getLevel());
                }
                else if (position) {
                    this.father.setRight(v.getLeft());
                } else {
                    this.father.setLeft(v.getLeft());
                }
                levelDown(v);
                v.setRight(null);

            }
        } else {
            BinaryNode minimum = getMinor(v.getRight());
            Delete(minimum.getData());
            v.setData(minimum.getData());
            minimum.setLevel(v.getLevel());
        }
        nodes--;
        }
        else{
            
        }
    }

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }
    
    private void levelDown(BinaryNode  currentRoot){
        if(currentRoot!=null){
            currentRoot.setLevel(currentRoot.getLevel()-1);
            levelDown(currentRoot.getLeft());
            levelDown(currentRoot.getRight());
        }
    }

    /**
     * @return the nodes
     */
    public int CountNodes() {
        return nodes;
    }

    /**
     * @return the leaves
     */
    public int CountLeafs() {
        LeafNodes(root);
        return leaves;
    }
}

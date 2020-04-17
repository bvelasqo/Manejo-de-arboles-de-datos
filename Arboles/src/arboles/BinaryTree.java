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
public class BinaryTree<T extends Comparable> {

    private Nodo<T> root;
    private Nodo<T> father;
    private boolean position;
    private int size;
    private int leaves;
    private int altura;

    BinaryTree(T raiz) {
        root = new Nodo<>(raiz);
        size++;
    }

    BinaryTree() {
        root = null;
    }

    public void Add(T data) {
        if (root == null) {
            root = new Nodo(data);
            root.setLevel(heigth());
            size++;
        } else {
            if (search(data) == null) {
                Add(data, root);
                size++;
            } else {
                System.out.println("Ya existe ese dato");
            }
        }
    }

    private void Add(T data, Nodo<T> currentRoot) {
        if (currentRoot.getData().compareTo(data) > 0) {
            if (currentRoot.getLeft() == null) {
                Nodo<T> nodo = new Nodo(data);
                nodo.setLevel(currentRoot.getLevel()+1);
                currentRoot.setLeft(nodo);
            } else {
                Add(data, currentRoot.getLeft());
            }
        } else {
            if (currentRoot.getRight() == null) {
                Nodo<T> nodo = new Nodo(data);
                nodo.setLevel(currentRoot.getLevel()+1);
                currentRoot.setRight(nodo);
            } else {
                Add(data, currentRoot.getRight());
            }
        }
    }

    public void inorden() {
        inorden(root);
    }

    private void inorden(Nodo<T> currentRoot) {
        if (root == null) {
            System.out.println("Árbol vacío");
        } else if (currentRoot != null) {
            inorden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + ",");
            inorden(currentRoot.getRight());
        }
    }
    
    public void preorden(){
        preorden(root);
    }
    
    private void preorden(Nodo<T> currentRoot){
        if(root==null)
            System.out.println("Árbol vacío");
        else if(currentRoot != null){
            System.out.print(currentRoot.getData() + ",");
            preorden(currentRoot.getLeft());
            preorden(currentRoot.getRight());
        }
    }
    
    public void postorden(){
        postorden(root);
    }
    
    private void postorden(Nodo<T> currentRoot){
        if(root==null)
            System.out.println("Árbol vacío");
        else if(currentRoot != null){
            postorden(currentRoot.getLeft());
            postorden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + ",");
        }
    }
    String linea="";
    public String searchLevel(int level){
        searchLevel(level, root);
        String temp=linea;
        linea="";
        return temp;
        
    }
    private void searchLevel(int level, Nodo<T> currentRoot){
        if (currentRoot != null) {
        if (currentRoot.getLevel() == level) {
            linea+=currentRoot.getData().toString()+"  ";
        }
            searchLevel(level,currentRoot.getLeft());
            searchLevel(level, currentRoot.getRight());
        }
    }
    
    public void LevelOrder(){
        for(int i=0;i<heigth()+1;i++){
            System.out.println(searchLevel(i));
        }
    }
    
    public Nodo search(T data) {
        return search(data, root);
    }

    private Nodo search(T data, Nodo<T> currentRoot) {
        if (currentRoot == null) {
            return currentRoot;
        } else if (currentRoot.getData().compareTo(data) == 0) {
            return currentRoot;
        }
        this.father = currentRoot;
        if (currentRoot.getData().compareTo(data) > 0) {
            this.position = false;
            return search(data, currentRoot.getLeft());
        } else {
            this.position = true;
            return search(data, currentRoot.getRight());
        }
    }
    
    public int heigth() {
        altura = -1;
        heigth(root, 0);
        return altura;
    }
    
    private void heigth(Nodo currentRoot, int nivel) {
        if (currentRoot != null) {
            heigth(currentRoot.getLeft(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            heigth(currentRoot.getRight(), nivel + 1);
        }
    }
    
    private void LeafNodes(Nodo currentRoot) {
        if (currentRoot != null) {
            if (currentRoot.getLeft()== null && currentRoot.getRight()== null) {
                leaves++;
            }
            LeafNodes(currentRoot.getLeft());
            LeafNodes(currentRoot.getRight());
        }
    }

    public void delete(T data) {
        if (root == null) {
            System.out.println("Árbol vacío");
        } else {
            delete(data, root);
        }
    }

    private void delete(T data, Nodo<T> currentRoot) {
        Nodo v = search(data);
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
                //SI EL NODO ESTA A LA DERECHA
                if (position) {
                    this.father.setRight(v.getRight());
                } else {
                    this.father.setLeft(v.getRight());
                }
                v.setRight(null);

            } else {
                if (position) {
                    this.father.setRight(v.getLeft());
                } else {
                    this.father.setLeft(v.getLeft());
                }
                v.setRight(null);

            }
        } else {
            Nodo minimum = getMinor(v.getRight());
            delete((T) minimum.getData());
            v.setData(minimum.getData());
        }
        size--;
        }
        else{
            System.out.println("");
            System.out.println("No existe ese dato a borrar");
        }
    }

    public Nodo getMinor(Nodo currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the leaves
     */
    public int getLeaves() {
        LeafNodes(root);
        return leaves;
    }

}

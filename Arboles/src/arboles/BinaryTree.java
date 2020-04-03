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

    BinaryTree(T raiz) {
        root = new Nodo<>(raiz);
    }

    BinaryTree() {
        root = null;
    }

    public void Add(T data) {
        if (root == null) {
            root = new Nodo(data);
        } else {
            if (search(data) == null) {
                Add(data, root);
            } else {
                System.out.println("Ya existe ese dato");
            }
        }
    }

    private void Add(T data, Nodo<T> currentRoot) {
        if (currentRoot.getData().compareTo(data) > 0) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(new Nodo(data));
            } else {
                Add(data, currentRoot.getLeft());
            }
        } else {
            if (currentRoot.getRight() == null) {
                currentRoot.setRight(new Nodo(data));
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
            System.out.print(currentRoot.getData() + "-");
            inorden(currentRoot.getRight());
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

    public void delete(T data) {
        if (root == null) {
            System.out.println("Árbol vacío");
        } else {
            delete(data, root);
        }
    }

    private void delete(T data, Nodo<T> currentRoot) {
        Nodo v = search(data);
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

    }

    public Nodo getMinor(Nodo currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }

}

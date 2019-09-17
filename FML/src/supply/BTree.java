package supply;

/**
 *
 * @author dsrose3626
 */
public class BTree<T> {
    private Node<T> root;
    private Node<T> currentNode;
    
    public BTree(){        
        root = null;
    }
    public BTree(Node n){
        root = n;
    }
    
    public boolean search(T data){        
        if(root==null){
            return false;
        }
        if(root.getData().equals(data)){
            return true;
        }
        BTree l = new BTree(root.getLeft());
        BTree r = new BTree(root.getRight());
        return (l.search(data)||r.search(data));        
    }
    public void printInOrder(){
        root.printInOrder();
    }
    public void printPreOrder(){
        root.printPreOrder();
    }
    public void printPostOrder(){
        root.printPostOrder();
    }
    public Node getRoot(){
        return root;
    }
    public void setRoot(Node n){
        root = n;
    }
    public boolean isEmpty(){
        return (root==null);
    }
    public int countNodes(){
        int c = 0;
        if(isEmpty()){            
            return 0;
        }
        if(root.getLeft()==null&&root.getRight()==null){
            return 1;
        }
        c+=(new BTree(root.getLeft()).countNodes());
        c+=1;
        c+=(new BTree(root.getRight()).countNodes());
        return c;
    }
    public void print(){
        root.print();
    }
    public Node getCurrent(){
        return currentNode;
    }
    public void setCurrent(Node n){
        currentNode = n;
    }
}

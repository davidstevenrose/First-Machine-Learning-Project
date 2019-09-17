package supply;
/**
*
*@author drose
*/

public class Node<T> {

    private Node<T> left;
    private Node<T> right;
    private T data;

    public Node(T object){
        setLeft(null);
        setRight(null);
        this.setData(object);
    }

    public Node<T> getLeft() {
        return left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public Node<T> getRight() {
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }    
    public void printPreOrder(){
        if(this==null){
            return;
        }else{
            System.out.println(data.toString());
            left.printPreOrder();
            right.printPostOrder();
        }
    }
    public void printPostOrder(){
        if(this==null){
            return;
        }else{            
            left.printPreOrder();
            right.printPostOrder();
            System.out.println(data.toString());
        }
    }
    public void printInOrder(){
        if(this==null){
            return;
        }else{            
            left.printPreOrder();
            System.out.println(data.toString());
            right.printPostOrder();
        }
    }
}

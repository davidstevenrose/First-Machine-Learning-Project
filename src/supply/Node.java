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
        System.out.println(data.toString());
        if(left!=null){
            left.printPreOrder();
        }        
        if(right!=null){
            right.printPreOrder();
        }
    }
    public void printPostOrder(){
        if(left!=null){
            left.printPostOrder();
        }        
        if(right!=null){
            right.printPostOrder();
        }
        System.out.println(data.toString());
    }
    public void printInOrder(){
        if(left!=null){
            left.printInOrder();
        }
        System.out.println(data.toString());
        if(right!=null){
            right.printInOrder();
        }
    }
    public String print(){
        return this.print("",true,"");
    }
    public String print(String prefix, boolean isTail, String sb){
        if(right!=null){
            right.print(prefix + (isTail?"|   ":"    "),false,sb);            
        }
        System.out.println(prefix + (isTail?"\\-- ":"/-- ")+data);
        if(left!=null){
            left.print(prefix + (isTail?"    ":"|   "),true,sb);            
        }
        return sb;
    }
    
}

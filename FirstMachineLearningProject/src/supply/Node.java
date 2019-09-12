package supply;
/**
 * 
 * @author drose
 * @param <T> The abstract data type of what a Node object contains.
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
}
package supply;

/**
 * <p>A single generic binary node for use in a tree graph.</p>
 *
 * @author drose
 */

public class Node<T> {

  /**
   * The child node to the left.
   */
  private Node<T> left;
  /**
   * The child node to the right.
   */
  private Node<T> right;
  /**
   * The data the node carries.
   */
  private T data;

  /**
   * Creates a new node object that carries a passed data value.
   *
   * @param object the data that is an instance of the type declared.
   */
  public Node(T object) {
    setLeft(null);
    setRight(null);
    this.data = object;
  }

  /**
   * Gets the left child of the node.
   *
   * @return the left child
   */
  public Node<T> getLeft() {
    return left;
  }

  /**
   * Sets the left child of the node.
   *
   * @param left the new left child
   */
  public void setLeft(Node<T> left) {
    this.left = left;
  }

  /**
   * Gets the right child of the node.
   *
   * @return the right child
   */
  public Node<T> getRight() {
    return right;
  }

  /**
   * Sets the right child of the node.
   *
   * @param right the new right child
   */
  public void setRight(Node<T> right) {
    this.right = right;
  }

  /**
   * Gets the data of the node.
   *
   * @return the data as an Object.
   */
  public T getData() {
    return data;
  }

  /**
   * Sets the data of the node.
   *
   * @param data the new data
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * Prints the contents of the node and its children in pre-order.
   */
  public void printPreOrder() {
    System.out.println(data.toString());
    if (left != null) {
      left.printPreOrder();
    }
    if (right != null) {
      right.printPreOrder();
    }
  }

  /**
   * Prints the contents of the node and its children in post-order.
   */
  public void printPostOrder() {
    if (left != null) {
      left.printPostOrder();
    }
    if (right != null) {
      right.printPostOrder();
    }
    System.out.println(data.toString());
  }

  /**
   * Prints the contents of the node and its children in order.
   */
  public void printInOrder() {
    if (left != null) {
      left.printInOrder();
    }
    System.out.println(data.toString());
    if (right != null) {
      right.printInOrder();
    }
  }

  /**
   * Prints a graphical representation of the node and its children as a tree into the output.
   */
  public void print() {
    this.print_p("", true, "");
  }

  private void print_p(String prefix, boolean isTail, String sb) {
    if (right != null) {
      right.print_p(prefix + (isTail ? "|   " : "    "), false, sb);
    }
    System.out.println(prefix + (isTail ? "\\-- " : "/-- ") + data);
    if (left != null) {
      left.print_p(prefix + (isTail ? "    " : "|   "), true, sb);
    }
  }
}

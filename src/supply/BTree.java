package supply;

/**
 * @author dsrose3626
 */
public class BTree<T> {

  private Node<T> root;
  private Node<T> currentNode;

  public BTree() {
    root = null;
  }

  public BTree(Node<T> n) {
    root = n;
  }

// --Commented out by Inspection START (9/30/2019 1:21 PM):
//  private boolean search(T data) {
//    if (root == null) {
//      return false;
//    }
//    if (root.getData().equals(data)) {
//      return true;
//    }
//    BTree<T> l = new BTree<>(root.getLeft());
//    BTree<T> r = new BTree<>(root.getRight());
//    return (l.search(data) || r.search(data));
//  }
// --Commented out by Inspection STOP (9/30/2019 1:21 PM)

  public void printInOrder() {
    root.printInOrder();
  }

  public void printPreOrder() {
    root.printPreOrder();
  }

  public void printPostOrder() {
    root.printPostOrder();
  }

  public Node<T> getRoot() {
    return root;
  }

  public void setRoot(Node n) {
    root = n;
  }

  private boolean isEmpty() {
    return (root == null);
  }

  public int countNodes() {
    int c = 0;
    if (isEmpty()) {
      return 0;
    }
    if (root.getLeft() == null && root.getRight() == null) {
      return 1;
    }
    c += (new BTree(root.getLeft()).countNodes());
    c += 1;
    c += (new BTree(root.getRight()).countNodes());
    return c;
  }

// --Commented out by Inspection START (9/30/2019 1:21 PM):
//  public void print() {
//    root.print();
//  }
// --Commented out by Inspection STOP (9/30/2019 1:21 PM)

  /**
   * Gets the node in the current node field of BTree. This is not initialized in the constructor,
   * nor does the constructor set the current node to the root. to get the root, use the getRoot()
   * method.   *
   *
   * @return the current node.
   * @deprecated the BTree object should only have an instance reference to the root.
   */
  public Node<T> getCurrent() {
    return currentNode;
  }

  /**
   * Sets the node in the current node field of BTree. This is not initialized in the constructor,
   * nor does the constructor set the current node to the root. to get the root, use the getRoot()
   * method.
   *
   * @param n some current node.
   * @deprecated the BTree object should only have an instance reference to the root.
   */
  public void setCurrent(Node<T> n) {
    currentNode = n;
  }
}

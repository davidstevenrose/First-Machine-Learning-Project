package io.github.genericbinarytree;

/**
 * <p>A binary tree that contains a Node object. Stores the root for the tree.</p>
 *
 * @author dsrose3626
 */
@SuppressWarnings("ALL")
public class BTree<T> {

  /**
   * The root of the tree.
   */
  private Node<T> root;

  /**
   * A reference to some node in the BTree object.
   *
   * @deprecated field is module dependent.
   */
  private Node<T> currentNode;

  /**
   * Create a BTree with an empty tree.
   */
  public BTree() {
    root = null;
  }

  /**
   * Create a BTree with a given root.
   *
   * @param n the given root that is a Node object.
   */
  public BTree(Node<T> n) {
    root = n;
  }

  /**
   * Searches the tree for the passed data. Uses the equals() method from class Object for
   * comparing.
   *
   * @param data the data to search
   * @return true if the tree contains the data, otherwise false.
   */
  public boolean search(T data) {
    if (root == null) {
      return false;
    }
    if (root.getData().equals(data)) {
      return true;
    }
    BTree<T> l = new BTree<>(root.getLeft());
    BTree<T> r = new BTree<>(root.getRight());
    return (l.search(data) || r.search(data));
  }

  /**
   * Prints the contents of the tree in order.
   */
  public void printInOrder() {
    root.printInOrder();
  }

  /**
   * Prints the contents of the tree in pre-order.
   */
  public void printPreOrder() {
    root.printPreOrder();
  }

  /**
   * Prints the contents of the tree in post-order.
   */
  public void printPostOrder() {
    root.printPostOrder();
  }

  /**
   * Gets the root of the binary tree.
   *
   * @return the root
   */
  public Node<T> getRoot() {
    return root;
  }

  /**
   * Set the root of the binary tree to some other Node object.
   *
   * @param n the new root of the tree
   */
  public void setRoot(Node<T> n) {
    root = n;
  }

  /**
   * Checks is the tree is empty.
   *
   * @return True if the tree is empty; false otherwise.
   */
  public boolean isEmpty() {
    return (root == null);
  }

  /**
   * Returns the amount of nodes in the BTree object.
   *
   * @return the size of the BTree
   */
  public int countNodes() {
    int c = 0;
    if (isEmpty()) {
      return 0;
    }
    if (root.getLeft() == null && root.getRight() == null) {
      return 1;
    }
    c += (new BTree<>(root.getLeft()).countNodes());
    c += 1;
    c += (new BTree<>(root.getRight()).countNodes());
    return c;
  }

  /**
   * Prints the tree as a graph.
   */
  public void print() {
    root.print();
  }

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

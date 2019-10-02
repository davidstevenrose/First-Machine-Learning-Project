package supply;

/**
 * <p>A driver class to test the BTree and Node classes.</p>
 *
 * @author drose
 */
public class TreeDriver {

  /**
   * main method.
   * @param args passed args
   */
  public static void main(String[] args) {
    System.out.println("Creating Tree");
    BTree<Integer> tree = new BTree<>();

    System.out.println("Number of nodes in empty tree");
    System.out.println(tree.countNodes());

    System.out.println("Create Nodes with data 1");
    //compiler determines type implicitly
    Node<Integer> root = new Node<>(1);

    System.out.println("set node as root");
    tree.setRoot(root);

    //declare child nodes
    Node<Integer> node2 = new Node<>(2);
    Node<Integer> node3 = new Node<>(3);
    Node<Integer> node4 = new Node<>(4);
    Node<Integer> node5 = new Node<>(5);
    Node<Integer> node6 = new Node<>(6);
    Node<Integer> node7 = new Node<>(7);

    //set child nodes
    root.setLeft(node2);
    node2.setLeft(node4);
    node2.setRight(node5);
    root.setRight(node3);
    node3.setLeft(node6);
    node3.setRight(node7);

    System.out.println("Size of new tree");
    System.out.println(tree.countNodes());

    System.out.println("In Order");
    tree.printInOrder();
    System.out.println("\nPre Order");
    tree.printPreOrder();
    System.out.println("\nPost Order");
    tree.printPostOrder();
    tree.getRoot().print();
  }

}

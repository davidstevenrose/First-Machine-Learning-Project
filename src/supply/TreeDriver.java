package supply;

public class TreeDriver {

  public static void main(String[] args){
    System.out.println("Creating Tree");
    BTree<Integer> tree = new BTree<>();

    System.out.println("Number of nodes in empty tree");
    System.out.println(tree.countNodes());

    System.out.println("Create Nodes with data 1");
    //compiler determines type implicitly
    Node root = new Node(1);

    System.out.println("set node as root");
    tree.setRoot(root);

    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);

    root.setLeft(node2);
    node2.setLeft(node4);
    node2.setRight(node5);
    root.setRight(node3);
    node3.setLeft(node6);
    node3.setRight(node7);

    tree.setCurrent(tree.getRoot());
    System.out.println("The current node");
    System.out.println(tree.getCurrent().getData());

    Node current = tree.getCurrent();
    System.out.println("Size of new tree");
    System.out.println(tree.countNodes());

    System.out.println("In Order");
    tree.printInOrder();
    System.out.println("\nPre Order");
    tree.printPreOrder();
    System.out.println("\nPost Order");
    tree.printPostOrder();

  }

}

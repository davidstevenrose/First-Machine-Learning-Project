package supply;

/**
*
*@author drose
* 
* <p>This is the driver class to test the Node class and its instances.</p>
*/

public class Main {

    /**
     * A method that uses recursion to raise a to the power of b.
     * @param b the base
     * @param p the power
     * @return b^p
     */
    public static int power(int b, int p){
        if(p==0){
            return 1;
        }
        return b * power(b, p-1);
    };
    /**
     * Finds the factorial
     * @param i number greater than 0
     * @return i*(i-1)!
     */
    public static int factorial(int i){
        if(i==0){
            return 1;
        }
        return i * factorial(i-1);
    }    
    /**
     * @deprecated 
     * @param f a number greater than 0
     * @return the f'th number in the fib sequence.
     */
    public static int fib(int f){
        if(f==0 || f==1){
            return 1;
        }
        return fib(f-1)+fib(f-2);
    }

    public static void main(String[] args){
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        BTree tree = new BTree(root);
        
        root.setLeft(n2);
        root.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n5.setLeft(n7);
        n3.setRight(n6);        

        root.printInOrder();
        System.out.println();
        root.printPreOrder();
        System.out.println();      
        root.printPostOrder();
        
        System.out.println();
        root.print();
        System.out.println(tree.countNodes());        
        /*Node<Integer> root = new Node(1);
        Node current = root;
        current.setLeft(new Node(2));
        current.setRight(new Node(3));
        current = current.getRight();
        current.setRight(new Node(6));
        current = root.getLeft();
        current.setLeft(current);*/
    }
}

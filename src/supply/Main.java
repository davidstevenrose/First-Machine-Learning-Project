package supply;

import java.util.Scanner;

/**
 * <p>This is the driver class to test the Node class and its instances.</p>
 *
 * @author drose
 */

public class Main {

  /**
   * The give up message string.
   */
  private static final String GIVE_UP = "I give up. You win!";

  /**
   * main method. Yes/No game.
   *
   * @param args not used
   */
  public static void main(String[] args) {
    //Beginning of Yes/No game
    //initialize tree
    Node<String> n1 = new Node<>("Is your animal a mammal?");
    BTree<String> gameTree = new BTree<>(n1);
    n1.setLeft(new Node<>(GIVE_UP));
    n1.setRight(new Node<>("Does your animal bark?"));
    Node<String> n2 = n1.getRight();
    n2.setLeft(new Node<>(GIVE_UP));
    n2.setRight(new Node<>("A dog. I win!"));
    Node<String> current;
    //end initialize
    //set flags
    boolean endResult;
    boolean running = true;
    //input
    Scanner sc = new Scanner(System.in);
    String input;

    //Start of game
    System.out.println("Think of an animal, and this program will try to guess it.");
    System.out.println("Type 'y' or 'n' for yes and no");
    while (running) {
      current = gameTree.getRoot();
      endResult = false;
      while (!endResult) {
        System.out.println(current.getData());
        input = sc.next();
        if (input.equals("y")) {
          current = current.getRight();
        } else if (input.equals("n")) {
          current = current.getLeft();
        } else {
          System.out.println("Input not recognized. Use 'y' or 'n' only.");
          continue;
        }
        String data = current.getData();
        if (data.charAt(data.length() - 1) == '!') {
          endResult = true;
        }
      }
      System.out.println(current.getData());
      //if the game lost the round
      if (current.getData().equals(GIVE_UP)) {
        boolean verified = false;
        do {
          System.out.println("Tell me, what was your animal, and what question would"
              + " you ask to distinct it from the last question?");
          System.out.println("Enter your input in the form [animal] [question] with "
              + "a space in between.");
          try {
            String a = sc.next();
            String q = sc.nextLine();
            StringBuilder aw = new StringBuilder(a);
            if (a.charAt(a.length() - 1) != '.') {
              aw.append('.');
            }
            aw.append(" I win!");
            StringBuilder qw = new StringBuilder(q);
            if (q.charAt(q.length() - 1) != '?') {
              qw.append('?');
            }
            //make sure to trim this string.
            current.setData(qw.toString().trim());
            Node<String> nodeYes = new Node<>(aw.toString());
            current.setRight(nodeYes);
            current.setLeft(new Node<>(GIVE_UP));
            System.out.println("Thank you. Animal noticed.");
            verified = true;
          } catch (Exception e) {
            System.out.println("Input was in bad format. Please try again.");
          }
        } while (!verified);
      }
      //ask if the user wants to play again.
      boolean recognized = false;
      do {
        System.out.println("Do you want to play again? ('y' or 'n')");
        input = sc.next();
        if (input.equals("n")) {
          running = false;
          recognized = true;
        } else if (input.equals("y")) {
          recognized = true;
        } else {
          System.out.println("Input was invalid. Please try again.");
        }
      } while (!recognized);
    }
    //end of game
    System.out.println("Game Over");
  }
}

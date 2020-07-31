package io.github.firstmachinelearningproject;

/**
 * Holder for a StringNode tree. This wraps the entire decision tree with string data. The tree is
 * instantiated by generating a full decision tree.
 *
 * @author drose
 */
public class StringTree {

  private StringNode root;

  StringTree(StringNode root) {
    this.root = root;
  }

  /**
   * Checks if the tree is empty.
   *
   * @return true if empty, false otherwise
   */
  public boolean isEmpty() {
    return getRoot() == null;
  }

  /**
   * Prints the entire tree as a graphic.
   */
  public void print() {
    getRoot().print("", true);
  }

  StringNode getRoot() {
    return root;
  }

  private void setRoot(StringNode root) {
    this.root = root;
  }
}

package io.github.firstmachinelearningproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * A Node that specifically stores a String as its data.
 */
class StringNode {

  /**
   * The data of the node.
   */
  private String data;
  /**
   * the children of the node.
   */
  HashMap<String, StringNode> children = new HashMap<>();
  private NodeType type;

  /**
   * creates a node with data.
   *
   * @param data a String datum
   */
  StringNode(String data, NodeType nt) {
    this.data = data;
    type = nt;
  }

  /**
   * gets the node data.
   *
   * @return the data
   */
  String getData() {
    return data;
  }

  /**
   * Set the data value of the node.
   *
   * @param data the data
   */
  void setData(String data) {
    this.data = data;
  }


  /**
   * removes all children from a node.
   */
  void removeChildren() {
    children.clear();
  }


  /**
   * print all the nodes from the current node.
   *
   * @param prefix string prefix
   * @param isTail is the node a tail?
   */
  void print(String prefix, boolean isTail) {
    System.out.println(prefix + (isTail ? "\\-- " : "|-- ") + data);
    StringNode[] sn = new StringNode[children.values().size()];
    children.values().toArray(sn);
    List<StringNode> childs = Arrays.asList(sn);
    for (int i = 0; i < childs.size() - 1; i++) {
      childs.get(i).print(prefix + (isTail ? "   " : "|   "), false);
    }
    if (childs.size() > 0) {
      childs.get(childs.size() - 1)
          .print(prefix + (isTail ? "    " : "|   "), true);
    }
  }

  /**
   * The type of the node.
   */
  NodeType getType() {
    return type;
  }
}

package io.github.firstmachinelearningproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class to create a decision tree based of provided data for the machine to learn.
 */
public final class DecisionTreeGenerator {


  /**
   * generates a decision tree based on the ID3 algorithm.
   *
   * @param learningTable a 2D array of data to learn
   * @return a reference to the generated decision tree
   */
  public static StringTree makeDecisionTree(String[][] learningTable) {
    return new StringTree(makeDecisionTreeRoot(learningTable));
  }

  /**
   * generates a decision tree based on the ID3 algorithm.
   *
   * @param learningTable a 2D array of data to learn
   * @return a reference to the root of the generated decision tree
   */
  private static StringNode makeDecisionTreeRoot(String[][] learningTable) {
    int ynPos = learningTable[0].length - 1;
    HashMap<String, Float> attributeIG = new HashMap<>();
    ArrayList<String> yesno = new ArrayList<>();
    Arrays.stream(learningTable).skip(1).forEach(line -> yesno.add(line[ynPos]));
    float ynEntropy = calcEntropy(yesno);
    //if the y/n entropy is zero, then the path will end
    if (ynEntropy == 0) {
      String result = yesno.get(0);
      return new StringNode(result, NodeType.LEAFNODE);
    }
    //otherwise:
    for (int att = 0; att < ynPos; att++) {
      HashMap<String, Integer> partitions = new HashMap<>();
      HashMap<String, Integer> probs = new HashMap<>();
      for (int row = 1; row < learningTable.length; row++) {
        if (!partitions.containsKey(learningTable[row][att])) {
          partitions.put(learningTable[row][att], 1);
          if (learningTable[row][ynPos].equals("Yes")) {
            probs.put(learningTable[row][att], 1);
          } else {
            probs.put(learningTable[row][att], 0);
          }
        } else {
          partitions.put(learningTable[row][att], partitions.get(learningTable[row][att]) + 1);
          if (learningTable[row][ynPos].equals("Yes")) {
            probs.put(learningTable[row][att], probs.get(learningTable[row][att]) + 1);
          }
        }
      }
      Integer[] in1 = new Integer[partitions.values().size()];
      Integer[] in2 = new Integer[probs.values().size()];
      attributeIG.put(learningTable[0][att],
          calcGain(ynEntropy, Arrays.asList(partitions.values().toArray(in1)),
              Arrays.asList(probs.values().toArray(in2))));
    }

    //attributeIG is filled, choose greatest value
    Optional<Entry<String, Float>> maxEntry = attributeIG.entrySet().stream()
        .max(Comparator.comparing(Entry::getValue));
    String nodeAttribute = maxEntry.get().getKey();
    //set greatest value to a string root
    StringNode root = new StringNode(nodeAttribute, NodeType.BRANCH);
    //partition learning table and build tree
    int indexOfAtt = IntStream.range(0,ynPos).filter(i -> nodeAttribute.equals(learningTable[0][i]))
        .boxed().collect(Collectors.toList()).get(0);
    HashMap<String, Integer> valuePartitions = new HashMap<>();
    for (int row = 1; row < learningTable.length; row++) {
      if (!valuePartitions.containsKey(learningTable[row][indexOfAtt])) {
        valuePartitions.put(learningTable[row][indexOfAtt], 1);
      } else {
        valuePartitions.put(learningTable[row][indexOfAtt],
            valuePartitions.get(learningTable[row][indexOfAtt]) + 1);
      }
    }
    //the root node's children
    for (Entry<String, Integer> pair : valuePartitions.entrySet()) {
      String[][] newTable = new String[pair.getValue() + 1][ynPos];
      //everything to left of att
      for (int i = 0; i < indexOfAtt; i++) {
        //metadata
        newTable[0][i] = learningTable[0][i];
        //contents
        int proseRow = 1;
        for (int row = 1; row < learningTable.length && proseRow < newTable.length; row++) {
          if (learningTable[row][indexOfAtt].equals(pair.getKey())) {
            newTable[proseRow][i] = learningTable[row][i];
            proseRow++;
          }
        }
      }
      //everything to right of att
      for (int i = indexOfAtt + 1; i < learningTable[0].length; i++) {
        //metadata
        newTable[0][i - 1] = learningTable[0][i];
        //contents
        int proseRow = 1;
        for (int row = 1; row < learningTable.length && proseRow < newTable.length; row++) {
          if (learningTable[row][indexOfAtt].equals(pair.getKey())) {
            newTable[proseRow][i - 1] = learningTable[row][i];
            proseRow++;
          }
        }
      }
      root.children.put(pair.getKey(), makeDecisionTreeRoot(newTable));
    }
    return root;
  }

  /**
   * Asks user for input to make a decision with the given learning tree.
   *
   * @param tree the decision tree
   * @param sc   the scanner class object
   */
  public static void makeDecision(StringTree tree, Scanner sc) {
    if (tree.getRoot().getType() == NodeType.LEAFNODE) {
      String result =
          tree.getRoot().getData().equals("Yes") ? "You should play." : "You should not play :(";
      System.out.println(result);
      return;
    }
    StringNode current = tree.getRoot();
    String attribute = current.getData();
    String[] values = new String[current.children.size()];
    current.children.keySet().toArray(values);
    System.out.println("What is the observation for " + attribute + "?");
    System.out.println("("+String.join(",", values)+")");
    String observ = sc.nextLine().toLowerCase();
    current = current.children.get(observ);
    makeDecision(new StringTree(current), sc);
  }

  /**
   * Calculate the entropy of data. list only accepts yes/no values
   *
   * @param list list of yes/no values
   * @return entropy of list
   */
  private static float calcEntropy(ArrayList<String> list) {
    int yes = (int) list.stream().filter(s -> s.equals("Yes")).count();
    int no = list.size() - yes;

    float[] arr = {(float) yes / list.size(), (float) no / list.size()};
    float sum = 0f;
    sum += arr[0] == 0 ? 0 : (arr[0] * (Math.log10(arr[0]) / Math.log10(2)));
    sum += arr[1] == 0 ? 0 : (arr[1] * (Math.log10(arr[1]) / Math.log10(2)));
    return sum * (-1f);
  }

  /**
   * Calculate the information gain of an attribute.
   *
   * @param ynEntropy     the yes/no entropy (binary)
   * @param partitions    the amount of times the values of the attribute appear in the whole
   *                      column.
   * @param probabilities the amount of times those partitions had the result of yes.
   * @return the information gain for that attribute.
   */
  private static float calcGain(float ynEntropy, List<Integer> partitions,
      List<Integer> probabilities) {
    float diff = 0;
    int sum = partitions.stream().reduce(0, Integer::sum);
    for (int i = 0; i < partitions.size(); i++) {
      int p = partitions.get(i);
      float frac = (float) p / sum;
      ArrayList<String> probs = new ArrayList<>();
      for (int j = 0; j < probabilities.get(i); j++) {
        probs.add("Yes");
      }
      for (int j = 0; j < p - probabilities.get(i); j++) {
        probs.add("No");
      }
      diff += (frac * calcEntropy(probs));
    }
    return ynEntropy - diff;
  }
}
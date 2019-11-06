package driver;

import io.github.firstmachinelearningproject.DecisionTreeGenerator;
import io.github.firstmachinelearningproject.StringTree;
import java.util.Scanner;

/**
 * <p>This is an example usage to test the decision tree generator (ID3 algorithm) and its
 * helpers.</p>
 *
 * @author drose
 */

public class Main {

  /**
   * main method.
   *
   * @param args not used
   */
  public static void main(String[] args) {
    //decision tree
    StringTree weatherTree;
    //learning table
    String[][] learningTableWeather = {{"Outlook", "Temperature", "Humidity", "Wind", "Result"},
        {"sunny", "hot", "high", "weak", "No"},
        {"sunny", "hot", "high", "strong", "No"},
        {"overcast", "hot", "high", "weak", "Yes"},
        {"rain", "mild", "high", "weak", "Yes"},
        {"rain", "cold", "normal", "weak", "Yes"},
        {"rain", "cold", "normal", "strong", "No"},
        {"overcast", "cold", "normal", "strong", "Yes"},
        {"sunny", "mild", "high", "weak", "No"},
        {"sunny", "cold", "normal", "weak", "Yes"},
        {"rain", "mild", "normal", "weak", "Yes"},
        {"sunny", "mild", "normal", "strong", "Yes"},
        {"overcast", "mild", "high", "strong", "Yes"},
        {"overcast", "hot", "normal", "weak", "Yes"},
        {"rain", "mild", "high", "strong", "No"}
    };
    weatherTree = DecisionTreeGenerator.makeDecisionTree(learningTableWeather);
    Scanner sc = new Scanner(System.in, "UTF-8");
    //make a decision from user input. Note: there are 36 different cases based on learning table.
    DecisionTreeGenerator.makeDecision(weatherTree, sc);
    /*user instructions: write only one of the available attributes in parentheses.
     Input is not case sensitive.
     */
  }

}

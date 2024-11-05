package labs;

import java.util.Comparator;
import java.util.Scanner;

public class Lab {
  /**
   * Run the laboratory work program
   * It requires user to input sentences and sort the sentences by amount of words in each of them.
   * Prints the sorted sentences to console.
   */
  void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input sentences: ");
    StringBuilder input = new StringBuilder(scanner.nextLine());
    
    Text text = new Text(input);
    Text sortedText = new Text();
    
    text.getSentences().stream()
      .sorted(Comparator.comparingInt(Sentence::getWordCount))
      .forEach(sortedText::addSentence);
    
    System.out.println("Result: " + sortedText);
  }
}

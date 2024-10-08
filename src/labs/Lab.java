package labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class Lab {
  void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input list of words: ");
    StringBuilder input = new StringBuilder(scanner.nextLine());
    
    StringBuilder[] words = this.getListOfWords(input);
    StringBuilder sortedWords = new StringBuilder();
    
    Arrays.stream(words)
      .sorted(Comparator.comparing(StringBuilder::length))
      .forEach(word -> sortedWords.append(word).append(" "));
    
    System.out.println(sortedWords);
  }
  
  private StringBuilder[] getListOfWords(StringBuilder input) {
    StringBuilder word = new StringBuilder();
    List<StringBuilder> words = new ArrayList<>();
    
    for (int i = 0; i <= input.length(); i++) {
      if (i == input.length() || !this.isLetter(input.charAt(i))) {
        if (!word.isEmpty()) {
          words.add(word);
          word = new StringBuilder();
        }
      } else {
        word.append(input.charAt(i));
      }
    }
    
    return words.toArray(StringBuilder[]::new);
  }
  
  public boolean isLetter (char c) {
    StringBuilder letters = new StringBuilder("abcdefghijklmnopqrstuvwxyz0123456789");
    
    for (int i = 0; i < letters.length(); i++) {
      if (c == letters.charAt(i)) return true;
    }
    
    return false;
  }
}

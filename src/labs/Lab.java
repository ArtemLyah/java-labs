package labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class Lab {
  private final StringBuilder letters = new StringBuilder("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
  private final StringBuilder sentenceEnd = new StringBuilder(".?!");
  private final StringBuilder delimiters = new StringBuilder(",:/<>'\";|\\@#$%^&*()_-=+`~");
  private final StringBuilder symbols = new StringBuilder().append(sentenceEnd).append(delimiters);
  
  void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input sentences: ");
    StringBuilder input = new StringBuilder(scanner.nextLine());
    
    StringBuilder[] sentences = this.getListOfSentences(input);
    StringBuilder sortedSentences = new StringBuilder();
    
    Arrays.stream(sentences)
      .map(this::parseSentence)
      .sorted(Comparator.comparingInt(this::countSentenceWords))
      .forEach((parsedSentence) -> {
        sortedSentences.append(joinParsedSentence(parsedSentence));
      });
    
    System.out.println("Result:" + sortedSentences);
  }
  
  private StringBuilder[] getListOfSentences(StringBuilder input) {
    List<StringBuilder> sentences = new ArrayList<>();
    StringBuilder sentence = new StringBuilder();
    
    for (int i = 0; i < input.length(); i++) {
      sentence.append(input.charAt(i));
      
      if (this.isIncludeChar(input.charAt(i), sentenceEnd) || i == input.length() - 1) {
        sentences.add(sentence);
        sentence = new StringBuilder();
      }
    }
    
    return sentences.toArray(StringBuilder[]::new);
  }
  
  private StringBuilder[] parseSentence (StringBuilder sentence) {
    List<StringBuilder> result = new ArrayList<>();
    StringBuilder word = new StringBuilder();
    
    for (int i = 0; i < sentence.length(); i++) {
      if (this.isIncludeChar(sentence.charAt(i), letters)) {
        word.append(sentence.charAt(i));
      } else if (this.isIncludeChar(sentence.charAt(i), symbols)) {
        if (!word.isEmpty()) {
          result.add(word);
          word = new StringBuilder();
        }
        result.add(new StringBuilder().append(sentence.charAt(i)));
      } else {
        if (!word.isEmpty()) {
          result.add(word);
          word = new StringBuilder();
        }
      }
    }
    
    if (!word.isEmpty()) {
      result.add(word);
    }
    
    return result.toArray(StringBuilder[]::new);
  }
  
  private StringBuilder joinParsedSentence(StringBuilder[] sentence) {
    StringBuilder result = new StringBuilder();
    
    for (StringBuilder stringBuilder : sentence) {
      if (isIncludeChar(stringBuilder.charAt(0), symbols)) {
        result.append(stringBuilder.charAt(0));
      } else {
        result.append(' ');
        result.append(stringBuilder);
      }
    }
    
    return result;
  }
  
  private int countSentenceWords(StringBuilder[] parsedSentence) {
    int count = 0;
    
    for (StringBuilder sentenceItem : parsedSentence) {
      if (!isIncludeChar(sentenceItem.charAt(0), symbols)) {
        count++;
      }
    }
    
    return count;
  }
  
  private boolean isIncludeChar (char c, StringBuilder builder) {
    for (int i = 0; i < builder.length(); i++) {
      if (c == builder.charAt(i)) return true;
    }
    
    return false;
  }
}

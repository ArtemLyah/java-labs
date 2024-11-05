package labs;

import java.util.*;

/**
 * Class Sentence contains structure of sentence and list of its words
 */
public class Sentence {
  /**
   * List of words that this sentence contain
   * @see Word
   */
  private final List<Word> words;
  
  /**
   * Delimiter map contains index of delimiter in this sentence.
   * If delimiters are combined they are stored in a list
   */
  private final Map<Integer, List<Delimiter>> delimiterMap;
  
  /**
   * Constructs sentence from its {@link StringBuilder} type.
   * Makes list of words and delimiter map
   * @param sentence the sentence in {@link StringBuilder} type
   */
  public Sentence(StringBuilder sentence) {
    delimiterMap = new HashMap<Integer, List<Delimiter>>();
    words = new ArrayList<Word>();
    
    StringBuilder word = new StringBuilder();
    
    for (int i = 0; i < sentence.length(); i++) {
      if (!Letter.isLetter(sentence.charAt(i))) {
        if (!word.isEmpty()) {
          words.add(new Word(word));
          word = new StringBuilder();
        }
        if (Delimiter.isSymbol(sentence.charAt(i))) {
          int delimiterIndex = words.size()-1;
          
          if (!delimiterMap.containsKey(delimiterIndex)) {
            List<Delimiter> symbolsList = new ArrayList<>();
            delimiterMap.put(delimiterIndex, symbolsList);
          }
          boolean isPrefix = sentence.charAt(i-1) == ' ';
          boolean isSuffix = i+1 != sentence.length() && sentence.charAt(i+1) == ' ';
          
          delimiterMap.get(delimiterIndex).add(new Delimiter(sentence.charAt(i), isPrefix, isSuffix));
        }
        continue;
      }
      
      word.append(sentence.charAt(i));
    }
  }
  
  /**
   * Returns amount of words in this sentence
   * @return amount of words
   */
  public int getWordCount() {
    return words.size();
  }
  
  /**
   * Returns a string containing this sentence.
   * It considers delimiter and word position
   * @return a string consisting of sentence words and delimiters
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < words.size(); i++) {
      str.append(words.get(i));
      
      List<Delimiter> delimiters = delimiterMap.get(i);
      
      if (Optional.ofNullable(delimiters).isEmpty()) {
        if (i < words.size() - 1) {
          str.append(' ');
        }
        continue;
      }
      
      delimiters.forEach((delimiter -> {
        if (delimiter.isPrefix()) str.append(' ');
        str.append(delimiter);
        if (delimiter.isSuffix()) str.append(' ');
      }));
    }
    
    return str.toString();
  }
}

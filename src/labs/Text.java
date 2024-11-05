package labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Text class contains full text with list of sentences.
 */
public class Text {
  /**
   * List of sentences in this text
   * @see Sentence
   */
  private final List<Sentence> sentences;
  
  /**
   * Constructs text from passed text in {@link  StringBuilder} type.
   * Divide the text to list of {@link Sentence}
   * @param text the text in {@link StringBuilder} type
   */
  public Text(StringBuilder text) {
    sentences = getListOfSentences(text);
  }
  
  /**
   * Constructs text with empty sentences
   */
  public Text() {
    this.sentences = new ArrayList<>();
  }
  
  /**
   * Add {@link Sentence} to this text
   * @param sentence the sentence with {@link Sentence} type
   */
  public void addSentence(Sentence sentence) {
    sentences.add(sentence);
  }
  
  /**
   * Returns list of sentences from provided text.
   * The sentences will be split by their ending symbols
   * @param text the text in {@link StringBuilder} type
   * @return list of {@link Sentence} that provided text contains
   */
  
  public static List<Sentence> getListOfSentences(StringBuilder text) {
    List<Sentence> sentences = new ArrayList<>();
    StringBuilder sentence = new StringBuilder();
    
    for (int i = 0; i < text.length(); i++) {
      sentence.append(text.charAt(i));
      
      if (Delimiter.isSentenceEnd(text.charAt(i)) || i == text.length() - 1) {
        sentences.add(new Sentence(sentence));
        sentence = new StringBuilder();
      }
    }
    
    return sentences;
  }
  
  /**
   * Returns a list of sentences from this text object
   * @return list of {@link Sentence}
   */
  public List<Sentence> getSentences() {
    return sentences;
  }
  
  /**
   * Returns the string that constructs from sentences of this Text object.
   * @return string of this text object
   */
  @Override
  public String toString() {
    StringBuilder text = new StringBuilder();
    sentences.forEach(sentence -> text.append(sentence.toString()).append(' '));
    return text.toString();
  }
}

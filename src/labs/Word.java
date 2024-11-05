package labs;

/**
 * Class Word contains list of letters
 */
public class Word {
  /**
   * List of letters in this word
   * @see Letter
   */
  private final Letter[] letters;
  
  /**
   * The string builder with full word
   */
  private final StringBuilder word;
  
  /**
   * Constructs word from string builder and makes list of its letters
   * @param word the string builder of a word
   */
  public Word(StringBuilder word) {
    this.word = word;
    this.letters = new Letter[word.length()];
    
    for (int i = 0; i < word.length(); i++) {
      letters[i] = new Letter(word.charAt(i));
    }
  }
  
  /**
   * Returns length of this word
   * @return amount of letters in this word
   */
  public int length() {
    return word.length();
  }
  
  /**
   * Returns list of letters in this word
   * @return list of letters
   * @see Letter
   */
  public Letter[] getLetters() {
    return letters;
  }
  
  /**
   * Return word in {@link StringBuilder} type
   * @return the full word in {@link StringBuilder} type
   */
  public StringBuilder getWord() {
    return word;
  }
  
  /**
   * Returns the string representation of this word
   * @return a string with this word
   */
  @Override
  public String toString() {
    return word.toString();
  }
}

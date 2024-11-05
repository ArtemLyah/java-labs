package labs;

public class Delimiter extends Symbol {
  /**
   * String with symbols that divide sentences
   */
  private static final StringBuilder sentenceEnd = new StringBuilder(".?!");
  
  /**
   * String with any non-alphabetical symbol that is used in sentences
   */
  private static final StringBuilder delimiters = new StringBuilder(",:/<>'\";|\\@#$%^&*()_-=+`~");
  
  /**
   * Represents whether delimiter is in prefix part of a word
   */
  private final boolean isPrefix;
  
  /**
   * Represents whether delimiter is in suffix part of a word
   */
  private final boolean isSuffix;
  
  /**
   * Construct class with specific character in Unicode format and {@code isPrefix} {@code isSuffix} flags
   * @param symbol any symbol in Unicode format
   * @param isPrefix the flag that represent if this delimiter is in prefix part of a word
   * @param isSuffix the flag that represent if this delimiter is in suffix part of a word
   */
  public Delimiter(char symbol, boolean isPrefix, boolean isSuffix) {
    super(symbol);
    this.isPrefix = isPrefix;
    this.isSuffix = isSuffix;
  }
  
  /**
   * Construct class with specific character in Unicode format
   * @param symbol any symbol in Unicode format
   */
  public Delimiter(char symbol) {
    super(symbol);
    this.isPrefix = false;
    this.isSuffix = false;
  }
  
  /**
   * Returns boolean that represents whether delimiter is in prefix part of a word
   * @return {@code ture} if this delimiter is in prefix part of a word otherwise {@code false}
   */
  public boolean isPrefix() {
    return isPrefix;
  }
  
  /**
   * Returns boolean that represents whether delimiter is in suffix part of a word
   * @return {@code ture} if this delimiter is in suffix part of a word otherwise {@code false}
   */
  public boolean isSuffix() {
    return isSuffix;
  }
  
  /**
   * Checks whether character value is delimiter in a sentence
   * @return {@code ture} if the character value is delimiter otherwise {@code false}
   */
  public static boolean isDelimiter (char value) {
    return isIncludesChar(value, delimiters);
  }
  
  /**
   * Checks whether character value is the end of a sentence
   * @return {@code true} if the character value is the end of a sentence otherwise {@code false}
   */
  public static boolean isSentenceEnd (char value) {
    return isIncludesChar(value, sentenceEnd);
  }
  
  /**
   * Checks whether character value is the symbol. Symbol is non-alphabetical character that is used in sentences.
   * @return {@code true} if the character value is a symbol otherwise {@code false}
   */
  public static boolean isSymbol (char value) {
    return isDelimiter(value) || isSentenceEnd(value);
  }
}

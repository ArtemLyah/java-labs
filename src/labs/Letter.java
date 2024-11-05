package labs;

/**
 * Class Letter contains only symbol from alphabet. It can be either in lower or upper case.
 */
public class Letter extends Symbol {
  /**
   * String with alphabet is used to check if a symbol is a letter
   */
  private static final StringBuilder letters = new StringBuilder("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
  
  /**
   * Construct class with specific character in Unicode format
   * @param symbol any symbol in Unicode format
   * @see Symbol the main class that stores character symbol
   */
  Letter(char symbol) {
    super(symbol);
  }
  
  /**
   * Checks if a character value is a letter
   * @param value any character value
   * @return {@code true} if character value is alphabetic letter otherwise {@code false}
   */
  public static boolean isLetter (char value) {
    return isIncludesChar(value, letters);
  }
}

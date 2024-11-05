package labs;

/**
 * Class Symbol contains char symbol
 */
public class Symbol {
  /**
   * The character symbol
   */
  private final char symbol;
  
  /**
   * Construct class with specific character in Unicode format
   * @param symbol any symbol in Unicode format
   */
  public Symbol(char symbol) {
    this.symbol = symbol;
  }
  
  public char getSymbol() {
    return symbol;
  }
  
  /**
   * If {@code stringBuilder} contains character {@code c} it returns {@code true}, otherwise {@code false}
   * @param c the character to check whether it contains in {@link  StringBuilder}
   * @param stringBuilder the builder that either contains or not character {@code  c}
   * @return {@code true} if {@link  StringBuilder} contains character {@code c} otherwise {@code false}
   */
  protected static boolean isIncludesChar(char c, StringBuilder stringBuilder) {
    for (int i = 0; i < stringBuilder.length(); i++) {
      if (c == stringBuilder.charAt(i)) return true;
    }
    
    return false;
  }
  
  /**
   * Returns a string containing the character
   * @return a string containing single character
   */
  @Override
  public String toString() {
    return String.valueOf(symbol);
  }
}

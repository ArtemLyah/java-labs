package labs;

/**
 * The {@code GemStone} class represents gemstone.
 * <p>
 * Parameters: {@code color}, {@code transparency}, {@code price}, {@code weight}
 * @see GemStone
 */
public class GemStone {
  private final String color;
  private final double transparency;
  private final int price;
  private final double weight;
  
  /**
   * The {@code GemStone} constructor
   * @param color the color of gemstone. Ex: {@code Blood Red}, {@code Colourless}
   * @param transparency the transparency degree of gemstone
   * @param price the price in dollars
   * @param weight the weight in carats
   *
   * @see GemStone
   */
  public GemStone(String color, double transparency, int price, double weight) {
    
    this.color = color;
    this.transparency = transparency;
    this.price = price;
    this.weight = weight;
  }
  
  /**
   * Returns the gemstone color. Ex: {@code Blood Red}, {@code Colourless}
   * @return color name
   */
  public String getColor() {
    return color;
  }
  
  /**
   * Returns the gemstone transparency degree
   * @return transparency
   */
  public double getTransparency() {
    return transparency;
  }
  
  /**
   * Returns the gemstone price
   * @return price in dollars
   */
  public int getPrice() {
    return price;
  }
  
  /**
   * Returns the gemstone weight
   * @return weight in carats
   */
  public double getWeight() {
    return weight;
  }
  
  @Override
  public String toString() {
    return String.format("%s [%s, $%s, %s, %s ct]", this.getClass().getSimpleName(), color, price, transparency, weight);
  }
}

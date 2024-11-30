package labs.precious;

import labs.GemStone;

/**
 * The {@code Diamond} class represents diamond.
 * <p>
 * Parameters: {@code color}, {@code transparency}, {@code price}, {@code weight}
 *
 * @see Diamond
 * @see GemStone
 */
public class Diamond extends GemStone {
  /**
   * The {@code Diamond} constructor
   * @param color the color of gemstone. Ex: {@code Blood Red}, {@code Colourless}
   * @param transparency the transparency degree of gemstone
   * @param price the price in dollars
   * @param weight the weight in carats
   *
   * @see Diamond
   * @see GemStone
   */
  public Diamond(String color, double transparency, int price, double weight) {
    super(color, transparency, price, weight);
  }
}

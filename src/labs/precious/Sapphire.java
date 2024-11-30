package labs.precious;

import labs.GemStone;

/**
 * The {@code Sapphire} class represents sapphire.
 * <p>
 * Parameters: {@code color}, {@code transparency}, {@code price}, {@code weight}
 *
 * @see Sapphire
 * @see GemStone
 */
public class Sapphire extends GemStone {
  /**
   * The {@code Sapphire} constructor
   * @param color the color of gemstone. Ex: {@code Blood Red}, {@code Colourless}
   * @param transparency the transparency degree of gemstone
   * @param price the price in dollars
   * @param weight the weight in carats
   *
   * @see Sapphire
   * @see GemStone
   */
  public Sapphire(String color, double transparency, int price, double weight) {
    super(color, transparency, price, weight);
  }
}

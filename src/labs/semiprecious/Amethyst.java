package labs.semiprecious;

import labs.GemStone;

/**
 * The {@code Amethyst} class represents amethyst.
 * <p>
 * Parameters: {@code color}, {@code transparency}, {@code price}, {@code weight}
 *
 * @see Amethyst
 * @see GemStone
 */
public class Amethyst extends GemStone {
  /**
   * The {@code Amethyst} constructor
   * @param color the color of gemstone. Ex: {@code Blood Red}, {@code Colourless}
   * @param transparency the transparency degree of gemstone
   * @param price the price in dollars
   * @param weight the weight in carats
   *
   * @see Amethyst
   * @see GemStone
   */
  public Amethyst(String color, double transparency, int price, double weight) {
    super(color, transparency, price, weight);
  }
}

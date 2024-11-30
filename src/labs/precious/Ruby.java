package labs.precious;

import labs.GemStone;

/**
 * The {@code Ruby} class represents ruby.
 * <p>
 * Parameters: {@code color}, {@code transparency}, {@code price}, {@code weight}
 *
 * @see Ruby
 * @see GemStone
 */
public class Ruby extends GemStone {
  /**
   * The {@code Ruby} constructor
   * @param color the color of gemstone. Ex: {@code Blood Red}, {@code Colourless}
   * @param transparency the transparency degree of gemstone
   * @param price the price in dollars
   * @param weight the weight in carats
   *
   * @see Ruby
   * @see GemStone
   */
  public Ruby(String color, double transparency, int price, double weight) {
    super(color, transparency, price, weight);
  }
}

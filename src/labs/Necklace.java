package labs;

import java.util.Arrays;

/**
 * The {@code Necklace} class represents necklace.
 * Contains list of gems and allows to calculate total weight and price of gems.
 * <p>
 * Parameters: {@code gems}
 *
 * @see Necklace
 * @see GemStone
 */
public class Necklace {
  public GemStone[] gems;
  
  /**
   * Container of {@code Necklace} class
   * @param gems list of {@code GemStone} objects and its inheritances
   *
   * @see Necklace
   * @see GemStone
   */
  public Necklace(GemStone[] gems) {
    this.gems = gems;
  }
  
  /**
   * Calculates total weight of gems in this object
   * @return weight of gems
   */
  double calculateWeight() {
    return Arrays.stream(this.gems).mapToDouble(GemStone::getWeight).sum();
  }
  
  /**
   * Calculates total price of gems in this object
   * @return price of gems
   */
  int calculatePrice() {
    return Arrays.stream(this.gems).mapToInt(GemStone::getPrice).sum();
  }
}

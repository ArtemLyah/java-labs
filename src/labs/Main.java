package labs;

import labs.precious.Diamond;
import labs.precious.Ruby;
import labs.precious.Sapphire;
import labs.semiprecious.Amethyst;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    GemStone[] gems = {
      new Diamond("Colourless", 0.6, 1000, 3),
      new Diamond("Black", 0.4, 2000, 2.5),
      new Ruby("Red", 0.6, 500, 2),
      new Sapphire("Neon Blue", 0.7, 700, 3),
      new Amethyst("Pale Violet", 0.8, 500, 2),
    };
    
    Necklace necklace = new Necklace(gems);
    
    System.out.println("Weight of the necklace: "+necklace.calculateWeight()+" ct");
    System.out.println("Price of the necklace: $"+necklace.calculatePrice());
    
    List<GemStone> sortedGems = Arrays.stream(gems)
      .sorted(Comparator.comparingInt(GemStone::getPrice))
      .toList();
    
    List<GemStone> filteredGems = Arrays.stream(gems)
        .filter(gem -> gem.getTransparency() > 0.5 && gem.getTransparency() < 0.8)
        .toList();
    
    System.out.println("\nSorted gems by price:");
    System.out.println(String.join("\n", sortedGems.stream().map(GemStone::toString).toList()));
    
    System.out.println("\nFiltered gems by transparency:");
    System.out.println(String.join("\n", filteredGems.stream().map(GemStone::toString).toList()));
  }
}

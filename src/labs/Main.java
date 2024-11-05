package labs;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Furniture[] sofas = {
      new Furniture(
        "sofa",
        300,
        100,
        90,
        150,
        "black tree",
        new String[]{ "image1", "image2" }
      ),
      
      new Furniture(
        "chair",
        50,
        50,
        120,
        50,
        "oak",
        new String[]{ "image1", "image2" }
      ),
      
      new Furniture(
        "door",
        120,
        10,
        200,
        50,
        "black tree",
        new String[]{ "image1", "image2" }
      ),
      
      new Furniture(
        "table",
        100,
        100,
        80,
        100,
        "buk",
        new String[]{ "image1", "image2" }
      )
    };
    
    System.out.println("Sort by price and size:");
    Arrays.stream(sofas)
      .sorted((f1, f2) -> {
        int priseDiff = f1.getPrice() - f2.getPrice();
        int sizeDiff = f2.getArea() - f1.getArea();
        if (priseDiff == 0) {
          return sizeDiff;
        }
        return priseDiff;
      })
      .forEach(System.out::println);
    
    System.out.println();
  }
}

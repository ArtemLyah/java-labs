package labs;

/**
 * Class Furniture
 * Basic class that describes furniture
 * It contains the following parameters: name, width, length, height, price, material, images.
 * Each parameter is required.
*/
public class Furniture {
  private String name;
  private final int width;
  private final int length;
  private final int height;
  private int price;
  private final String material;
  private String[] images;
  
  /**
   * Constructs furniture with params
   * @param name the name of furniture
   * @param length the length of furniture in cm
   * @param width the width of furniture in cm
   * @param height the height of furniture in cm
   * @param price the price of furniture in dollars
   * @param material the material of furniture
   * @param images the list with images url
   */
  public Furniture(
    String name,
    int length,
    int width,
    int height,
    int price,
    String material,
    String[] images
  ) {
    this.name = name;
    this.length = length;
    this.width = width;
    this.height = height;
    this.price = price;
    this.material = material;
    this.images = images;
  }
  
  /**
   * Get furniture area in cm
   * @return area
   */
  public int getArea() {
    return length*width;
  }
  
  /**
   * Get furniture name
   * @return name
  */
  public String getName() {
    return name;
  }
  
  /**
   * Get furniture length in cm
   * @return length
   */
  public int getLength() { return length; }
  
  /**
   * Get furniture width in cm
   * @return width
   */
  public int getWidth() {
    return width;
  }
  
  /**
   * Get furniture height in cm
   * @return height
   */
  public int getHeight() {
    return height;
  }
  
  /**
   * Get furniture price in dollars
   * @return price
   */
  public int getPrice() {
    return price;
  }
  
  /**
   * Get furniture material
   * @return material
   */
  public String getMaterial() {
    return material;
  }
  
  /**
   * Get furniture links to images
   * @return images
   */
  public String[] getImages() {
    return images;
  }
  
  /**
   * Set furniture name
   */
  public void setName(String name) { this.name = name; }
  
  /**
   * Get furniture price in dollars
   */
  public void setPrice(int price) {
     this.price = price;
  }
  
  /**
   * Set furniture images
   */
  public void setImages(String[] images) {
    this.images = images;
  }
  
  /**
   * Get furniture description
   * @return string with format: Furniture<name, lengthXwidthXheight cm, price, material>
   */
  @Override
  public String toString() {
    return String.format("Furniture<%s %dx%dx%d cm, %d$, %s>", name, length, width, height, price, material);
  }
}

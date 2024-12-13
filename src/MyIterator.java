import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic iterator implementation for iterating over a fixed-size array of elements.
 *
 * @param <E> the type of elements returned by this iterator
 */
public class MyIterator<E> implements Iterator<E> {
  /**
   * The current index of the iterator.
   */
  private int index = 0;
  
  /**
   * The array of elements to be iterated.
   */
  private final E[] list;
  
  /**
   * The size of the array to iterate over.
   * This may be less than the length of the array to support partially filled arrays.
   */
  private final int listSize;
  
  /**
   * Constructs an instance of {@code MyIterator}.
   *
   * @param list     the array of elements to iterate over
   * @param listSize the number of valid elements in the array
   * @throws IllegalArgumentException if {@code listSize} is greater than the length of {@code list} or less than 0
   */
  public MyIterator(E[] list, int listSize) {
    if (listSize < 0 || listSize > list.length) {
      throw new IllegalArgumentException("Invalid list size");
    }
    this.list = list;
    this.listSize = listSize;
  }
  
  /**
   * Checks if there are more elements to iterate over.
   *
   * @return {@code true} if there are more elements, {@code false} otherwise
   */
  @Override
  public boolean hasNext() {
    return index < listSize;
  }
  
  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if there are no more elements to return
   */
  @Override
  public E next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return list[index++];
  }
}

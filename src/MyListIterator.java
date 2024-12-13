import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Custom implementation of a {@link ListIterator} for a list of elements.
 *
 * @param <E> the type of elements in the list
 */
public class MyListIterator<E> implements ListIterator<E> {
  private List<E> list;
  private int lastIndex = 0;
  private int cursor;
  
  /**
   * Constructs a new {@code MyListIterator} for the specified list.
   * The iterator starts at the beginning of the list.
   *
   * @param list the list to iterate over
   */
  public MyListIterator(List<E> list) {
    this.list = list;
    this.cursor = 0;
  }
  
  /**
   * Constructs a new {@code MyListIterator} for the specified list starting at the given position.
   *
   * @param list the list to iterate over
   * @param cursor the initial position of the iterator
   */
  public MyListIterator(List<E> list, int cursor) {
    this.list = list;
    this.cursor = cursor;
  }
  
  /**
   * Returns {@code true} if the iteration has more elements.
   *
   * @return {@code true} if there are more elements to iterate over
   */
  @Override
  public boolean hasNext() {
    return cursor < list.size();
  }
  
  /**
   * Returns the next element in the iteration and advances the cursor position.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public E next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    lastIndex = cursor;
    return list.get(cursor++);
  }
  
  /**
   * Returns {@code true} if there are elements before the current cursor position.
   *
   * @return {@code true} if there are previous elements
   */
  @Override
  public boolean hasPrevious() {
    return cursor > 0;
  }
  
  /**
   * Returns the previous element in the iteration and moves the cursor position backwards.
   *
   * @return the previous element in the iteration
   * @throws NoSuchElementException if there are no previous elements
   */
  @Override
  public E previous() {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }
    lastIndex = cursor--;
    return list.get(cursor);
  }
  
  /**
   * Returns the index of the element that would be returned by a subsequent call to {@link #next()}.
   *
   * @return the index of the next element
   */
  @Override
  public int nextIndex() {
    return cursor;
  }
  
  /**
   * Returns the index of the element that would be returned by a subsequent call to {@link #previous()}.
   *
   * @return the index of the previous element
   */
  @Override
  public int previousIndex() {
    return cursor - 1;
  }
  
  /**
   * Removes the last element returned by {@link #next()} or {@link #previous()} from the list.
   *
   * @throws IllegalStateException if {@link #next()} or {@link #previous()} have not been called,
   *         or {@link #remove()} has already been called after the last call to {@link #next()} or {@link #previous()}
   */
  @Override
  public void remove() {
    if (lastIndex == -1) {
      throw new IllegalStateException();
    }
    list.remove(lastIndex);
    cursor = lastIndex;
    lastIndex = -1;
  }
  
  /**
   * Replaces the last element returned by {@link #next()} or {@link #previous()} with the specified element.
   *
   * @param e the element with which to replace the last element returned
   * @throws IllegalStateException if {@link #next()} or {@link #previous()} have not been called,
   *         or {@link #set(Object)} has already been called after the last call to {@link #next()} or {@link #previous()}
   */
  @Override
  public void set(E e) {
    if (lastIndex == -1) {
      throw new IllegalStateException();
    }
    list.set(lastIndex, e);
    lastIndex = -1;
  }
  
  /**
   * Inserts the specified element into the list at the current cursor position.
   * The element is inserted immediately before the next element that would be returned by {@link #next()},
   * if any, and after the next element that would be returned by {@link #previous()}, if any.
   *
   * @param e the element to insert
   */
  @Override
  public void add(E e) {
    list.add(cursor++, e);
    lastIndex = -1;
  }
}

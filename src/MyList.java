import java.util.*;
import java.util.function.UnaryOperator;

/**
 * A custom implementation of the {@link List} interface.
 *
 * @param <E> the type of elements in this list
 */
public class MyList<E> implements List<E> {
  private E[] list;
  private int size = 0;
  private int DEFAULT_CAPACITY = 15;
  private double GROWTH_COEF = 1.3;
  
  /**
   * Constructs an empty list with an initial capacity of 15.
   */
  public MyList() {
    list = (E[]) new Object[DEFAULT_CAPACITY];
  }
  
  /**
   * Constructs a list containing the elements of the specified list.
   *
   * @param list the list whose elements are to be placed into this list
   */
  public MyList(List<E> list) {
    this();
    this.addAll(list);
  }
  
  /**
   * Constructs a list containing the elements of the specified collection.
   *
   * @param collection the collection whose elements are to be placed into this list
   */
  public MyList(Collection<E> collection) {
    this();
    this.addAll(collection);
  }
  
  @Override
  public int size() {
    return size;
  }
  
  @Override
  public boolean isEmpty() {
    return size == 0;
  }
  
  @Override
  public boolean contains(Object o) {
    return indexOf(o) != -1;
  }
  
  @Override
  public Iterator<E> iterator() {
    return new MyIterator<>(list, size);
  }
  
  @Override
  public E[] toArray() {
    return Arrays.copyOf(list, list.length);
  }
  
  @Override
  public <T> T[] toArray(T[] a) {
    if (a.length < list.length) {
      return (T[]) Arrays.copyOf(list, list.length, a.getClass());
    }
    for (int i = 0; i < list.length; i++) {
      a[i] = (T) list[i];
    }
    return a;
  }
  
  @Override
  public boolean add(E e) {
    if (size == list.length) {
      list = Arrays.copyOf(list, (int) Math.ceil(list.length * GROWTH_COEF));
    }
    list[size++] = e;
    return true;
  }
  
  @Override
  public boolean remove(Object o) {
    int index = indexOf(o);
    if (index != -1) {
      remove(index);
      return true;
    }
    return false;
  }
  
  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      if (!contains(o)) {
        return false;
      }
    }
    return true;
  }
  
  @Override
  public boolean addAll(Collection<? extends E> c) {
    for (E e : c) {
      add(e);
    }
    return !c.isEmpty();
  }
  
  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    checkIndex(index);
    E[] restElements = (E[]) new Object[size - index];
    System.arraycopy(list, index, restElements, 0, size - index);
    size = index;
    for (E e : c) {
      add(e);
    }
    addAll(List.of(restElements));
    return !c.isEmpty();
  }
  
  @Override
  public boolean removeAll(Collection<?> c) {
    boolean changed = false;
    for (Object o : c) {
      while (remove(o)) {
        changed = true;
      }
    }
    return changed;
  }
  
  @Override
  public boolean retainAll(Collection<?> c) {
    boolean changed = false;
    for (int i = size - 1; i >= 0; i--) {
      if (!c.contains(list[i])) {
        remove(i);
        changed = true;
      }
    }
    return changed;
  }
  
  @Override
  public void replaceAll(UnaryOperator<E> operator) {
    for (int i = 0; i < size; i++) {
      operator.apply(list[i]);
    }
  }
  
  @Override
  public void sort(Comparator<? super E> c) {
    Arrays.sort(list, c);
  }
  
  @Override
  public void clear() {
    list = (E[]) new Object[DEFAULT_CAPACITY];
    size = 0;
  }
  
  @Override
  public E get(int index) {
    checkIndex(index);
    return list[index];
  }
  
  @Override
  public E set(int index, E element) {
    checkIndex(index);
    E old = list[index];
    list[index] = element;
    return old;
  }
  
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    E[] restElements = (E[]) new Object[size - index];
    System.arraycopy(list, index, restElements, 0, size - index);
    size = index;
    add(element);
    addAll(List.of(restElements));
  }
  
  @Override
  public E remove(int index) {
    checkIndex(index);
    E old = list[index];
    if (index == size - 1) {
      list[index] = null;
    } else {
      System.arraycopy(list, index + 1, list, index, size - index);
    }
    size--;
    return old;
  }
  
  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (o.equals(list[i])) {
        return i;
      }
    }
    return -1;
  }
  
  @Override
  public int lastIndexOf(Object o) {
    for (int i = size - 1; i >= 0; i--) {
      if (o.equals(list[i])) {
        return i;
      }
    }
    return -1;
  }
  
  @Override
  public ListIterator<E> listIterator() {
    return new MyListIterator<>(this);
  }
  
  @Override
  public ListIterator<E> listIterator(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    return new MyListIterator<>(this, index);
  }
  
  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException();
    }
    E[] resultList = (E[]) new Object[toIndex - fromIndex];
    System.arraycopy(list, fromIndex, resultList, 0, toIndex - fromIndex);
    return new MyList<>(List.of(resultList));
  }
  
  @Override
  public void addFirst(E e) {
    this.add(0, e);
  }
  
  @Override
  public void addLast(E e) {
    this.add(e);
  }
  
  @Override
  public E getFirst() {
    return list[0];
  }
  
  @Override
  public E getLast() {
    return list[size - 1];
  }
  
  @Override
  public E removeFirst() {
    return remove(0);
  }
  
  @Override
  public E removeLast() {
    return remove(size - 1);
  }
  
  @Override
  public MyList<E> reversed() {
    E[] reversedList = (E[]) new Object[size];
    for (int i = 0; i < size; i++) {
      reversedList[i] = list[size - i - 1];
    }
    return new MyList<>(List.of(reversedList));
  }
  
  /**
   * Checks if the specified index is within the valid range.
   *
   * @param index the index to check
   * @throws IndexOutOfBoundsException if the index is out of range
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  @Override
  public String toString() {
    return Arrays.stream(list).filter(Objects::nonNull).toList().toString();
  }
}

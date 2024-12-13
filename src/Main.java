import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<String> list = new MyList<>();
    
    list.add("Hello");
    list.add("World");
    list.add("A");
    list.add("B");
    list.add("C");
    list.add(3, "D");
    
    System.out.println(list);
    System.out.println("Size: " + list.size());
    System.out.println("First element: " + list.getFirst());
    System.out.println("Last element: " + list.getLast());
    System.out.println("The second element: " + list.get(1));
    System.out.println("Reversed list: " + list.reversed().toString());
    System.out.println("Index of World word: " + list.indexOf("World"));
    
    System.out.println("Is it contains A, B, C: " + list.containsAll(List.of("A", "B", "C")));
    list.addAll(2, List.of("1", "2", "3"));
    System.out.println("Add list of elements: "+list);
    list.retainAll(List.of("1", "2", "3", "Hello", "World"));
    System.out.println("Retain list of elements: "+list);
    
    System.out.println("Iterate list:");
    for (String s : list) {
      System.out.println(s);
    }
    
    System.out.println("Test list iterator:");
    ListIterator<String> listIterator = list.listIterator();
    
    System.out.println(listIterator.next());
    System.out.println(listIterator.next());
    System.out.println(listIterator.next());
    listIterator.set("0");
    listIterator.add("9");
    System.out.println(listIterator.previous());
    System.out.println(listIterator.next());
    System.out.println(listIterator.next());
    System.out.println(listIterator.next());
    listIterator.remove();
    
    System.out.println(list);
  }
}

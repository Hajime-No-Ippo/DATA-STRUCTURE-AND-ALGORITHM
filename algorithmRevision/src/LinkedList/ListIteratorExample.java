package LinkedList;

import java.util.*;

public class ListIteratorExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Create a ListIterator
        ListIterator<String> iterator = list.listIterator();

        System.out.println("Forward traversal:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Backward traversal:");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }


        //create a new list and show how to use add/set to modify the list
        List<String> names = new LinkedList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        ListIterator<String> it = names.listIterator();

        while (it.hasNext()) {
            String name = it.next();
            if (name.equals("Bob")) {
                it.add("David"); // Add after Bob
            }
            if (name.equals("Charlie")) {
                it.set("Eve"); // Replace Charlie with Eve
            }
        }

        System.out.println(names);
    }
}

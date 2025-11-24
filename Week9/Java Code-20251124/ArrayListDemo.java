import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 1. Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // 2. Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Lemon");
        fruits.add("Strawberry");
        System.out.println("Fruits: " + fruits);

        // 3. Insert element at a specific index
        fruits.add(1, "Orange");
        System.out.println("After inserting Orange at index 1: " + fruits);

        // 4. Access element by index
        String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);

        // 5. Modify element
        fruits.set(2, "Blueberry");
        System.out.println("After modifying index 2: " + fruits);

        // 6. Remove element by value
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);

        // 7. Remove element by index
        fruits.remove(0);
        System.out.println("After removing index 0: " + fruits);

        // 8. Check if list contains an element
        boolean hasCherry = fruits.contains("Cherry");
        System.out.println("Contains Cherry? " + hasCherry);

        // 9. Get the size of the ArrayList
        int size = fruits.size();
        System.out.println("Size of list: " + size);

        // 10. Iterate using for-each loop
        System.out.println("Iterating over list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }


        // 11. Shuffle array 
        System.out.println("Before shuffling: " + fruits);
        Collections.shuffle(fruits);
        System.out.println("After shuffling: " + fruits);

        // 12. Clear the list
        fruits.clear();
        System.out.println("After clearing: " + fruits);
    }
}

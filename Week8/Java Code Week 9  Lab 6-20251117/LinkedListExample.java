import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList of integers
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements
        list.add(10);             // Add at end
        list.add(20);
        list.add(30);

        // Add at specific positions
        list.addFirst(5);         // Add at beginning
        list.addLast(40);         // Add at end

        // Display elements
        System.out.println("LinkedList: " + list);

        // Access elements
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // Remove elements
        list.removeFirst();       // Remove from beginning
        list.removeLast();        // Remove from end
        list.remove(1);           // Remove by index

        // Check contents
        System.out.println("After removals: " + list);
        System.out.println("Contains 20? " + list.contains(20));

        // Iterate over elements
        System.out.print("Elements: ");
        for (int num : list) {
            System.out.print(num + " ");
        }

        
    }

    public int get(Node head, int target){
        

    }
}

import java.util.LinkedList;
import java.util.ListIterator;

public class SortedLinkedList {
    private LinkedList<Integer> list = new LinkedList<>();

    // Insert while maintaining ascending order
    public void add(int value) {
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            if (it.next() > value) {
                it.previous();  // step back one position
                it.add(value);
                return;
            }
        }
        list.add(value); // if larger than all existing elements
    }

    public void display() {
        System.out.println(list);
    }

    public static void main(String[] args) {
        SortedLinkedList sList = new SortedLinkedList();
        sList.add(30);
        sList.add(10);
        sList.add(20);
        sList.add(25);
        sList.add(5);

        sList.display();  // Output: [5, 10, 20, 25, 30]
    }
}

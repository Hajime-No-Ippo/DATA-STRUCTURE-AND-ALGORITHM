public class LinkedListJava {

    // Node class (inner class)
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;   // head of the list
    private int size;    // track size

    // Constructor
    public LinkedListJava() {
        head = null;
        size = 0;
    }

    // Insert at beginning
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Insert at end
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Delete first occurrence of a value
    public void delete(int data) {
        if (head == null) return;

        // If deleting head
        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    // Search for a value
    public boolean search(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }

        return false;
    }

    // Get size
    public int size() {
        return size;
    }

    // Print list
    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Testing
    public static void main(String[] args) {
        LinkedListJava list = new LinkedListJava();
        LinkedListJava list2 = new LinkedListJava();
        Node newRevHead = null;

        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtTail(4);
        list.insertAtTail(5);
        
        list2.insertAtHead(3);
        list2.insertAtHead(2);
        list2.insertAtTail(4);
        list2.insertAtTail(5);

        list.printList(); // 2 -> 3 -> 4 -> 5 -> null

        System.out.println("Search 3: " + list.search(3)); // true

        list.delete(3);
        list.printList(); // 2 -> 4 -> 5 -> null

        System.out.println("Size: " + list.size());

        //Insert three target value in linked list
        list.head = list.insert_sorted(list.head,3);
        list.head = list.insert_sorted(list.head,3);
        list.head = list.insert_sorted(list.head,1);
        list.printList();

        //Insertion and print (void) method
        list.insert_sorted_in_void(list.head,6);
        list.insert_sorted_in_void(list.head,7);
        list.insert_sorted_in_void(list.head,8);
        
        //Merge two list and print
        System.out.println();
        System.out.println("\nPrint merged list: ");
        list2.head = list.merge_two_List(list.head, list2.head);
        list2.printList();


        //sort the list and do the printing
        /*  list.head = list.reverse_list(list.head);
        list.printList();
        */
        
    }

    //Task1
    public int get(Node head, int index){

        if(index < 0){
            return -1;
        }

        Node current = head;
        int count = 0;
        while(current != null){
            if(count== index){
                return current.data;}
            else{
            current= current.next;
            count++;}
        }
        return -1;
    }

    //Task2 Insert a target element to a sorted Linked Node
    public Node insert_sorted(Node head, int target){
        Node current = head;
        Node newNode = new Node(target);
        

        //if target is smaller than the head, or the linked ist is null
        if(head==null|| target<head.data){
            newNode.next = head;
            return newNode;
        }

        //serach the position, insert the data in 
        while (current.next != null && current.next.data < target){
            current = current.next;
        }

        //Do the insert by let node.next eq to 'current' .next, and let the 'current' itself eq to the node we want to insert
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    //Task2.5 Insert a target element to a sorted Linked Node
    public void insert_sorted_in_void(Node head, int target){
        Node current = head;
        Node newNode = new Node(target);
        Node dummy = head;

        //if target is smaller than the head, or the linked ist is null
        if(head==null || target<head.data){
            newNode.data = head.data;
            newNode.next = head.next;

            head.data = target;
            head.next = newNode;
            return;
        }
       
        //serach the position, insert the data in the position
        while(current.next != null && current.data < target){
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        //Do the print in the whole method.
        System.out.println();
        while(dummy != null){
            System.out.print( dummy.data + " -> ");
            dummy = dummy.next;
        }
    }


    //Task3 Reverse the list
    public Node reverse_list(Node head){
        //create a list to store the previous elements in list?
        //track the list from end to beginning
        LinkedListJava revList = new LinkedListJava();

        //set a pointer to traverse the head list.
        Node current = head;
        //reverse the list by adding to head
        while(current != null){
            revList.insertAtHead(current.data);
            current = current.next;
        }

        //return the node of new list
        return revList.head;
    }

    //Task4 sorting in the list
    public Node sort_list(Node head){
        //elements for store the current.data
        LinkedListJava newList = new LinkedListJava();
        //get the smallest element in an list, then delete it, everytime we choose the smallest value to add it into the new list.
        while(head != null){ 
            Node previous = head;
            Node current = head.next;
            Node smallestNode = head;
            Node prevSmallestNode = null;

            smallestNode = current;
            prevSmallestNode = previous; 
            while(current != null){
                if(current.data < smallestNode.data){
                    smallestNode = current;
                    prevSmallestNode = previous;
                }
                previous = current;
                current = current.next;
            }

            if(smallestNode == null){
                head = head.next;
            }else{
                prevSmallestNode = smallestNode.next;
            }
            newList.insertAtTail(smallestNode.data);
        }
        return newList.head;
    }

    //Task5 Merge two list
    public Node merge_two_List(Node l1, Node l2){
        Node dummy = new Node(0);
        Node curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.data<l2.data) {curr.next = l1; l1 = l1.next;}
            else {curr.next = l2; l2 = l2.next;}
            curr = curr.next;
        }

        if(l1 != null) {curr.next = l1;}
        if(l2 != null) {curr.next = l2;}

        return dummy;
    }

    //Task6 HashMap Java Class
        
    

}

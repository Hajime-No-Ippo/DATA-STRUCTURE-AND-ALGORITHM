class Customer {
    String name;
    String surname;
    int age;

    Customer(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    void display() {
        System.out.println(name + " " + surname + " (" + age + ")");
    }
}

public class SortCustomers {
    public static void main(String[] args) {
        // Hardcoded customer data
        Customer[] customers = {
            new Customer("John", "Smith", 30),
            new Customer("Alice", "Brown", 25),
            new Customer("Bob", "Adams", 28),
            new Customer("Diana", "Clark", 35),
            new Customer("Eve", "Davis", 22),
            new Customer("Adam", "Smith", 25)
        };

        System.out.println("Original list of customers:");
        printCustomers(customers);

        // Sort by surname
        bubbleSortBySurname(customers);
        System.out.println("\nSorted by surname:");
        printCustomers(customers);

        // Sort by age
        bubbleSortByAge(customers);
        System.out.println("\nSorted by age:");
        printCustomers(customers);

        // Sort by surname, then age
        bubbleSortBySurnameThenAge(customers);
        System.out.println("\nSorted by surname, then age:");
        printCustomers(customers);
    }

    // Bubble Sort by surname (alphabetically)
    public static void bubbleSortBySurname(Customer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].surname.compareToIgnoreCase(arr[j + 1].surname) > 0) {
                    Customer temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort by age (ascending)
    public static void bubbleSortByAge(Customer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].age > arr[j + 1].age) {
                    Customer temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort by surname, then age
    public static void bubbleSortBySurnameThenAge(Customer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean swap = false;

                // Compare by surname first
                int surnameCompare = arr[j].surname.compareToIgnoreCase(arr[j + 1].surname);
                if (surnameCompare > 0) {
                    swap = true;
                } 
                // If surnames are equal, compare by age
                else if (surnameCompare == 0 && arr[j].age > arr[j + 1].age) {
                    swap = true;
                }

                if (swap) {
                    Customer temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Print all customers
    public static void printCustomers(Customer[] arr) {
        for (Customer c : arr) {
            c.display();
        }
    }
}

import java.util.HashSet;
import java.util.Scanner;

/*
    SAMPLE 01;
    import java.util.HashSet;

    HashSet<String> set = new HashSet<>();

    set.add("Apple");
    set.add("Banana");
    set.add("Apple");  // duplicate — ignored

    System.out.println(set);
*/

public class EmailRegistry {
    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter email addresses (type 'exit' to stop):");

        while (true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Add email only if it doesn't already exist
            if (emails.contains(input)) {
                System.out.println("❌ This email is already registered.");
            } else {
                emails.add(input);
                System.out.println("✅ Email added successfully.");
            }
        }

        sc.close();

        System.out.println("\nAll registered emails (unique list):");
        for (String email : emails) {
            System.out.println(" - " + email);
        }
    }
}


/*
 * for(;;)
 * {
 * 
 * if(input.equalsIgnoreCase("exit"))
 * {
 *      break;
 * }
 * else if(emails.contains(input))
 * {
 *      System.out.println("This email has been registered.")
 * }
 * else
 * {
 *      emails.add(input);
 *      System.out.println("Add this email successfully.")
 * }
 * }
 */
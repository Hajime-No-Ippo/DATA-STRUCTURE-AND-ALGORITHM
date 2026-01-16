package Week10;
import java.util.*;

public class Solution {

   public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Random ran = new Random(3);
        int s = sc.nextInt();
        int h = sc.nextInt();
        sc.nextLine();
        String [][] r = new String[s][h];
        
     // Selected Matrix
     for(int i = 0; i < s; i++){
        for(int j = 0; j < h; j++){
            r[i][j] = Integer.toString(ran.nextInt(9));
        }
     }

     // 2x2 Matrix
     String [][] re = new String[2][2];
     for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            re[i][j] = Integer.toString(ran.nextInt(9));
        }
     }

     for(int i = 0; i < s; i++){
        for(int j = 0; j < h; j++){
            System.out.print(r[i][j]);
        }
        System.out.println();
     }

     System.out.println();

     for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            System.out.print(re[i][j]);
        }
        System.out.println();
     }

        System.out.println(Arrays.asList(r).toString());   
        
        // Search for the 2x2 pattern `re` inside the larger array `r`
        boolean found = false;
        for (int i = 0; i <= s - 2 && !found; i++) {
            for (int j = 0; j <= h - 2 && !found; j++) {
                if (matchesAt(r, re, i, j)) {
                    System.out.println("Found at top-left position: (" + i + ", " + j + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Pattern not found.");
        }

        sc.close(); 
    }

    // Returns true if `pattern` matches `grid` with its top-left at (row, col)
    private static boolean matchesAt(String[][] grid, String[][] pattern, int row, int col) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (!grid[row + i][col + j].equals(pattern[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}

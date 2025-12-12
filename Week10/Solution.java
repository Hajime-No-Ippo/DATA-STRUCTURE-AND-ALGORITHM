package Week10;
import java.util.*;

public class Solution {

   public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int s = sc.nextInt();
        int h = sc.nextInt();
        sc.nextLine();
        String [][] r = new String[s][h];
     
     for(int i = 0; i < s; i++){
        for(int j = 0; j < h; j++){
            r[i][j] = Integer.toString(ran.nextInt(9));
        }
     }
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
        sc.close(); 
    }
}


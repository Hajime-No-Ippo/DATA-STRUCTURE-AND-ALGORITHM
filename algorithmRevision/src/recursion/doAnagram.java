package recursion;

public class doAnagram {
    public static void main(String[] args) {
        doAnagram("Hello World");
    }
    private static String doAnagram(String a) {
        if(a.length()<2){
            return a;
        }
        return doAnagram(a.substring(1) + a.charAt(0));
    }
}

package Leetcode28FindTheIndexOfFirstOccur;

public class lc28 {
    public static void main(String[] args) {
        System.out.println(strStr("   fly me   to   the moon  ", "fly"));
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.isEmpty() || needle.isEmpty()){
            return -1;
        }
        // startsWith() function ("elements", "index")
        String h = haystack.replaceAll(" ", ""); //specified case ignore " " with replace function

        for(int i = 0; i < h.length();i++)
        {
            if(h.startsWith(needle, i) ){
                return i;
            }
        }
        return -1;
    }
}

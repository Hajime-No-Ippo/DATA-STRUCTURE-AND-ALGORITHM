package Leetcode58LengthOfLastWord;

public class lc58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        for (int  i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && s.charAt(i-1) != ' ') {
                s = s.substring(0, i);
                break;
            }
            if(s.charAt(i) != ' '){
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length()-1-i;
            }
        }
        return s.length();
    }
}

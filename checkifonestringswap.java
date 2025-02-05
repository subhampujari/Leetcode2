import java.util.Arrays;

public class checkifonestringswap {
    public boolean areAlmostEqual(String s1, String s2) {
      // If the strings are already equal, return true
        if(s1.equals(s2)) return true;
        
        // If the strings are not of the same length, they can't be almost equal
        if(s1.length() != s2.length()) return false;

        // Find the positions where characters differ
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        // Count frequencies of characters in both strings
        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        // Check if the frequency of characters is the same in both strings
        if (!Arrays.equals(freq1, freq2)) return false;

        // Find the indices where characters in s1 and s2 differ
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
        }

        // The strings are almost equal if there are exactly 2 differences
        return diffCount == 2;
    }
    public static void main(String[] args) {
        checkIfOneString checker=new checkIfOneString();

        String s1="abca";
        String s2="acba";

        boolean res=checker.areAlmostEqual(s1, s2);
        System.out.println("Are the Strings almost equal?" +res);
        
    }
}

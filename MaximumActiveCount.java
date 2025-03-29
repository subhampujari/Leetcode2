public class MaximumActiveCount{
    public int maxActiveSectionsAfterTrade(String binaryString) {
        int length = binaryString.length(), countOnes = 0;
    
    // Count the number of '1's in the original string
    for (char ch : binaryString.toCharArray()) {
        if (ch == '1') countOnes++;
    }
    
    // Augment the string with '1' at both ends
    String modifiedString = "1" + binaryString + "1";
    int newLength = modifiedString.length(), maxCount = countOnes;
    
    for (int i = 1; i < newLength - 1; ) {
        if (modifiedString.charAt(i) == '1') {
            int j = i;
            
            // Move j to the end of continuous '1's
            while (j < newLength && modifiedString.charAt(j) == '1') j++;

            // Check for a valid window
            if (j < newLength - 1 && modifiedString.charAt(i - 1) == '0' && modifiedString.charAt(j) == '0') {
                int leftCount = 0, rightCount = 0, k = i - 1;

                // Count left-side contiguous '1's
                while (k >= 0 && modifiedString.charAt(k) == '0') {
                    leftCount++; 
                    k--;
                }
                k = j;

                // Count right-side contiguous '1's
                while (k < newLength && modifiedString.charAt(k) == '0') {
                    rightCount++; 
                    k++;
                }

                // Update the maximum possible active sections
                maxCount = Math.max(maxCount, countOnes + leftCount + rightCount);
            }
            i = j;
        } else {
            i++;
        }
    }
    return maxCount;
    }
}
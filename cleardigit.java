class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                sb.append(s.charAt(i));  // Append lowercase character
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);  // Remove the last character
                }
            }
        }
        
        return sb.toString();  // Return the modified string
    }
}

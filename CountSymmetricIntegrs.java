public class CountSymmetricIntegrs{
        public int countSymmetricIntegers(int low, int high) {
            int count = 0;
            for (int i = low; i <= high; i++) {
                String str = Integer.toString(i);
                if (isSymmetric(str)) {
                    count++;
                }
            }
            return count;
        }
    
        public boolean isSymmetric(String str) {
            if (str.length() % 2 != 0) return false; // Skip odd-length numbers
    
            int mid = str.length() / 2;
            int left = 0, right = 0;
            for (int i = 0; i < mid; i++) {
                left += str.charAt(i) - '0';
                right += str.charAt(mid + i) - '0';
            }
            return left == right;
        }
}
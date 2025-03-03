public class PartitionArray{
        public int[] pivotArray(int[] nums, int pivot) {
            int n = nums.length;
            int[] ans = new int[n];
    
            int lessThan = 0;  // count of numbers less than pivot
            int equal = 0;     // count of numbers equal to pivot
            int greaterThan = 0; // count of numbers greater than pivot
    
            // First loop to count numbers
            for (int i = 0; i < n; i++) {
                if (nums[i] < pivot) {
                    lessThan++;
                } else if (nums[i] == pivot) {
                    equal++;
                } else {
                    greaterThan++;
                }
            }
    
            // Indices to place numbers in the result array
            int i = 0;        // Pointer for numbers less than pivot
            int j = lessThan; // Pointer for numbers equal to pivot
            int k = lessThan + equal; // Pointer for numbers greater than pivot
    
            // Second loop to fill the result array
            for (int l = 0; l < n; l++) {
                if (nums[l] < pivot) {
                    ans[i] = nums[l];
                    i++;
                } else if (nums[l] == pivot) {
                    ans[j] = nums[l];
                    j++;
                } else {
                    ans[k] = nums[l];
                    k++;
                }
            }
    
            return ans;
        }
    }
public class LargestValidSubString{
    public int[] constructDistancedSequence(int n) {
        int arr[] = new int[2 * n - 1];
        boolean vist[] = new boolean[n + 1];
        solve(arr, vist, 0, n);
        return arr;
    }

    public boolean solve(int arr[], boolean vist[], int index, int n) {
        if (index == arr.length) {
            return true;
        }

        // Skip filled positions
        if (arr[index] != 0) {
            return solve(arr, vist, index + 1, n);
        }

        // Try placing numbers from n down to 1
        for (int i = n; i >= 1; --i) {
            // For number i, if i == 1, only place at the current index
            // Otherwise, try to place at index and index + i - 1
            int nextIndex = (i == 1) ? index : index + i;

            // Skip if the number is already used or if the positions are out of bounds
            if (vist[i] || nextIndex >= arr.length || arr[nextIndex] != 0) {
                continue;
            }

            // Place number i at both positions
            arr[index] = arr[nextIndex] = i;
            vist[i] = true;

            // Recursively solve for the next index
            if (solve(arr, vist, index + 1, n)) {
                return true;
            }

            // Backtrack
            arr[index] = arr[nextIndex] = 0;
            vist[i] = false;
        }
        return false;
    }
}
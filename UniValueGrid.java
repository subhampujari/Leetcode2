import java.util.Arrays;

public class UniValueGrid{
    public int minOperations(int[][] grid, int x) {
          int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];
        int index = 0;

        // Flatten the grid into a 1D array
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

        // Sort the array
        Arrays.sort(arr);
        
        // Find the median
        int median = arr[size / 2];
        int operations = 0;

        // Calculate the number of operations
        for (int num : arr) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1; // Not possible
            operations += diff / x;
        }

        return operations;
    }
}
import java.util.*;

public class FindTheNumberOfDistinctColor {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Map<Integer, Integer> colorMap = new HashMap<>();
        Map<Integer, Integer> ballMap = new HashMap<>();

        // Iterate through queries
        for (int i = 0; i < n; i++) {
            // Extract ball label and color from query
            int ball = queries[i][0];
            int color = queries[i][1];

            // Check if ball is already colored
            if (ballMap.containsKey(ball)) {
                // Decrement count of the previous color on the ball
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);

                // If there are no balls with previous color left, remove color from color map
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }
            // Set color of ball to the new color
            ballMap.put(ball, color);

            // Increment the count of the new color
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            result[i] = colorMap.size();
        }
        return result;
    }

    public static void main(String[] args) {
        // Creating an instance of Solution class
        FindTheNumberOfDistinctColor solution = new FindTheNumberOfDistinctColor();

        // Sample input for queries (ball, color)
        int[][] queries = {
            {1, 2},
            {2, 3},
            {3, 2},
            {1, 3},
            {2, 2}
        };

        // Define the limit (can be used as a parameter if needed)
        int limit = 10;

        // Calling the queryResults method
        int[] result = solution.queryResults(limit, queries);

        // Printing the result array
        System.out.println("Result:");
        System.out.println(Arrays.toString(result));
    }
}

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithOutMetting{
    public int countDays(int days, int[][] meetings) {
          if (meetings.length == 0) return days; // If no meetings, all days are free
        
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0])); // Correct sorting
        
        int dayCount = 0;
        int lastEnd = 0; // Tracks the last meeting end day
        
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            
            if (start > lastEnd + 1) { // Only count free days when there's a gap
                dayCount += start - lastEnd - 1;
            }
            lastEnd = Math.max(lastEnd, end); // Ensure we correctly track merged meetings
        }

        // Count free days after the last meeting
        dayCount += days - lastEnd;
        
        return dayCount;
    }
}
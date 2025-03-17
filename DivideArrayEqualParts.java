import java.util.HashMap;
import java.util.Map;

public class DivideArrayEqualParts{
    public boolean divideArray(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check if all frequencies are even
        for (int freq : map.values()) {
            if (freq % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}
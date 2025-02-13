class Solution {
    public int minOperations(int[] nums, int k) {
        int operation = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            pq.offer((long)nums[i]);
        }
        
        while (pq.size() >= 1) {
            long x = pq.poll();
            long y = -1;
            if (!pq.isEmpty()) {
                y = pq.poll();
            }
            if (x >= k) {
                break;
            }
            long xy = Math.min(x, y) * 2 + Math.max(x, y);
            operation++;
            pq.offer(xy);
        }
        
        return operation;
    }
}
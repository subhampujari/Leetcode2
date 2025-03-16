public class MinimumTimeToSpendCar{
        public long repairCars(int[] ranks, int cars) {
            long left = 0, high = (long) 1e14; // Correctly using long type
            while (left <= high) {
                long mid = left + (high - left) / 2;
                if (isPossible(ranks, cars, mid)) {
                    high = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    
        public boolean isPossible(int[] ranks, int totalCars, long mid) {
            long repairedCars = 0;
            for (int rank : ranks) {
                repairedCars += Math.sqrt(mid / rank); // Correct formula
            }
            return repairedCars >= totalCars;
        }    
}
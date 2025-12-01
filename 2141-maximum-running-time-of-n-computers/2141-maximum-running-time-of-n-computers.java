class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) {
            total += b;
        }

        long low = 0;
        long high = total / n;  // max possible minutes per computer

        while (low < high) {
            long mid = (low + high + 1) / 2;  // upper mid
            long usable = 0;

            for (int b : batteries) {
                usable += Math.min((long) b, mid);
                // Early stop to avoid unnecessary overflow-ish growth
                if (usable >= mid * n) {
                    break;
                }
            }

            if (usable >= mid * n) {
                low = mid;      // mid is feasible, try larger
            } else {
                high = mid - 1; // mid is not feasible, shrink
            }
        }

        return low;
    }
}

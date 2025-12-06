class Solution {
    final int MOD = 1000000007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        // dp[i] stores the number of ways to partition nums[0...i-1]
        int[] dp = new int[n + 1];
        // pre[i] stores the prefix sum of dp array up to index i
        int[] pre = new int[n + 1];

        // Base case: One way to partition an empty prefix
        pre[0] = 1;
        dp[0] = 1;

        // TreeMap to maintain the sorted elements in the current sliding window
        // Key: element value, Value: frequency
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int j = 0; // Left pointer of the sliding window

        for (int i = 0; i < n; i++) {
            // Add current element to the window
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // Shrink window from the left if the condition (max - min <= k) is violated
            while (j <= i && map.lastKey() - map.firstKey() > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }

            // Calculate dp[i+1] using prefix sums
            // We can transition from any state ending in the range [j-1, i-1] (relative to 0-index input)
            // which corresponds to dp indices [j, i].
            if (j > 0) {
                dp[i + 1] = (pre[i] - pre[j - 1] + MOD) % MOD;
            } else {
                dp[i + 1] = pre[i];
            }

            // Update prefix sum for the next iteration
            pre[i + 1] = (pre[i] + dp[i + 1]) % MOD;
        }

        return dp[n] % MOD;
    }
}
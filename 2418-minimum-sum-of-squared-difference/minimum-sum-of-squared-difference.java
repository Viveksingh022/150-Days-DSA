class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int maxdiff = 0;
        long totaldiff = 0;
        long[] freq = new long[100001];

        // Step 1: Calculate difference and frequency
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);

            freq[diff]++;
            totaldiff += diff;
            maxdiff = Math.max(maxdiff, diff);
        }

        // Step 2: Combine operations
        long k = (long) k1 + k2;

        // Step 3: Check if all differences can become zero
        if (totaldiff <= k) {
            return 0;
        }

        // Step 4: Greedy optimization
        for (int d = maxdiff; d > 0 && k > 0; d--) {
            long moves = Math.min(k, freq[d]);

            freq[d] -= moves;
            freq[d - 1] += moves;
            k -= moves;
        }

        // Step 5: Calculate minimum sum of squares
        long answer = 0;

        for (int d = 1; d <= maxdiff; d++) {
            answer += (long) d * d * freq[d];
        }

        return answer;
    }
}
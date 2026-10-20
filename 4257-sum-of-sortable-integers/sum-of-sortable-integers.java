class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int previousMax = -1;

            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;
                int min = nums[start];
                int max = nums[start];
                int descents = 0;

                for (int i = start; i <= end; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }

                for (int i = start; i < end; i++) {
                    if (nums[i] > nums[i + 1]) {
                        descents++;
                    }
                }

                if (nums[end] > nums[start]) {
                    descents++;
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                if (start > 0 && previousMax > min) {
                    valid = false;
                    break;
                }

                previousMax = max;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
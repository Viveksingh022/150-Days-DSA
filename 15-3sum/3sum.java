import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);                  // Step 1: Sort the array
        List<List<Integer>> ans = new ArrayList<>();

        // Step 2: Fix one element
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Two pointers
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {

                int sum = nums[i] + nums[start] + nums[end];

                // Triplet found
                if (sum == 0) {

                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // Skip duplicate values of start
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }

                    // Skip duplicate values of end
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }

                    // Move both pointers
                    start++;
                    end--;

                }
                // Sum is smaller than 0
                else if (sum < 0) {
                    start++;     // Increase sum
                }
                // Sum is greater than 0
                else {
                    end--;       // Decrease sum
                }
            }
        }

        return ans;
    }
}

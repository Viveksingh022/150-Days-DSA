
import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = nums.length - 1;

        // Find the first occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Add all occurrences
        while (start < nums.length && nums[start] == target) {
            result.add(start);
            start++;
        }

        return result;
    }
}

class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1; // Starts with all bits set to 1 as a neutral identity
        boolean isSorted = true;
        
        for (int i = 0; i < nums.length; i++) {
            // Check if the element is out of place
            if (nums[i] != i) {
                isSorted = false;
                if (ans == -1) {
                    ans = nums[i];
                } else {
                    ans &= nums[i];
                }
            }
        }
        
        // If the array is already sorted, return 0
        return isSorted ? 0 : ans;
    }
}
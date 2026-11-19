class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for(int i = 0; i  < nums.length; i++) {
            sum +=  nums[i];
        }
        int suffix = 0;
        int prefix = 0;

        for(int i = 0 ; i < nums.length; i++) {
              suffix = sum - prefix;
              prefix += nums[i];

            if(suffix == prefix) return i;
        }
        return -1;
    }
}
class Solution {

    private int check(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (nums[0] + i) % n) {
                return -1;
            }
        }

        int zeroIndex = 0;
        while (nums[zeroIndex] != 0) {
            zeroIndex++;
        }
        return zeroIndex;
    }

    public int minOperations(int[] nums) {

        int n = nums.length;
        int rotations = check(nums);

        if (rotations != -1) {
            return Math.min(rotations, n - rotations + 2);
        }

        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }

        int reverseRotations = check(reversed);
        if (reverseRotations == -1) {
            return -1;
        }
        
        return 1 + Math.min(reverseRotations, n - reverseRotations);
    }
}
class Solution {
    public boolean uniformArray(int[] nums) {
        boolean allOdd = true;
        boolean allEven = true;

        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 0) {
                allOdd = false;
                minEven = Math.min(minEven, num);
            } else {
                allEven = false;
                minOdd = Math.min(minOdd, num);
            }
        }

        return allOdd || allEven || minEven > minOdd;
    }
}
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[] squares = new long[n];

        //calcullate square for each num
       for(int i = 0; i < n; i++){
        squares[i] = (long) nums[i] * nums[i];
       }

       //sort the array

       Arrays.sort(squares);
       long score = 0;
       // subtract the smallest n / 2 square

       for(int i = 0; i < n /2; i++) {
        score -=squares[i];
       }
       // add remainig squares
       for(int i = n / 2; i < n; i++){
        score += squares[i];
       }
       return score;
    }
}
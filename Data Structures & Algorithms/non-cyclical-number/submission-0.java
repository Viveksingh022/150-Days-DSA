class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = square(slow);
            fast = square(square(fast));

        } while(slow != fast);

        return slow == 1;

    }

   public int square(int  nums){
        int ans = 0;

        while(nums > 0){
            int remainder = nums % 10;

            ans += remainder * remainder;
            nums /= 10;
        }

        return ans;
    }
}

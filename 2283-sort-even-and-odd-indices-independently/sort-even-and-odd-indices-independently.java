class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }

        Collections.sort(even);
        odd.sort(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) nums[i] = even.remove(0);
            else nums[i] = odd.remove(0);
        }

        return nums;
    }
}
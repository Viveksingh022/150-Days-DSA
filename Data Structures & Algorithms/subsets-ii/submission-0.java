class Solution {
    static void solve(int[] nums, int index, List<List<Integer>> ans, List<Integer> output) {
        //base case

        if (index >= nums.length) {
            //subsequence ready hai => output wali list main
            // is subsequence ko store karna h ans m
            ans.add(new ArrayList<>(output));
            return;
        }

        //include - exclude pattern
        //include
        int currval = nums[index];
        output.add(currval);

        solve(nums, index + 1, ans, output);

        //backtracking step
        output.remove(output.size() - 1);

        //while excluding, ignore the same element and move on the new element
        // ye exclude wala logic ek assumption par based hai
        //assumption ye hai array sorted hai
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        //exclude
        solve(nums, index + 1, ans, output);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int index = 0;
        solve(nums, index, ans, output);

        return ans;
    }
}

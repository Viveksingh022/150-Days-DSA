class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                if(ans.isEmpty() || ans.get(ans.size() - 1) != nums[i]) {
                    ans.add(nums[i]);
                }
            }
        }

        return ans;
    }
}
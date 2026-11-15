class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int start = 0;
        int end = arr.length - 1;

        List<Integer> ans = new ArrayList<>();

        // If all elements are required
        if (k == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }

        // Find first element >= x
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // Two pointers
        start = start - 1;
        end = start + 1;

        // Select k closest elements
        while (k > 0) {

            if (start < 0) {
                end++;

            } else if (end >= arr.length) {
                start--;

            } else if (Math.abs(arr[start] - x) <=
                       Math.abs(arr[end] - x)) {
                start--;

            } else {
                end++;
            }

            k--;
        }

        // Add elements in sorted order
        for (int i = start + 1; i < end; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
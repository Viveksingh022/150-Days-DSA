class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        if (n < 3) return false;

        int low = 0, high = n - 1;

        // Find peak
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int peak = low;

        // Peak cannot be first or last
        if (peak == 0 || peak == n - 1) return false;

        // Check increasing part
        for (int i = 0; i < peak; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }

        // Check decreasing part
        for (int i = peak; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}

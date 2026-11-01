class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int start = 0;
        int end = grid[0].length - 1;
        int count = 0;
        while(start < rows && end >= 0) {
            if(grid[start][end] >= 0) {
                start++;
            } else {
                count += rows - start;
                end--;
            }
        }
        return count;
    }
}
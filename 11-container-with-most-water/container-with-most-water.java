class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxarea = 0;

        while(start <= end) {
            int width = end - start;

            int area = width * Math.min(height[start] , height[end]);

            maxarea = Math.max(area , maxarea);
            
            if(height[start] < height[end]){
                start++;
            }
            else {
                end--;
            }
        }
        return maxarea;
    }
}
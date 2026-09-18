class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int[] nse = new int[n];
        int[] pse = new int[n];

        // Next Smaller Element
        st.push(n - 1);
        nse[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // Previous Smaller Element
        st.push(0);
        pse[0] = -1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max, area);
        }

        return max;
    }

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] mat = new int[rows][cols];

        for (int col = 0; col < cols; col++) {
            mat[0][col] = (matrix[0][col] == '1') ? 1 : 0;
        }

        int max = largestRectangleArea(mat[0]);

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1')
                    mat[row][col] = mat[row - 1][col] + 1;
                else
                    mat[row][col] = 0;
            }

            max = Math.max(max, largestRectangleArea(mat[row]));
        }

        return max;
    }
}

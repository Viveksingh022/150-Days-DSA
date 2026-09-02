class Solution {

    static boolean isSafeToPlace(char[][] board, int n, int rowIndex, int colIndex) {

        //check left horizontal 
        int row = rowIndex;
        int col = colIndex;

        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            // row index main koi change nahi karna hai 
            //col index ki value zero tak travel karge
            col--;
        }

        //left upper diagonal 
        row = rowIndex;
        col = colIndex;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row = row - 1;
            col = col - 1;
        }

        //check lower diagonal 
        row = rowIndex;
        col = colIndex;

        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row = row + 1;
            col = col - 1;
        }

        return true;
    }

    static void solve(char[][] board, int n, int colIndex, List<List<String>> ans) {

        //Base case 

        if (colIndex >= n) {
            //iska matlab -> board par mareko ek valid arrangment milgayi h
            //iss valid arrangment ko ans me store karlo 
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // 1 case main solve karoga baaki  recursion sambhal lega 
        //current column k har cell pr jaake ye fer current column k har row pr jaakar 
        //queen place karoga and rest recurion ko deduga solve karne ke liye 
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {

            if (isSafeToPlace(board, n, rowIndex, colIndex)) {

                //place Queen 
                board[rowIndex][colIndex] = 'Q';

                //baaki bacha hua recursion ko dedo 
                solve(board, n, colIndex + 1, ans);

                //undo backtracking wala step  important step hai ye wala 
                board[rowIndex][colIndex] = '.';
            }
        }
    }

   public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int colIndex = 0;
        List<List<String>> ans = new ArrayList<>();

        solve(board, n, colIndex, ans);

       return ans.size();
    }
}


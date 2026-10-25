class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visited[i][j] == false) {
                    if (bfs(i, j, grid, visited)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean bfs(int i, int j, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        boolean closed = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] front = q.remove();
            int r = front[0];
            int c = front[1];

            if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
                closed = false;
            }

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                    && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return closed;
    }
}
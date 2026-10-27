
import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) {
            return true;
        }

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        // Start BFS from source
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int front = q.remove();

            if (front == destination) {
                return true;
            }

            for (int element : adj.get(front)) {
                if (!visited[element]) {
                    visited[element] = true;
                    q.add(element);
                }
            }
        }

        return false;
    }
}

class Solution {

    boolean found = false;

    public List<String> removeInvalidParentheses(String s) {

        List<String> answer = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // Check whether current string is valid
                if (isValid(current)) {
                    answer.add(current);
                    found = true;
                }

                // If valid strings are found at this level,
                // don't generate the next level
                if (found) {
                    continue;
                }

                // Remove one parenthesis
                for (int j = 0; j < current.length(); j++) {

                    char ch = current.charAt(j);

                    // We only remove '(' or ')'
                    if (ch != '(' && ch != ')') {
                        continue;
                    }

                    String next = current.substring(0, j) + current.substring(j + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            // We found all answers at the minimum-removal level
            if (found) {
                break;
            }
        }

        return answer;
    }

    public boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;

            } else if (ch == ')') {
                count--;

                // More closing brackets than opening brackets
                if (count < 0) {
                    return false;
                }
            }
        }

        // All opening brackets must also be closed
        return count == 0;
    }
}

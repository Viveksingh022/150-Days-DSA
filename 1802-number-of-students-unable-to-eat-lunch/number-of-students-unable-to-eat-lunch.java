import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> qu = new LinkedList<>();

        int top = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == sandwiches[top]) {
                top++;
            } else {
                qu.offer(students[i]);
            }
        }

        int canteat = 0;

        // circular queue movement
        while (canteat < qu.size() && top < sandwiches.length) {
            if (qu.peek() == sandwiches[top]) {
                qu.poll();
                top++;
                canteat = 0;
            } else {
                qu.offer(qu.peek());
                qu.poll();
                canteat++;
            }
        }

        return qu.size();
    }
}

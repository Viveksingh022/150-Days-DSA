class Solution {
    public boolean checkValidString(String s) {
        int start = 0, end = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                start++;
                end++;
            } else if (c == ')') {
                start--;
                end--;
            } else {
                start--;
                end++;
            }

            if (end < 0)
                return false;

            start = Math.max(start, 0);
        }

        return start == 0;
    }
}

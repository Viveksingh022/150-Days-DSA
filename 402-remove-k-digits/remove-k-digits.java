class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k > 0 && (st.peek() - '0' > (num.charAt(i) - '0'))) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        // Agar abhi bhi k bacha hai to pop kar do
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Stack ko string mein convert karo
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Reverse karna zaroori hai kyunki stack se ulta niklega
        res.reverse();

        // Leading zeros hatao
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        if (res.length() == 0)
            return "0";
        return res.toString();

    }
}

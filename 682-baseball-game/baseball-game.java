class Solution {
    public int calPoints(String[] operations) {
        int result = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < operations.length; i++) {      
            String op = operations[i];

            if (op.equals("C")) {                            
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (op.equals("D")) {                      
                if (!st.isEmpty()) {
                    st.push(2 * st.peek());
                }
            } else if (op.equals("+")) {                      
                if (st.size() >= 2) {
                    int num1 = st.pop();
                    int num2 = st.pop();
                    int num3 = num1 + num2;                   
                    st.push(num2);
                    st.push(num1);
                    st.push(num3);
                }
            } else {
                st.push(Integer.parseInt(op));               
            }
        }

        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}
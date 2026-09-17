class Solution {
    public int evalRPN(String[] tokens) {
        String str = "*/+-";

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i< tokens.length; i++){
            String token = tokens[i];

            // "+" , "-" , "/", "*"

            if(str.contains(token)){
                //compute the result and push it back into the stack 
                //token---> "+" , "-" ,"/" ,"*"

                int secondElement = st.pop(); //stack ka second element
                int FirstElement = st.pop();  //stack ka first element 
                  
                  int val = 0;

                switch(token){
                  case "+" :
                  val = FirstElement + secondElement;
                  break;
                  case "-" :
                  val = FirstElement - secondElement;
                  break;
                  case "*":
                  val = FirstElement * secondElement;
                  break;
                  case "/" :
                  val = FirstElement / secondElement;
                  break;
                }

                st.push(val);

            }  else {
                st.push(Integer.parseInt(token));
            }
            
        }
        return st.peek();
    }
}
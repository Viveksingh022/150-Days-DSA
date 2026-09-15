class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Brute force approach 
        int[] days = new int[temperatures.length];
        int n = temperatures.length;

       Stack<Integer> st = new Stack<>();
          
          st.push(0);
         for(int i = 0; i < n; i++){
          while(!st.isEmpty()){
            int index = st.peek();
            int temptop = temperatures[index];

              if(temptop < temperatures[i]){
                days[index] = i - index;
                st.pop();
                
                 } else {
                    break;
                 }

               }
               st.push(i);

        }
    return days;
        }
    }
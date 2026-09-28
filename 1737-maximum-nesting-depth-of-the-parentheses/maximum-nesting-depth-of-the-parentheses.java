class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int sum = 0;

        for(char ch  :  s.toCharArray()){
            if(ch == '(') {
               sum++;
            }  else if(ch == ')'){
                  sum--;
               }
               if( max < sum){
                max = sum;
               }
        }
        return max;
    }
}
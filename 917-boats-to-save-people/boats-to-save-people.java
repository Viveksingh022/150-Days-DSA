class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans=0;
      int start=0;
      int end=people.length-1;
      while(start<=end){
        if((people[end] + people[start]) <= limit){
            start++;
            end--;
            ans++;
        }
        else
        {
            end--;
            ans++;
        }
      }
      return ans;
    }
}
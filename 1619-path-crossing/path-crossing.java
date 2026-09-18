class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;

        HashSet<String> set = new HashSet<>();
        set.add("0,0");

        for(char ch : path.toCharArray()){
            if(ch == 'N'){
                y++;
            }
            else if(ch == 'S'){
                y--;
            }
            else if(ch == 'E'){
                x++;
            }
            else{
                x--;
            }
            String pos = x + "," + y;

            if(set.contains(pos)){
                return true;
            }
            set.add(pos);
        }
        return false;
    }
}
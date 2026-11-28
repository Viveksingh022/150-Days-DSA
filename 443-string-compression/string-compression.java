class Solution {
    public int compress(char[] chars) {
        int start = 0;  // tracks where to write in the array
        int end = 0;    // scans through the array
        
        while (end < chars.length) {
            char currentChar = chars[end];
            int count = 0;
            
            // Move 'end' forward, counting consecutive same characters
            while (end < chars.length && chars[end] == currentChar) {
                count++;
                end++;
            }
            
            // Write the character at 'start' position
            chars[start++] = currentChar;
            
            // If count > 1, write each digit of the count
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char digit : countStr.toCharArray()) {
                    chars[start++] = digit;
                }
            }
        }
        
        return start;
    }
}
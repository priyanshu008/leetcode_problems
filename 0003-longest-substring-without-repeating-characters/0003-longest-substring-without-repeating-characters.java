class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();

        Map<Character, Integer> lastIndex = new HashMap<>();

        int start = 0;
        for(int end = 0; end < n;end++){
            char c = s.charAt(end);
            if (lastIndex.containsKey(c)){
                start = Math.max(start, lastIndex.get(c) + 1);
            }
            lastIndex.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
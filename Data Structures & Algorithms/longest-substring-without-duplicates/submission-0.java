class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>hm = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);
            if(hm.containsKey(ch)){
                left = Math.max(left, hm.get(ch)+1);
            }
            hm.put(ch,right);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}

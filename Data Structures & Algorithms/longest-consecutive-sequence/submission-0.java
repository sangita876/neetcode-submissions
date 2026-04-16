class Solution {
    public int longestConsecutive(int[] nums) { //{}
       int longest = 0;
       HashSet<Integer>hs = new HashSet<>();
       for(int num:nums){
        hs.add(num);
       }
       for(int x:hs){
        if(!hs.contains(x-1)){
            int cur = x;
            int count = 1;
        while(hs.contains(cur+1)){
                cur++;
                count++;
        }
        longest = Math.max(longest, count);
        }
       }
       return longest;
    }
}

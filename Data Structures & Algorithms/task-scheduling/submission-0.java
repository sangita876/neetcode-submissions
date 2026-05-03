class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]freq = new int[26];
        for(char t:tasks){
            freq[t-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        
        int countMax = 1;
        for(int i=24; i>=0; i--){
            if(freq[i]==maxFreq) countMax++;
            else break;
        }
        int formula = (maxFreq-1) * (n+1) + countMax;

        return Math.max(tasks.length, formula);
    }
}

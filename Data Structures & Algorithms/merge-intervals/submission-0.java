class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]- b[0]);
        List<int[]>res = new ArrayList<>();
        for(int[] cur :intervals){
            if(res.isEmpty()){
                res.add(cur);
            } else {
                int[]last = res.get(res.size()-1);
                if(cur[0] <= last[1]){
                    last[1] = Math.max(last[1], cur[1]);
                } else {
                    res.add(cur);
                }
            }
        }
       return res.toArray(new int[res.size()][]);
    }
}

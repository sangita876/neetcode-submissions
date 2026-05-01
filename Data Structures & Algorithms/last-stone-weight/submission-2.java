class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int first = pq.poll();
            int sec = pq.poll();
            if(first !=sec){
                pq.offer(first-sec);
            }
        }
        return pq.isEmpty() ? 0:pq.poll();
    }
}

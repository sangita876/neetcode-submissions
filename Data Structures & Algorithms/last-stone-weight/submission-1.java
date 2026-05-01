class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size()>1){
            int first = maxHeap.poll();
            int sec = maxHeap.poll();
            if(first !=sec){
                maxHeap.offer(first-sec);
            }
        }
        return maxHeap.isEmpty() ? 0:maxHeap.poll();
    }
}

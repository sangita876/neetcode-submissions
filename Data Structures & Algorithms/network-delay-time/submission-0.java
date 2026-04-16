class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>>graph = new HashMap<>();
        for(int[]time:times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u,new ArrayList<>());
            graph.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Map<Integer,Integer>dist = new HashMap<>();
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int time = cur[0];
            int node = cur[1];
            if(dist.containsKey(node)){
                continue;
            }
            dist.put(node,time);
            if(graph.containsKey(node)){
                for(int[]neighbor:graph.get(node)){
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    if(!dist.containsKey(nextNode)){
                        pq.offer(new int[]{time+weight, nextNode});
                    }
                }
            }
        }
        if(dist.size() !=n){
            return -1;
        }
        int maxTime = 0;
        for(int d:dist.values()){
            maxTime = Math.max(maxTime,d);
        }
        return maxTime;

    }
}

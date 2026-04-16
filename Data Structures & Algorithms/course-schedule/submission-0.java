class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
       int[]indegree = new int[numCourses];
       for(int[]p:prerequisites){
        int a = p[0];
        int b = p[1];
        graph.get(b).add(a);
        indegree[a]++;
       }
       Queue<Integer>q = new ArrayDeque<>();
       for(int i=0; i<numCourses; i++){
         if(indegree[i]==0){
            q.offer(i);
         }
       }
       int completed = 0;
       while(!q.isEmpty()){
        int cur = q.poll();
        completed++;
        for(int next:graph.get(cur)){
            indegree[next]--;
        if(indegree[next]==0){
            q.offer(next);
        }
        }
       }
       return completed==numCourses;
    }
}

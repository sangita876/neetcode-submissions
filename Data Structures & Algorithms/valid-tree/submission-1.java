class Solution {
    public boolean validTree(int n, int[][] edges) {
      if(edges.length !=n-1){
        return false;
      }
      UnionFind uf = new UnionFind(n);
      for(int[]edge:edges){
        int a = edge[0];
        int b = edge[1];
        if(!uf.union(a,b)){
            return false;
        }
      }
      return true;
    
    }

}
class UnionFind{
    int[]parent;
    int[]rank;
    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
    for(int i=0; i<n; i++){
        parent[i] = i;
    }
    }
    public int find(int x){
        if(parent[x] !=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        } else if(rank[rootA]<rank[rootB]){
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }
}

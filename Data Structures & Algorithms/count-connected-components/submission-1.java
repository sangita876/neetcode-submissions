class Solution {
    public int countComponents(int n, int[][] edges) {
      UnionFind uf = new UnionFind(n);
      for(int[]edge:edges){
         uf.union(edge[0],edge[1]);
      }
      return uf.count;
    }
}
public class UnionFind {
    int[]rank;
    int[]parent;
    int count;

    public UnionFind(int n){
        rank = new int[n];
        parent = new int[n];
        count = n;

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
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB){
            return;
        }
        if(rank[rootA]>rank[rootB]){
            parent[rootB] = rootA;
        } else if(rank[rootA]<rank[rootB]){
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        count--;
    }
}

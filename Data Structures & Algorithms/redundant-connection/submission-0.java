class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1);
        for(int[]edge:edges){
            int a = edge[0];
            int b = edge[1];
        if(!uf.union(a,b)){
            return edge;
        }
        }
        return new int[0];
    }
}
public class UnionFind {
    int[]rank;
    int[]parent;
public UnionFind(int size){
    rank = new int[size];
    parent = new int[size];
    for(int i=0; i<size; i++){
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
    if(rootA==rootB){
        return false;
    }
    if(rank[rootA] > rank[rootB]){
        parent[rootB] = rootA;
    } else if(rank[rootA] < rank[rootB]){
         parent[rootA] = rootB;
    } else {
        parent[rootB] = rootA;
        rank[rootA]++;
    }
    return true;
}
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]>q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
              if(grid[i][j]==2){
                q.offer(new int[]{i,j});
              } else if(grid[i][j]==1){
                fresh++;
              }
            }
        }
        if(fresh==0) return 0;
        int mins = 0;
        int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotThisMin = false;
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
            for(int[]dir:dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];
                if(nr >=0 && nr < m && nc >=0 && nc < n && grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                    rotThisMin = true;
                }
            }
            }
            if(rotThisMin){
                mins++;
            }
        }
       return fresh==0 ? mins:-1;
    }
}

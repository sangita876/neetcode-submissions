class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]>q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
        for(int[]dir:dirs){
            int nr = row+dir[0];
            int nc = col+dir[1];
            if(nr < 0 || nr >=m || nc < 0 || nc >=n){
                continue;
            }
            if(grid[nr][nc] !=2147483647){
                continue;
            }
            grid[nr][nc] = grid[row][col]+1;
            q.offer(new int[]{nr,nc});
        }
        }
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
   private void bfs(char[][]grid, int i, int j){
     Queue<int[]>q = new LinkedList<>();
     q.offer(new int[]{i,j});
     grid[i][j]='0';
     int[][]dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
     while(!q.isEmpty()){
        int[]cur = q.poll();
        for(int[]dir:dirs){
            int nr = cur[0]+dir[0];
            int nc = cur[1]+dir[1];
            if(nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length && 
            grid[nr][nc]=='1'){
                q.offer(new int[]{nr,nc});
                grid[nr][nc] = '0';
            }
        }
     }
   }
}

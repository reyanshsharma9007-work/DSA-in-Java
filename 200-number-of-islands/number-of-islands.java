class Pair {
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    private static void bfs(int row,int col,int[][] vis,char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(row,col));
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();
           int[] delrow = {-1, 0, 1, 0};
int[] delcol = {0, 1, 0, -1};

for(int i=0; i<4; i++){
    int nrow = r + delrow[i];
    int ncol = c + delcol[i];

    if(nrow >= 0 && nrow < n &&
       ncol >= 0 && ncol < m &&
       grid[nrow][ncol] == '1' &&
       vis[nrow][ncol] == 0){

        vis[nrow][ncol] = 1;
        q.add(new Pair(nrow,ncol));
    }
}
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return cnt;
    }
}
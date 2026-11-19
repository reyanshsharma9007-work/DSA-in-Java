class pair{
    int first;
    int second;
    int tm;
    public pair(int first,int second,int tm){
        this.first=first;
        this.second=second;
        this.tm=tm;
    }
}
    class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<pair>();
        int[][] vis=new int[n][m];
        int t=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
            }
        }
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int tm=q.peek().tm;
            q.remove();
            t=Math.max(t,tm);

            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.add(new pair(nrow,ncol,tm+1));
                    vis[nrow][ncol]=2;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1)return -1;
            }
        }
        return t;
    }
}
class Solution {
    private static void dfs(int[][] rep,int sr,int sc,int color,int init){
        int n=rep.length;
        int m=rep[0].length;
        if(rep[sr][sc]==color)return;
        else{
            rep[sr][sc]=color;
            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for(int i=0; i<4; i++){
               int nrow = sr + delrow[i];
               int ncol = sc + delcol[i];

               if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && rep[nrow][ncol]==init){
                dfs(rep,nrow,ncol,color,init);
               }
        }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row=image.length;
        int col=image[0].length;
        int[][] rep=image.clone(); 
        int init=image[sr][sc];
        dfs(rep,sr,sc,color,init);
        return rep;
    }
}
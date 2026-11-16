class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adjL=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjL.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjL.get(i).add(j);
                }
            }
        }
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,adjL,vis);
            }
        }
        return count;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
    }
}
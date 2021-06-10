class Solution
{
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        ArrayList<Integer> storeDFS = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(!vis[i])
                dfs(i, adj, vis, storeDFS);
        }
        
        return storeDFS;
    }
    
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> storeDFS){
        storeDFS.add(node);
        vis[node] = true;
        
        for(Integer i: adj.get(node)){
            if(!vis[i])
                dfs(i, adj, vis, storeDFS);
        }
    }
    
}

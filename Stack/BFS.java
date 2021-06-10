class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V+1];
        
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                bfsTraversal(vis, adj, bfs, i);
            }
        }
     
        return bfs;
    }
    
    private void bfsTraversal(boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> bfs, int sI){
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(sI);
        vis[sI] = true;
   
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            bfs.add(node);
    
            // traversing adjacent nodes
            for(Integer i: adj.get(node)) {
                if(!vis[i]){
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }
    }
    
}

class Node{
    int node;
    int parent;
    
    Node(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

class Solution
{
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfsHasCycle(i, -1, adj, vis))
                    return true;
            }
        }
        
        return false;
    }
    
    
    private boolean dfsHasCycle(int node, int par, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
         vis[node] = true;
         
         for(Integer i: adj.get(node)){
             if(!vis[i]){
                 // I am returning true becasuse once we find a cycle contains in the graph
                 // then we simply return true;
                 if(dfsHasCycle(i, node, adj, vis))
                    return true;
             }
             else if(i != par)
                return true;
         }
         
         return false;
    }
}

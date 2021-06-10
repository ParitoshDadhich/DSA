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
                if(bfsHasCycle(i, adj, vis))
                    return true;
            }
        }
        
        return false;
    }
    
    
    private boolean bfsHasCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(node, -1));
        vis[node] = true;
        
        while(!queue.isEmpty()){
            int child = queue.peek().node;
            int par = queue.peek().parent;
            queue.poll();
            
            for(Integer i: adj.get(child)){
                if(!vis[i]){
                    vis[i] = true;
                    queue.add(new Node(i, child));
                }
                
                else if(i != par)
                    return true;
            }
        }
        
        return false;
    }
    
}

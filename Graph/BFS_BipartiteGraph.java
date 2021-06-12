class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
        Arrays.fill(color, -1);
        
        for(int i=0; i<V; i++){
            if(color[i] == -1)
                if(!bfsCheckBipartite(i, color, adj))
                    return false;
        }
        
        return true;
    }
    
    private static boolean bfsCheckBipartite(int node, int color[], ArrayList<ArrayList<Integer>>adj){
        color[node] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            int front = queue.poll();
            
            for(Integer i: adj.get(front)){
                if(color[i] == -1){
                    // assigning opposite color to the adjacent nodes
                    color[i] = 1 - color[front];    
                    queue.add(i);
                }
                else if(color[i] == color[front])
                    return false;
            }
        }
        
        return true;
    }
    
}

class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[v];
        Arrays.fill(color, -1);
        
        for(int i=0; i<v; i++){
            if(color[i] == -1)
                if(!dfsCheck(color, i, adj))
                    return false;
        }
        
        return true;
    }
    
    private boolean dfsCheck(int color[], int node, ArrayList<ArrayList<Integer>>adj){
        if(color[node] == -1)
            color[node] = 1;
        
        for(Integer i: adj.get(node)){
            if(color[i] == -1){
                color[i] = 1 - color[node];
                
                if(!dfsCheck(color, i, adj))
                    return false;
            } else if(color[i] == color[node])
                return false;
        }
        
        return true;
    }
    
}

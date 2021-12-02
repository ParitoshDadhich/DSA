class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<>();
        int vis[] = new int[v];
        
        for(int i=0; i<v; i++)
            if(vis[i] == 0)
                findTopoSort(i, vis, st, adj);
        
        int topo[] = new int[v];
        int ind = 0;
        while(!st.isEmpty())
            topo[ind++] = st.pop();
            
        return topo;
    }
    
    private static void findTopoSort(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = 1;
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                vis[it] = 1;
                findTopoSort(it, vis, st, adj);
            }
        }
        
        st.push(node);
        
    }
    
}

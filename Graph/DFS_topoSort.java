class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<Integer>();
        int vis[] = new int[v];
        
        for(int i=0; i<v; i++)
            if(vis[i] == 0)
                findTopoSort(i, vis, adj, st);
        
        int topo[] = new int[v];
        int ind = 0;
        while(!st.isEmpty())
            topo[ind++] = st.pop();
        
        return topo;
    }
    
    private static void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(Integer i: adj.get(node))
            if(vis[i] == 0)
                findTopoSort(i, vis, adj, st);
        
        st.push(node);
    }
    
}

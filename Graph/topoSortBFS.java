class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        int topo[] = new int[v];
        int indegree[] = new int[v];
        
        // calculating indegree
        for(int i=0; i<v; i++)
            for(Integer it: adj.get(i))
                indegree[it]++;
                
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++)
            if(indegree[i] == 0)
                q.add(i);
        
        
        int ind = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[ind++] = node;
            
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        
        return topo;
    }
}

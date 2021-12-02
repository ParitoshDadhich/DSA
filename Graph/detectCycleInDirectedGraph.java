// this question can be solved using topological sorting algo



class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[v];
       // int topo[] = new int[v];
        
        // calculating indegrees
        for(int i=0; i<v; i++){
            for(Integer it: adj.get(i))
                indegree[it]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        // nodes with indegre 0;
        for(int i=0; i<v; i++)
            if(indegree[i] == 0)
                q.add(i);
        
        int count = 0;
        while(!q.isEmpty()){
            count++;
            Integer node = q.poll();
          //  topo[ind++] = node;
            
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
            
        }
        
        if(count == v) return false;
        
        return true;
    }
}

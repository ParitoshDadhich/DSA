class Pair{
    Node node;
    int hd;
    
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}


class Solution
{
    static ArrayList<Integer> topView(Node root)
    {
        if(root == null) 
            return new ArrayList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            Pair front = queue.poll();
            Node curr = front.node;
            int dis = front.hd;
            
            if(!map.containsKey(dis))
                map.put(dis, curr);
                
            if(curr.left != null)
                queue.add(new Pair(curr.left, dis-1));
            
            if(curr.right != null)
                queue.add(new Pair(curr.right, dis+1));
            
        }
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Node> entry : map.entrySet()){
            min = Math.min(min, entry.getKey());
            max = Math.max(max, entry.getKey());
        }
            
        for(int i=min; i<=max; i++)
            ans.add(map.get(i).data);
   
        return ans;
    }
}

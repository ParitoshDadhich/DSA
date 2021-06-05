class Solution
{
    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        Arrays.sort(arr, new Comparator<Item>(){
            public int compare(Item a, Item b){
                double val1 = (double)a.value/a.weight;
                double val2 = (double)b.value/b.weight;
                
                if(val2 > val1)
                    return 1;
                else if(val2 < val1)
                    return -1;
                else
                    return 0;
            }
        });
        
        
        // for(Item i: arr){
        //     System.out.println(i.value + " " + i.weight);
        // }
        
        
        double ans = 0;
        for(Item i: arr){
            int val = i.value;
            int wei = i.weight;
            
            if(w - wei >= 0){
                ans += val;
                w -= wei;
            } else{
                double fraction = ((double)w/(double)wei);
                ans = ans + val * fraction;
                break;
            }
        }
        
        
       return ans; 
    }
}

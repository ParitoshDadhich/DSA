
// Greedy approach

class Solution{

	public int minCoins(int coins[], int n, int amount) 
	{ 
	    Arrays.sort(coins);
	    
	    int res = 0;
	    for(int i=n-1; i>=0; i--){
	        if(coins[i] <= amount){
	            int c = amount/coins[i];
	            res = res + c;
	            amount = amount - (c*coins[i]);
	        }
	        
	        if(amount == 0)
	            break;
	    }
	    
	    return res;
	} 
}

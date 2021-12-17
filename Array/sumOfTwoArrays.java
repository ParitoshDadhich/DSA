
public class Solution {

    public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
    	int m = arr1.length-1;
        int n = arr2.length-1;
        int k = output.length-1;
        
        int carry = 0;
        while(m >=0 && n >=0){
            int sum = carry + arr1[m] + arr2[n];
            carry = sum/10;
            output[k] = sum%10;
            
            m--;
            n--;
            k--;
        }
        
        while(m >=0){
            int sum = carry + arr1[m];
            carry = sum/10;
            output[k] = sum%10;
            
            k--;
            m--;
        }
        
          while(n >=0){
            int sum = carry + arr2[n];
            carry = sum/10;
            output[k] = sum%10;
            
            k--;
            n--;
        }
        
        output[0] = carry;       
    }

}

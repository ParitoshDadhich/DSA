lass Sol
{
    public static int search(int a[], int n)
    {
        int start = 0;
        int end = n-1;
        
        if(end == 0) 
            return a[end];
        
        if(a[0] != a[1]) 
            return a[0];
        
        if(a[n-1] != a[n-2])
            return a[n-1];
            
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(a[mid] != a[mid+1] && a[mid] != a[mid-1])
                return a[mid];
            
            if((mid%2 == 0 && (a[mid] == a[mid+1])) ||  (mid%2 != 0 && (a[mid] == a[mid-1])))
                start = mid+1;
            else
                end = mid - 1;
        }
        return -1;
    }
}

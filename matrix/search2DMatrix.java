class Solution {
    public boolean searchMatrix(int[][] mat, int key) {
        int row = mat.length;
        int col = mat[0].length;
        
        int i=0, j=col-1;
        while(i<row && j>=0){
            if(key == mat[i][j])
                return true;
            else if( key > mat[i][j])
                i++;
            else  
                j--;
        }
        
        return false;
    }
}

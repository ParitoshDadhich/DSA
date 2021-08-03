class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> list = new ArrayList<Integer>();
        
        int top = 0, left = 0, bottom = m-1, right = n-1;
        while(top <= bottom && left <= right){
            for(int i=left; i<=right; i++)
                list.add(mat[top][i]);
            top++;
            
            for(int i=top; i<=bottom; i++)
                list.add(mat[i][right]);
            right--;
            
            if(top <= bottom){
                for(int i=right; i>=left; i--)
                    list.add(mat[bottom][i]);
                bottom--;
            }
            
            if(left <= right){
                for(int i=bottom; i>=top; i--)
                    list.add(mat[i][left]);
                left++;
            }
        }
        
        return list;
    }
}

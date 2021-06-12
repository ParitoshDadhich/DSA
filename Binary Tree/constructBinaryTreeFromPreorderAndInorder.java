class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return helper(inorder, 0, n-1, preorder, 0, n-1);
    }
    
    private static Node helper(int in[], int inSi, int inEi, int pr[], int prSi, int prEi){
        int n = in.length;
        
        // base case
        if(inSi > inEi) return null;
        if(prSi > prEi) return null;
        
        // find index of the root
        int index = -1;
        int rootData = pr[prSi];
        Node root = new Node(rootData);
        
        for(int i=inSi; i<=inEi; i++){
            if(rootData == in[i]){
                index = i;
                break;
            }
        }
        
        if(index == -1) return null;
        
        // doing required calculations;
        
        // left half
        int inSiLeft = inSi;
        int inEiLeft = index - 1;
        int inSiRight = index + 1;
        int inEiRight = inEi;
        
        // right half;
        int prSiLeft = prSi + 1;
        int prEiLeft = prSiLeft + (inEiLeft - inSiLeft);
        int prSiRight = prEiLeft + 1;
        int prEiRight = prEi;
        
        root.left = helper(in, inSiLeft, inEiLeft, pr, prSiLeft, prEiLeft);
        root.right = helper(in, inSiRight, inEiRight, pr, prSiRight, prEiRight);
        
        return root;
    }
    
}

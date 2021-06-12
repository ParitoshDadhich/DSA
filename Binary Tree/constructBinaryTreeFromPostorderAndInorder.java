
class GfG
{
    Node buildTree(int in[], int post[], int n) {
        return helper(in, 0, n-1, post, 0, n-1);
    }
    
    private static Node helper(int in[], int inSi, int inEi, int po[], int poSi, int poEi){
        if(inSi > inEi) return null;
        if(poSi > poEi) return null;
        
        int n = po.length;
        int rootData = po[poEi];
        Node root = new Node(rootData);
        
        // find index of root node
        int index = -1;
        for(int i=inSi; i<=inEi; i++){
            if(rootData == in[i]){
                index = i;
                break;
            }
        }
        
        if(index == -1) return null;
        
        // doing required calculations
        
        // left part
        int inSiLeft = inSi;
        int inEiLeft = index - 1;
        int inSiRight = index + 1;
        int inEiRight = inEi;
        
        // right part
        int poSiLeft = poSi;
        int poEiLeft = poSiLeft + (inEiLeft - inSiLeft);
        int poSiRight = poEiLeft+1;
        int poEiRight = poEi - 1;
        
        root.left = helper(in, inSiLeft, inEiLeft, po, poSiLeft, poEiLeft);
        root.right = helper(in, inSiRight, inEiRight, po, poSiRight, poEiRight);
        
        return root;
    }
    
}

import java.util.* ;
import java.io.*; 


import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        
        if(isLeaf(root) == false) 
            res.add(root.data);
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        
        return res;
	}
    
    private static boolean isLeaf(TreeNode root){
        if(root == null) return true;
        return root.left == null && root.right == null;
    }
    
    private static void addLeftBoundary(TreeNode root, ArrayList<Integer> res){
        TreeNode curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)) 
                res.add(curr.data);
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    
    private static void addRightBoundary(TreeNode root, ArrayList<Integer> res){
        Stack<Integer> st = new Stack<>();
        TreeNode curr = root.right;
        while(curr != null){
            if(!isLeaf(curr))
                st.push(curr.data);
            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        
        while(!st.isEmpty())
            res.add(st.pop());
    }
    
    private static void addLeaves(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }
    
}

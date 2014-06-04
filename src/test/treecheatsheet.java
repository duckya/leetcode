package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class treecheatsheet {
	  public class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new  LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while(!stack.isEmpty() || cur!=null)
        {
            if(cur!=null) 
            {
               stack.push(cur);
               cur = cur.left;
            }
            else{
                cur =  stack.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;
   }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null)stack.push(cur.right);
            if(cur.left!=null)stack.push(cur.left);
        }
        
        return res;
    }
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> path = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root ==null) return res;
        path.add(root);
        
        while(!path.isEmpty())
        {
        	cur = path.pop();
       		res.add(0, cur.val);
           	if(cur.left !=null) path.add(cur.left);
           	if(cur.right !=null) path.add(cur.right);
        }
        
    	return res;
    }
}

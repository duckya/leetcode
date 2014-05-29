import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Tree {

	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	 
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; next = null; }
	 }
	 
	 public class TreeLinkNode {
	        TreeLinkNode left;
	        TreeLinkNode right;
	        TreeLinkNode next;
	      }
	public static void main (String args[]) {
		char C[][] = {{'1','1'}};
		Tree testA =new Tree();
		TreeNode A = testA.new TreeNode(1);
		A.left = testA.new TreeNode(0);
			//A.next = testA.new ListNode(2);
			//A.next.next = testA.new ListNode(3);
			//A.next.next.next = testA.new ListNode(4);
		int[] b={4,2,0,3,2,5};
		testA.maximalRectangle(C);
		System.out.print("end");
	}
	
    public ArrayList<Integer> preorderTraversalRecur(TreeNode root) {
        TreeNode cur = root;
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        GetNode(root, res);
    	return res;
    }
    
    private void GetNode(TreeNode root, ArrayList<Integer> res)
    {
    	if(root == null) return;
    	res.add(root.val);
    	GetNode(root.left, res);
    	GetNode(root.right, res);
    }
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> path = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root ==null) return res;
        path.add(root);
        
        while(!path.isEmpty())
        {
        	cur = path.pop();
       		res.add(cur.val);
           	if(cur.right !=null) path.add(cur.right);
           	if(cur.left !=null) path.add(cur.left);
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
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> path = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root ==null) return res;
        path.add(root);
        
        while(!path.isEmpty())
        {
        	cur = path.pop();
        	TreeNode left = cur.left;
        	TreeNode right = cur.right;
           	
           	if(left == null && right == null)
           	{
           		res.add(cur.val);
           	}else
           	{
            	cur.left =null;
            	cur.right =null;
               	if(right !=null) path.add(right);
               	path.add(cur);
               	if(left !=null) path.add(left);
           	}
        }
        
    	return res;
    }
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(root == null) return res;
    	
    	GetNode(root, 0, res);
    	
    	return res;
    }
    
    private void GetNode(TreeNode node, int level, ArrayList<ArrayList<Integer>> res)
    {
    	if(res.size() == level)
    	{
    		res.add(new ArrayList<Integer>());
    	}
    	res.get(level).add(node.val);
    	if(node.left !=null) GetNode(node.left,level+1, res);
    	if(node.right !=null) GetNode(node.right,level+1, res);
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(root == null) return res;
    	
    	GetNode2(root, 0, res);
    	
    	return res; 
    }
    private void GetNode2(TreeNode node, int level, ArrayList<ArrayList<Integer>> res)
    {
    	if(res.size() == level)
    	{
    		res.add(new ArrayList<Integer>());
    	}
    	if(level%2 ==0)
    		res.get(level).add(node.val);
    	else
    		res.get(level).add(0, node.val);
    	if(node.left !=null) GetNode2(node.left,level+1, res);
    	if(node.right !=null) GetNode2(node.right,level+1, res);
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(root == null) return res;
    	
    	GetNode3(root, 0, res);
    	
    	return res;
    }
    
    private void GetNode3(TreeNode node, int level, ArrayList<ArrayList<Integer>> res)
    {
    	if(res.size() == level)
    	{
    		res.add(0, new ArrayList<Integer>());
    	}
    	res.get(res.size()-level-1).add(node.val);
    	if(node.left !=null) GetNode3(node.left,level+1, res);
    	if(node.right !=null) GetNode3(node.right,level+1, res);
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p!=null && q!=null && q.val==p.val) 
        {
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else
        	return false;
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true; 
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left== null && right == null) return true; 
        if(left == null && right != null) return false; 
        if(left != null && right == null) return false;
        if(left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    
    public boolean isBalanced(TreeNode root) {
    	if(root == null) return true; 
        return isBalanced(root.left) && isBalanced(root.right) && isSameHeight(root.left, root.right);
    }
    private boolean isSameHeight(TreeNode left, TreeNode right) {
    	return Math.abs(getHeight(left) - getHeight(right))<=1;
    }
    private int getHeight(TreeNode root)
    {
    	if(root==null) return 0; 
    	if(root.left == null && root.right ==null) return 1; 
    	if(root.left == null && root.right !=null) return getHeight(root.right) + 1;
    	if(root.left != null && root.right ==null) return getHeight(root.left) + 1;
    	return Math.max(getHeight(root.right), getHeight(root.left)) +1;
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	st.add(root); 
    	TreeNode dummy = new TreeNode(-1);
    	TreeNode curr=dummy; 
    	while(!st.isEmpty())
    	{
    		TreeNode t = st.pop();
    		curr.right = t;
    		curr.left = null;
    		curr = t;
    		if(t.right != null) st.add(t.right);
    		if(t.left != null) st.add(t.left);
    	}
    }
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0; 
        if(root.left == null && root.right == null) return 1; 
        if(root.left == null && root.right != null) return minDepth(root.right) +1; 
        if(root.left != null && root.right == null) return minDepth(root.left) +1; 
        return Math.min(minDepth(root.right), minDepth(root.left)) +1;
    }
    
    public int maxDepth(TreeNode root) {
    	if(root==null) return 0; 
    	if(root.left == null && root.right ==null) return 1; 
    	if(root.left == null && root.right !=null) return maxDepth(root.right) + 1;
    	if(root.left != null && root.right ==null) return maxDepth(root.left) + 1;
    	return Math.max(maxDepth(root.right), maxDepth(root.left)) +1;
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null; 
        TreeNode mid =  new TreeNode(preorder[0]);
        
        if(preorder.length == 1) return mid;
        
        int midIndex = -1;
        for(int i=0; i< inorder.length; i++)
        {
        	if(inorder[i] == mid.val)
        	{
        		midIndex = i; 
        		break;
        	}
        }
        
        int[] leftInorder = {}, leftPreorder= {}; 
        if(midIndex>0) 
        {
        	leftInorder = Arrays.copyOfRange(inorder, 0, midIndex);
        	leftPreorder = Arrays.copyOfRange(preorder, 1, midIndex+1);
        }
        int[] rightInorder= {}, rightPreorder= {};
        if(midIndex<inorder.length-1) 
        {
        	rightInorder = Arrays.copyOfRange(inorder, midIndex+1, inorder.length);
        	rightPreorder = Arrays.copyOfRange(preorder, midIndex+1 , preorder.length);
        }

        mid.left = buildTree1(leftPreorder, leftInorder);
        mid.right = buildTree1(rightPreorder, rightInorder);
        
        return mid; 
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	 if(postorder.length == 0 || inorder.length == 0) return null; 
         TreeNode mid =  new TreeNode(postorder[postorder.length-1]);
         
         if(postorder.length == 1) return mid;
         
         int midIndex = -1;
         for(int i=0; i< inorder.length; i++)
         {
         	if(inorder[i] == mid.val)
         	{
         		midIndex = i; 
         		break;
         	}
         }
         
         int[] leftInorder = {}, leftpostorder= {}; 
         if(midIndex>0) 
         {
         	leftInorder = Arrays.copyOfRange(inorder, 0, midIndex);
         	leftpostorder = Arrays.copyOfRange(postorder, 0, midIndex);
         }
         int[] rightInorder= {}, rightpostorder= {};
         if(midIndex<inorder.length-1) 
         {
         	rightInorder = Arrays.copyOfRange(inorder, midIndex+1, inorder.length-1);
         	rightpostorder = Arrays.copyOfRange(postorder, midIndex , postorder.length-2);
         }
         

         
         mid.left = buildTree(leftInorder, leftpostorder);
         mid.right = buildTree(rightInorder, rightpostorder);
         
         return mid; 
    }
   
    public int numTrees(int n) {
        if(n<=1) return 1;
        int res = 0; 
        for(int i=1; i<=n; i++)
        {
        	res+=numTrees(i-1) * numTrees(n-i);
        }
        return res; 
       
    }
    
    public boolean isValidBST(TreeNode root) {
    	
    	return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    }
    
    private boolean isValid(TreeNode root, int min, int max)
    {
        if(root == null) return true; 
		return root.val<max && min<root.val && isValid(root.left, min, root.val) && isValid(root.right, root.val, max); 
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
    	if(num.length == 0) return null; 
    	if(num.length == 1) return new TreeNode(num[0]);
    		
        int midIndex = num.length/2;
        int[] left = Arrays.copyOfRange(num, 0, midIndex);
        int[] right = Arrays.copyOfRange(num, midIndex+1, num.length);
        
        TreeNode root = new TreeNode(num[midIndex]); 
        root.left = sortedArrayToBST(left); 
        root.right = sortedArrayToBST(right); 
        
        return root; 
    }
    
    public TreeNode sortedListToBST(ListNode head) {
    	ListNode p = head;
    	List<Integer> li = new ArrayList<Integer>();
    	while(p!=null)
    	{
    		li.add(p.val);
    		p=p.next;
    	}
    	
    	return sortedListToBST(li);
    }
    
    private TreeNode sortedListToBST(List<Integer> num) {
    	if(num.size() == 0) return null; 
    	if(num.size() == 1) return new TreeNode(num.get(0));
    		
        int midIndex = num.size()/2;
        List<Integer> left = num.subList(0, midIndex);
        List<Integer> right =num.subList(midIndex+1, num.size());
        
        TreeNode root = new TreeNode(num.get(midIndex)); 
        root.left = sortedListToBST(left); 
        root.right = sortedListToBST(right); 
        
        return root; 
    }
    
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> a = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode lastNode=null, first=null, second=null;
        
        while(!a.isEmpty() || p!=null)
        {
        	if(p==null)
        	{
        		p=a.pop();
        		if(lastNode!=null && p.val < lastNode.val)
        		{
        			if(first== null) 
        			{
        				first = lastNode;
        				second = p;
        			}
        			else
        				second = p;
        		}
        		lastNode = p;
        		p=p.right;
        	}else
        	{
        		a.add(p);
        		p=p.left;
        	}
        }
        
        int t = first.val;
        first.val = second.val; 
        second.val = t;
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	boolean bleft = false, bright=false;
    	
    	if(root.left==null && root.right==null) 
    	{
    		if(sum==root.val) 
    			return true;
    		else
    			return false;
    	}
    	
    	if(root.left != null) bleft =hasPathSum(root.left, sum-root.val);
    	if(root.right != null) bright =hasPathSum(root.right, sum-root.val);
        return  bleft||bright;
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	if(root == null) return res;
    	ArrayList<ArrayList<Integer>> listleft, listright;
    	
    	if(root.left==null && root.right==null) 
    	{
    		if(sum==root.val) 
    		{
    			ArrayList<Integer> t = new ArrayList<Integer>();
    			t.add(root.val);
    			res.add(t);
    			return res;
    		}

    	}
    	
    	if(root.left != null)
    	{
    		listleft =pathSum(root.left, sum-root.val);
    		for(ArrayList<Integer> t:listleft)
    		{
    			t.add(0, root.val);
    			res.add(t);
    		}
    		
    	}
    	if(root.right != null) 
    	{
    		listright =pathSum(root.right, sum-root.val);
    		for(ArrayList<Integer> t:listright)
    		{
    			t.add(0, root.val);
    			res.add(t);
    		}
    	}
    	return res;

    }
    
    public int maxPathSum(TreeNode root) {
    	
    	int[] res = {Integer.MIN_VALUE};
    	maxSum(root, res);
    	return res[0];
    }
    
    private int maxSum(TreeNode root, int[] res)
    {
    	
        if(root==null) return 0; 
        int maxleft = maxSum(root.left, res);
        int maxright = maxSum(root.right, res);
        res[0] = Math.max(res[0],  Math.max(Math.max(Math.max(maxleft+maxright, 0), maxleft),maxright)  + root.val);
        return Math.max(0, Math.max(maxleft, maxright)) + root.val;
    }

    public int sumNumbers(TreeNode root) {
    	if(root == null) return 0;
    	ArrayList<String> res = GetNumbers(root);
    	
    	int sum = 0;
    	for(String e:res)
    	{
    		sum += Integer.parseInt(e);
    	}
    	return sum;

        
    }
    private ArrayList<String> GetNumbers(TreeNode root)
    {
        ArrayList<String> resString = new ArrayList<String>();
        if(root.left==null && root.right == null) 
        {
        	resString.add(String.valueOf(root.val));
        }else
        {
        	if(root.left!=null) 
        		resString.addAll(GetNumbers(root.left));
        	if(root.right!=null) 
        		resString.addAll(GetNumbers(root.right));
        	for(int i=0; i<resString.size(); i++)
        	{
        		resString.set(i, String.valueOf(root.val) + resString.get(i));
        	}
        }
        return resString;
    }

    public void connectBalanced(TreeLinkNode root) {
        if(root==null) return; 
        if(root.left!=null) root.left.next = root.right;
        if(root.right!=null) 
        {
        	if(root.next != null) 
        		root.right.next = root.next.left;
        	else
        		root.right.next = null;
        }
        
        connectBalanced(root.left);
        connectBalanced(root.right);
    }
    
    public void connect(TreeLinkNode root) {
    	if(root==null) return; 
    	TreeLinkNode cur = root; 
    	TreeLinkNode prev = null;
    	TreeLinkNode leftMost = null; 
    	while(cur!=null)
    	{
    		if(cur.left!=null) 
    		{
    			if(prev != null)prev.next = cur.left;
    			prev = cur.left;
    			if(leftMost == null)leftMost = cur.left;
    		}
    				
    		if(cur.right!=null)
    		{
    			if(prev != null)prev.next = cur.right;
    			prev = cur.right;
    			if(leftMost == null)leftMost = cur.right;
    		}
    				
    		cur = cur.next;
    	}
    	
    	connect(leftMost);
    }
    
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(n==0){
            res.add(null);
        }else
    	    res = makenode(1, n);
    	return res;
    }
    
    private ArrayList<TreeNode> makenode(int start, int end)
    {
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    	if(start>end) {
    		res.add(null);
    		return res;
    	}
    	
    	for(int i=start; i<=end; i++)
    	{
    		ArrayList<TreeNode> left = makenode(start, i-1);
    		ArrayList<TreeNode> right = makenode(i+1, end);
    		
    		for(TreeNode l:left)
    		{
    			for(TreeNode r:right)
    			{
    				TreeNode node = new TreeNode(i);
    				node.left = l; 
    				node.right = r;
    				res.add(node);
    			}
    		}

    	}
    	
    	return res;
    }
    
    public int largestRectangleAreaTLE(int[] height) {
    	int max = 0;
    	for(int i=0; i<height.length; i++)
    	{
    		int min = height[i];
    		for(int j=i; j>=0; j--)
    		{
    			min = Math.min(height[j], min);
    			max = Math.max(max, (i-j+1)*min);
    		}
    	}
    	
    	return max;
        
    }
    
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0 || matrix[0].length==0) return 0;
    	int[] height = new int[matrix[0].length];
    	int max = 0;
    	for(int i=0; i<matrix.length; i++)
    	{
    		for(int j=0; j<matrix[i].length; j++)
    		{
    			if(matrix[i][j]=='0')
    				height[j]=0;
    			else
    			{
    				height[j]= height[j]+1;
    			}
    					
    		}
    		max = Math.max(max, largestRectangleAreaTLE(height));
    		
    	}
    	return max;
        
    }
    
    
    public int largestRectangleArea(int[] height) {
        int max = 0;
        if(height.length ==0) return 0;
        
        int[] nh = Arrays.copyOf(height, height.length+1);
        nh[height.length] = 0;
         	    	
    	Stack<Integer> large = new Stack<Integer>();

    	for(int i=0; i<nh.length; i++)
    	{
    		if(large.isEmpty() ||nh[i]>=nh[large.peek()])
    		{
    			large.add(i);
    		}else
    		{
    			while(!large.isEmpty() && (nh[large.peek()]>nh[i] || large.peek() ==0))
    			{
    				int j=large.pop();
    				max = Math.max(max, (large.isEmpty()?i:(i-j))*nh[j]);
    				
    			}
    			large.add(i);
    		}
    	}
    	return max;
    }
    
    public TreeNode getTree(int[] numbers)
    {
    	return getTreeNode(numbers, 0, numbers.length-1);
    }

    private TreeNode getTreeNode(int[] numbers, int start, int end)
    {
    	if(end<start) return null;
    	int mid = (start+end)/2;
    	int val = numbers[mid];
    	TreeNode root = new TreeNode(val);
    	root.left = getTreeNode(numbers, start, mid-1);
    	root.right = getTreeNode(numbers, mid+1, end);
    	return root;

    }
    
    public ArrayList<LinkedList<TreeNode>> getlistFromTree(TreeNode root)
    {
    	ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
    	
    	if(root==null) return res;
    	LinkedList<TreeNode> l = new LinkedList<TreeNode>();
    	l.add(root);
    	res.add(l);
    	int level = 1;
    	
    	while(true)
    	{
    		LinkedList<TreeNode> pl = res.get(level);
    		LinkedList<TreeNode> nl = res.get(level);
    		for(TreeNode node:pl)
    		{
    			if(node.left!=null) nl.add(node.left);
    			if(node.right!=null) nl.add(node.right);
    		}
    		if(nl.size()>0)
    			res.add(nl);
    		else
    			return res;
    		
    		level++;

    	}
    	
    	
    }
    
    public TreeNode getancestor(TreeNode root, TreeNode p, TreeNode q)
    {
    	if(cover(root.left, p) && cover(root.left, q))
    		return getancestor(root.left, p, q);

    	if(cover(root.right, p) && cover(root.right, q))
    		return getancestor(root.right, p, q);

    	return root;

    }

    private boolean cover(TreeNode root, TreeNode p)
    {
    	Stack<Integer> s = new Stack<Integer>();

    	if(root == null) return false;
    	if(root == p) return true;

    	return cover(root.left,p)||cover(root.right,p);
    }
    
    public boolean isSubTree(TreeNode p, TreeNode q)
    {
    	if(q==null) return true;	
    	if(p==null) return false;
    	
    	if(p.val==q.val)
    		if(isMatch(p, q)) return true;
    	return isSubTree(p.left, q) || isSubTree(p.right, q);

    }

    private boolean isMatch(TreeNode p, TreeNode q)
    {
    	if(p == null && q == null ) return true;
    	if(p == null || q == null ) return false;

    	if(p.val == q.val) return isMatch(p.left, q.left) && isMatch(p.right, q.right);
    	return false;
    }
    
    
    private void getPath(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res)
    {
        if(root.left==null && root.right ==null&& root.val == sum)
        {
            path.add(root.val);
            ArrayList<Integer> newpath=new ArrayList<Integer>();
            newpath.addAll(path);
            res.add(newpath);
            path.remove(root.val);
            return;
        }
        
        path.add(root.val);
        if(root.left!=null)
        {
            getPath(root.left, sum-root.val, path, res);
        }   
        if(root.right!=null)
        {
            getPath(root.right, sum-root.val, path, res);
        } 
        path.remove(root.val);
        return;
        
    }
    
    
}

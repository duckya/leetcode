package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import test.linklist.ListNode;

import java.util.Hashtable;




public class linklist {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	       next = null;
	    }
	}
	
	class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	};
	
	public static void main (String args[]) {
		linklist testA =new linklist();
		ListNode A = testA.new ListNode(2);
		A.next = testA.new ListNode(1);
		//A.next.next = testA.new ListNode(3);
		//A.next.next.next = testA.new ListNode(4);

		testA.insertionSortList(A);
		System.out.print("end");
	}
    
	void maxSlidingWindow(int A[], int n, int w, int B[]) {
		  LinkedList<Integer> Q = new LinkedList<Integer>();
		  for (int i = 0; i < w; i++) {
		    while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
		      Q.removeLast();
		    Q.addLast(i);
		  }
		  for (int i = w; i < n; i++) {
		    B[i-w] = A[Q.getFirst()];
		    while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
		      Q.removeLast();
		    while (!Q.isEmpty() && Q.getFirst() <= i-w)
		      Q.removeFirst();
		    Q.addLast(i);
		  }
		  B[n-w] = A[Q.getFirst()];
		}
	
    private ListNode insertAfterFirst(ListNode newnode, ListNode head) {
    	if(head == null) return head;
    	
    	if(head.next ==null)
    	{
    		head.next = newnode;
    	}else
    	{
    		ListNode next = head.next;
    		head.next = newnode;
    		newnode.next = next;
    	}
        return head;
    }
	
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        int currentValue = head.val;
        
        while(cur != null && cur.next != null)
        {
            if(currentValue == cur.next.val)
            {
                cur.next = cur.next.next;
            }else
            {
                currentValue = cur.next.val;
                cur = cur.next;
            }
        }
        return head;
        
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
        if(l2 == null) return l1; 
        ListNode res = null;
        ListNode head = null;


    	while(l1 != null && l2 !=null)
    	{
    		if(l1.val<l2.val)
    		{
    			if(res == null)
    			{
    				res = l1;
    				head = l1;
    			}
    			else
    				res.next =l1;
    			l1=l1.next;
    		}else
    		{
    			if(res == null)
    			{
    				res = l2;
    				head = l2;
    			}
    			else
    				res.next =l2;
    			l2=l2.next;
    		}
    	}
    	
    	if(l1 == null) res.next= l2;
    	if(l2 == null) res.next= l1;
    	
    	return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 ==null || l2 ==null) return null;
    	
    	ListNode c1 = l1;
    	ListNode c2 = l2;
    	ListNode res = new ListNode(-1);
    	ListNode cur = res;
    	int carryover = 0;
    	while(c1 !=null || c2 !=null)
    	{
    		int val = ((c1==null?0:c1.val) + (c2==null?0:c2.val) + carryover)%10; 
    		carryover = ((c1==null?0:c1.val) + (c2==null?0:c2.val) + carryover)/10;
    		ListNode x = new ListNode(val);
   		
    		cur.next = x; 
    		cur =cur.next;
    		if(c1!=null)
    			c1 = c1.next; 
    		if(c2!=null)
    			c2 = c2.next; 
    	}
    	
    	if(carryover > 0)
    	{
    		ListNode x = new ListNode(carryover);
    		cur.next = x; 
    	}
    	return res.next;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(m==n) return head;
    	
    	ListNode start = null; 
    	ListNode beforestart = null; 
    	ListNode curr = null; 
    	
    	for(int i=0; i<m-1; i++)
    	{
    		beforestart = beforestart==null?head:beforestart.next; 
    	}
    	
   		start = beforestart==null?head:beforestart.next;
   		ListNode end = start;
    	
   		curr = start.next; 
    	ListNode oldNext = curr.next;
    	for(int i=0; i<n-m; i++)
    	{	    		
    		oldNext = curr.next; 
    		curr.next = start; 
    		start = curr; 
    		curr = oldNext; 
    	}
    	end.next = oldNext;
    	
    	if(beforestart!= null)
    		beforestart.next = start;
  	    	
    	return (beforestart== null?start:head); 
    }
    
    public ListNode partition(ListNode head, int x) {
    	ListNode dummyleft = new ListNode(-1); 
    	ListNode dummyright = new ListNode(-1); 
    	ListNode left = dummyleft; 
    	ListNode right = dummyright; 

    	
    	ListNode curr = head; 
    	while(curr != null)
    	{
    		if(curr.val < x)
    		{
    			left.next =curr; 
    			left = left.next;
    		}else
    		{
    			right.next = curr;
    			right = right.next; 
    		}
    		curr = curr.next;
    	}
    	
    	left.next = dummyright.next;
    	right.next = null; 
    	return dummyleft.next; 
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head; 
        
        ListNode cur = head;
        ListNode prev = dummy;
        
        int currentValue = head.val;
        boolean isDup = false; 
        while(cur.next != null)
        {
            if(currentValue != cur.next.val)
            {
            	if(isDup)
            		prev.next = cur.next;
            	else
            		prev=cur;
            	//prev
                currentValue = cur.next.val;    
                
                isDup = false; 
            }else
            {
            	isDup = true; 
            }
            cur = cur.next;
            
        }
        
        if(isDup)
        	prev.next = null; 
        
        return dummy.next;
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        
    	if(head==null || n ==0 ) return head; 
    	int length = 1; 
    	ListNode cur = head;
    	ListNode start = null; 
    	
    	while(cur.next!=null)
    	{
    		length++;
    		cur = cur.next;
    	}
    	cur.next = head;
    	n = n%length;
    	cur = head; 
    	
    	for(int i=1; i<length-n; i++)
    	{
    		cur = cur.next;
    	}
    	start = cur.next;
    	cur.next = null;
    			
    	return start;
    	
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head; 
        ArrayList<ListNode> temp = new ArrayList<ListNode>();
        ListNode cur = dummy;
        
        while(cur!=null)
    	{
        	temp.add(cur);
    		cur = cur.next;
    	}
        temp.add(null);
        int k = temp.size() - n-1;
        
        temp.get(k-1).next = temp.get(k+1);
        return dummy.next;
    }
    
    public ListNode swapPairs(ListNode head) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head; 
    	ListNode cur = dummy;
    	ListNode temp = null;
    	
    	while(cur.next!=null && cur.next.next!=null)
    	{
    		temp =cur.next; 
    		cur.next = cur.next.next;
    		temp.next = cur.next.next;
    		cur.next.next = temp;
    		
    		cur=cur.next.next;
    	}
    	
    	return dummy.next;
    	
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(k<2) return head;
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head; 
    	ListNode prev = dummy;
    	ListNode cur = head;
    	ListNode curInner = head;

    	boolean startreverse = true;
    	while(cur!=null)
    	{
    		curInner = cur;
    		for(int i=1; i<=k; i++)
    		{
    			if(curInner != null)
    				curInner = curInner.next;
    			else
    			{
    				startreverse=false;
    				break;
    			}
    		}
    		
    		curInner = cur;
    		if(startreverse)
    		{
    			ListNode temp = null;
    			ListNode start = cur;
    			
        		for(int i=1; i<k; i++)
        		{
        			temp = curInner.next.next;
        			curInner.next.next = start;
        			start = curInner.next;
        			curInner.next = temp;
    
        		}
    			
        		prev.next = start;
        		prev = curInner;
    			
    		}
    	
    		//index++;
    		cur=curInner.next;
    	}
    	
    	return dummy.next;
    }
   
    public boolean hasCycle(ListNode head) {
    	
    	if(head == null || head.next ==null) return false;
    	
    	HashSet<ListNode> lists = new HashSet<ListNode>();
    	ListNode curr = head;
    	while(curr != null)
    	{
    		if(lists.contains(curr.next)) return true;
    		lists.add(curr.next);
    		curr=curr.next;
    	}
    	
    	return false;
    }
    
    public ListNode detectCycle(ListNode head) {
    	if(head == null || head.next ==null) return null;
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	HashSet<ListNode> lists = new HashSet<ListNode>();
    	ListNode curr = dummy;
    	while(curr != null)
    	{
    		if(lists.contains(curr.next)) return curr.next;
    		lists.add(curr.next);
    		curr=curr.next;
    	}
    	
    	return null;
    }
    
    public void reorderList(ListNode head) {
    	if(head == null || head.next ==null) return;
    	
    	ListNode curr1 = head;
    	int count = 0;
    	while(curr1 != null)
    	{
    		curr1=curr1.next;
    		count ++;
    	}
    	
    	//split after count/2
    	ListNode second = null;
    	curr1 = head;
    	int i = 1;
    	while(i < (count+1)/2)
    	{
    		curr1=curr1.next;
    		i++;
    	}
    	
    	second = curr1.next;
    	curr1.next = null;
    	
    	//revert the second
    	ListNode dummy2 = new ListNode(-1);
    	dummy2.next = second;
    	ListNode curr2 = second.next;
    	while(curr2 != null)
    	{
    		ListNode x = curr2.next;
    		second.next = curr2.next;
    		curr2.next = dummy2.next;
    		dummy2.next = curr2;
    		curr2 = x;
    	}
    	
    	//merge
    	ListNode dummy = new ListNode(-1);
    	ListNode curr = dummy;
    	curr1 = head;
    	curr2 = dummy2.next;
    	while(curr1 != null && curr2 != null)
    	{
    		ListNode x =curr1.next;
    		ListNode y =curr2.next;
    		curr.next = curr1; 
    		curr1.next = curr2;
    		curr = curr2;
    		curr1 = x;
    		curr2 = y;
    	}
    	
    	if(curr1 != null) curr.next = curr1;
    	if(curr2 != null) curr.next = curr2;
    		
    	
    	head = dummy.next;
    	
    }

    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null) return null;
    	
    	RandomListNode curr = head;
    	while(curr!=null)
    	{
    		RandomListNode newnode = new RandomListNode(curr.label);
    		newnode.next = curr.next;
    		newnode.random = curr.random;
    		curr.next = newnode;
    		curr = newnode.next;
    	}
    	
    	curr = head.next;
    	while(curr!=null)
    	{
    		if(curr.random!=null)
    			curr.random = curr.random.next;
    		
    		if(curr.next!=null)
    			curr = curr.next.next;
    		else
    			curr = null;
    	}
    	
    	RandomListNode copyHead = new RandomListNode(-1);
    	RandomListNode copyCur = copyHead;
    	RandomListNode srcHead = new RandomListNode(-1);
    	RandomListNode srcCur = srcHead;

    	curr = head;
    	while(curr!=null && curr.next!= null)
    	{
    		srcCur.next = curr;
    		copyCur.next = curr.next;
    		
    		srcCur =srcCur.next;
    		copyCur = copyCur.next;
    		
    		curr.next = curr.next.next;
    		curr = curr.next;
    	}
    	
    	head = srcHead.next;
        return copyHead.next;
    }
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	
    	ListNode res = null;
    	for(ListNode a: lists)
    	{
    		res = mergeLists(res, a);
    	}

    	return res;
    }
    
    public ListNode mergeLists(ListNode A, ListNode B)
    {
    	if(A == null) return B; 
    	if(B == null) return A;
    	
    	ListNode dummy = new ListNode(0);
    	ListNode currA = A, currB = B, curr = dummy;
    	
    	while(currA!=null || currB!=null)
    	{
    		if(currA == null)
    		{
    			curr.next = currB; 
    			currB = currB.next;
    		}else if(currB == null)
    		{
    			curr.next = currA; 
    			currA = currA.next;
    		}else if(currA.val < currB.val)
    		{
    			curr.next = currA; 
    			currA = currA.next;
    		}else
    		{
    			curr.next = currB; 
    			currB = currB.next;
    		}
    		curr = curr.next;
    	}
    	
    	return dummy.next;
    }
    
    public ListNode insertionSortList(ListNode head) {
    	ListNode res = null, curr=head;
    	
    	while(curr!=null)
    	{
    		ListNode next =curr.next; 
    		curr.next = null;
    		res = InsertNode(curr, res);
    		curr= next;
    	}
    	
    	return res;
    }
    
    private ListNode InsertNode(ListNode node, ListNode list)
    {
    	if(list==null) return node;
    	ListNode dummy =new ListNode(-1);
    	dummy.next = list;
    	ListNode curr=list, pre = dummy;
    	
    	while(curr != null && curr.val<node.val)
    	{
    		pre = curr;
    		curr= curr.next;
    	}
    	pre.next = node;
    	node.next = curr;
    
    	return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        
    	if(head == null || head.next == null) return head; 

    	ListNode slow=head, fast = head; 
    	while(fast.next!=null && fast.next.next !=null)
    	{
    		fast=fast.next.next;
    		slow = slow.next;
    	}
    	ListNode right = slow.next;
    	slow.next = null;
    	   	
    	ListNode l1 = sortList(head);
    	ListNode l2 = sortList(right);
    	return mergeLists(l1, l2);
    }
    
    
    
}




package test;

import java.util.HashSet;

public class CCLinkedList {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	       next = null;
	    }
	}
	
	public boolean isPalindrome(ListNode head)
	{
		if(head==null || head.next==null) return true;
		ListNode cur = head;
		ListNode tail=null;
		while(cur!=null)
		{
			ListNode copy = new ListNode(cur.val);
			copy.next = tail;
			tail = copy;
			cur = cur.next;
		}
		
		cur = head;
		while(cur!=null)
		{
			if(cur.val!=tail.val)
				return false;
			tail = tail.next;
			cur = cur.next;
		}
		return true;
		
	}
	
	
	public ListNode partitionList(ListNode head, int val)
	{
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(-1);
		dummy.next = head;
		ListNode cur=head, prev = dummy;
		
		while(cur!=null)
		{
			if(cur.val>= val)
			{
				prev = cur;
				cur=cur.next;
			}else
			{
				if(cur==head)
				{
					head=head.next;
					prev = cur;
					cur=cur.next;
					
				}else
				{
					prev.next = cur.next;
					cur.next = dummy.next;
					dummy.next = cur;
					cur=prev.next;
				}
			}
		}
		
		
		
		return dummy.next;
	}
	public void deletenode (ListNode head)
	{
		if(head==null) return;
		if(head.next == null) return;
		head.val =head.next.val;
		head.next = head.next.next;
		return;
	}
	
	public void removedup1(ListNode head)
	{
		if(head==null || head.next==null) return;
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode cur= head, pre=null;
		while(cur!=null)
		{
			if(!set.contains(cur.val))
			{
				set.add(cur.val);
				pre = cur;
			}
			else
			{
				pre.next = cur.next;
			}
			cur=cur.next;
			
		}
		return;
		
	}
	
	public void removedup(ListNode head)
	{
		if(head == null || head.next == null) return;
		ListNode curr = head; 
		ListNode unique = head;
		while(unique!=null)
		{
			curr = unique;
			while(curr.next!=null)
			{
				if(curr.next.val==unique.val)
				{
					curr.next = curr.next.next;
				}else
					curr = curr.next;
			}
			
			
			unique = unique.next;
		}

	}
	
	
	
	public ListNode kthtoLast(ListNode head, int k)
	{
		if(head==null) return null;
		if(k==0) return head;
		ListNode p1 = head;
		ListNode p2 = head;
		
		while(k>0 && p1!=null)
		{
			p1=p1.next;
			k--;
		}
		if(k>0) return null;
		
		while(p1!=null)
		{
			p2=p2.next;
			p1=p1.next;
		}
		return p2;
	}
	
	public ListNode add(ListNode l1, ListNode l2)
	{
		ListNode c1 = l1; 
		ListNode c2 = l2; 
		ListNode dummy = new ListNode(-1);
		ListNode c3 = dummy;
		int carry = 0;

		while(c1!=null || c2!=null || carry>0)
		{
			int x = (c1==null?0:c1.val) + (c2==null?0:c2.val) + carry; 
			ListNode t = new ListNode(x%10);
			carry = x/10;
			c3.next = t;
			c1=c1==null?null:c1.next;
			c2=c2==null?null:c2.next;
			c3 = t;
		}



		return dummy.next;
	}
	
	
}

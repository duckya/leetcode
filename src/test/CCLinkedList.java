package test;

public class CCLinkedList {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	       next = null;
	    }
	}
	
	public void removedup(ListNode head)
	{
		if(head == null || head.next == null) return;
		ListNode curr = head.next; 
		ListNode unique, prev=head;
		while(curr!=null)
		{
			
			for(unique = head; unique !=curr; unique=unique.next)
			{
				if(unique.val == curr.val)
				{
					prev.next = curr.next;
					curr = curr.next;
					break;
				}
			}
			
			if(curr == unique)	
			{
				prev = curr;
				curr = curr.next;
			}
		}

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

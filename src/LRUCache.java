import java.util.Hashtable;

public class LRUCache {
	
	public static void main (String args[]) {

		System.out.println();
		LRUCache testA =new LRUCache(2);
		testA.set(2,1);
		testA.get(2);
		testA.set(3,2);
		testA.get(2);
		testA.get(3);
		System.out.println();
	}
	
	
	
	public class ListNode {
	    int val;
	    int key;
	    ListNode next;
	    ListNode prev;
	    ListNode(int x, int y) {
	        key = x;
	    	val = y;
	       next = null;
	    }
	}
    
    private Hashtable<Integer, ListNode> _listLookup = new Hashtable<Integer, ListNode>();
    private int _capacity = 0; 
    private ListNode _start = new ListNode(-1, -1);
    private ListNode _end = new ListNode(-1, -1);

    public LRUCache(int capacity) {
    	_capacity = capacity;
    	_start.next = _end; 
    	_end.prev = _start;
    }
    
    public int get(int key) {
        if(_listLookup.containsKey(key))
        {
        	ListNode x =  _listLookup.get(key);
        	x.prev.next = x.next;
        	x.next.prev = x.prev;
        	x.prev = _end.prev;
        	_end.prev.next = x;
        	x.next = _end;
        	_end.prev = x;
        	
        	return x.val;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        if(_listLookup.containsKey(key))
        {
        	ListNode x =  _listLookup.get(key);
        	x.val = value;
        	
        	x.prev.next = x.next;
        	x.next.prev = x.prev;
        	x.prev = _end.prev;
        	_end.prev.next = x;
        	x.next = _end;
        	_end.prev = x;
        }
        else
        {
        	if(_listLookup.size() < _capacity)
        	{
        		ListNode x = new ListNode(key, value);
        		_listLookup.put(key, x);
            	x.prev = _end.prev;
            	_end.prev.next = x;
            	x.next = _end;
            	_end.prev = x;
        		
        	}
        	else{
        		ListNode x = _start.next;
        		_start.next = x.next; 
        		x.next.prev = _start;
        		_listLookup.remove(x.key);
        		
        		ListNode y = new ListNode(key, value);
        		_listLookup.put(key, y);
        		
            	y.prev = _end.prev;
            	_end.prev.next = y;
            	y.next = _end;
            	_end.prev = y;
        	}
        }

    }
}

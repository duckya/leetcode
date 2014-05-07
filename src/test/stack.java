package test;

import java.util.Stack;

public class stack {
	public static void main (String args[]) {
		int A[] = {2,1};
		int B[] = {1,2};
		
		test testA =new test();
		testA.canCompleteCircuit(B, A);
		System.out.println();
	}
	
    public boolean isValid(String s) {
    	Stack<Character> a =new Stack<Character>();
    	for(char x:s.toCharArray())
    	{
    		if(x=='[' || x=='(' || x=='{' )
    		{
    			a.push(x);
    		}else
    		{
    			if(a.empty()) return false; 
    			char y=(Character)a.pop();
    			if((x==']' && y=='[') || (x=='}' && y=='{') || (x==')' && y=='(') )
    			{
    				
    			}else
    			{
    				return false; 
    			}
    		}
    		
    	}
    		
    	
    	if(!a.empty()) return false;
    	return true;
    	
    }
    
    public int longestValidParentheses(String s) {
    	Stack<Character> a =new Stack<Character>();
    	int size = 0;
    	int longest = 0;
    	char[] arrays = s.toCharArray();
    	for(char x:arrays)
    	{
    		if(x=='(')
    		{
    			a.push(x);
    		}else
    		{
    			if(a.empty())
    			{
    				size = 0;
    			}else
    			{
	    			size++;
	    			if(a.empty() && size>longest) longest =size;
    			}
    		}
    	}
    	
    	size = 0;
    	a.clear();
    	for(int i = arrays.length-1; i>=0; i--)
    	{
    		char x = arrays[i];
    		if(x==')')
    		{
    			a.push(x);
    		}else
    		{
    			if(a.empty())
    			{
    				size = 0;
    			}else
    			{
	    			size++;
	    			if(a.empty() && size>longest) longest =size;
    			}
    		}
    	}
    		
    	
    	return longest*2;
    }

    public int evalRPN(String[] tokens) {
    	Stack<Integer> cal = new Stack<Integer>();
     
    	for(int i=0; i<tokens.length; i++)
    	{
    		try{
    			int num = Integer.parseInt(tokens[i]);
    			cal.push(num);	 
    		} catch (NumberFormatException e) {

    			int op2 = (int) cal.pop();
    			int op1 = (int) cal.pop();
    			switch(tokens[i])
    			{
    				case "+": 
    					cal.push(op1 + op2);
    					break;
    				case "-": 
    					cal.push(op1 - op2);
    					break;
    				case "*": 
    					cal.push(op1 * op2);
    					break;
    				case "/":
    					cal.push(op1 / op2);
    					break;
    				default:
    					return 0;
    			}
    		}
    	}
    	return (int) cal.pop();
    }

}

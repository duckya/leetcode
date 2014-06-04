package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CCArrayandStrings {
	
	public static void main (String args[]) 
	{
		CCArrayandStrings testA =new CCArrayandStrings();
		int[] num = {1,3,2};
		//Arrays.sort(word);
		
		testA.printfive(250);
		System.out.println();
	}

	public String compress(String input)
	{
		if(input.length()==0) return input;
		StringBuffer res = new StringBuffer();
		char[] c = input.toCharArray();
		
		char lastChar=c[0];
		int lastIndex = 0;
		int count = 0;
		for(int i=1; i<c.length; i++)
		{
			if(c[i]!=lastChar)
			{
				count = i-lastIndex;
				res.append(lastChar);
				res.append(count);
				lastIndex = i;
				lastChar = c[i];
			}
		}
		res.append(lastChar);
		res.append(count);
				
		return (res.length()<input.length()?res.toString():input);
	}
	public boolean isUnique(String input)
	{
		if(input.length() > 256) return false;
		boolean[] isUsed = new boolean[256];
		
		for(int i=0; i<input.length(); i++)
		{
			if(isUsed[input.charAt(i)])
				return false;
			else
				isUsed[input.charAt(i)] = true;	
				
		}
		return true;
	}
	
    public String reverseWords2(String s) {
    	char[] c = s.toCharArray();
    	int start = 0; 
    	int end  = c.length;
    	
    	while(start<end)
    	{
    		char t = c[start];
    		c[start] = c[end];
    		c[end] = t;
    		start++; 
    		end--;
    	}
    	
    	return new String(c);
        
    }
	
    public String reverseWords(String s) {
        String res = "";
        int lastIndex = s.length();
        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i)==' ')
            {
                if(i!=lastIndex -1)
                    res = s.substring(i+1, lastIndex);
                lastIndex = i;
            }
                
        }
        return res;
    }
	public void printfive(int n)
	{
		for(int i=0; i<=n; i++)
		{
			String x = String.valueOf(i); 
			for(int j=0; j<x.length(); j++)
			{
				if(x.substring(j, j+1).equals("5"))
				{
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	public void printfive2(int n)
	{
		ArrayList<String> res = new ArrayList<String>();
		int div= 1; 
		while(n/div>10)
		{
			div*=10;
			
		}
		
		while(div>=1)
		{
			if(n/div >= 5)
			{
				res.add("5");
			}
		}
		

			
	}
	
	public void printprime(int n)
	{
		int j;
		if(n==2) System.out.println(2);
		for(int i=1; i<=n; i++)
		{
			boolean bPrime = true;
			for(j=2; j<=Math.sqrt(i); j++)
			{
				if(i%j==0)
				{
					bPrime = false; 
					break;
				}
			}
			if(bPrime)
				System.out.println(i);

		}
	}

	public ArrayList<ArrayList<Integer>> getcois(int cents)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		getcoinInternal(cents, path, res);
		return res;
		
	}

	private void getcoinInternal(int centsleft, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res)
	{
		if(centsleft == 0)
		{
			ArrayList<Integer> newpath = new ArrayList<Integer>();
			newpath.addAll(path);
			res.add(newpath);
			return;
		}
		if(centsleft >= 25 && (path.size() ==0 || path.get(path.size()-1)==25))
		{
			path.add(25); 
			getcoinInternal(centsleft-25, path, res);
			path.remove(path.size()-1);
		}

		if(centsleft >= 10 && (path.size() ==0 || path.get(path.size()-1)>=10))
		{
			path.add(10); 
			getcoinInternal(centsleft-10, path, res);
			path.remove(path.size()-1);
		}

		if(centsleft >= 5 && (path.size() ==0 || path.get(path.size()-1)>=5))
		{
			path.add(5); 
			getcoinInternal(centsleft-5, path, res);
			path.remove(path.size()-1);
		}

		if(centsleft >= 1 && (path.size() ==0 || path.get(path.size()-1)>=1))
		{
			path.add(1); 
			getcoinInternal(centsleft-1, path, res);
			path.remove(path.size()-1);
		}

		return;

	}
	
    public void nextPermutation(int[] num) {
        int i;
        for(i = num.length-2; i>=0; i--)
        {
            if(num[i]<num[i+1])
                break;
        }
        if(i==-1)
        {
            Arrays.sort(num);
            return; 
        }
        
        int val = num[i];
        num[i] = num[num.length-1];
        num[num.length-1] = val;
        Arrays.sort(num, i+1, num.length-1);
        return;
    }

	boolean IsUnique(String word)
	{
		boolean[] bUsed = new boolean[256];
		for(int i=0; i<word.length(); i++)
		{
			if(bUsed[word.charAt(i)])
				return false;
			else
				bUsed[word.charAt(i)] = true;
		}
		return true;
	}
	
	String reverse(String word)
	{
		String res = "";
		for(int i=word.length()-1; i>=0; i--)
		{
			res = res+word.substring(i, i+1);
		}
		return res;
	}
	
	public void removedup(char[] word)
	{
		if(word.length<2) return;
		int tail = 1; 

		for(int i=1; i<word.length; i++)
		{
			int j;
			for(j=0; j<tail; j++)
			{
				if(word[i] == word[j])
				{
					break;
				}
			}
			if(j==tail)
			{
				word[tail] = word[i];
				tail++;
			}
		}

		word[tail] = 0;
	}

	
	public void removedup2(char[] word)
	{
		if(word.length<2) return;
		int tail = 1; 
		boolean[] bUsed  =new boolean[256];
		bUsed[word[0]]=true;
		for(int i=1; i<word.length; i++)
		{
			if(!bUsed[word[i]])
			{
				word[tail] = word[i];
				bUsed[word[i]] =true;
				tail++;
			}
		}
		word[tail] = 0;
	}
	
	public boolean isAnagrams(String s1, String s2)
	{
		if(s1.length() != s2.length()) return false;

		int[] count=new int[256];

		for(int i=0; i<s1.length(); i++)
		{
			count[s1.charAt(i)] ++;
		}

		for(int i=0; i<s2.length(); i++)
		{
			if(count[s2.charAt(i)] ==0) return false;
			count[s2.charAt(i)] --;
		}	

		return true;
	}
	

	
	public String ReplaceSpace(char s[], int length)
	{
		int count = 0;
		for(int i=s.length-1; i>=0; i--)
			if(s[i] == ' ') count++;
		
		for(int i=s.length-1, j=s.length-1+count*2; i>=0; i--, j--)
		{
			if(s[i] == ' ')
			{
				s[j] = '0';
				s[j-1] = '2';
				s[j-2] = '%';
				j = j-2;
			}
			else
				s[j] = s[i];
			
		}
		return new String(s);
	}
	

	
	public void setZero(int[][] matrix)
	{
		if(matrix.length ==0 || matrix[0].length==0) return;

		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];

		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				if(matrix[i][j] == 0)
				{
					row[i] = 1; 
					col[j] = 1;
				}
				
			}
		}


		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				if(row[i] == 1||col[j] == 1)
				{
					matrix[i][j] = 0;
				}
				
			}
		}


	}
	
	public ArrayList<String> getResult(String s)
	{
		ArrayList<String> res = new ArrayList<String>();

		for(int i=0; i<s.length(); i++)
		{
			char curr = s.charAt(i);
			if(curr == '*')
			{
				int size = res.size();
				if(size == 0)
				{
					res.add("0");
					res.add("1");
				}else
				{
					for(int k=0; k<size; k++)
					{
						String old = res.get(0);
						res.remove(0);
						res.add(old+"0");
						res.add(old+"1");
					}
				}

			}else
			{
				if(res.size() == 0) 
					res.add(s.substring(i, i+1));
				else		
					for(int k=0; k<res.size(); k++)
					{
						String old = res.get(k);
						res.set(k, old+s.substring(i, i+1));
					}
				}
			
		}
		return res;
		//Arrays.sort(arg0, arg1, arg2);
	}
	
	public static void printFive(int n)
	  {
	    for(int i=0; i<=n; i++)
	    {
	       String x = String.valueOf(i);
	       //x.lastIndexOf(ch)
	       char[] ar = x.toCharArray();
	       for(int j=0; j<ar.length; j++)
	       {
	         if(ar[j] == '5') 
	         {
	             System.out.println(i);
	            break;
	         }
	       }
	    }
	    
	  }
	
}

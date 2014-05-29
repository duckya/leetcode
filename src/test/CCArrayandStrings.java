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
	
	public String ReplaceSpace(String s)
	{
		for(int i=s.length()-1; i>=0; i--)
		{
			if(s.charAt(i) == ' ')
				s=s.substring(0, i) + "%20" + (i==s.length()-1?"":s.substring(i+1, s.length()));
		}
		return s;
	}
	
	public char[] ReplaceSpace(char[] word)
	{
		int spacect=0;
		for(int i=0; i<word.length; i++)
		{
			if(word[i]==' ') spacect++;		
		}

		char[] newword = new char[word.length+spacect*2];


		for(int i=0, j=0; i<word.length; i++, j++)
		{
			if(word[i]== ' ' )
			{
				newword[j] = '%';
				newword[j+1] = '2';
				newword[j+2] = '0';
				j=j+2;
				
			}else
			{
				newword[j] = word[i];
			}
		}
		
		return newword;

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
	}
	
	public static void printFive(int n)
	  {
	    for(int i=0; i<=n; i++)
	    {
	       String x = String.valueOf(i);
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

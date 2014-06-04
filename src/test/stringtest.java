package test;

import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class stringtest {
	
	public static void main (String args[]) {
		int a = 20;
		Set<String> B = new HashSet<String>(); 
		B.add("dog");
		B.add("s");
		B.add("gs");

		char[][] board = new char[3][3];

		String[] t = {"a","b","c","d","e"}; 
		stringtest testA =new stringtest();
		//testA.longestPalindrome(t);
		testA.fullJustify(t, 3);
		StringBuffer sb= new StringBuffer("init");
		//sb.toString().insert(index, str, offset, len).delete(start, end).charAt(index).append(arg0)
	}
	
    public String reverseWords(String s) {
    	
    	String[] x = s.split(" ");
    	String res = "";
    	
    	for(int i=x.length-1; i>=0; i--)
        {
    		String n = x[i];
    		if(n.trim().length()!= 0)
    		{
    			res += n + " ";
    		}
        }
    	
    	return res.trim(); 
    }
    
    public boolean isPalindrome(String s) {
    	s = s.replaceAll("[^A-Za-z0-9]", "");
    	char[] inputs = s.toCharArray();
    	int size = inputs.length;
    	for(int i=0, j=size-1; i<j; i++,j--)
    	{
    		
    		if(Character.toUpperCase(inputs[i])!=Character.toUpperCase(inputs[j]))
    			return false;
    	}
    	
        return true;
    }
    
    public String strStr(String haystack, String needle) {
        int size1 = haystack.length();
        int size2 = needle.length();
        
        if(size2 ==0) return haystack;
        if(size1==0) return null;
    	
    	for(int i=0; i<size1-size2+1; i++)
    	{
    		
    		for(int j=0; j<size2; j++)
    		{
    			if(haystack.charAt(i+j) != needle.charAt(j))
    			{
    				break;
    			}
    			else
    			{
    				if(j==size2-1)
    				{
    					return haystack.substring(i);
    				}
    			}
    		}

    	}
    	
    	return null;
    }

    public int atoi(String str) {
    	str = str.trim();
    	if(str.length() ==0) return 0;
    	
    	int minus = 1;
    	if(str.charAt(0) == '-')
    	{
    		minus = -1;
    		str = str.substring(1);
    	}else if (str.charAt(0) == '+')
    	{
    		str = str.substring(1);
    	}
    		
    		
    	if(str.length() ==0 || str.charAt(0)<'0'||str.charAt(0)>'9') return 0;
    	
    	int res = 0;
    	for(int i=0; i<str.length(); i++)
    	{
    		if(str.charAt(i)<'0'||str.charAt(i)>'9')
    			break;
    		else
    		{
    			if(res<=Integer.MAX_VALUE/10 && Integer.MAX_VALUE - res*10 >=str.charAt(i) - '0')
    			{
    				res = res*10 + str.charAt(i) - '0';
    			}else
    			{
    				if( minus == 1)
    					return Integer.MAX_VALUE;
    				else
    					return Integer.MIN_VALUE;
    				
    			}
    			
    		}
    	}
    	
    	return res*minus;
        
    	
    }

    public String addBinary(String a, String b) {
        int sizeA = a.length();
        int sizeB = b.length();
        
        if (sizeA ==0) return b; 
        if (sizeB==0) return a; 
        
        String res = "";
        
    	int r = 0;
    	int carryover = 0;
        for(int i=sizeA-1, j = sizeB-1; i>=0 || j>=0; )
        {
        	char ca = '0';
        	char cb = '0';
        	
        	if(i>=0) ca = a.charAt(i);
        	if(j>=0) cb = b.charAt(j);

	        	if(ca=='0' && cb=='0')
	        	{
	        		r=carryover; 
	        		carryover = 0;
	        	}else if((ca=='0' && cb=='1') || (ca=='1' && cb=='0'))
	        	{
	        		if(carryover==0)
	        		{
		        		r=1; 
		        		carryover = 0;
	        		}else
	        		{
	            		r=0; 
	            		carryover = 1;
	        		}
	        		
	        	}else if(ca=='1' && cb=='1')
	        	{
	        		r=carryover; 
	        		carryover = 1;
	        	}else
	        	{
	        		return "";
	        	}
	        	res = String.valueOf(r)+res;
	        	
	        	i--;
	        	j--;

        }
        
        if(carryover == 1)
        	res = "1"+res;
        
        return res;
    	
    	
    }

    public String longestPalindrome(String s) {
        int longestSize = -1; 
        String res = "";
        
        if (s.length() ==0) return s; 
        
        for(int i = 0; i<s.length(); i++)
        {
            //get the palindrome centered by i
        	for(int j=0; j<=i&&j<s.length()-i; j++)
        	{
        		if(s.charAt(i-j) == s.charAt(i+j))
        		{
        			if(j*2+1>longestSize)
        			{
        				longestSize = j*2+1;
        				res = s.substring(i-j, i+j+1);
        			}
        			
        		}else
        			break;
        	}
        	
        	for(int j=0; j<=i&&j<s.length()-i-1; j++)
        	{
        		if(s.charAt(i-j) == s.charAt(i+j+1))
        		{
        			if(j*2+2>longestSize)
        			{
        				longestSize = j*2+2;
        				res = s.substring(i-j, i+j+2);
        			}
        			
        		}else
        			break;
        	}
        }
        
        return res;
    }

    public boolean isMatch2(String s, String p) {
    	int sizep = p.length();
    	int sizes = s.length();
    	
    	if(sizep==0) return sizes==0;
    	
    	if(sizep==1)
    	{
    		if(sizes ==1 && (p.charAt(0)=='.' || p.charAt(0) ==s.charAt(0)))
    		{
    			return true;
    		}else
    			return false;
    				
    	}else
    	{
    		if(p.charAt(1)=='*')
    		{
    			if(sizes > 0 && (p.charAt(0)=='.' || p.charAt(0) ==s.charAt(0)))
    			{
    				return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
    			}else
    				return isMatch(s, p.substring(2));
    		}else
    		{
    			if(sizes > 0 && (p.charAt(0)=='.' || p.charAt(0) ==s.charAt(0)))
    			{
    				return isMatch(s.substring(1), p.substring(1));
    			}
    			else
    				return false;
    		}
    	}
    	
        
    }

    public boolean isMatch(String s, String p) {
        int sizep = p.length();
    	int sizes = s.length();
    	
    	if(sizep ==0) return sizes==0;
    	
    	if(sizes ==0)
    	{
    		if(p.charAt(0)=='*')
    			return isMatch(s, p.substring(1));
    		else 
    			return false;
    	}else
    	{
    		if(p.charAt(0)=='?'|| p.charAt(0) == s.charAt(0)) 
	    	{
	    		return isMatch(s.substring(1), p.substring(1));
	   		}else if(p.charAt(0)=='*')
	   		{
	   			while(p.length()>1 && p.charAt(1)=='*')
	   			{
	   				p=p.substring(1);
	   			}
	   			return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
	   		}else
	   			return false;
    	}
    	


    }

    public String longestCommonPrefix(String[] strs) {
        String res="";
        if(strs.length==0) return res;
        
    	for(int i=0;;i++)
    	{
    		if(strs[0].length() == i) return res;
    		char r = strs[0].charAt(i);
    		for(int j=0; j<strs.length; j++)
    		{
    			if(strs[j].length() == i || r != strs[j].charAt(i) )
    				return res;
    		}
    		res = res + strs[0].charAt(i);
    	}
    }

    public boolean isNumber(String s) {
    	if(s.trim() == "") return false;
    	s = s.trim();
    	if(s.startsWith("-") || s.startsWith("+")) s=s.substring(1);
    	if(s.length() == 0) return false;
    	        
    	int point = -1; 
    	int science = -1;
        for(int i = 0; i< s.length(); i++)
    	{
        	if((s.charAt(i)>'9' || s.charAt(i)<'0') && s.charAt(i)!='e' && s.charAt(i)!='.' && s.charAt(i)!='+' && s.charAt(i)!='-')
    			return false;
        	
        	if((s.charAt(i)=='+' || s.charAt(i)=='-') && ( i==0 || s.charAt(i-1) != 'e' || i==s.length()-1))
        		return false;
        	
        	if(s.charAt(i)=='.')
        	{
        		if(point != -1) return false;
        		point = i;
        		
        	}
        	
        	if(s.charAt(i)=='e')
        	{
        		if(science != -1) return false;
        		science =i;
        	}
    	}
        
        if(point == 0 && s.length()==1)
        {
        	return false;
        }
    	
        if(science == 0 || science==s.length()-1)
        {
        	return false;
        }
    	
        if(point > science && science!=-1)
        {
        	return false;
        }else if(point == 0 && science==1)
        {
        	return false;
        }
        
        
        return true; 
    }

    public String intToRoman(int num) {
    	String str = "";    
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
        int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};   
        
        for(int i=0; i< value.length; )
        {
        	if(num>=value[i])
        	{
        		num = num - value[i];
        		str = str + symbol[i];
        	}else
        	{
        		i++;
        	}
        }
        return str;
    }
    
    public int romanToInt(String s) {
        int res = 0; 
        for(int i =0; i<s.length();i++)
        {
        	if(i<s.length()-1)
        	{
        		
        		String x  = s.substring(i, i+2);
        		switch (x){
        			case "CM": res += 900;i++; break; 
        			case "CD": res += 400;i++;break; 
        			case "XC": res += 90;i++;break; 
        			case "XL": res += 40;i++;break; 
        			case "IX": res += 9;i++;break; 
        			case "IV": res += 4;i++;break; 
        			default:
        				res += mapSingle(s.substring(i, i+1));  
        		}

        	}else
        		res += mapSingle(s.substring(i, i+1));
        		
        }
        return res;
    }
    
    private int mapSingle(String s)
    {
		switch (s){
			case "M": return 1000;
			case "D": return 500;
			case "C": return 100;
			case "L": return 50;
			case "X": return 10;
			case "V": return 5;
			case "I": return 1;
			default: return 0; 
		}
    }

    public String countAndSay(int n) {

    	if(n==0) return "";
    	if(n==1) return "1";
    	String res = "1";
        
        for(int i=2; i<=n; i++)
        {
        	res = countAndSay(res);
        }
        return res;
        
    }
    
    private String countAndSay(String seq)
    {
    	
    	String res = "";
    	String lastValue = "";
    	int lastValueNumber = 0;
    	for(int i = 0; i < seq.length(); i++)
    	{
    		if(!seq.substring(i, i+1).equals(lastValue))
    		{
    			if(lastValueNumber !=0)
    				res += lastValueNumber + lastValue;
    			lastValue = seq.substring(i, i+1);
    			lastValueNumber = 1;
    		}else
    		{
    			lastValueNumber++; 
    		}
    		
    	}
    	
    	res += lastValueNumber + lastValue;
    	return res; 
    }

    public ArrayList<String> anagrams(String[] strs) {
    	HashMap<String, ArrayList<String>> res = new HashMap<String, ArrayList<String>>();
    	ArrayList<String> result = new ArrayList<String>();
    	for(String str:strs)
    	{
    		String s = str.replace(" ", "");
    		char[] arr = s.toCharArray();
    		Arrays.sort(arr);
    		s = Arrays.toString(arr); 
    		if(res.containsKey(s))
    		{
    			ArrayList<String> t = res.get(s);
    			t.add(str);
    			
    		}else
    		{
    			ArrayList<String> t = new ArrayList<String>();
    			t.add(str);
    			res.put(s, t);
    		}
    	}
    	
    	for(String key:res.keySet())
    	{ 
    		if(res.get(key).size() > 1)
    			result.addAll(res.get(key));
    	}
    	
   		return result;
    	
    }

    public int lengthOfLastWord(String s) {
    	s = s.trim();
    	if(s=="") return 0;
        String[] arr = s.split(" ");
        int size = arr.length;
        return arr[size-1].length();
        
    }

    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> map = new ArrayList<String>();
    	map.add("");
    	map.add("");
    	map.add("abc");
    	map.add("def");
    	map.add("ghi");
    	map.add("jkl");
    	map.add("mno");
    	map.add("pqrs");
    	map.add("tuv");
    	map.add("wxyz");
    	
    	return combineletter(digits, map);
    	
    }
    
    private ArrayList<String> combineletter(String digits, ArrayList<String> map)
    {
    	ArrayList<String> res = new ArrayList<String>();
    	if(digits.length() == 0) 
    	{
    		res.add("");
    		return res;
    	}
    	
    	int digit = Integer.parseInt(digits.substring(0, 1));    
    	String mapping = map.get(digit);
   		String rest = digits.substring(1);
   		ArrayList<String> prev = combineletter(rest, map);
   		
   		for(char a:mapping.toCharArray())
   		{
   			for(String r:prev)
   			{
   				String t = a + r;
   				res.add(t);
   			}
   		}
    		
    	return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        if(s.length()<=1) return s.length();
        int i=0, max=1;
        int[] map=new int[256];
        
        for(int k=0; k<256; k++) map[k] = -1;
        
    	while(i<s.length()-1)
    	{
    		map[s.charAt(i)] = i;
    		int j=i+1;
    		for(;j<s.length() && (map[s.charAt(j)] < i || map[s.charAt(j)]== j); j++){
    			map[s.charAt(j)] = j;
    		}
    		max=Math.max(max, j-i);
    		if(j==s.length()) return max;
    		i=map[s.charAt(j)] +1;
    	}
    	return max;
    }
    
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        int i=0, max=1;
        int[] map=new int[256];
        for(int k=0; k<256; k++) map[k] = -1;
        
    	while(i<s.length()-1)
    	{
    		map[s.charAt(i)] = i;
    		int k=i-1, j=i+1;
    		for(;k>=0 && (map[s.charAt(k)] < k || map[s.charAt(k)] > i||map[s.charAt(k)]==k) ; k--){
    			map[s.charAt(k)] = k;
    		}

    		//k=k+2;
    		for(;j<s.length() && (map[s.charAt(j)] < k+1 || map[s.charAt(j)] > j ||map[s.charAt(j)]==j); j++){
    			map[s.charAt(j)] = j;
    		}
    		
    		max	= Math.max(max, j-(k+1));
    		i=j;
    	}
    	return max;
    }
    
    public ArrayList<ArrayList<String>> partition(String s) {
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    	ArrayList<String> path =new ArrayList<String>();
    	
    	dfs(s, path, 0, res);
    
    	return res;  	
    }
    
    private void dfs(String s, ArrayList<String> path, int start, ArrayList<ArrayList<String>> res)
    {
    	if(start==s.length())
    	{
    		
    		ArrayList<String> newpath = new ArrayList<String>();
    		newpath.addAll(path);	
    		res.add(newpath);
    		return;
    	}
    	
		for(int j=start; j<s.length(); j++)
		{
			if(isPalindrome(s, start, j))
			{
				path.add(s.substring(start, j+1));
				dfs(s, path, j+1, res);
				path.remove(path.size()-1);
			}
		}
    }
    
    private boolean isPalindrome(String s, int start, int end) {
    	char[] inputs = s.toCharArray();
    	while(start<end)
    	{
    		if(Character.toUpperCase(inputs[start])==Character.toUpperCase(inputs[end]))
    		{
    			start++; 
    			end--;
    		}
    		else
    			return false;
    	}
    	
        return true;
    }
    
    public int uniquePaths1(int m, int n) {
    	int[][] steps = new int[m][n];
    	steps[0][0] = 0; 
    	for(int i =0; i<m; i++) steps[i][0] =1;
    	for(int i =0; i<n; i++) steps[0][i] =1;
    	
    	if(m==1 || n==1) return steps[m-1][n-1];
    	
    	int total = getStep(m-1, n-1, steps);
    	return total;
    }
    private int getStep(int m, int n, int[][] steps)
    {
    	int path1, path2;
    	if(steps[m-1][n]>0) 
    		path1 =steps[m-1][n];
    	else
    		path1 = getStep(m-1, n, steps);
    	
    	if(steps[m][n-1]>0) 
    		path2 =steps[m][n-1];
    	else
    		path2 = getStep(m, n-1, steps);
    	
    	steps[m][n] = path1 + path2;
    	return steps[m][n];
    }
    
    public int uniquePaths(int m, int n) {
    	int[][] steps = new int[m][n];
    	steps[0][0] = 0; 
    	for(int i =0; i<m; i++) steps[i][0] =1;
    	for(int i =0; i<n; i++) steps[0][i] =1;
    	
    	for(int i=1; i<m; i++)
    	{
    		for(int j=1; j<n; j++)
    		{
    			steps[i][j] = steps[i-1][j] + steps[i][j-1];
    		}
    	}

    	return steps[m-1][n-1];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length, n=obstacleGrid[0].length;
    	int[][] steps = new int[m][n];
    	steps[0][0] = (obstacleGrid[0][0]==0?1:0); 

    	for(int i =1; i<m; i++) 
    		steps[i][0] =(obstacleGrid[i][0]==1? 0:steps[i-1][0]);

    	
    	for(int i =1; i<n; i++) 
    		steps[0][i] =(obstacleGrid[0][i]==1? 0:steps[0][i-1]);

    	
    	for(int i=1; i<m; i++)
    	{
    		for(int j=1; j<n; j++)
    		{
    			if(obstacleGrid[i][j]==1) 
    				steps[i][j] = 0;
    			else
   					steps[i][j] = steps[i-1][j] + steps[i][j-1];
    		}
    	}
    	return steps[m-1][n-1];
    	
    }
    
    public ArrayList<String[]> solveNQueensTLE(int n) {
    	ArrayList<String[]> res = new ArrayList<String[]>();
    	int[][] board=new int[n][n];
    	int currentcolumn = 0;
    	solveTLE(currentcolumn, n, board, res);
    	return res;
    }
     private void solveTLE(int currentcolumn, int size, int[][] board, ArrayList<String[]> res)
     {
    	 if(currentcolumn == size)
    	 {
    		 String[] solution =new  String[size];
    		 String row="";
    		 for(int i=0; i<size; i++)
    		 {
    			 row = "";
    			 for(int j=0; j<size; j++)
    			 {
    				 row += (board[i][j] >0? String.valueOf(board[i][j]):".");
    			 }
    			 solution[i] = row;
    		 }
    		 res.add(solution);
    		 return;
    	 }
         for(int i=0; i<size; i++)
         {
         	if(validPlaceTLE(currentcolumn, i, board))
         	{
         		
         		board[i][currentcolumn] =1;
         		currentcolumn++; 
         		solveTLE(currentcolumn, size, board, res);
         		currentcolumn--;
         		board[i][currentcolumn] =0;
         	}
         }
     }
     
     private boolean validPlaceTLE(int column, int row, int[][] board)
     {
    	 int sum = 0;
    	 for(int i=0; i<board.length; i++)
    		 sum += board[row][i];
    	 if(sum>0) return false;
    	 
    	 for(int i=0; i<board.length; i++)
    		 sum += board[i][column];
    	 if(sum>0) return false; 
    	 
    	 for(int i=0; i<board.length; i++)
    		 sum += board[i][i];
    	 if(sum>0) return false; 
    	 
    	 return true;
    	 
     }
     
     public ArrayList<String[]> solveNQueens(int n) {
     	ArrayList<String[]> res = new ArrayList<String[]>();
     	HashSet<Integer> cols = new HashSet<Integer>();
     	HashSet<Integer> diag1 = new HashSet<Integer>();
     	HashSet<Integer> diag2 = new HashSet<Integer>();
     	int[] board = new int[n];
     	
     	int currentrow = 0;
     	solve(currentrow, n, board, res, cols, diag1, diag2);
     	return res;
     }
      private void solve(int currentrow, int size, int[] board, ArrayList<String[]> res, HashSet<Integer> cols, HashSet<Integer> diag1, HashSet<Integer> diag2)
      {
     	 if(currentrow == size)
     	 {
     		 String[] solution =new  String[size];
	      		 
			 for(int i=0; i<size; i++)
     		 {
	     		 char[] chars = new char[size];
				 Arrays.fill(chars, '.');
				 chars[board[i]] = 'Q';
				 String row = new String(chars);
     			 solution[i] = row;
     		 }
     		 res.add(solution);
     		 return;
     	 }
          for(int i=0; i<size; i++)
          {
          	if(validPlace(currentrow, i, cols, diag1, diag2))
          	{
          		
          		board[currentrow] =i;
          		cols.add(i);
          		diag1.add(i+currentrow);
          		diag2.add(i-currentrow);
          		currentrow++; 
          		solve(currentrow, size, board, res, cols, diag1, diag2);
          		currentrow--;
          		cols.remove(i);
          		diag1.remove(i+currentrow);
          		diag2.remove(i-currentrow);
          		board[currentrow] =0;
          	}
          }
      }
      
      private boolean validPlace(int row, int col,  HashSet<Integer> cols, HashSet<Integer> diag1, HashSet<Integer> diag2)
      {
     	 
     	  if(cols.contains(col) || diag1.contains(row+col)||diag2.contains(col-row))
     		  return false;
     	 return true;	 
      }
      
      public int totalNQueens(int n) {
       	
       	HashSet<Integer> cols = new HashSet<Integer>();
       	HashSet<Integer> diag1 = new HashSet<Integer>();
       	HashSet<Integer> diag2 = new HashSet<Integer>();
       	int[] board = new int[n];
       	
       	int currentrow = 0;
       	int total = solvetotal(currentrow, n, board, cols, diag1, diag2, 0);
       	return total;
      }
      
      private int solvetotal(int currentrow, int size, int[] board, HashSet<Integer> cols, HashSet<Integer> diag1, HashSet<Integer> diag2, int total)
      {
     	 if(currentrow == size)
     	 {
     		   total ++;
     		   return total;
     	 }
         for(int i=0; i<size; i++)
         {
          	if(!(cols.contains(i) || diag1.contains(currentrow+i)||diag2.contains(i-currentrow)))
          	{
          		
          		board[currentrow] =i;
          		cols.add(i);
          		diag1.add(i+currentrow);
          		diag2.add(i-currentrow);
          		currentrow++; 
          		total = solvetotal(currentrow, size, board, cols, diag1, diag2, total);
          		currentrow--;
          		cols.remove(i);
          		diag1.remove(i+currentrow);
          		diag2.remove(i-currentrow);
          		board[currentrow] =0;
          	}
          }
          return total;
      }

      
      public ArrayList<String> restoreIpAddresses(String s) {
    	  ArrayList<String> res = new ArrayList<String>();
    	  int part = 0; 
    	  dfs(s, res, 0, "", part);
    	  return res;
      }
      
      private void dfs(String s, ArrayList<String> res, int start, String IP, int part)
      {
    	  if(start == s.length()  && part ==4)
    	  {
    		  
    		  res.add(IP);
    		  return; 
    	  }
    	  if(part>=4) return;
    	  for(int i=start; i<s.length() && i< start+3; i++)
    	  {
    		  String t = s.substring(start, i+1);
    		  if(Integer.parseInt(t)<=255 && part<4 && (!t.startsWith("0") ||t.equals("0")))
    		  {
    			  int old = start;
    			  String oldIP = IP;
    			  if(IP == "") 
    				  IP = t;
    			  else
    				  IP+="."+t;
    			  part++; 
    			  start = i+1;
    			  dfs(s, res, start, IP, part);
    			  start = old; 
    			  IP = oldIP;
    			  part--;
    			  
    		  }
    	  }
      }
      
      public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	  ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	  ArrayList<Integer> path = new ArrayList<Integer>();
    	  Arrays.sort(candidates);
    	  dfs(res, candidates, target, path, 0);
    	  return res;
    	  
      }
      private void dfs(ArrayList<ArrayList<Integer>> res, int[] candidates, int target, ArrayList<Integer> path, int start)
      {
    	  if(target == 0)
    	  {
    		  ArrayList<Integer> p = new ArrayList<Integer>();
    		  p.addAll(path); 
    		  res.add(p);
    		  return; 
    	  }
    	  int i =start; 
    	  while(i<candidates.length && candidates[i]<=target)
    	  {
    		  path.add(candidates[i]);
    		  dfs(res, candidates, target - candidates[i], path, i);
    		  path.remove(path.size()-1); 
    		  i++;
    	  }
      }
      
      public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	  ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	  ArrayList<Integer> path = new ArrayList<Integer>();
    	  Arrays.sort(num);
    	  dfs2(res, num, target, path, 0);
    	  return res;
      }
      
      private void dfs2(ArrayList<ArrayList<Integer>> res, int[] candidates, int target, ArrayList<Integer> path, int start)
      {
    	  if(target == 0)
    	  {
    		  ArrayList<Integer> p = new ArrayList<Integer>();
    		  p.addAll(path); 
    		  res.add(p);
    		  return; 
    	  }
    	  int i =start; 
    	  int prev = -1;
    	  while(i<candidates.length && candidates[i]<=target)
    	  {
    		  if(prev == candidates[i])
    		  {
    			  i++;
    			  continue;
    		  }
    		  prev = candidates[i]; 
    		  path.add(candidates[i]);
    		  dfs2(res, candidates, target - candidates[i], path, i+1);
    		  path.remove(path.size()-1); 
    		  i++;
    	  }
      }
      
      public ArrayList<String> generateParenthesis(int n) {
    	  ArrayList<String> res = new ArrayList<String>();
    	  String path = ""; 
    	  Stack<String> st = new Stack<String>(); 
    	  generate(res, path, 0, n, st);
    	  return res; 
      }
      
      private void generate(ArrayList<String> res, String path, int posi, int size, Stack<String> st)
      {
    	  if(posi == size && st.isEmpty())
    	  {
    		  res.add(path); 
    		  return; 
    	  }
    	  
    	  if(posi < size)
    	  {
	    	  st.push("(");
	       	  generate(res, path + "(", posi+1, size, st);
	       	  st.pop();
    	  }
          if(!st.empty())
          {
	          st.pop();
	          generate(res, path + ")", posi, size, st);
	          st.push("(");
          } 
      }
      
      public void solveSudoku(char[][] board) {
          fillNumber(board, 0, 0);
      }
      
      private boolean fillNumber(char[][] board, int row, int col)
      {
    	  int size = board.length; 
    	  
    	  
   	 
          for(int i=row; i<size; i++)
          {
        	  int j=col;
        	  if(i==row+1)j=0;
        	  
        	  for(; j<size; j++)
        	  {
        		  if(board[i][j]!='.')
        			  continue;
        		  else
        		  {
        			  for(int k=1; k<10; k++)
        			  {
        				  if(isValidSudoku(board, i, j, k))
        				  {
        					  board[i][j] = String.valueOf(k).charAt(0); 
        					  if(fillNumber(board, (j==size-1?i+1:i), (j==size-1?0:j+1))) return true;
        					  board[i][j] = '.';
        				  }
        				  
        			  }
        			  return false;
        		  }
        		  
        	  }
          }
          return true;
          
      }
      
      public boolean isValidSudoku(char[][] board, int row, int col, int val) 
      {
      	
          for(int i=0; i<9; i++)
          {
        	  if(Character.getNumericValue(board[row][i])==val) return false;
          }
          
          for(int i=0; i<9; i++)
          {
        	  if(Character.getNumericValue(board[i][col])==val) return false;
          }

          int x= row/3;
          int y = col/3;
          
          for(int i=0; i<3; i++)
          {
          	for(int j=0; j<3; j++)
          	{
          		if(Character.getNumericValue(board[i+x*3][j+y*3])==val) return false;
          	}
          }
      			

          return true; 
      }

      public boolean exist(char[][] board, String word) {
    	  boolean[][] visited = new boolean[board.length][board[0].length];
    	  
          for(int i=0; i<board.length; i++)
          {
        	  for(int j=0; j<board[0].length; j++)
        	  {
        		  if(board[i][j] == word.charAt(0))
        		  {
        			  visited[i][j] = true;
        			  if(check(board, visited, i, j, word, 1)) return true;
        			  visited[i][j] = false;
        		  }
        	  }
          }
          return false;
      }
      
      private boolean check(char[][] board, boolean[][] visited, int row, int col, String word, int pos)
      {
    	  if(pos==word.length()) return true;
    	  
    	  if(row>0 && !visited[row-1][col] && board[row-1][col] == word.charAt(pos))
    	  {
    		  visited[row-1][col] = true;
    		  if(check(board, visited, row-1, col, word, pos+1)) return true;
    		  visited[row-1][col] = false;
    	  }
    	  
    	  if(row<board.length-1 && !visited[row+1][col] && board[row+1][col] == word.charAt(pos))
    	  {
    		  visited[row+1][col] = true;
    		  if(check(board, visited, row+1, col, word, pos+1)) return true;
    		  visited[row+1][col] = false;
    	  }
    	  
    	  if(col>0 && !visited[row][col-1] && board[row][col-1] == word.charAt(pos))
    	  {
    		  visited[row][col-1] = true;
    		  if( check(board, visited, row, col-1, word, pos+1)) return true;
    		  visited[row][col-1] = false;
    	  }
    	  
    	  if(col<board[0].length-1 && !visited[row][col+1] && board[row][col+1] == word.charAt(pos))
    	  {
    		  visited[row][col+1] = true;
    		  if(check(board, visited, row, col+1, word, pos+1)) return true;
    		  visited[row][col+1] = false;
    	  }
    	  
    	  return false;
    		  
      }

      public String minWindow(String S, String T) {
          if(T.length() == 0) return "";
    	  int lastBeginIndex = -1;
    	  String res = "";
    	  for(int i=0,j=0; i<S.length(); i++)
    	  {
    		  if(S.charAt(i) == T.charAt(j))
    		  {
    			  j++;
    			  if(j==1)lastBeginIndex = i;
    				  
    			  if(j==T.length())
    			  {
    				  
    				  j=0;
    				  String sub = S.substring(lastBeginIndex, i+1);
    				  res = sub.length() < res.length() || res.length()==0 ? sub:res;
    			  }
    		  }
    	  }
          
    	  return res;
      }
      
      public String multiply(String num1, String num2) {
          if(num1.equals("0") || num2.equals("0")) return "0";
          
          String res = "";
          String midres = "";
    	  int carryOver = 0;
    	  
    	  char[] n1 = num1.toCharArray();
    	  char[] n2 = num2.toCharArray();
    	  
    	  for(int i=n1.length-1; i>=0; i--)
    	  {
    		  carryOver = 0;
    		  midres = "";
    		  for(int j=n2.length-1; j>=0; j--)
    		  {
    			  int l1 = n1[i] - '0';
    			  int l2 = n2[j] - '0';
    			  
    			  int r = l1*l2+carryOver;
    			  int val = r%10;
    			  carryOver = r/10;
    			  
    			  midres =String.valueOf(val) +  midres;
    			  
    		  }
    		  
    		  if(carryOver>0)midres = String.valueOf(carryOver) +  midres;
    		  
    		  for(int k=i; k<n1.length-1; k++)
    		  {
    			  midres = midres + "0";
    		  }
    		  res = addString(res, midres);	  
    	  }
    	  
    	  return res;
      }
      
      public String addString(String num1, String num2) {
                    
          String res = "";
          int carryOver = 0;
    	  
    	  char[] n1 = num1.toCharArray();
    	  char[] n2 = num2.toCharArray();
    	  
    	  for(int i=n1.length-1, j=n2.length-1; i>=0 || j>=0; i--, j--)
    	  {	    		 
    			  int l1 = i<0? 0 : n1[i] - '0';
    			  int l2 = j<0? 0 : n2[j] - '0';
    			  
    			  int r = l1+l2+carryOver;
    			  int val = r%10;
    			  carryOver = r/10;
    			  
    			  res = String.valueOf(val) + res;  
    	  }
    	  
		  if(carryOver>0)res = String.valueOf(carryOver) + res;
		  

    	  
    	  return res;
      }
      
      public ArrayList<Integer> findSubstring(String S, String[] L) {
    	  ArrayList<Integer> res = new ArrayList<Integer>();
    	  ArrayList<String> source = new ArrayList<String>();
    	  boolean[] bUsed = new boolean[L.length];
    	  int count = 0;
    	  int size = L[0].length();
    	  for(int i=0; i<S.length()-size; i=i+size)
    	  {
    		  source.add(S.substring(i, i+size)); 
    	  }
    	  
    	  for(int i = 0; i<source.size(); i++)
    	  {
    		  for(int j =0; j<L.length; j++)
    		  {
    			  if(source.get(i).equals(L[j]))
    			  {
    				  if( bUsed[j] == false)
    				  {
    					  count++;
    					  bUsed[j] = true;
    					  
    					  if(count ==L.length)
    					  {
    						  res.add((i-L.length+1)*size);
        					  
        					  count =0;
        					  Arrays.fill(bUsed, false);
    					  }
    					  
    				  }else
    				  {
    					  //more than once
    					  count =0;
    					  Arrays.fill(bUsed, false);
    					  
    				  }
    			  }
    		  }
    		  
    	  }
    	  
    	  return res;
          
      }
      
      public int minDistance(String word1, String word2) {
    	  if(word1.length() ==0) return word2.length();
    	  if(word2.length() ==0) return word1.length();
    	  
    	  int[][] res = new int[word1.length()+1][word2.length()+1];
    	  res[0][0] = 0;
    	  for(int i=1; i<=word1.length(); i++) res[i][0] = i;
    	  for(int j=1; j<=word2.length(); j++) res[0][j] = j;
    	  
    	  for(int i=1; i<=word1.length(); i++)
    	  {
    		  for(int j=1; j<=word2.length(); j++)
    		  {
    			  if(word1.charAt(i-1) == word2.charAt(j-1))
    			  {
    				  res[i][j] = res[i-1][j-1];
    			  }else
    			  {
    				  res[i][j] = Math.min(Math.min(res[i-1][j-1], res[i][j-1]), res[i-1][j])+1;
    			  }
    		  }
    	  }
    	  
    	  return res[word1.length()][word2.length()];
          
      }

      public boolean wordBreak(String s, Set<String> dict) {
          if(s.length()==0) return true;
          boolean[] res = new boolean[s.length()];
          
          for(int i=0; i<s.length(); i++)
          {
        	  for(String d:dict)
              {
            	  if(i >= d.length()-1 && s.substring(i-d.length()+1, i+1).equals(d))
            	  {
            		  res[i] = i-d.length()<0? true:res[i-d.length()];
            		  if(res[i]==true) break;
            	  }
           
              } 
          }
    	  return res[s.length()-1];
      }
      
      public int numDistinct(String S, String T) {
    	  if(S.equals(T)) return 1;
    	  if(S.length()<=T.length()) return 0;
    	  
    	  int[][] res = new int[S.length()+1][T.length()+1];
    	  res[0][0] = 1;
    	  for(int i=1; i<S.length()+1; i++) res[i][0] = 1;
    	  for(int j=1; j<T.length()+1; j++) res[0][j] = 0;
    	  
    	  for(int i=0; i<S.length(); i++)
    	  {
    		  for(int j=0; j<T.length(); j++)
    		  {
    			  if(i<j) res[i+1][j+1] = 0;
    			  if(i==j) res[i+1][j+1] = S.substring(0, i+1).equals(T.substring(0, j+1))?1:0;
    			  if(i>j)
    			  {
    				  if(S.charAt(i)==T.charAt(j))
    				  {
    					  res[i+1][j+1] = res[i][j]+res[i][j+1];
    				  }else
    				  {
    					  res[i+1][j+1] = res[i][j+1];
    				  }
    			  }

    		  }
    	  }
    	  
    	  return res[S.length()][T.length()];
          
      }
      
      public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	  
    	  ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	  if(num.length == 0) return res;
    	  Arrays.sort(num);
    	  ArrayList<Integer> init = new ArrayList<Integer>();
    	  HashSet<String> dup=new HashSet<String>();
    	  init.add(num[0]);
    	  res.add(init);
    	  dup.add(init.toString());
    	  for(int i=1; i<num.length; i++)
    	  {
    		  int n = num[i];
    		  int size = res.size();
    		  for(int k=0; k<size; k++)
    		  {
    			  ArrayList<Integer> t = res.get(0);
    			  res.remove(0);
    			  for(int j=0; j<=t.size(); j++)
    			  {
    				  ArrayList<Integer> nt=new ArrayList<Integer>();
    				  nt.addAll(t);
    				  nt.add(j, n);
    				  if(!dup.contains(nt.toString()))
    				  {
    					  res.add(nt);
    					  dup.add(nt.toString());
    				  }
    			  }
    		  }
   		  
   		  
    	  }
    	  return res;
      }
      
      public boolean isScramble(String s1, String s2) {
    	  return scramble(s1).get(s1).contains(s2);
      }
      
      private HashMap<String, HashSet<String>> scramble(String s)
      {
    	  HashMap<String, HashSet<String>> res = new HashMap<String, HashSet<String>>();
    	  
    	  if(s.length() ==0) return res;
    	  
    	  for(int i=0; i<s.length(); i++)
    	  {
    		  String curr = s.substring(i, i+1);
    		  if(!res.containsKey(curr))
    		  {
	    		  HashSet<String> path = new HashSet<String>();
	    		  path.add(curr); 
	    		  res.put(curr, path);
    		  }
    	  }
    	  
		  for(int x=2; x<=s.length(); x++)
		  {
	    	  for(int i=0; i<=s.length()-x; i++)
	    	  {
	    			  String curr = s.substring(i, i+x);
	        		  if(!res.containsKey(curr))
	        		  {
	        			  HashSet<String> path = new HashSet<String>();
	        			  for(int k=1; k<curr.length(); k++)
	        			  {
	        				  
	            	   		  HashSet<String> left = res.get(curr.substring(0, k));
	                		  HashSet<String> right = res.get(curr.substring(k, curr.length()));
	                		  for(String l:left)
	                		  {
	                			  for(String r:right)
	                			  {
	                				  if(!path.contains(l+r)) path.add(l+r);
	                				  if(!path.contains(r+l)) path.add(r+l);         	    		  	  
	                			  }
	                		  }
	        			  }
	        			  res.put(curr, path);			    		  
	        		  }		  
	    		  
    		  }
    	  }
    	  
    	  return res;    	  
      }

      public ArrayList<String> wordBreak2(String s, Set<String> dict) {
    	  ArrayList<String> res = new ArrayList<String>();
    	  ArrayList<String> path = new ArrayList<String>();
    	  breakWord(s, dict, path, res);
    	  return res;
      }
      
      private void breakWord(String s, Set<String> dict, ArrayList<String> path, ArrayList<String> res)
      {
    	  if(s.length() ==0) 
    	  {
    		 String r=""; 
    		 for(String p:path)
    		 {
    			 r = r+ (r.length()==0?p:" "+p);
    		 }
    		 res.add(r);
    		 return;
    	  }
    	  
    	  
    	  for(int i=1; i<=s.length(); i++)
    	  {
    		  String curr = s.substring(0, i);
    		  for(String d:dict)
    		  {
    			  if(curr.equals(d))
    			  {
    				  path.add(d); 
    				  breakWord(s.substring(i), dict, path, res);
    				  path.remove(d); 
    			  }
    		  }
    	  }
      }
      
      public ArrayList<String> fullJustify(String[] words, int L) {
    	  ArrayList<String> res = new ArrayList<String>();
    	  String line= "";
    	  for(int i=0; i<words.length; i++)
    	  {
    	      int ll = line.length()==0?words[i].length():line.length()+1+words[i].length();
    		  if(ll<=L)
    		  {
    			  line = line.length()==0?words[i]:line+" "+words[i];
    			 
    		  }else
    		  {
    			  res.add(line);
    			  line=words[i];
    		  }   
    		  if(i==words.length-1) res.add(line);
    	  }
    	  if(res.size() ==0) res.add("");
    	  
    	  for(int i=0; i<res.size()-1; i++)
    	  {
    		  line = res.get(i);
    		  int extra = L-line.length();
    		  String[] w = line.split(" ");
    		  int spaces = w.length==1?extra: extra/(w.length-1);
    		  int mode = w.length==1?0:extra%(w.length-1);
    		  line = w[0];
    		  for(int j=1; j<w.length; j++)
    		  {
    			  if(j<mode)
    				  line = line + dup(spaces+2) + w[j];
    			  else
    				  line = line + dup(spaces+1) + w[j];
    			  
    			  res.set(i, line);
    		  }
    	  }
    	  
    	  line = res.get(res.size()-1);
    	  int extra = L-line.length();
    	  line = line + dup(extra);
    	  res.set(res.size()-1, line);
    	  
    	  return res;
          
      }
      
      private String dup(int n)
      {
    	  String res = "";
    	  for(int i=0; i<n; i++)
    	  {
    		  res += " ";
    	  }
    	  return res;
      }
}

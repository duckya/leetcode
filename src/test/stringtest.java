package test;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class stringtest {
	
	public static void main (String args[]) {
		int a = 20;
		int B[] = {1,2};
		String t = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		stringtest testA =new stringtest();
		//testA.longestPalindrome(t);
		System.out.println(testA.lengthOfLongestSubstring(t));
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
}

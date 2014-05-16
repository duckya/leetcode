package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class test {

	public static void main (String args[]) {
		int A[][] = {{1,2,3},{8,1,4}, {7,6,5}};
		int B[] = {1,2};
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot"); 
		dict.add("cog"); 
		dict.add("dog"); 
		dict.add("tot"); 
		dict.add("hog"); 
		dict.add("hop"); 
		dict.add("pot"); 
		dict.add("dot"); 
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		triangle.add(a);
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(3);
		triangle.add(b);
		
		test testA =new test();
		testA.numDecodings("10");
		System.out.println();
	}

	 public class Interval {
		      int start;
		    int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
	 }
	
	public double findMedianSortedArrays(int A[], int B[]) {
	    int a = A.length;
	    int b = B.length;
	    
	    if((a+b)%2 == 0)
	    {
	        double first = find_K(A, 0, B, 0, (a+b)/2);
	        double second = find_K(A, 0, B, 0, (a+b)/2+1);
	        return (first+second)/2.0;
	        
	    }else
	    {
	        return find_K(A, 0, B, 0, (a+b)/2+1);
	    }
	    
	}
	
	private int find_K(int A[], int startA, int B[], int startB, int k)
	{
	    
	    if(A.length ==0 || A.length <= startA) return B[startB+k-1];
	    if(B.length ==0 || B.length <= startB) return A[startA+k-1];
	    
	    if(k==1)
	    {
	        if(A[startA]<B[startB])
	            return A[startA];
	        else
	            return B[startB];
	    }
	
	    int checkAIndex = k/2;
	    
	    if(startA+checkAIndex > A.length) checkAIndex = A.length -startA;
	    int checkBIndex = k-checkAIndex;
	    checkAIndex--; 
	    checkBIndex--;
	    
	    if(A[startA+checkAIndex] == B[startB+checkBIndex]) return A[startA+checkAIndex];
	    
	    if(A[startA+checkAIndex] < B[startB+checkBIndex]) 
	    {
	        startA += checkAIndex+1;
	        k = k-checkAIndex-1;
	        return find_K(A, startA, B, startB, k);
	    }else
	    {
	        startB += checkBIndex+1;
	        k = k-checkBIndex-1;
	        return find_K(A, startA, B, startB, k);
	    }
	    
	}
	
	public int singleNumberBF(int[] A) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		if(A.length == 1) return A[0];
		for(int i=1; i<A.length; i++)
        {
			if(arrlist.contains(i))
				arrlist.remove(i);
			else
				arrlist.add(i);
        }
		return arrlist.get(0);
	}
	
    public int singleNumber(int[] A) {
		int x=0;
		if(A.length == 1) return A[0];
		
		for(int i=0; i<A.length; i++)
        {
			x=x^A[i];
			System.out.println(x);
        }
		return x;
    }
    
    public int singleNumber2(int[] A) {
       
		if(A.length <= 3) return A[0];
		for(int i=0; i<A.length; i++)
        {

        }
		
		return 0;
    }
	
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> maps= new HashMap<Integer, Boolean>();
        int maxLengh = 0;
        for(int i=0; i<num.length; i++)
        	maps.put(num[i], false);
        
        for(int i=0; i<num.length; i++)
        {
        	if(maps.get(num[i]) ==true) continue;
        	int length=1;
        	int j = num[i]+1;
        	maps.put(num[i], true);
        	while(maps.containsKey(j))
        	{
        		maps.put(j, true);
        		j++;
        		length++;
        	}
        	
        	j = num[i]-1;
        	while(maps.containsKey(j))
        	{
        		maps.put(j, true);
        		j--;
        		length++;
        	}
        	
        	if (length > maxLengh) maxLengh = length;
        	
        }
    	
    	
    	return maxLengh;
    }
    
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++)
        {
        	maps.put(numbers[i], i);
        }
        
        for(int i=0; i<numbers.length; i++)
        {
        	if(maps.containsKey(target-numbers[i])) 
        	{
        		int index1 = i + 1; 
        		int index2 = maps.get(target-numbers[i]) + 1; 
        		
        		if(index1 > index2) 
        		{
        			return new int[]{index2, index1};
        		}
        		else
        			return new int[]{index1, index2};
        	}
        }
		return numbers;
    }
    
    public int[] twoSumBF(int[] numbers, int target) {
        
        for(int i=0; i<numbers.length; i++)
        {
        	for(int j=i+1; j<numbers.length; j++)
        	{
        		if (numbers[i] + numbers[j] == target)
        			return new int[]{i, j};
        	}
        }
        
		return numbers;
    }
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length<3) return result; 
        Arrays.sort(num);
        int lastUniqe = num[0];
        for(int i=0; i<num.length; i++)
        {
        	if(i==0 || num[i] != lastUniqe)
        	{
        		lastUniqe = num[i];
	        	ArrayList<ArrayList<Integer>> two = twoSumInternal(num, 0-num[i], i+1);
	            if( !two.isEmpty()) 
	            {
	            	for(ArrayList<Integer> ele:two)
	            	{
		                ArrayList<Integer> res = new ArrayList<Integer>();
		                res.add(num[i]);
		                res.add(ele.get(0));
		                res.add(ele.get(1));
		                result.add(res); 
	            	}
	  
	            }
            }
        }
         
        return result;
        
    }
    
    private ArrayList<ArrayList<Integer>> twoSumInternal(int[] numbers, int target, int startpos) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(numbers.length<2) return result;
    	HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
    	int lastUniqe = numbers[0];
        for(int i=startpos; i<numbers.length; i++)
        {
        	maps.put(numbers[i], i);
        }
        
        for(int i=startpos; i<numbers.length; i++)
        {
        	if(i==startpos || numbers[i] != lastUniqe)
        	{
        		lastUniqe = numbers[i];
            	if(maps.containsKey(target-numbers[i])&& i< maps.get(target-numbers[i])) 
            	{
            		       		
            		ArrayList<Integer> res = new ArrayList<Integer>();
                    res.add(numbers[i]);
                    res.add(target-numbers[i]);
                    result.add(res); 
            	}
        	}

        }
		return result;
    }
    
    public int threeSumClosest(int[] num, int target) {
    	int result = 0; 
    	int gap = Integer.MAX_VALUE;
        if(num.length<3) return 0;
        
        Arrays.sort(num);
        for(int i=0; i<num.length-2; i++)
        {
	       	int two = twoSumClosest(num, target-num[i], i+1);
	        if(Math.abs(num[i]+two-target) < gap)
	        {
	        	result = num[i]+two;
	        	gap = Math.abs(num[i]+two-target);
	        	if(result==target) return target;
	        }
        }
        
        return result;
    }
    
    private int twoSumClosest(int[] numbers, int target, int startpos) {
    	
    	int result = 0; 
    	int gap = Integer.MAX_VALUE;
    	int start = startpos; 
    	int end = numbers.length -1;
    	
    	while (start<end)
    	{
    		if(Math.abs(numbers[start] + numbers[end] - target) < gap)
    		{
    			gap = Math.abs(numbers[start] + numbers[end] - target);
    			result = numbers[start] + numbers[end]; 
    		}
    		int sum = numbers[start] + numbers[end]; 
			if(sum>target) end--;
			if(sum<target) start ++;
			if(sum==target) return target;
    		
    	}
    	return result;
		
    }

    public int removeElement(int[] A, int elem) {
        int newindex = 0;
        
        for(int i=0; i< A.length; i++)
        {
            if (A[i] != elem)
            {
            	A[newindex] = A[i];
                newindex++;
            }
            
        }
        return newindex;
        
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	
    	Arrays.sort(num);
        for(int i=0; i<num.length-3; i++)
        {
            int a = num[i]; 
            for (int j=i+1; j<num.length-2; j++)
            {
            	int b=num[j];
            	
            	int start = j+1; 
            	int end = num.length-1;
            	
            	while(start < end)
            	{
            		int c = num[start]; 
            		int d = num[end]; 
            		int sum = a + b + c + d; 
            		if(sum == target) 
            		{
            			ArrayList<Integer> res = new ArrayList<Integer>();
            			res.add(a); 
            			res.add(b); 
            			res.add(c); 
            			res.add(d); 
            			results.add(res);
            			start++;
            			end--; 
            		}
            		
            		if(sum>target) end--; 
            		if(sum<target) start++;
            	}
            	
            	
            }
        }
        HashSet<String> unique = new HashSet<String>();
        for(int i=results.size()-1; i>=0; i--)
        {
        	String converted = results.get(i).toString();
        	if(unique.contains(converted))
        	{
        		results.remove(i);
        	}else
        	{
        		unique.add(converted);
        	}
        	
        }
        return results;
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	
    	for(int i=0; i<candidates.length; i++)
    	{
    		
    	}
    	
    	
        HashSet<String> unique = new HashSet<String>();
        for(int i=results.size()-1; i>=0; i--)
        {
        	String converted = results.get(i).toString();
        	if(unique.contains(converted))
        	{
        		results.remove(i);
        	}else
        	{
        		unique.add(converted);
        	}
        	
        }
        return results;
    }

    public void nextPermutation1(int[] num) {
    	if(num.length<=1) return;
    	if(IsLargest(num, 0))
    	{
    		Arrays.sort(num);
    		return;
    	}
    	int startpos=0;
    	while(startpos<num.length)
    	{
    		if(!IsLargest(num, startpos+1))
    		{
    			startpos++;
    		}else
    		{
    			int oldStart = num[startpos];
    			Arrays.sort(num, startpos, num.length);
    			for(int i=startpos; i<num.length; i++)
    			{
    				if(num[i]>oldStart)
    				{
    					int newstart = num[i];
    					for(int j=i; j>startpos; j--)
    					{
    						num[j] = num[j-1];
    					}
    					num[startpos] = newstart;
    					return;
    				}
    			}
    			
    			
    		}
    	}
        
    }
    
    private boolean IsLargest(int[] num, int startPos)
    {
    	if (startPos>=num.length-1) return true;
    	
    	for(int i=startPos; i< num.length-1; i++)
    	{
    		if(num[i] >= num[i+1])
    			continue;
    		else
    			return false;
    	}
    	return true; 
    }

    public void nextPermutation(int[] num) {
    	if(num.length<=1) return;

    	int startpos=num.length-1;
    	while(startpos>0)
    	{
    		if(num[startpos] <= num[startpos-1])
    		{
    			startpos--;
    		}else
    		{
    			
    			for(int i=num.length-1; i>startpos-1; i--)
    			{
    				if(num[i]>num[startpos-1])
    				{
    					int newstart = num[i];
    					num[i] = num[startpos-1];
    					num[startpos-1] =newstart; 
    					Arrays.sort(num, startpos, num.length);
    					return;
    				}
    			}
    			
    			
    		}
    	}
    	
    	Arrays.sort(num);
        
    }

    public String getPermutation(int n, int k) {

    	String result = "";
    	ArrayList<Integer> num = new ArrayList<Integer>();
    	
    	//construct the first element
        for(Integer i=0; i<n; i++)
        {
        	num.add(i+1);
        } 
    	
    	int skipnumber = factorial(n-1);

        for(int i=n; i>1; i-- )
        {
        	int a = k/skipnumber;
        	if(k % skipnumber ==0 && a>0)
        	{
        		a--;
        	}
        	Integer value = num.get(a);
        	result = result + value.toString();
        	num.remove(a);
        		
        	k = k - a*skipnumber;
        	skipnumber = skipnumber/(i-1);
        }

        

        return result + num.get(0);
    }
    
    private int factorial(int n)
    {
    	int result= 1; 
        for(int i=1; i<=n; i++)
        {
        	result *=i;

        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
        return permuteInternal(num, 0);

    }

    private ArrayList<ArrayList<Integer>> permuteInternal(int[] num, int start)
    {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
    	if(start>=num.length-1)
    	{
    		ArrayList<Integer> res = new ArrayList<Integer>();
    		res.add(num[start]); 
    		results.add(res); 
    		return results;
    	} 

    	int i = num[start];
    	ArrayList<ArrayList<Integer>> subResults = permuteInternal(num, start+1);
    	for(ArrayList<Integer> sres:subResults)
    	{
    		for(int j=0; j<=sres.size(); j++)
    		{
    			ArrayList<Integer> res = new ArrayList<Integer>();
    			res.addAll(sres); 
    			res.add(j, i);
    			results.add(res);
    		}		
    	}
    		        	

		return results;
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
        results = permuteInternalUnique(num, 0);
               
        return results;
    }
    
    private ArrayList<ArrayList<Integer>> permuteInternalUnique(int[] num, int start)
    {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
    	if(start>=num.length-1)
    	{
    		ArrayList<Integer> res = new ArrayList<Integer>();
    		res.add(num[start]); 
    		results.add(res); 
    		return results;
    	} 

    	int i = num[start];
    	ArrayList<ArrayList<Integer>> subResults = permuteInternalUnique(num, start+1);
    	for(ArrayList<Integer> sres:subResults)
    	{
    		for(int j=0; j<=sres.size(); j++)
    		{
    			if( j ==sres.size() || i != sres.get(j))
    			{
	    			ArrayList<Integer> res = new ArrayList<Integer>();
	    			res.addAll(sres); 
	    			res.add(j, i);
	    			results.add(res);
    			}
    		}		
    	}
    		        	

		return results;
    }
    
    public boolean isValidSudoku(char[][] board) {
    	
    	Boolean[] used = new Boolean[9];
    	

    	
        for(int i=0; i<9; i++)
        {
        	for(int k=0; k<9; k++)
        		used[k]=false;
        	for(int j=0; j<9; j++)
        	{
        		char value = board[i][j];
        		if(value !='.')
        		{
        			int number = Character.getNumericValue(value);
        			if(used[number] ==false)
        				used[number] = true;
        			else
        				return false;
        		}
        	}
        	
        	for(int k=0; k<9; k++)
        		used[k]=false;
        	for(int j=0; j<9; j++)
        	{
        		char value = board[j][i];
        		if(value !='.')
        		{
        			int number = Character.getNumericValue(value);
        			if(used[number] ==false)
        				used[number] = true;
        			else
        				return false;
        		}
        	}
        	
        }
        
        for(int x=0; x<3; x++)
        {
        	for(int y=0; y<3; y++)
        	{
    			int rstart=x*3;
    			int rend = rstart+ 3;
    			int cstart = y*3;
    			int cend = cstart + 3;
            	for(int k=0; k<9; k++)
            		used[k]=false;
            	
    			for(int i=rstart; i<rend; i++)
    			{
    				for(int j=cstart; j<cend; j++)
    				{
    	        		char value = board[j][i];
    	        		if(value !='.')
    	        		{
    	        			int number = Character.getNumericValue(value);
    	        			if(used[number] ==false)
    	        				used[number] = true;
    	        			else
    	        				return false;
    	        		}
    				}

    			}
    			
        	}
        }
    			

        return true; 
    }

    public int trap(int[] A) {
    	if(A.length<3) return 0;
    	int water = 0; 
    	int maxLeft[] = new int[A.length];
    	maxLeft[0] = 0; 
    	
    	int maxRight[] = new int[A.length];
    	maxRight[A.length-1] = 0;
    	
    	for(int i=1; i<A.length; i++)
    	{
    		if(maxLeft[i-1] < A[i-1])
    		{
    			maxLeft[i] = A[i-1];
    		}else
    		{
    			maxLeft[i] = maxLeft[i-1];
    		}
    	}
    	
    	for(int i=A.length-2; i>=0; i--)
    	{
    		if(maxRight[i+1] < A[i+1])
    		{
    			maxRight[i] = A[i+1];
    		}else
    		{
    			maxRight[i] = maxRight[i+1];
    		}
    	}
    	
    	for(int i=1; i<A.length; i++)
    	{
    		
    		if(Math.min(maxLeft[i], maxRight[i]) > A[i])
    			water += Math.min(maxLeft[i], maxRight[i]) - A[i];
    	}

        return water;
    }

    public int climbStairsRecursion(int n) {
        if(n==1) return 1;
        if (n==2) return 2; 
        return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
    }
    
    public int climbStairs(int n) {
	    if(n==1) return 1;
		if (n==2) return 2; 
		int[] num= new int[n+1];
		num[1] = 1; 
		num[2] = 2;
 		for(int i=3; i<=n; i++)
		{
			num[i] = num[i-1] + num[i-2];
		}
 		return num[n];
	}

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int res = 0;
        candy[0] = 1;
        for(int i=1; i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
               candy[i] =  candy[i-1] + 1;
            }else
            {
                candy[i] = 1; 
            }
  
        }
        for(int i=ratings.length-2; i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
               candy[i] = Math.max(candy[i], candy[i+1] + 1) ;
            }   
        }
        
        for(int i=1; i<ratings.length;i++)
        {
        	res +=candy[i];
        }
        
        return res;
    }
    
    public void rotate(int[][] matrix) {
        int temp = 0;
    	int midWidh = (matrix.length+1)/2;
    	int midHeigh = matrix.length/2;
    	int n = matrix.length;
    	if(n==1) return;
    	for(int i=0; i<midWidh; i++)
    	{
    		for(int j=0; j<midHeigh; j++)
    		{
    		    temp = matrix[j][i];
    			matrix[j][i] = matrix[n-1-i][j];
    			matrix[n-1-i][j] = matrix[n-1-j][n-1-i];
    			matrix[n-1-j][n-1-i] = matrix[i][n-1-j];
    			matrix[i][n-1-j] = temp;
    		}
    	}
    }
    
    public int[] plusOne(int[] digits) {
    	
        for(int i=digits.length-1; i>=0; i--)
        {
        	if(digits[i] ==9)
        	{
        		digits[i] = 0;
        	}else
        	{
        		digits[i] ++;
        		return digits;
        	}
        }
        int[] result = new int[digits.length+1];
        
        Arrays.fill(result, 0);
        result[0] = 1;
       
        return digits;
    }
    
    public void setZeroes(int[][] matrix) {
      boolean[] row = new boolean[matrix.length]; 
      boolean[] col = new boolean[matrix[0].length]; 
      
      for(int i=0; i<matrix.length; i++)
      {
          for(int j=0; j<matrix[i].length; j++)
          {
        	  if(matrix[i][j] ==0)
        	  {
        		  row[i] = true; 
        		  col[j] = true;
        	  }
          }
      }
        
      for(int i=0; i<matrix.length; i++)
      {
    	  for(int j=0; j<matrix[i].length; j++)
          {
    		  if(row[i] || col[j])
    			  matrix[i][j]=0;
          }
      }
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int start = 0; 
        int end = matrix.length-1;
        int row=0;
        
    	while(start<=end)
    	{
    		int midrow = (start + end)/2;
    		if(target<matrix[midrow][0])
    		{
    			end = midrow-1;
    		}else if(target>=matrix[midrow][0] && (midrow==matrix.length-1 || target<matrix[midrow+1][0]))
    		{
    			row = midrow; 
    			break;
    		}else
    		{
    			start = midrow++;
    		}
    	}
    	start = 0;
    	end = matrix[0].length-1;
    	while(start<=end)
    	{
    		int mid = (start + end)/2;
    		if(target<matrix[row][mid])
    		{
    			end = mid-1;
    		}else if(target==matrix[row][mid])
    		{
    			return true;
    		}else
    		{
    			start = mid+1;
    		}
    	}
    	
    	return false;
    	
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0; 
        int end = matrix.length *matrix[0].length-1;
        int row=0;
        
    	while(start<=end)
    	{
    		int mid = (start + end)/2;
    		int x = mid/matrix[0].length;
    		int y = mid % matrix[0].length;
    		if(target<matrix[x][y])
    		{
    			end = mid-1;
    		}else if(target==matrix[x][y])
    		{
    			return true;
    		}else
    		{
    			start = mid+1;
    		}
    	}
    	/*start = 0;
    	end = matrix[0].length-1;
    	while(start<=end)
    	{
    		int mid = (start + end)/2;
    		if(target<matrix[row][mid])
    		{
    			end = mid-1;
    		}else if(target==matrix[row][mid])
    		{
    			return true;
    		}else
    		{
    			start = mid++;
    		}
    	}*/
    	
    	return false;
    	
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1; 
        int n = gas.length;
        int total = 0;
        int[] gap = new int[n];
        for(int i=0, j=0; i<n; i++, j++)
        {
        	if(i==0)
        		gap[i] = gas[i] - cost[i];
        	else
        		gap[i] = gap[i-1] + gas[i] - cost[i];
        	total += gas[i] - cost[i]; 
        }
        
        if(total<0)
        	return res;
        {
        	int least = gap[0];
        	res = 0;
        	for(int i=1; i<n; i++)
        	{
        		if(gap[i] <= least)
        		{
        			least = gap[i];
        			res = i;
        		}
        	}
        	res = res + 1;
        	if(res == n) res =0;
        	return res;
        }
    }
    
    public int largestRectangleAreaTLE(int[] height) {
        int [] area = new int[height.length];
        int [] area2 = new int[height.length];
    	for(int i=0; i<height.length; i++)
    	{
    		int left = height[i];
    		int unit = 1; 
    		for(int j=i+1; j<height.length; j++)
    		{
    			if(height[j]>=left)
    			{
    				unit++; 
    				if(j==height.length-1)
    				{
    					area[i] = unit*left;
    				}
    			}
    			else
    			{
    				area[i] = unit*left;
    				break;
    			}	
    		}
    	}
    	
    	for(int i=height.length-1; i>=0; i--)
    	{
    		int right = height[i];
    		int unit = 1; 
    		for(int j=i-1; j>=0; j--)
    		{
    			if(height[j]>=right)
    			{
    				unit++; 
    				if(j==0)
    				{
    					area2[i] = unit*right;
    				}
    			}
    			else
    			{
    				area2[i] = unit*right;
    				break;
    			}	
    		}
    	}
    	
    	int max = 0; 
    	for(int i=0; i<height.length; i++)
    	{
    		int larger = Math.max(area[i], area2[i]);
    		if(larger > max)
    			max = larger; 
    	}
    	
    	return max;
    }

    public void merge(int A[], int m, int B[], int n) {
    	int i=m-1,j=n-1, k=m+n-1;
        while(i>=0 && j>=0)
        {
        	if(A[i] > B[j])
        	{
        		A[k] = A[i]; 
        		i--;
        	}else
        	{
        		A[k] = B[j]; 
        		j--;
        	}
        	k--;
        }
        
        while(j>=0)
        {
    		A[k] = B[j]; 
    		j--;
    		k--;
        }

    }

    public int firstMissingPositive(int[] A) {
    	for(int i =1; i<=A.length; i++)
    	{
    		int j;
    		for(j=0; j<A.length; j++)
    		{
    			if(A[j] == i) break;
    		}
    		if(j==A.length) return i;
    	}
    	return A.length+1;
    }
    
    public void sortColors(int[] A) {
    	quicksort(A, 0);
    	quicksort(A, 1);
    }
    
    private void quicksort(int[] A, int mid)
    {
    	int i=0, j=A.length-1;
    	while(i<j)
    	{
    		if(A[i]<=mid)
    			i++;
    		else if(A[j]>mid)
    			j--;
    		else{
    			int t = A[i];
    			A[i] = A[j]; 
    			A[j] = t;
    			
    			i++; 
    			j--;
    		}
    	}
    	
    }
    
    public int[] searchRange(int[] A, int target) {
        int l=0, r=A.length-1, mid=A.length/2;
        boolean bfound = false;
        while(l<=r)
        {
        	if(A[mid]<target)
        	{
        		l=mid+1; 
        		mid=(l+r)/2;
        	}else if(A[mid]>target)
        	{
        		r=mid-1;
        		mid=(l+r)/2;
        	}else
        	{
        		bfound =  true;
        		break;
        	}
        }
        
        if(!bfound) 
        {
        	int[] res = {-1, -1};
        	return res;
        }
        int min = mid, max = min;
        while(min>=0 && A[min] == target)
        {
        	min--;
        }
        while(max<A.length && A[max] == target)
        {
        	max++;
        }
        int[] res = {min+1, max-1};
        return res;
    }

    public int searchInsert(int[] A, int target) {
    	int l=0, r=A.length-1, mid=A.length/2;
        while(l<=r)
        {
        	if(A[mid]<target)
        	{
        		l=mid+1; 
        		mid=(l+r)/2;
        	}else if(A[mid]>target)
        	{
        		r=mid-1;
        		mid=(l+r)/2;
        	}else
        	{
        		return mid;
        	}
        }
        
        if(A[mid]>target) 
        	return mid;
        else
        	return mid+1;
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return subsets(S, 0);
    }
    
    private ArrayList<ArrayList<Integer>> subsets(int[] S, int startpos)
    {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(startpos == S.length-1)
    	{
    		ArrayList<Integer> t = new ArrayList<Integer>();
    		t.add(S[startpos]);
    		res.add(t);
    		
    		res.add(new ArrayList<Integer>());
    	}else
    	{
    		ArrayList<ArrayList<Integer>> r = subsets(S, startpos+1);
    		res.addAll(r);
    		for(ArrayList<Integer> rt:r)
    		{
    			ArrayList<Integer> t = new ArrayList<Integer>();
    			t.add(S[startpos]);
    			t.addAll(rt);
    			if(!res.contains(t))res.add(t);
    		}
    	}
    	
    	return res;
    	
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        return subsetsWithDup(num, 0);
    }
    
    private ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S, int startpos)
    {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(startpos == S.length-1)
    	{
    		ArrayList<Integer> t = new ArrayList<Integer>();
    		t.add(S[startpos]);
    		res.add(t);
    		
    		res.add(new ArrayList<Integer>());
    	}else
    	{
    		ArrayList<ArrayList<Integer>> r = subsetsWithDup(S, startpos+1);
    		res.addAll(r);
    		int prenumber = 0;

    		int i = startpos+1;
    		while(i<S.length && S[i]==S[startpos])
    		{
    			i++;
    			prenumber++;
    		}
    		for(ArrayList<Integer> rt:r)
    		{
    			if(prenumber==0 || (rt.size() >= prenumber && rt.get(prenumber-1)==S[startpos])){
	    			ArrayList<Integer> t = new ArrayList<Integer>();
	    			t.add(S[startpos]);
	    			t.addAll(rt);
	    			res.add(t);
    			}
    		}
    	}
    	
    	return res;
    	
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	if(k==0 || k>n) return res;
    	if(k==1) 
    	{
    		for(int i=1; i<=n; i++)
    		{
    			ArrayList<Integer> t = new ArrayList<Integer>();
    			t.add(i);
    			res.add(t);
    		}
    		return res;
    	}
    	ArrayList<ArrayList<Integer>> res1 = combine(n-1, k);
    	ArrayList<ArrayList<Integer>> res2 = combine(n-1, k-1);
    	res.addAll(res1);
    	
    	for(ArrayList<Integer> r:res2)
    	{
    		r.add(n);
    		res.add(r);
    	}
    	
    	return res;
    }

    public double pow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;
        
        double res = pow(x, n/2);
    	return res * res * pow(x, n-(n/2)*2);
    }
    
    public int sqrt(int x) {
    	if(x<=1) return x;
    	int l=1, r=x/2, mid, res=0;
    	
    	while(l<=r)
    	{
    		mid = (l+r)/2;
    		if(x/mid == mid)
    			return mid;
    		else if(x/mid < mid)
    			r=mid-1;
    		else{
    			l=mid+1;
    			res = mid;
    		}
    	}

    	return res;
    }
    
    public boolean canJump(int[] A) {
    	if(A.length<=1) return true;
    	int reach = 1;
        for(int i=0; i<A.length-1; i++)
        {
        	reach = Math.max(reach-1, A[i]);
        	if(reach<=0) return false;
        }
        
        return reach >=0;
    	
    }
    
    public int jump(int[] A) {
    	if(A.length<=1) return 0;
    	int left = 1;
    	int end =  A[0];
    	int step = 1; 
        while(end<A.length)
        {
        	int max = 0;
        	int i = left;
        	for(i=left; i<=end; i++)
        	{
        		if(i>=A.length-1) return step;
        		max = Math.max(max, i+A[i]);
        	}
        	step++;
        	left = i;
        	end = max;
        }
        	
        
        return step;
    }
    
    public int maxProfit1(int[] prices) {
        if(prices.length<=1) return 0;
    	
        int min=prices[0];
        int gap = 0;
        
        for(int i=1; i<prices.length; i++)
        {
        	min = Math.min(min, prices[i]);
        	gap = Math.max(gap, prices[i]-min);
        }
        
        return gap;
    }
    
    public int maxProfit2(int[] prices) {
        if(prices.length<=1) return 0;
    	
        int min=prices[0];
        int gap = 0;
        
        for(int i=1; i<prices.length; i++)
        {
        	if(prices[i]<prices[i-1])
        		min = Math.min(min, prices[i]);
        	else
        		gap += prices[i]-prices[i-1];
        }
        
        return gap;
    }
    
    public int maxProfit(int[] prices) {
        int sum = 0;
    	for(int i=1; i<prices.length-1; i++)
    	{
    		int[] left = Arrays.copyOfRange(prices, 0, i);
    		int[] right = Arrays.copyOfRange(prices, i, prices.length);
    		sum = Math.max(sum, maxProfit1(left)+ maxProfit1(right));
    	}
    	return sum;
    }
    
    public int maxArea(int[] height) {
    	if(height.length<=1) return 0;
    	
    	int left = 0;
    	int right = height.length-1;
    	int max = 0;
    	while(left<right)
    	{
    		int t = Math.min(height[left], height[right]);
    		max = Math.max(max, t*(right-left));
    		if(height[left] <= height[right]) 
    			left++;
    		else
    			right--;
    	}
    	return max;
        
    }
    
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	 
        if (dict.size() == 0)  
            return 0; 
 
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
 
        wordQueue.add(start);
        distanceQueue.add(1);
 
 
        while(!wordQueue.isEmpty()){
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();
 
            if(currWord.equals(end)){
                return currDistance;
            }
 
            for(int i=0; i<currWord.length(); i++){
                char[] currCharArr = currWord.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;
 
                    String newWord = new String(currCharArr);
                    if(newWord == end) return currDistance+1;
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance+1);
                        dict.remove(newWord);
                    }
                }
            }
        }
 
        return 0;
    }
    
    public ArrayList<ArrayList<String>> findLaddersETL(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    	HashMap<String, ArrayList<ArrayList<String>>> path = new HashMap<String, ArrayList<ArrayList<String>>>();
    	HashSet<String> used = new HashSet<String>();
    	if(dict.size() ==0 || start==end) return res;
    	
    	ArrayList<String> word = new ArrayList<String>();
    	word.add(start);
    	ArrayList<Integer> step = new ArrayList<Integer>();
    	step.add(0);
    	
    	ArrayList<String> pathSteps = new ArrayList<String>();
    	pathSteps.add(start);
    	ArrayList<ArrayList<String>> pathList = new ArrayList<ArrayList<String>>();
    	pathList.add(pathSteps);
    	path.put(start, pathList);
    	
    	int minStep = -1;
    	int level = 0;
    	
    	while(word.size()>0)
    	{
    		String currentWord = word.get(0);
    		word.remove(0);
    		
    		Integer currentStep = step.get(0);
    		step.remove(0);
    		if(currentStep>level)
    		{
    			level = currentStep;
    			dict.removeAll(used);
    		}
    		
   		 	if(currentStep+1>minStep && minStep >0) break;
    		for(int i=0; i<currentWord.length(); i++)
    		{
    			for(char c='a'; c<='z'; c++)
    			{
    				char[] wordArray = currentWord.toCharArray();
    				if(c==wordArray[i]) continue; 
    				wordArray[i] = c;
    				
    				
    				String newword =new String(wordArray);
    				if(newword.equals(end))
    				{
    					minStep = currentStep+1;  
    				}
    				if(dict.contains(newword)  || newword.equals(end))
    				{
    					word.add(newword);
    					step.add(currentStep+1);
    					used.add(newword);
    					
    					
    					ArrayList<ArrayList<String>> oldList = path.get(currentWord);
    					ArrayList<ArrayList<String>> newlist = new ArrayList<ArrayList<String>>();
    					if(path.containsKey(newword))
    					{
    						newlist = path.get(newword);
    					}	
    					
    					for(ArrayList<String> steps:oldList)
    					{
    						ArrayList<String> newSteps = new ArrayList<String>();
    						newSteps.addAll(steps);
    						newSteps.add(newword);
    						newlist.add(newSteps);
    					}
    					if(!path.containsKey(newword))
    						path.put(newword, newlist);
    					
    				}
    			}
    		}
    		
    		
    	}
    	if(path.containsKey(end)) res = path.get(end);
    	
    	return res;
    	
    }
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, HashSet<String>> visited = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> level = new HashMap<String, Integer>();
        LinkedList<String> queue = new LinkedList<String>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if(start == null || end == null || start.length()!=end.length()) return result;

        HashSet<String> path = new HashSet<String>();
        int minLen = Integer.MAX_VALUE;
        visited.put(start, path);//only difference from word ladder I
        level.put(start, 1);
        queue.add(start);

        while(!queue.isEmpty()){
        	String head = queue.remove();
        	char[] chars = head.toCharArray();
        	for(int i = 0; i < head.length(); i++){
        		char old = chars[i];
        		for(char letter = 'a'; letter <= 'z'; letter++){
        			chars[i] = letter;
        			String nextWord = new String(chars);
					//two possible situations
					//level does not contain nextWord
					//level contains nextWord and near the start
        			if(dict.contains(nextWord) && (!level.containsKey(nextWord)
        				|| (level.containsKey(nextWord) && level.get(nextWord) > level.get(head)))){
        					//we update the path, visited, level
        				if(visited.containsKey(nextWord)){
        					visited.get(nextWord).add(head);
        				}else{
        					path = new HashSet<String>();
        					path.add(head);
        					visited.put(nextWord, path);
        					level.put(nextWord, level.get(head) + 1);
        					queue.add(nextWord);
        				}
        			}

        			if(nextWord.equals(end)){
        				if(level.get(head) < minLen){
        					ArrayList<String> entry = new ArrayList<String>();
        					entry.add(end);
        					result.addAll(backtrace(head,visited,entry));
        					minLen = level.get(head)+1;
        				}else{
        					break;
        				}
        			}
        			chars[i] = old;

        		}
        	}
        }
        return result;
	}
	
	private ArrayList<ArrayList<String>> backtrace(String end,
		HashMap<String, HashSet<String>> visited, ArrayList<String> path) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> entry = new ArrayList<String>(path);
		entry.add(0,end);
		if(visited.get(end).size()<1){
			result.add(entry);
			return result;
		}
		
		for(String str : visited.get(end)){
			result.addAll(backtrace(str,visited,entry));
		}
		return result;
	}
	
    public void solve(char[][] board) {
    	
    	if(board.length==0 || board[0].length==0) return;
    	
        int length  = board.length; 
        int width = board[0].length;
        ArrayList<Integer> Iindexes =new ArrayList<Integer>();
        ArrayList<Integer> Jindexes =new ArrayList<Integer>();
        
    	for(int i=0; i<length; i++) 
    	{
    		for(int j=0; j<width; j++) 
    		{
    			if(board[i][j] == 'O' && (i==0||i==length-1||j==0||j==width-1))
    			{
    				Iindexes.add(i);
    				Jindexes.add(j);
    				
    			}else
    				continue;
    		}
       	}

    	while(!Iindexes.isEmpty())
		{
			int x = Iindexes.get(0);
			int y = Jindexes.get(0);
			Iindexes.remove(0);
			Jindexes.remove(0);
			board[x][y] = 'p';
			if(x>0 && board[x-1][y] == 'O') 
			{
				Iindexes.add(x-1);
				Jindexes.add(y);
			}
			if(x<length-1 && board[x+1][y] == 'O') 
			{
				Iindexes.add(x+1);
				Jindexes.add(y);
			}
			if(y>0 && board[x][y-1] == 'O') 
			{
				Iindexes.add(x);
				Jindexes.add(y-1);
			}
			if(y<width-1 && board[x][y+1] == 'O') 
			{
				Iindexes.add(x);
				Jindexes.add(y+1);
			}
		}
    	 
    	for(int i=0; i<length; i++) 
    	{
    		for(int j=0; j<width; j++) 
    		{
    			if(board[i][j] =='o'|| board[i][j] == 'O')board[i][j] = 'X';
    			if(board[i][j] =='p')board[i][j] = 'O';	
    		}
    	}
    	
    }
    
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	   	
    	if(triangle.size() ==0) return 0;
    	int[] minvalues = new int[triangle.size()];
    	int min = Integer.MAX_VALUE;
    	for(int row =0; row<triangle.size(); row ++)
    	{
	    	for(int index = triangle.get(row).size()-1; index >=0; index--)
	    	{
	    		int res = getMin(row, index, triangle, minvalues);
	    		if(row==triangle.size()-1)
	    		{
	    			min = Math.min(min, res);
	    		}
	    		
	    	}
    	}
    	return min;
    }
    
    private int getMin(int row, int index, ArrayList<ArrayList<Integer>> triangle, int[] minvalues)
    {
    	
    	int val = triangle.get(row).get(index);
    	int minvalue = 0;
    	if(row == 0)
    	{
    		minvalue = val; 
    	}else
    	{
    		if(index==0)
    		{
    			minvalue = minvalues[index] + val; 
    		}
    		else if(index==triangle.get(row).size()-1)
    		{
    			minvalue = minvalues[index-1] + val; 
    		}
    		else 
	    	{
	    		minvalue = Math.min(val+minvalues[index], val+minvalues[index-1]);
	    	}
    	}
    	
    	minvalues[index] = minvalue;
    	return minvalue;
    }
    
    public int maxSubArray(int[] A) {
    	int[] largest = new int[A.length];
    	largest[0] = A[0];
    	
    	for(int i=1; i<A.length; i++)
    	{
    		if(largest[i-1]<0)
    		{
    			largest[i] = A[i];
    		}else
    		{
    			largest[i] = largest[i-1]+A[i];   			
    		}
    		
    	}
        int max = A[0];
    	for(int i=1; i<A.length; i++)
    	{
    		max = Math.max(max,  largest[i]);
    	}
    	
    	return max;
    }
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	for(int i=0; i<numRows; i++)
    	{
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		row.add(1);
    		if(i>0)
    		{
    			ArrayList<Integer> prevrow = res.get(i-1);
    			for(int j=1; j<prevrow.size(); j++)
    			{
    				row.add(prevrow.get(j-1)+prevrow.get(j));
    			}
    			row.add(1);
    		}
    		res.add(row);
    	}
    	
    	return res;
        
    }
    
    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	
    	for(int i=0; i<rowIndex+1; i++)
    	{
    		res.add(0, 1);

    		for(int j=1; j<res.size()-1; j++)
    		{
     			res.set(j, res.get(j+1)+res.get(j));
    		}   		
    	}  	
    	return res;	
    }
    
    public int minPathSum(int[][] grid) {
    	int[][] sum = new int[grid.length][grid[0].length];
    	sum[0][0] = grid[0][0];
    	for(int i=1; i<grid.length; i++)
    		sum[i][0] = grid[i][0] + sum[i-1][0];
    	
    	for(int j=1; j<grid[0].length; j++)
    		sum[0][j] = grid[0][j] + sum[0][j-1];
    	
    	for(int i=1; i<grid.length; i++)
    	{
    		for(int j=1; j<grid[i].length; j++)
    		{
    			sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1])+ grid[i][j];
    			
    		}
    	}
    	return sum[grid.length-1][grid[0].length-1];
    }
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
   	 ArrayList<Integer> res = new ArrayList<Integer>();
   	 if(matrix.length==0 || matrix[0].length==0) return res;
   	
   	int left = 0, top = 0; 
       int right = matrix[0].length, bottom = matrix.length;
      
       while(top<bottom&&left<right)
       {
       	loop(matrix, res, left, top, right, bottom);
       	left++;
       	right--;
       	top++;
       	bottom--;
       }
       return res;
   }
   
   private void loop(int[][] matrix, ArrayList<Integer> res, int left, int top, int right, int bottom)
   {
   	for(int j=left; j<right; j++)
      		res.add(matrix[top][j]);
   	for(int i=top+1; i<bottom; i++)
      		res.add(matrix[i][right-1]);
       
   	for(int j=right-2; j>=left && top<bottom-1; j--)
      		res.add(matrix[bottom-1][j]);
   	for(int i=bottom-2; i>top && left<right-1; i--)
      		res.add(matrix[i][left]);
   }
   
   public int[][] generateMatrix(int n) {
	   int[][] res = new int[n][n];
	   int size = n;
	   int startNumber = 1;
	   int startpos = 0;
	   while(size>0)
	   {
		   loop(res, startpos, size, startNumber);
		   
		   startNumber= startNumber+(size-1)*4;
		   startpos++;
		   size=size-2;
	   }
	   
       return res;
   }
    
   private void loop(int[][] res, int startpos, int size, int startNumber)
   {
	   if(size==1) 
	   {
		   res[startpos][startpos] = startNumber;
		   return;
	   }
	   for(int j=startpos; j<startpos+size-1; j++, startNumber++)
	   		res[startpos][j]=startNumber;
	   
	   for(int i=startpos; i<startpos+size-1; i++, startNumber++)
   		   res[i][startpos+size-1]=startNumber;
	   
	   for(int j=startpos+size-1; j>startpos; j--, startNumber++)
	   		res[startpos+size-1][j]=startNumber;
	   
	   for(int i=startpos+size-1; i>startpos; i--, startNumber++)
   		   res[i][startpos]=startNumber;
   }
   
   public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	   if(intervals.size() == 0)
	   {
		   intervals.add(newInterval);
		   return intervals;
	   }
	   boolean bMerged = false;
	   
	   for(int i=0; i<intervals.size(); i++){
		   if(!bMerged && intervals.get(i).end<newInterval.start)
		   {
			   if(i==intervals.size()-1) intervals.add(newInterval);
			   continue;
		   }
		   if(intervals.get(i).start>newInterval.end)
		   {
			   if(!bMerged) intervals.add(i, newInterval);
			   break;
		   }
		   if(bMerged)
		   {
			   intervals.get(i-1).end = Math.max(newInterval.end, intervals.get(i).end);
			   intervals.remove(i);
			   i--;
		   }
		   if(!bMerged && intervals.get(i).end>=newInterval.start)
		   {
			   intervals.get(i).end = Math.max(newInterval.end, intervals.get(i).end);
			   bMerged = true;
		   }
		   if(intervals.get(i).start<=newInterval.end)
		   {
			   intervals.get(i).start = Math.min(newInterval.start, intervals.get(i).start);
			   bMerged = true;
		   }

			   
	   }
	   return intervals;
   }
   
   public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	   if(intervals.size() <=1) return intervals;
	   ArrayList<Interval> res =new ArrayList<Interval>();
	   res.add(intervals.get(0));
       for(int i=0; i<intervals.size(); i++)
       {
    	   res = insert(res, intervals.get(i));
       }
       return res;
   }
   
   public int minDistance(String word1, String word2) {
	   
	   if(Math.min(word1.length(), word2.length()) ==0 ) return Math.max(word1.length(), word2.length());
	   
       int[][] min1 = new int[word1.length()][word2.length()];
       
       return getMin(word1, word2, min1, 0, 0);
   }
   
   private int getMin(String word1, String word2, int[][] min1, int index1, int index2) {
       if(index1==word1.length()) 
       {   
    	   for(int j=index2; j<word2.length(); j++) 
    		   min1[index1][j] = word2.substring(index2+1).length();
    	   return word2.substring(index2).length();
       }else if(index2==word2.length()) 
       {   
    	   for(int j=index1; j<word1.length(); j++) 
    		   min1[j][index2] = word1.substring(index1+1).length();
    	   return word1.substring(index1).length();
       }
       
       int first = 0;
       if(min1[index1+1][index2+1]>0) 
    	   first = min1[index1+1][index2+1];
       else
    	   first = getMin(word1, word2, min1, index1+1, index2+1);
       
       int sec = 0;
       if(min1[index1+1][index2]>0) 
    	   sec = min1[index1+1][index2];
       else
    	   sec = getMin(word1, word2, min1, index1+1, index2);
       
       int third = 0;
       if(min1[index1][index2+1]>0) 
    	   third = min1[index1][index2+1];
       else
    	   third = getMin(word1, word2, min1, index1, index2+1);
       
       int sum = Math.min(third, Math.min(first, sec))+1;
       min1[index1][index2] = sum;
       
       return sum;
   }
   
    
   public int numDecodings(String s) {
	   if(s.length() == 0) return 0;
	   int[] num = new int[s.length()];
	 
	   if(s.charAt(0)>'0') 
		   num[0]=1;
	   else 
		   num[0]=0;
	   
	   for(int i=1; i<s.length(); i++)
	   {
		   int path1 = 0, path2=0;
		   
		   if(s.charAt(i)>'0') path1 = num[i-1];
		   
		   if((s.charAt(i)<='6' && s.charAt(i-1)=='2' ) || s.charAt(i-1)=='1')
		   {
		       if(i==1)
		        path2 = 1;
		       else
			    path2 = num[i-2];
		   }
		   num[i] = path1+path2;
	   }
       
	   return num[s.length()-1];
   }

}


package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class test {

	public static void main (String args[]) {
		int A[] = {1};
		int B[] = {1,2};
		
		test testA =new test();
		testA.searchRange(A,1);
		System.out.println();
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
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=S.length; i++)
        {
        	
        }
        for(int s:S)
        {
        	ArrayList<Integer> t = new ArrayList<Integer>();
        	t.add(s);
        	res.add(t);		
        }
        
        return res;
    }
}


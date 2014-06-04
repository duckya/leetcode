package test;

import java.util.ArrayList;
import java.util.Collections;

public class algcheatsheet {
	
	public static void mergeSort(int[] a){  
        int[] temp = new int[a.length];  
        int[][] matrix = new int[a.length][a.length];  
        
        
        mergeSort(a,temp,0,a.length-1); 
        quickSort(a, 0, a.length-1);
        doInsertionSort(a);
        
        
        binarySearch(a, 1);
        recursiveBinarySearch(a, 0, a.length-1, 1);
        searchinRotatedArray(a,1);
        searchinRotatedArrayWithDup(a, 1);
        search2DMatrix(matrix, 1);
        
        ArrayList<String> list = new ArrayList<String>();
        Collections.sort(list);
    }  
	
    public static boolean search2DMatrix(int[][] matrix, int target) {
        
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
    			start = midrow+1;
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
	
    public static boolean searchinRotatedArrayWithDup(int[] A, int target) {
        int start = 0; 
        int end=A.length-1; 
        int mid; 
        
        while(start<=end)
        {
            mid=(start+end)/2;
            if(A[mid]==target) return true; 
            
            if(A[start]<A[mid])
            {
                if(target >= A[start] && target < A[mid])
                    end = mid-1;
                else
                    start = mid+1;
                
            }else if(A[start]>A[mid])
            {
                if(target > A[mid] && target <= A[end])
                    start = mid+1; 
                else
                    end = mid-1;
                   
            }else
            {
                start++;
            }
            
        }
        return false;
        
    }
	
    public static int searchinRotatedArray(int[] A, int target) {
        int start = 0; 
        int end = A.length-1;
        int mid;
        
        while(start<=end)
        {
            mid = (start+end)/2;
            if(A[mid] == target)
                return mid;
            else
            {
                if(A[start]<=A[mid])
                {
                    if(target<A[start] || target >A[mid])
                        start = mid+1; 
                    else
                        end = mid-1;
                }else
                {
                    if(target<A[mid] || target >A[end])
                        end = mid-1;
                    else
                        start = mid+1; 
                }
            }
            
        }
        
        return -1;
        
    }
	
    public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
        
        if (start < end) {
            int mid = start + (end - start) / 2;  
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid, key);
                 
            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);
                 
            } else {
                return mid;   
            }
        }
        return -(start + 1);  
    }
	
    public static int binarySearch(int[] inputArr, int key) {
        
        int start = 0;
        int end = inputArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == inputArr[mid]) {
                return mid;
            }
            if (key < inputArr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
	
    private static void quickSort(int[] inputArr, int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = inputArr[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            while (inputArr[i] < pivot) {
                i++;
            }
            while (inputArr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(inputArr, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(inputArr, lowerIndex, j);
        if (i < higherIndex)
            quickSort(inputArr, i, higherIndex);
    }
 
    private static void exchangeNumbers(int[] inputArr, int i, int j) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = temp;
    }
      
    private static void mergeSort(int[] a, int[] temp, int left, int right) {  
        if(left<right){  
            int center = (left + right)/2;  
            mergeSort(a,temp,left,center);  
            mergeSort(a,temp,center+1,right);  
            merge(a,temp,left,center+1,right);  
        }  
    }  
    
    private static void merge(int[] a, int[] temp, int leftpos, int rightpos, int rightend) {  
        int leftend = rightpos-1;                
        int temppos = leftpos;                   
        int sum = rightend - leftpos+1;         
        
        while(leftpos<=leftend&&rightpos<=rightend)  
            if(a[leftpos]<a[rightpos])  
                temp[temppos++] = a[leftpos++];  
            else  
                temp[temppos++] = a[rightpos++];  
        while(leftpos<=leftend)  
            temp[temppos++] = a[leftpos++];  
        while(rightpos<=rightend)  
            temp[temppos++] = a[rightpos++];  
        
        for(int i = 0;i<sum;i++,rightend--)  
            a[rightend] = temp[rightend];  
    }  
		
    public static int[] doInsertionSort(int[] input){
        
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }

}

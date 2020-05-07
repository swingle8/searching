//https://practice.geeksforgeeks.org/problems/kth-smallest-element/0#_=_
// Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
// Expected Time Complexity: O(n)
// 
// Input:
// The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.
// 
// Output:
// Corresponding to each test case, print the kth smallest element in a new line.
// 
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 105
// 1 <= arr[i] <= 105
// 1 <= K <= N
// 
// Example:
// Input:
// 2
// 6
// 7 10 4 3 20 15
// 3
// 5
// 7 10 4 20 15
// 4
// Output:
// 7
// 15
// 
// Explanation:
// Testcase 1: 3rd smallest element in the given array is 7.
// Testcase 2: 4th smallest elemets in the given array is 15.

// Approach : 
// We are using Binary Search here instead of sorting and geting the element.
// First of all we are figuring out the smallest and largest number in the array because this is defined as our answer range.
// We need to apply binary search in the above defined range
// from the above range, we are calculating the mid element.
// We are trying to get the count of number which are smaller than equal to mid element in the Array.
// and fix our answer as the mid element.
// if k > count, then we need to increase the smaller count by increasing the value of mid.
// if k < count, then we can easily set our answer as mid, and try to figure out the next mid by setting r as mid-1


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    
	    while (cases --> 0) {
	        int len = sc.nextInt();
	        int [] A = new int[len];
	        int smallest = Integer.MAX_VALUE;
	        int largest = Integer.MIN_VALUE;
	        for (int i = 0 ; i < len ; i++) {
	            A[i] = sc.nextInt();
	            if (A[i] < smallest)
	                smallest = A[i];
	           if (A[i] > largest)
	                largest = A[i];
	        }
	       int k = sc.nextInt();
	        System.out.println(getKsmallest(A, len, k, smallest, largest));
	    }
	 }
	 
	 public static int getKsmallest (int [] A, int len, int k, int sm, int lar) {
	    int l = sm;
	    int r = lar;
	    int ans = l;
	    while (l <= r) {
	        int mid = l + ((r-l)/2);
	        int count = smallerthanMid( A, mid);
	        
	        if (count < k) {
	            l = mid+1;
	        }
	        else if (count >= k) {
	            ans = mid;
	            r = mid-1;
	        }
	        
	    }
	    return ans;
	 }
	 
	 public static int smallerthanMid (int [] A, int mid) {
	     int count = 0;
	     for (int i = 0 ; i < A.length ; i ++) {
	         if (A[i] <= mid)
	            count++;
	     }
	     
	     return count;
	 }
}
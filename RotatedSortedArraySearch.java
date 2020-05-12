// # Rotated Sorted Array Search
// # Problem Description
// # Given a sorted array of integers A of size N and an integer B. array A is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ). You are given a target value B to search. If found in the array, return its index, otherwise return -1. You may assume no duplicate exists in the array. 
// # 
// # 
// # Problem Constraints
// # 1 <= N <= 1000000 1 <= A[i] <= 10^9 all elements in A are disitinct. 
// # 
// # 
// # Input Format
// # The first argument given is the integer array A.The second argument given is the integer B.
// # 
// # 
// # Output Format
// # Return index of B in array A, otherwise return -1
// # 
// # 
// # Example Input
// # Input 1:
// # A = [4, 5, 6, 7, 0, 1, 2, 3]
// # B = 4
// #   Input 2:      
// # A = [1]
// # B = 1
// #     
// # 
// # 
// # Example Output
// # Output 1:
// #  0
// #   Output 2:      
// #  0
// #     
// # 
// # 
// # Example Explanation
// # Explanation 1:
// #  
// # Target 4 is found at index 0 in A.
// #   Explanation 2:      
// #  
// # Target 1 is found at index 0 in A.



public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
        //  figure out the peak
        int n = A.length;
        int low = 0;
        int high = n-1;
        int switchLow = 0;
        while (low <= high) {
            int mid = low + ((high - low)/2);
            if (mid > A[high])
                low = mid + 1;
                
            else if (mid < A[high])
                high = mid-1;
            
            else {
                switchLow = mid;
                break;
            }
        }
        
        if (switchLow == 0)
            return Bsearch (A, 0, n-1, B);
        else if (A[0] > B)
            return Bsearch (A, switchLow, n-1, B);
        else if (A[n-1] < B)
            return Bsearch (A, 0, switchLow-1, B);
        return -1;
    }
    
    public int Bsearch (int [] A, int low, int high, int B) {
        while (low <= high) {
            int mid = low + ((high - low)/2);
            if (A[mid] > B)
                high = mid-1;
            else if (A[mid] < B)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}

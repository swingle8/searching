// Matrix Median
// Problem Description
// Given a matrix of integers A of size N x M in which each row is sorted. Find and return the overall median of the matrix A. NOTE: No extra memory is allowed. NOTE: Rows are numbered from top to bottom and columns are numbered from left to right. 
// 
// 
// Problem Constraints
// 1 <= N, M <= 10^5 1 <= N*M <= 10^6 1 <= A[i] <= 10^9 N*M is odd 
// 
// 
// Input Format
// The first and only argument given is the integer matrix A.
// 
// 
// Output Format
// Return the overall median of the matrix A.
// 
// 
// Example Input
// Input 1:
// A = [   [1, 3, 5],
//         [2, 6, 9],
//         [3, 6, 9]   ]
//   Input 2:      
// A = [   [5, 17, 100]    ]
//     
// 
// 
// Example Output
// Output 1:
//  5
//   Output 2:      
//  17
//     
// 
// 
// Example Explanation
// Explanation 1:
//  
// A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
// Median is 5. So, we return 5.
//   Explanation 2:      
//  
// Median is 17.

public class Solution {
    public int findMedian(int[][] A) {
        int l = 0;
        int n = A.length;
        int m = A[0].length;
        int r = n*m;
        int total = m*n;
        int ans = -1;
        
      for (int j = 0 ; j < n ; j ++) {
          for (int i = 0 ; i < m ; i ++) {
                if (A[j][i] < l)
                    l = A[j][i];
                if (A[j][i] > r)
                    r = A[j][i];
          }
      }
      
        
        while (l <= r) {
              
            int mid = l + ((r-l)/2);
            int count = countTillMid(A, mid);
            if (count > (total/2)) {
                r = mid -1; 
            }
            else if (count < (total/2)) {
                ans = mid;
                l = mid + 1;
            }
            else {
                ans = mid;
                l = mid+1;
            }
        }
        
        return ans;
    }
    
    public int countTillMid (int [][] A, int mid) {
        int n = A.length;
        int count = 0;
        for (int i = 0 ; i < n ; i ++) {
            count = count + countTillMid(A[i], mid);
        }
       // System.out.println("Mid is : " + mid + " count is : " + count);
        return count;
    }
    
    public int countTillMid (int [] A, int mid) {
        int count = 0;
        int m = A.length;
        for (int i = 0 ; i < m ; i ++) {
            if (A[i] < mid)
                count++;
        }
        return count;
    }
}

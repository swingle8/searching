// # Find any peak element
// # Problem Description
// # Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors. For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.   
// # 
// # 
// # Problem Constraints
// # 1 <= |A| <= 100000 1 <= A[i] <= 10^9   
// # 
// # 
// # Input Format
// # The only argument given is the integer array A.
// # 
// # 
// # Output Format
// # Return the peak element.
// # 
// # 
// # Example Input
// # Input 1:
// # A = [1, 2, 3, 4, 5]
// #   Input 2:          
// # A = [5, 17, 100, 11]
// #       
// # 
// # 
// # Example Output
// # Output 1:
// #  5
// #   Output 2:          
// #  100
// #       
// # 
// # 
// # Example Explanation
// # Explanation 1:
// #  5 is the peak.
// #   Explanation 2:          
// #  100 is the peak.


public class Solution {
    public int solve(int[] A) {
        int l = 0;
        int r = A.length-1;
        
        while (l <= r) {
            int mid = l + ((r-l)/2);
            if (isPeak(A, mid))
                return A[mid];
            else if (A[mid] <= A[mid+1])
                l = mid + 1;
            else
                r = mid - 1;
            }
        
        return -1;
    }
    
    public boolean isPeak (int [] A, int index) {
        int num = A[index];
        if ((index == 0 || (index > 0 && A[index] >= A[index-1])) && (index == A.length-1 || (index < A.length-1 && A[index] >= A[index+1])))
            return true;
        return false;
    }
}

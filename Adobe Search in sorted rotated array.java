import java.util.*;
public class BinarySearch {
    
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        int cases = sc.nextInt();
        while (cases-- > 0 ) {
            int n = sc.nextInt();
            int [] arr = new int [n];
            for (int i = 0 ; i < n ; i ++)
                arr[i] = sc.nextInt();
            
            int target = sc.nextInt();
            System.out.println(search (arr, target));
        }
    }
    public static int search(int [] nums, int target) {
        int start = 0;
        int len = nums.length-1;
        int end = len;
        
        while (start <= end) {
            int mid = (end - start)/2 + start;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[0]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else if (nums[mid] <= nums[len]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            }            
        }
        
        return -1;
    }
}
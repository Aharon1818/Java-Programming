package binarySearch;
import java.util.Scanner;
public class splitArray {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int target = 2;
        System.out.println(splitArray(nums, target));
    }

    public static int splitArray(int[] nums, int m){
        int start = 0;
        int end = 0;

        for(int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]); // In the end of the loop this will contain the max item from array.
            end += nums[i];
        }

        while(start < end){
            // try for the middle as potential ans
            int mid = start + (end - start) / 2;

            //claculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;

             for(int num : nums){
                 if(sum + num > mid){
                     // You cannot add this in this subarray, make new one
                     //Say you add this num in new subarray, then sum = mum
                     sum = num;
                     pieces++;
                 }
                 else{
                     sum += num;
                 }
             }
             if(pieces > m){
                 start = mid + 1;
             }
             else{
                 end = mid;
             }
        }
        return end;
    }
}

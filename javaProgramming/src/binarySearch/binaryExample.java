package binarySearch;
import java.util.Scanner;
import java.util.Arrays;
public class binaryExample {
    public static void main(String[] args) {
        int[] arr = {70, 75, 79, 85, 90, 95};
        int target = 90;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] < target){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}

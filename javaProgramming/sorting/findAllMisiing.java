package sorting;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
 class findAllMisiing {
//public class findAllMissing{
     public List<Integer> FindDisappearedNumbers(int[] nums) {
//         int i = 0;
//public static void main(String[] args) {
//    int[] arr = {5, 4, 2, 3, 2, 3, 1};
//    System.out.println(search(arr));
//}

//static int search(int[] nums){
    int i = 0;
         while (i < nums.length) {
             int correct = nums[i] - 1;
             if (nums[i] != nums[correct]) {
                 swap(nums, i, correct);
             } else {
                 i++;
             }
         }

        List<Integer> ans = new ArrayList<>();
         for (i = 0; i < nums.length - 1; i++) {
             if (nums[i] != i + 1) {
                 ans.add(i + 1);
             }
         }
         return ans;
     }


     static void swap(int[] arr, int first, int second){
         int temp = arr[first];
         arr[first] = arr[second];
         arr[second] = temp;
     }


 }

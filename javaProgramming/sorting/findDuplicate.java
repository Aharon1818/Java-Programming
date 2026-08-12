package sorting;
import java.util.Scanner;
import java.util.Arrays;
public class findDuplicate {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 2};
        int ans = duplicate(arr);
        System.out.println(ans);
    }

    static int duplicate(int[] arr){
        int i = 0;
        while(i < arr.length){
            if(arr[i] != i + 1){
                int correct = arr[i] - 1;
                 if(arr[i] != arr[correct]){
                     swap(arr, i, correct);
                 }
                 else{
                     return arr[i];
                 }
            }
            else{
                i++;
            }
        }
        return -1;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

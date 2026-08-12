package sorting;
import java.util.Scanner;
import java.util.Arrays;
public class missingNumber {
    public static void main(String[] args) {
         int[] arr = {4, 0, 2, 1};
        System.out.println(sort(arr));
    }

    static int sort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }

        for(int index = 0; index < arr.length; index++){
            if(arr[index] != index){
                return index;
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

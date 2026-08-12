package sorting;
import java.util.Arrays;
import java.util.Scanner;
public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 3};
        bubble(arr);
        System.out.print(Arrays.toString(arr));
    }

    static void bubble(int[] arr){
        boolean swapped;
        //run the step n-1 times
        for(int i=0; i<arr.length; i++){
            swapped = false;
            //for each step max item will come at the last respective index
            for(int j=1; j<=arr.length - i -1; j++){
                //swap if the item is smaller than the previous item
                if(arr[j] < arr[j-1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                      arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}

package sorting;
import java.util.Scanner;
import java.util.Arrays;
public class mergeSort2 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        merge1(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void merge1(int[] arr, int s, int e){
        if(e - s == 1){
            return;
        }

        int mid = (s + e) / 2;
        merge1(arr, s, mid);
        merge1(arr, mid, e);

        merge_sort1(arr, s, mid, e);
    }

    static void merge_sort1(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = mid;
        int k = 0;

        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
}


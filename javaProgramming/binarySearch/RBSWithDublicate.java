package binarySearch;

public class RBSWithDublicate {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findPivotWithdublicates(arr));
    }

    static int search(int[] nums, int target){
        int pivot = findPivotWithdublicates(nums);
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if(nums[pivot] == target){
            return pivot;
        }

        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    // This will not work in dublicate values
    static int findPivotWithdublicates(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid <  end && arr[mid] > arr[mid + 1]){
                return mid;
            }

            if( mid > start && arr[mid] < arr[mid - 1]){
                return mid-1;
            }

            //if element at middle, start, end, are equal, then just skip, the dublicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //Skip the dublicates
                //Note : What if these element at start and end were the pivot ??
                //Check if start is pivot
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                //Check whether end is pivot
                if(arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            //Left side is sorted so pivot should be in right.
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}



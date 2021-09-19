package Divide;

/*
快排也用了分治的思想
 */
public class interview17_14 {
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private void quickSort(int[] arr, int start, int end, int k) {
        if (start > end) return;
        int value = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[j] >= value) {
                j--;
            }
            if (i < j) arr[i] = arr[j];
            while (i < j && arr[i] <= value) {
                i++;
            }
            if (i < j) arr[j] = arr[i];
        }
        arr[i] = value;
        if (i + 1 > k) {
            quickSort(arr, start, i - 1, k);
        } else if (i + 1 < k) {
            quickSort(arr, i + 1, end, k);
        } else {
            return;
        }
    }
}

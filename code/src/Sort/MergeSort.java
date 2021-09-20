package Sort;

import org.junit.Test;

import java.util.Random;

public class MergeSort implements Sort{
    public void sort(Comparable[] arr){
        mergeSort(arr,0,arr.length-1,new Comparable[arr.length]);
    }

    private void mergeSort(Comparable[] arr,int beg,int end,Comparable[] temp){
        if(beg<end){
            int mid=beg+end>>1;
            mergeSort(arr,beg,mid,temp);
            mergeSort(arr,mid+1,end,temp);
            merge(arr,beg,mid,end,temp);
        }
    }
    private void merge(Comparable[] arr,int beg,int mid,int end,Comparable[] temp){
        int i=beg,j=mid+1,k=0;
        while (i<=mid&&j<=end){
            if(arr[i].compareTo(arr[j])<=0) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }
        while (i<=mid) temp[k++]=arr[i++];
        while (j<=end) temp[k++]=arr[j++];
        k=0;
        while (beg<=end){
            arr[beg++]=temp[k++];
        }
    }

    @Test
    public void test() {
        Integer[] arr1 = new Integer[10];

        Random r=new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=r.nextInt(5);
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
        sort(arr1);
        System.out.println();
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
    }
}

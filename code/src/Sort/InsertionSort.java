package Sort;

import org.junit.Test;

import java.util.Random;

public class InsertionSort implements Sort{
    public void sort(Comparable[] arr){
        if(arr==null||arr.length<=1) return;
        for (int i = 1; i < arr.length; i++) {
            Comparable pilot=arr[i];
            int preIndex=i-1;
            while (preIndex>=0&&arr[preIndex].compareTo(pilot)>0){
                arr[preIndex+1]=arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1]=pilot;
        }
    }
    private void swap(Comparable[] arr,int i,int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}

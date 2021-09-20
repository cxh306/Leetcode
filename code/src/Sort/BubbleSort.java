package Sort;

import org.junit.Test;

import java.util.Random;

public class BubbleSort implements Sort{
    public void sort(Comparable[] arr){
        if(arr==null) return;
        for(int i=1;i<arr.length;i++){
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j].compareTo(arr[j+1])>0) swap(arr,j,j+1);
            }
        }
    }
    private void swap(Comparable[] arr,int i,int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

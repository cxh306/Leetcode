package Sort;
public class SelectionSort implements Sort{
    public void sort(Comparable[] arr){
        if(arr==null) return;
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex])<0) minIndex=j;
            }
            swap(arr,i,minIndex);
        }
    }

    private void swap(Comparable[] arr,int i,int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}

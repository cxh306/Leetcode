package Sort;

import java.util.Arrays;
import java.util.Random;


/**
 * 数据量少于1e5时，归并排序时间复杂度上强于三路快排,否则三路快排强于归并排序
 * 空间复杂度快排明显强于归排
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String[] sortMethod={"Sort.QuickSort","Sort.MergeSort"};
        Integer[] arr = new Integer[150000];
        Random r=new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(10000);
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
        for (int i = 0; i < sortMethod.length; i++) {
            long before = System.currentTimeMillis();
            ((Sort)Class.forName(sortMethod[i]).newInstance()).sort(Arrays.copyOfRange(arr,0,arr.length));
            long now=System.currentTimeMillis();
            System.out.println(now-before);
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
    }
}

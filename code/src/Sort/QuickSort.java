package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 三路快排在数据稀疏情况下与二路快排时间性能几乎一致，在数据重复率高情况下优于二路快排
 * 所以三路快排优于二路快排
 * 三路快排优于Java Arrays.sort()
 *
 * pilot随机选择会让快排在最坏情况下（数据高度有序）不至于性能太差，加强稳定性
 */
public class QuickSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        quickSort3Ways(arr,0,arr.length-1);
    }

    private void quickSort2Ways(Comparable[] nums, int beg, int end) {
        if (beg >= end) return;
        int randIndex=beg+(int)Math.floor((end-beg+1)*Math.random());
        Comparable pilot = nums[beg];
        swap(nums,randIndex,beg);
        int lt = beg, gt = end;
        while (lt<gt) {
            while (lt < gt && nums[gt].compareTo(pilot)>=0) gt--;
            if(lt<gt) nums[lt]=nums[gt];
            while (lt < gt && nums[lt].compareTo(pilot)<=0) lt++;
            if(lt<gt) nums[gt]=nums[lt];
            else nums[lt]=pilot;
        }
        quickSort2Ways(nums, beg, lt);
        quickSort2Ways(nums, gt+1, end);
    }
    private void quickSort3Ways(Comparable[] nums, int beg, int end) {
        if (beg >= end) return;
        int randIndex=beg+(int)Math.floor((end-beg+1)*Math.random());
        Comparable pilot = nums[beg];
        swap(nums,randIndex,beg);
        int lt = beg, gt = end, p = beg, q = end;
        while (true) {
            while (lt < gt && nums[gt].compareTo(pilot)>=0) {
                if (nums[gt].equals(pilot)) {
                    swap(nums, gt, q--);
                }
                gt--;
            }
            while (lt < gt && nums[lt].compareTo(pilot)<=0) {
                if (nums[lt] == pilot) {
                    swap(nums, lt, p++);
                }
                lt++;
            }
            if (lt < gt) {
                swap(nums, gt, lt);
            } else {
                p--;
                while (p >= beg) {
                    swap(nums, p--, lt--);
                }
                q++;
                gt++;
                while (q <= end) {
                    swap(nums, q++, gt++);
                }
                break;
            }
        }
        quickSort3Ways(nums, beg, lt);
        quickSort3Ways(nums, gt, end);
    }

    private void swap(Comparable[] nums, int i, int j) {
        Comparable temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

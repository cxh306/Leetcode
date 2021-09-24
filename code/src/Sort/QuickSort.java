package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

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
//        quickSort3Ways(arr,0,arr.length-1);
        quickSort3Ways(arr);
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

    //用栈模拟递归
    private void quickSort3Ways(Comparable[] nums) {
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{0,nums.length-1});
        while (!stack.isEmpty()){
            int[] top = stack.pop();
            int[] part=partition(nums,top[0],top[1]);
            if(top[0]<part[0]) stack.push(new int[]{top[0],part[0]});
            if(part[1]<top[1]) stack.push(new int[]{part[1],top[1]});
        }
    }

    //递归快排
    private void quickSort3Ways(Comparable[] nums, int left, int right) {
        if (left >= right) return;
        int[] part=partition(nums,left,right);
        quickSort3Ways(nums, left, part[0]);
        quickSort3Ways(nums, part[1], right);
    }

    private int[] partition(Comparable[] nums,int left,int right){
        //随机选择
        int randIndex=left+(int)Math.floor((right-left+1)*Math.random());
        Comparable pilot = nums[right];
        swap(nums,right,randIndex);
        int l=left-1,j=left,r=right;
        while(j<r){
            if(nums[j].compareTo(pilot)<0){
                swap(nums,j++,++l);
            }else if(nums[j].compareTo(pilot)>0){
                swap(nums,j,--r);
            }else{
                j++;
            }
        }
        swap(nums,j,right);
        return new int[]{l,j+1};
    }
    private void swap(Comparable[] nums, int i, int j) {
        Comparable temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

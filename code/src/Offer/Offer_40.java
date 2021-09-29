package Offer;

import java.util.*;

public class Offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        return helper1(arr,k,0,arr.length-1);
    }

    /**
     * 数组范围有限，计数排序
     * @param arr
     * @param k
     * @return
     */
    public int[] helper4(int arr[],int k){
        if(arr.length==0||k==0){
            return new int[0];
        }
        int[] st=new int[10001];
        for (int num:arr) {
            st[num]++;
        }
        int i=0;
        int j=0;
        int[] ans = new int[k];
        while(i<k){
            if(st[j]>0){
                st[j]--;
                ans[i++]=j;
            }else{
                j++;
            }
        }
        return ans;
    }
    /**
     *二叉搜索树/红黑树 TreeMap/TreeSet 由于有重复数字，故TreeMap key为数组元素值，value为个数
     */
    public int[] helper3(int arr[],int k){
        if(arr.length==0||k==0){
            return new int[0];
        }
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int cnt=0;
        for(int num:arr){
            if(cnt<k){
                tm.put(num,tm.getOrDefault(num,0)+1);
                cnt++;
                continue;
            }else{
                Integer lastKey = tm.lastKey();
                if(lastKey>num){
                    tm.put(lastKey,tm.getOrDefault(lastKey,0)+1);
                    int lastCnt = tm.get(lastKey) - 1;
                    if(lastCnt>0){
                        tm.put(lastKey,lastCnt);
                    }else{
                        tm.pollLastEntry();
                    }
                }
            }
        }
        Set<Integer> integerSet = tm.keySet();
        int[] ans = new int[k];
        int i=0;
        for(int key:integerSet){
            int n = tm.get(key);
            while(n-->0){
                ans[i++]=key;
            }
        }
        return ans;
    }
    /**
     * 优先队列/大根堆 用PriorityQueue实现
     * @param arr
     * @param k
     * @return
     */
    public int[] helper2(int[] arr,int k){
        if(arr==null||k==0){
            return new int[0];
        }
        PriorityQueue<Integer> p = new PriorityQueue<>((v1,v2)->v2-v1);
        for(int num:arr){
            if(p.size()<k){
                p.add(num);
            }else{
                if(p.peek() > num){
                    p.poll();
                    p.add(num);
                }
            }
        }
        int[] ans = new int[p.size()];
        int i=0;
        for (int num:p){
            ans[i++]=num;
        }
        return ans;
    }

    /**
     * 快排分组思想
     * @param arr
     * @param k
     * @param beg
     * @param end
     * @return
     */
    public int[] helper1(int[] arr,int k,int beg,int end){
        if(k==arr.length||beg>=end){
            return arr;
        }
        int baseVal = arr[beg];
        int i=beg,j=end;
        while(i<j){
            while(i<j&&arr[j]>=baseVal){
                j--;
            }
            if(i<j){
                arr[i++]=arr[j];
            }
            while(i<j&&arr[i]<=baseVal){
                i++;
            }
            if(i<j){
                arr[j--]=arr[i];
            }
        }
        arr[i]=baseVal;
        if(i<k){
            return helper1(arr,k,i+1,end);
        }else if(i>k){
            return helper1(arr,k,beg,i-1);
        }else{
            int[] ans = new int[k];
            for(int q=0;q<k;q++){
                ans[q]=arr[q];
            }
            return ans;
        }
    }
}
package Offer;

import java.util.ArrayList;

public class Offer_44 {
    public int findNthDigit(int n) {
        if(n<=9) return n;
        int pre=10;
        int i=1;
        while(pre<n){
            pre+=9*(i+1)*Math.pow(10,i);
            i++;
        }
        int end=(int)Math.pow(10,i)-1;
        int beg = (end+1)/10;
        int now=pre;
        while(beg<end){
            int mid = beg+(end-beg+1)>>1;
            if(now-(end-mid)*i>n){
                end = mid;
                now-= (end-beg)*i;
            }else{
                beg=mid;
            }
        }
        int value=beg-1;
        int cha=now-n;
        while(--cha>0){
            value/=10;
        }
        return value%10;
    }
}

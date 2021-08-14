package Offer;

import java.util.LinkedList;

public class Offer_31{
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> l = new LinkedList<>();
        int len = popped.length;
        int i=0,j=0;
        //预处理
        l.addLast(-1);
        while(j<len){
            //当popped[j]元素与栈顶元素相等，就pop栈顶元素,右指针移动
            if(popped[j]==l.getLast()){
                l.removeLast();
                j++;
            }else {
                //否则，若左指针已经到头,false
                if(i==len){
                    return false;
                }else{
                    //不然popped[j]与pushed[i]相等,左右指针都移动，匹配
                    if(popped[j]==pushed[i]){
                        i++;
                        j++;
                    }else{
                        //pushed[i]压栈,左指针移动
                        l.addLast(pushed[i]);
                        i++;
                    }
                }
            }
        }
        return true;
    }
}

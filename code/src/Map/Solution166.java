package Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution166 {
//    public String fractionToDecimal(int numerator, int denominator) {
//        List<String> Array = new ArrayList<>();
//        Map<Long,Integer> map = new HashMap<>();
//
//        map.put(0L,-1);
//        int sign=-1;
//        if(numerator<=0&&denominator<=0||numerator>=0&&denominator>=0){
//            sign=1;
//        }
//        long numerator1=Math.abs((long)numerator);
//        long denominator1=Math.abs((long)denominator);
//        long first=numerator1/denominator1;
//        long now = numerator1%denominator1;
//        while (!map.containsKey(now)){
//            StringBuilder sb = new StringBuilder();
//            long temp=now*10;
//            while(temp<denominator1){
//                sb.append(0);
//                temp*=10;
//            }
//            long div=temp/denominator1;
//            sb.append(div);
//            Array.add(sb.toString());
//            map.put(now,Array.size()-1);
//            now=temp%denominator1;
//        }
//
//        int index=map.get(now);
//        int len=Array.size();
//        StringBuilder ans=new StringBuilder();
//        if(sign==-1) ans.append('-');
//        ans.append(first);
//        if(index==-1){
//            if(!Array.isEmpty()){
//                ans.append('.');
//                for (String s : Array) {
//                    ans.append(s);
//                }
//            }
//        }
//        else{
//            ans.append('.');
//            StringBuilder secondStr=new StringBuilder();
//            StringBuilder firstStr=new StringBuilder();
//            for(int i=0;i<len;i++){
//                if(i<index){
//                    firstStr.append(Array.get(i));
//                }else{
//                    secondStr.append(Array.get(i));
//                }
//            }
//            ans.append(firstStr).append('(').append(secondStr).append(')');
//        }
//        return ans.toString();
//    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder fraction=new StringBuilder();
        long dividend= Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        //异或判断！！
        if(numerator < 0 ^ denominator < 0){
            fraction.append('-');
        }

        //大数溢出，提升int->long
        long first=dividend/divisor;
        long reminder = dividend%divisor;
        fraction.append(first);
        if(reminder!=0){
            fraction.append('.');
        }
        Map<Long, Integer> map = new HashMap<>();
        while (reminder!=0){
            if(!map.containsKey(reminder)){
                map.put(reminder,fraction.length());
                reminder*=10;
                while (reminder<divisor){
                    reminder*=10;
                    fraction.append(0);
                }
                fraction.append(reminder/divisor);
                reminder=reminder%divisor;
            }else{
                fraction.insert(map.get(reminder),"(");
                fraction.append(")");
                break;
            }
        }
        return fraction.toString();
    }
    @Test
    public void test(){
        int numerator = -1, denominator = -2147483648;
        System.out.println(fractionToDecimal(numerator,denominator));
    }
}

package Offer;

public class Offer_15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;

        for(int i=0;i<32;i++){
            count+=n&1;//第0位是1则为1,0则为0
            n=n>>1;//抛弃0位，向后看
        }
        return count;
    }
}
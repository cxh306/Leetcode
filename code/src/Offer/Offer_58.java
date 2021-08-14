package Offer;

public class Offer_58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s.substring(n));
        return sb.append(s.substring(0,n)).toString();
    }
}

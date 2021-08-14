package Hot200;

public class Solution157 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int idx=0;
        char[] buf4=new char[4];

//        int size=read4(buf4);
//        while(size>0&&idx<n){
//            for(int i=0;i<size&&idx<n;i++,idx++) buf[idx]=buf4[i];
//            size=read4(buf4);
//        }
        int size;
        do{
            size=read4(buf4);
            for(int i=0;i<size&&idx<n;i++,idx++) buf[idx]=buf4[i];
        }while (size>0&&idx<n);


        return idx;
    }
    int read4(char[] buf4){
        return 0;
    }
}

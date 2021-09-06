import org.junit.Test;

public class Monkey {
    public int helper(int i){
        if(i==10) return 1;
        return (helper(i+1)+1)*2;
    }

    @Test
    public void test(){
        System.out.println(helper(1));
    }
}

package Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] res=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]]++;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for (int i = 1; i < res.length; i++) {
            if(res[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}

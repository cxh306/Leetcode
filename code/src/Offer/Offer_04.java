package Offer;

public class Offer_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int left = 0,right = matrix[0].length-1;
        int up = 0,down = matrix.length-1;
        while(left<=right&&up<=down){
            //寻找第up行的不大于target的最大值的index,更新右界
            right=helper(matrix,left,right,up,false,target);
            //上下边界相等,则matrix[up][right]为全局不大于target的最大值的index，判断其是否与target相等即可
            if(up==down){
                return matrix[up][right] == target;
            }
            //若上下边界不想等，则当这个值等于target返回true
            if(matrix[up][right]==target){
                return true;
            }
            //否则，这一行没有目标值，上界下移
            up++;
            //寻找第left列的不大于target的最大值的index，更新下界
            down=helper(matrix,up,down,left,true,target);
            //左右边界相等,则matrix[down][left]为全局不大于target的最大值，判断其是否与target相等即可
            if(left==right){
                return matrix[down][left]==target;
            }
            //若左右边界不相等，则当这个值等于target返回true
            if (matrix[down][left]==target){
                return true;
            }
            //否则左界右移
            left++;
        }
        return false;
    }

    //b==true:第stat列的[left,right]不大于target的最大值的序号
    //b==false:第stat行的[left,right]不大于target的最大值的序号
    public int helper(int[][] matrix,int left,int right,int stat,boolean b,int target){
        int left_temp = left,right_temp = right;
        while(left_temp<right_temp){
            int temp = left_temp+(right_temp-left_temp+1)/2;
            int one = b?temp:stat;
            int two = b?stat:temp;
            if(matrix[one][two]>target){
                right_temp=temp-1;
            }else if(matrix[one][two]<target){
                left_temp = temp;
            }else{
                return temp;
            }
        }
        return left_temp;
    }

}
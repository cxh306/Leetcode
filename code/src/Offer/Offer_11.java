package Offer;

public class Offer_11 {
    public int minArray(int[] numbers) {
        int left=0,right = numbers.length-1;
        while(left<right){
            int mid = left+(right-left>>1);//>>,<<的运算优先级低于加减
            if(numbers[mid]<numbers[right]){//若中值小于右值，则中值落于右增区间
                right = mid;    //更新右界,因中值可能为最小值，故右界更新为中
            }else if(numbers[mid]>numbers[right]){//若中值大于右值，则中值落于左增区间
                left = mid + 1;     //更新左界，因存在numbers[right]小于中值，故中值必然不是最小值，左界在中值加1
            }else{
                /**
                 * 两种情况:
                 * 1.左值小于右值,此时[left,right]为升序,故返回
                 * 2.左值等于右值,此时最小值要么在(left,mid],要么在[mid,right)，且numbers[left]=numbers[mid]=numbers[right]
                 *    可以忽略right或者left,因为若left或right是目标值，则mid也是目标值，可以搜索到
                 */
                if(numbers[left]<numbers[right]) return numbers[left];
                else{
                    left++;
                    //right--;
                }
            }
        }
        return numbers[left];
    }
}
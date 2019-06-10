package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/can-place-flowers/
 *
 * 给定一个int数组，代表花罐子，里面的数值只能是0或者1，0代表空，1代表有花
 * 只有两个0之间才能种花，如果两个1挨着，会导致他们争夺水资源导致死亡。
 * 现在给定一个花罐数组，并给出新种的花的个数，让求出，这个罐子中能不能放的下新增的花。
 *
 * 思路：
 *
 * 循环数组，初始化情况下count=1，然后对连续0计数，如果遇到非0，就count-1的结果除以2，就是能中的颗数，
 * 直到循环结束，最后在除以2，看商是否大于等于n，如果满足，则可以中下。
 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 1;
        int result = 0;
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                count++;
            }else {
                result += (count-1)/2;
                count = 0;
            }
        }
        if(count != 0) result += count/2;
        return result>=n;
    }
    public static void main(String[] args) {
        int arr[]={0,0};
        System.out.println(canPlaceFlowers(arr,1));
    }
}

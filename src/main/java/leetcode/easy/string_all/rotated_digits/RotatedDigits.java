package leetcode.easy.string_all.rotated_digits;

/***
 *
 * 一个数字的每一位，在旋转后，如果还是数字，则为有效数字，但其不能与自身相等
 * 所以0,1,8 旋转后自身相等，所以排除
 * 2和5 6和9 相互旋转则可以
 * 其他的都不行 3,4,7
 *
 * 现在给定一个数字N，让算出，1到N之间，有多少个有效的数字。
 * 注意，如果数字大于10，需要拆分每一个数字进行判断，必须全部满足方可
 */
public class RotatedDigits {


    public static int rotatedDigits(int N) {

        int count=0;
        for (int i = 1; i <= N ; i++) {

          count+=isGood(i);
        }

    return count;
    }


    public static int isGood(int n) {

        boolean isNew = false;

        while(n != 0) {
            if(n % 10 == 2 || n % 10 == 5 || n % 10 == 6 || n % 10 == 9) {
                isNew = true;
                n = n /10;
            }

            else if(n % 10 == 3 || n % 10 == 4 || n % 10 == 7) {
                isNew = false;
                break;
            }
            else
                n = n /10;
        }

        return isNew ? 1 : 0;
    }




    public static void main(String[] args) {

         rotatedDigits(100);
    }


}

package leetcode.easy.hash_table_all;

/****
 *
 * 链接：https://leetcode.com/problems/bulls-and-cows/
 *
 * 给定两个总是相等的数字字符串，比如 =>  1807 和 7810
 *
 * 让求出公牛的数字=所有猜正确的数字。
 *
 * 母牛的数字=猜错位置的计数
 *
 *
 */
public class BullsAndCows {

    public static String getHint(String secret, String guess) {

        int len = secret.length();
        int []secretarr=new int[10];
        int []guessarr=new int[10];

        int bull=0;
        int cow=0;
        for (int i = 0; i < len; i++) {
            if(secret.charAt(i)==guess.charAt(i)){
                bull++;
            }else{
                secretarr[secret.charAt(i)-'0']++;
                guessarr[guess.charAt(i)-'0']++;
            }
        }


        System.out.println();

        for (int i = 0; i < 10; i++) {
            cow=cow+Math.min(secretarr[i],guessarr[i]);
        }
      return ""+bull+"A"+cow+"B";
    }


    public static void main(String[] args) {

        String s1="1123";
        String s2="0111";

        System.out.println(getHint(s1,s2));

    }


}

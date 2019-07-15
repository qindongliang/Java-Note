package leetcode.easy.hash_table_all;

/***
 *
 * https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
 *
 *
 */
public class JewelsandStones {

    public static int numJewelsInStones(String J, String S) {
        String text = S.replaceAll("[^" + J + "]", "");
//        System.out.println(text);

        return text.length();
    }


    public static int numJewelsInStones2(String J, String S) {
        int[] a = new int[58]; //小写+大写共有58个字符
        for (char stone : J.toCharArray()) {
            a[stone - 65]++;
        }
        int sum = 0;
        for (char jewel : S.toCharArray())
            sum += a[jewel - 65];

        return sum;
    }


    public static void main(String[] args) {

        //替换除了J里面的所有字符，在S里面其他的都为空
        numJewelsInStones("aA", "aAAbbbb");

    }

}

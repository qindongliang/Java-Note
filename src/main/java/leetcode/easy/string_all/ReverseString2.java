package leetcode.easy.string_all;

/***
 *
 * https://leetcode.com/problems/reverse-string-ii/
 * 每隔2k个数字之后，对前面的k个数字做反转，如果长度不够则不做处理。
 */
public class ReverseString2 {

    public static String reverseStr(String s, int k) {

        char []a=s.toCharArray();

        for (int start = 0; start <a.length ; start=start+2*k) {
            int i=start;
            int j=Math.min(start+k-1,a.length-1);

            while (i<j){
                char tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
                i++;
                j--;
            }
        }


        return new String(a);
    }


    public static void main(String[] args) {

        //"|ab| cd |ef| gy |po|"
        System.out.println(reverseStr("abcdefgypo",2));

    }

}

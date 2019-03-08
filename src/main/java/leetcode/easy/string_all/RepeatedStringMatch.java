package leetcode.easy.string_all;

/***
 * 判断重复的字符串是否包含指定的次数
 * 思路：
 * 声明一个StringBuilder，不断的追加A，然后判断sb的长度是否大于B.length
 * 如果大于就结束循环，然后判断
 */
public class RepeatedStringMatch {


    public static int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count=0;
        while(sb.length()<B.length())
        {
            sb.append(A);
            count++;

        }
        if(sb.toString().lastIndexOf(B)>-1) return count;
        else return sb.append(A).toString().lastIndexOf(B) >-1 ? count+1:-1 ;
    }


    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd","cdabedab"));
    }


}

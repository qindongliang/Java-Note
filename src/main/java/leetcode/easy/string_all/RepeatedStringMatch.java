package leetcode.easy.string_all;

/***
 * 判断重复的字符串是否包含指定的次数
 * 思路：
 * 声明一个StringBuilder，不断的追加A，知道长度大于B.length
 * 然后判断该子串是否在总的子串里面存在，不存在就再追加一次然后再判断。
 * 注意这里用的lastIndexOf而不是indexOf,lastIndexOf可以从后向前搜索
 * 如果已经知道这个子串在末尾，那么使用这个会明显提升性能。
 *
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

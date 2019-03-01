package leetcode.easy.string_all;

/***
 * https://leetcode.com/problems/count-and-say/
 *
 */
public class CountAndSay {


    public static String countAndSay(int n) {
        if(n==1)
            return "1";

        StringBuilder sb=new StringBuilder();

        //找到n-1的结果
        String str=countAndSay(n-1);

        //对n-1的结果进行表示
        char c='0';
        int count=0;
        for (int i=0;i<str.length();i++){
            c=str.charAt(i);
            count=1;
            while ((i+1)<str.length()&&str.charAt(i+1)==c){
                count++;
                i++;
            }
            sb.append(count+""+c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }
}

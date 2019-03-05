package leetcode.easy.string_all;

/***
 * 统计字符串里面忽略空格之后的长度，对多个空格也忽略
 *
 */
public class NumberSegmentsString {

    public static int countSegments(String s) {
        int res = 0;
        //判断第一个字符不等于空，并且index=0，然后+1,
        //后面的必须，前一个字符是空，后一个不为空也加1，其他不做判断
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                res++;
            }
        }
        return res;
    }


        public int countSegmentsRegex (String s){
            if (s.trim().length() == 0) {
                return 0;
            }
            return s.trim().split("\\s+").length;
        }


        public static void main (String[]args){
            String content = "Hello, my name is John";

            System.out.println(countSegments(content));


        }



}

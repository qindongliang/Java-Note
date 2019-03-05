package leetcode.easy.string_all;

/***
 * 字符串压缩
 */
public class StringCompression {

    public static int compress(char[] chars) {
        //定义两个偏移量
        int indexAns=0, index=0;
        while (index<chars.length){
            char currentChar=chars[index];
            int count=0;
            //如果有重复的就会一直统计count
            while (index<chars.length&&chars[index]==currentChar){
                index++;
                count++;
            }
            //最后在切换重置新的字符
            chars[indexAns++]=currentChar;
            //判断count的值，转成字符串，放入数组里面
            if(count!=1){
                for (char c:Integer.toString(count).toCharArray()) {
                    chars[indexAns++]=c;
                }
            }
        }
        //返回最终统计数量
        return indexAns;
    }


    public static void main(String[] args) {


        System.out.println(compress("aabbccc".toCharArray()));

    }



}

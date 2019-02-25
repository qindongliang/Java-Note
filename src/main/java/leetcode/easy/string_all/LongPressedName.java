package leetcode.easy.string_all;

/***
 *
 * 判断指定name，是否有可能在输入的typed字段里面
 *
 * 前提是：如果敲键盘的输入里面包含了指定name的字符，那么相等字符的长度一定等于指定的name
 *
 * 下面的处理思路是：必须按顺序遍历输入的name，如果遍历完，有字符和其长度相等就可以返回true
 *
 */
public class LongPressedName {


    public static boolean isLongPressedName(String name, String typed) {
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        int flag = 0;
        for (int i = 0; i < typedChars.length; i++) {
            if (flag < nameChars.length) {
                if (nameChars[flag] == typedChars[i]) {
                    flag++;
                }
            }
        }
        return (flag == nameChars.length);
    }


    public static void main(String[] args) {

        System.out.println(isLongPressedName("saeed","ssaaedd"));


    }


}

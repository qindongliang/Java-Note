package leetcode.easy.string_all;

import java.util.HashMap;
import java.util.Stack;

/****
 * https://leetcode.com/problems/valid-parentheses/
 *
 * 校验输入的字符串是否没有缺失和格式正常
 *
 * 解决思路：采用入栈的方式来处理，由于括号都是成对出现，先把所有的括号给录入到map，然后遍历输入字符串在遇见
 * 括号左边的时候，就把右边部分放进去，这样在下次遇到右边的括号时，由于map里面没有
 * 所以就会从栈里面弹出元素，然后与当前的比较，看看是否成对，如果不成对那就说明有问题，直接返回false
 * 如果整个集合处理完，最后队列为空，那么就说明格式如何
 *
 */
public class VaildParenttheses {

    static HashMap<Character,Character> map=new HashMap<>();
    static {
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
    }


    public static boolean isValid(String s) {

        Stack<Character> stack=new Stack<Character>();

        for (char c:s.toCharArray()) {

            Character value=map.get(c);
            if(value!=null) {
                stack.push(value);
            }else if(stack.isEmpty() || stack.pop()!=c) {
                return false;
            }
        }

    return stack.isEmpty();
    }

    public static void main(String[] args) {


        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));


    }

}

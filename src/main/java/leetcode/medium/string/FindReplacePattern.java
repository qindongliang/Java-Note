package leetcode.medium.string;

import java.util.LinkedList;
import java.util.List;

/***
 * https://leetcode.com/problems/find-and-replace-pattern/
 * 字符串查找和替换模式
 * 题目内容是给出一个字符串数组，然后给定一个模式串，要求数组里面的每个字符串，都得与模式串的每一个字符
 * 都必须是一对一的映射关系，不能出现一个字符映射多个模式的字符，反过来也一样。
 * 比如 mee和abb 符合1对1映射，aqq和mee也符合，但ccc和abb就不符合。
 * 解决思路：
 *  对比两个字符串是不是一对一字符映射关系，可用两个数组长度（归一后）为26，来表示状态，默认情况都是0.
 *  遍历其中一个字符串的长度，取每一个字符与另外一个模式串比较，相等的情况下都赋相同值，如果对比某个字符发现该位置上
 *  字符都不相等，那就认为不满足要求。
 *  另一种方式使用Map来解决，性能略低。
 */
public class FindReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res=new LinkedList<>();
        for (String w:words){

            int []p=new int[26];
            int []s=new int[26];
            boolean same=true;
            for (int i = 0; i < w.length(); i++) {
                if(s[w.charAt(i)-'a']!=p[pattern.charAt(i)-'a']){
                    same=false;
                    break;
                }else{
                    s[w.charAt(i)-'a']=p[pattern.charAt(i)-'a']=i+1;
                }
            }

            if(same) res.add(w);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb"));
    }


}

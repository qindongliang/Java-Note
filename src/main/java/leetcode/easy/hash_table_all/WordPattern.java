package leetcode.easy.hash_table_all;

import java.util.HashMap;
import java.util.Map;

/*****
 *
 *
 * https://leetcode.com/problems/word-pattern/
 *
 * 题目描述：给定一个p和t，p和t之间存在之间的模式的映射关闭
 *
 * 如  abba  和  dog cat cat dog存在相同的关系，如下：
 *
 * a     b    b     a
 * dog  cat   cat   dog
 * 符合对称映射，如abba和dog dog dog dog就构不成这种关系。
 *
 * 思路：采用hashmap来解决
 *
 * 如果两个字符串里面符合对称模式，那么他们在map里面出现的映射顺序，其实是相似的。
 *
 *
 *
 *
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        //转成数组
        String[] words = str.split(" ");
        //必须长度相等，才有机会构成映射
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        //放pattern里面的每一个字符到map里，同时放str里面的每一个单词也到map里
        //如果他们的映射是对称的，那么两者必定符合同时出现的规律，一旦有一个不符合就说明映射失败
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static void main(String[] args) {

    }
}

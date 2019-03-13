package leetcode.easy.string_all;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * https://leetcode.com/problems/buddy-strings/
 *
 * 给定2个字符串，如果他们的两个字符可以交换位置，例如ab，ba那么他们就符合要求
 * 解决思路，首先两个字符串的长度一定得相等，否则直接返回false
 * 其次，如果两个字符串相等，我们需要判断都是同一个字母，还是不同的字母，只有是同一个字母
 * 组成的才能返回true，最后如果不相等，我们需要用一个集合把不相等的字符收集起来
 * 最后判断，其size必须等于2，然后他们对应的字符串中位置取出来的字符相比，必须相等
 * 这样就符合要求。
 */

public class BuddyString {

    public boolean buddyStrings(String A, String B) {

        if(A.length()!=B.length()) return false;
        if(A.equals(B)){
            Set<Character> s=new HashSet<>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size()<A.length();
        }

        List<Integer> dif=new ArrayList<>();

        for (int i = 0; i < A.length(); ++i) {
            if(A.charAt(i)!=B.charAt(i)) dif.add(i);
        }

        return dif.size()==2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }

}

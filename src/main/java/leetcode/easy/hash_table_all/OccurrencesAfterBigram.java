package leetcode.easy.hash_table_all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *
 * https://leetcode.com/problems/occurrences-after-bigram/
 *
 * 给出第1个和第二个单词，让求出第三个单词，并返回结果数组
 */
public class OccurrencesAfterBigram {

    public static String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String words[] = text.split(" ");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                res.add(words[i + 2]);
            }

        }
        return res.toArray(new String[2]);
    }

    public static void main(String[] args) {

        String[] arr = findOcurrences("alice is a good girl she is a good student", "a", "good");

        System.out.println(Arrays.toString(arr));

    }


}

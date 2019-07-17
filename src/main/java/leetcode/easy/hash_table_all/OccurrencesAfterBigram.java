package leetcode.easy.hash_table_all;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OccurrencesAfterBigram {

    public static String[] findOcurrences(String text, String first, String second) {

        String regex = first + " " + second + "\\s\\b(?<t>\\w+)\\b?";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> list = new ArrayList<>();

        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                list.add(matcher.group(i));
            }
        }

//        System.out.println(list);
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {

        String[] arr = findOcurrences("alice is a good girl she is a good student", "a", "good");

        System.out.println(Arrays.toString(arr));

    }


}

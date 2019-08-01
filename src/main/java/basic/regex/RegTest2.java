package basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest2 {


    public static void main(String[] args) {
        String regex="\\w*?";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher("123456789@qq.com");

        while (matcher.find()){
            System.out.println(matcher.group());
        }


    }


    public static void main1(String[] args) {


//       Pattern pattern= Pattern.compile("\\d");
       Pattern pattern= Pattern.compile("h.*?\\b");

       String input="hello hadoop spark tez hive hi";

       Matcher matcher=pattern.matcher(input);

       while (matcher.find()){
           System.out.println(matcher.group()+" start: "+matcher.start()+" end: "+matcher.end());
       }


    }
}

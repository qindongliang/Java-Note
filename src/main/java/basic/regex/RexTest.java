package basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexTest {

    public static void main(String[] args) {
        String text    =
                "John writes about this, and John Doe writes about that," +
                        " and John hurt Wayne writes about everything."
                ;

//        String text="中国人民中化石油中离子是啥";
//        String patternString1 = "(John) (.+?) ";
//        String patternString1 = "(John) (.+?)） ";//注意有空格和无空格的区别
//        String patternString1 = "((John) (.+?)) ";//注意嵌套引用的组序号
        String patternString1 = "John.*+hurt";//注意嵌套引用的组序号

//        String patternString1 = "(中)(.+)";

        Pattern pattern = Pattern.compile(patternString1);
//        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);
//        System.out.println(matcher.matches());
        StringBuffer sb=new StringBuffer();
        while(matcher.find()) {
//            System.out.println(matcher.group(1)+" |  "+matcher.group(2)+" | "+matcher.group(3));

            System.out.println(matcher.group());
//            System.out.println(sb.toString());
        }


//        System.out.println(sb.toString());


//        System.out.println(matcher.replaceAll(" 东亮写 "));
//        System.out.println(matcher.replaceFirst(" 东亮写 "));

    }


    public static void main1(String[] args) {
        String text = "Cindarella and Sleeping Beauty sat in a tree";

        Pattern pattern = Pattern.compile(".*and.*|.*Sleeping Beauty.*");
        Matcher matcher = pattern.matcher(text);


        StringBuffer sb=new StringBuffer();
        while (matcher.find()){
//            System.out.println(matcher.group());
            matcher.appendReplacement(sb,"Joe Blocks");
            System.out.println(sb.toString());
        }


    }
}

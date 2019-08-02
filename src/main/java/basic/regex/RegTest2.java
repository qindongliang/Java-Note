package basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest2 {


    public static void orTest3(){

        String regex="(北京|上海)市";
        String input ="我们上周去了北京市，下周打算去上海市，下个月打算去深圳市";
//        String input ="上海市";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        System.out.println("是否全部相等："+Pattern.matches(regex,input));
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void orTest2(){

        String regex="(北京|上海)市";
        String input ="上海市";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        System.out.println("匹配成功："+Pattern.matches(regex,input));
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void orTest1(){

        String regex="cat|dog";
        String input ="this is dog";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        System.out.println("匹配成功："+Pattern.matches(regex,input));
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }


    public static void catchGroup2(){
        String regex="<h1>(.*?)@(.*?)</h1>";
        String input ="<h1>11111111@qq.com</h1>   <h1>2222222@126.com</h1>";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);

        while (matcher.find()){
            System.out.println("前缀："+matcher.group(1)+"   后缀："+matcher.group(2));
        }
    }

    public static void catchGroup(){


        String input="ABC";

        String regex="((A)(B(C)))";
        Pattern pattern=Pattern.compile(regex);//编译正则
        Matcher matcher=pattern.matcher(input);//获取匹配
        while (matcher.find()){//
            System.out.println(matcher.group());//
            System.out.println("==============");
            for (int i = 1; i <= matcher.groupCount(); i++) {
            System.out.println(matcher.group(i));
        }
        }

    }


    public static void greedy(){
        String regex="\\d+3";
        String input =" <h1>12345@qq.com</h1>   <h1>67890@qq.com</h1> ";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group());
        }



    }


    public static void main(String[] args) {
//        greedy();
//        main2(null);
//        catchGroup();
//    catchGroup2();
//    orTest1();
//    orTest2();
    orTest3();
    }




    public static void main2(String[] args) {
        String regex="\\d++@";
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

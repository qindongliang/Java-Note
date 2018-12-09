package leetcode.easy.string_all.string_to_lower_case;

/**
 * Created by qindongliang on 2018/12/9.
 * leetcode-string-709
 */
public class Solution {

    public static String toLowerCase(String str) {
        char[] chr=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (char c: chr) {

            if(c>='A'&&c<='Z'){
                c= (char) (c+ 32);
            }
            sb.append(c);

        }
        return  sb.toString();
    }


    public static void test1(){

        for (int i='a';i<='z';i++){

            System.out.print(i+""+ (char)i+"  ");

        }
        System.out.println();
        for (int i='A';i<='Z';i++){

            System.out.print(i+""+ (char)i+"  ");

        }


    }


    public static void main(String[] args) {
        test1();
        System.out.println(toLowerCase("CaseZADFDC"));
    }



}

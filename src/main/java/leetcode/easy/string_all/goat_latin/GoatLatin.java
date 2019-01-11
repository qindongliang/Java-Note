package leetcode.easy.string_all.goat_latin;

import java.util.*;

public class GoatLatin {

    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

    public static String toGoatLatin(String s){

        StringBuilder  sb=new StringBuilder();
        String array[]=s.split(" ");
        for(int i=0;i<array.length;i++){
            String word=array[i];
            char first=word.charAt(0);

            if(vowels.contains(first)){
                sb.append(word).append("ma");
            }else{
                sb.append(word.substring(1));
                sb.append(first);
                sb.append("ma");
            }

            for(int j=0;j<i+1;j++){
                sb.append("a");
            }
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }


    public static void main(String[] args) {


        System.out.println( toGoatLatin("I speak Goat Latin") );





    }


}

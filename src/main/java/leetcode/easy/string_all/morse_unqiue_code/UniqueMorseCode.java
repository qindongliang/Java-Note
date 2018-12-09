package leetcode.easy.string_all.morse_unqiue_code;

import java.util.HashSet;

/**
 * Created by qindongliang on 2018/12/9.
 */
public class UniqueMorseCode {
    String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {

        HashSet<String> unique=new HashSet<>();
        for (String word:words){
            StringBuilder sb=new StringBuilder();
            for(char c : word.toCharArray()){
                sb.append( morseCodes[c-'a']);
            }
            unique.add(sb.toString());
        }
       return  unique.size();


    }

    public static void main(String[] args) {



    }


}

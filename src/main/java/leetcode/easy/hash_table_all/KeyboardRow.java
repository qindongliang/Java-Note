package leetcode.easy.hash_table_all;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/***
 *
 * https://leetcode.com/problems/keyboard-row/
 * 找出在键盘上能用同一行字母打出来的单词
 *
 */
public class KeyboardRow {
    static String []strs={"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};

    static  Map<Character, Integer> map = new HashMap<>();
    static {

        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }

    }

    public static String[] findWords(String[] words) {
        List<String> res = new LinkedList<>();
        for (String w:words){
            if(w.equals("")) continue;
            String word=w.toUpperCase();
            int index=map.get(word.charAt(0));
            for (char c:word.toCharArray()){
                if(map.get(c)!=index){
                    index=-1;
                    break;
                }
            }

            if(index!=-1){
              res.add(w);
            }
        }

        return res.toArray(new String[0]);
    }


    public static void main(String[] args) {

    }

}

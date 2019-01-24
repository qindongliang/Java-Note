package leetcode.easy.string_all.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/***
 * Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    private static Map<Character,Integer> map=new HashMap<>();
    static {
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }

    public static int romanToInt(String s) {
        char romans[]=s.toCharArray();
        int sum=0;

        for (int i = 0; i < romans.length-1; i++) {

            int cur=map.get(romans[i]);
            int next=map.get(romans[i+1]);

            if(cur<next){
                sum=sum - cur;
            }else {
                sum=sum + cur;
            }
        }

        return sum+map.get(romans[romans.length-1]);
    }


    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));

    }



}

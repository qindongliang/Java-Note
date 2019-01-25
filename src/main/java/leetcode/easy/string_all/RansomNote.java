package leetcode.easy.string_all;

/***
 * 输入两个字符串，
 * a 和 b
 * a的组成，如果都能从b中完全构造出来，那么就返回true，否则返回false
 * 注意b里面同一个位置的字符只能使用一次。
 */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {


        int []arr=new int[26];//构造一个26大小的数组
        //将每个字符-'a'，归一到数组里面，记录每个字符出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)-'a']++;
        }
        //如果ransomNote中出现一个，数组里面就减去一个，如果小于0则说明字符不够用，直接返回false
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String ransomNote="aa";
        String magazine="acc";
        System.out.println(canConstruct(ransomNote,magazine));


    }

}

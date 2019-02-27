package leetcode.easy.string_all;

/***
 *
 * 输入一个字符串，然后反转里面的元音字母
 *
 * 解决思路：双指针法
 * start指针遇到元音字母的时候停下来，然后end指针向前遍历，知道遇到元音停下来，然后交换双方即可，
 * 最后两边的指针，分别start++，end--，进行下一轮的迭代
 *
 */
public class ReverseVowelsString {

    public static boolean isVowel(char a){
        switch(a){
            case ('a') : return true;
            case ('e') : return true;
            case ('i') : return true;
            case ('o') : return true;
            case ('u') : return true;
            case ('A') : return true;
            case ('E') : return true;
            case ('I') : return true;
            case ('O') : return true;
            case ('U') : return true;
            default : return false;
        }
    }



    public static String reverseVowels1(String s) {

        // 双指针法
        char[] tab=s.toCharArray();
        int i=0;
        int j=tab.length-1;


        while (i<j){

            if(!isVowel(tab[i])){//辅音的话左边偏移量++
                i++;
            }else{

                while (j!=i && !isVowel(tab[j])){
                    j--;
                }
                //到这一步的时候i和j都代表首和尾的原因的字母

                char temp=tab[i];
                tab[i]=tab[j];
                tab[j]=temp;
                i++;
                j--;


            }

        }

        return new String(tab);
    }


    private static final char[] charMap = new char[256];

    static {
        charMap['a'] = charMap['A'] = 1;
        charMap['e'] = charMap['E'] = 1;
        charMap['i'] = charMap['I'] = 1;
        charMap['u'] = charMap['U'] = 1;
        charMap['o'] = charMap['O'] = 1;
    }



    public static String reverseVowels(String s) {

        // 双指针法
        char[] tab=s.toCharArray();
        int start=0;
        int end=tab.length-1;

        while (start<end){

            if(charMap[tab[start]]==0){
                start++;
                continue;
            }

            if(charMap[tab[end]]==0){
                end--;
                continue;
            }

            char temp=tab[start];
            tab[start]=tab[end];
            tab[end]=temp;
            start++;
            end--;
        }




        return new String(tab);
    }






    public static void main(String[] args) {


        System.out.println(reverseVowels("leetcode"));

    }


}

package leetcode.easy.string_all.reverse_word;

/**
 * Created by qindongliang on 2018/12/15.
 */
public class ReverseWord2 {


    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String word:s.split(" ")) {
            char array[] = word.toCharArray();
            for (int i = array.length - 1; i >=0; i--) {
                sb.append(array[i]);
            }
            sb.append(" ");
        }

        return  sb.deleteCharAt(sb.length()-1).toString();
    }

    public static String reverseWords2(String s) {
            char[] arr=s.toCharArray();
        int len = s.length();
        int start = 0;
        for(int i = 0; i < len; i++){
            if(arr[i] == ' '){
                reverse(arr,start,i - 1);
                start = i + 1;
            }
        }
        reverse(arr,start,len -1);
        return  new String(arr);
    }

    private static void reverse(char[] arr, int start, int end) {

       while (start<end){
           char temp=arr[start];
           arr[start]=arr[end];
           arr[end]=temp;
           start++;
           end--;
       }


    }


    public static void main(String[] args) {

        String input="Let's take LeetCode contest";
        //性能一般
        System.out.println(reverseWords(input));
        //性能好
        System.out.println(reverseWords2(input));


    }



}

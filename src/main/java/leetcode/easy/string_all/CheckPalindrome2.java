package leetcode.easy.string_all;

/*****
 * 回文数：正读倒读都一样的整数
 * 1234321 奇数回文数
 * 124421  偶数回文数
 */
public class CheckPalindrome2 {

    /***
     * 使用双指针法判断是不是回文数字，然后最后在删除一位后判断
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {

      int  start=0;
      int  end=s.length()-1;
      while (start<end && s.charAt(start)==s.charAt(end)){
          start++;
          end--;
      }
      if(start>=end) return true;
      //删除一位后进行判断
      if(isPalin(s,start+1,end)||isPalin(s,start,end-1)) return true;
      return false;
    }

    private static boolean isPalin(String s , int i, int j){
        while (i<j){
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }

        return true;
    }





    public static void main(String[] args) {

        System.out.println(validPalindrome("abca"));

    }

}

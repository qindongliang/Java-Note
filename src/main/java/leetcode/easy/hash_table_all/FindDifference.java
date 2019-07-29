package leetcode.easy.hash_table_all;

/***
 *
 * Find the Difference
 *
 * 给定两个都是小写字母的字符串s和t，其中t比s多一个字母，
 * 让找出这个字母是哪个，文中提供了三种方式。
 *
 * （1）数组
 * (2)求和
 * （3）异或的方式
 *
 */
public class FindDifference {

    public static char findTheDifference(String s, String t) {
       char arr1[]=s.toCharArray();
       char arr2[]=t.toCharArray();

       char diff=arr2[arr2.length-1];

       for(int i=0;i<arr1.length;i++){
           diff^=diff^arr1[i]^arr2[i];
       }

       return diff;

    }

    public static char findTheDifference2(String s, String t) {
        int sum=0;
        for (char ch:s.toCharArray()){
            sum+=ch;
        }

        int tsum=0;
        for (char ch:t.toCharArray()){
            tsum+=ch;
        }

        return (char)(tsum-sum);
    }

    public static char findTheDifference1(String s, String t) {

        int arr[]=new int[26];

        for (char c:s.toCharArray()){
            arr[c-'a']++;
        }

        for (char c:t.toCharArray()){
            if(arr[c-'a']--==0){
                return c;
            }
        }

    return 'S';
    }

    public static void main(String[] args) {


        System.out.println(findTheDifference("abcd","abcde"));
    }


}

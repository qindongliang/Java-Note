package leetcode.easy.hash_table_all;

/****
 *
 *
 * 链接：https://leetcode.com/problems/isomorphic-strings/
 * 同构词
 *
 * 给定两个字符s和t，然后判断这两个词是否是同构词，
 *
 * 比如egg和add，paper和title就可以。但foo和bar就不行
 *
 *
 *
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        //256代表所有的ascii码的可能
        int []m1=new int[256];
        int []m2=new int[256];

        int n=s.length();
        for (int i = 0; i < n; i++) {
            //判断相同的位置是否不相等，如果不相等则返回false
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]){
              return false;
            }
            //相等则都从0计数，保持统一
            m1[s.charAt(i)]=i+1;
            m2[t.charAt(i)]=i+1;
        }

        //若都符合，都返回true
        return true;


    }

    public static void main(String[] args) {

        System.out.println(isIsomorphic("egg","add"));


    }






}

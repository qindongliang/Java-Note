package leetcode.easy.hash_table_all;

/***
 *
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 *
 * 描述，给定一个词组的数组，并给定指定的一个顺序排列字符串，让判断这个数组里面的词组
 * 是不是有序的，根据顺序排列字符串来判断
 */

public class VerifyingAlienDictionary {

    public static boolean isAlienSorted(String[] words, String order) {

        int []dict=new int[26];

        for (int i = 0; i < dict.length; i++) {
            int idx=order.charAt(i)-'a';
            dict[idx]=i;
        }

        for (int i = 0; i < words.length-1; i++) {
            //出现大于0的，说明大的在前面，那么顺序肯定不对
            if(compare(words[i],words[i+1],dict)>0) return false;
        }

        return true;
    }

    private static int compare(String word1,String word2,int[] dict){

        int l1=word1.length();
        int l2=word2.length();

        int min=Math.min(l1,l2);

        for (int i = 0; i < min; i++) {
            int c1=word1.charAt(i)-'a';
            int c2=word2.charAt(i)-'a';
            if(c1!=c2){
                //只要有不相等的字母就返回其对比值
                return dict[c1]-dict[c2];
            }
        }
        //走到这里说明，公共部分都相等，如果l1=min，说明
        //其实最短部分，直接返回-1，代表应该排在前面，否则就在后面
        return l1==min?-1:1;



    }


    public static void main(String[] args) {


        isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz");



    }

}

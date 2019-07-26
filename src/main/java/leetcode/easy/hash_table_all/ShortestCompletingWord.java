package leetcode.easy.hash_table_all;

/****
 *
 * 给定一个单词s，让求出words数组里面，最短的那个word与s里面的字母重合
 *
 */
public class ShortestCompletingWord {

    public String shortestCompletingWord(String s, String[] words) {

        int []counts=new int[26];

        int total=0;
        //对字符串里面出现的字母进行计数
        for (char c:s.toLowerCase().toCharArray()){
            if('a'<=c&&c<='z'){
             counts[c-'a']++;
             total++;
            }
        }

        String res=null;
        //遍历数组里面每一个word进行判断
        for (String w:words){
            int n=total;
            int []cnts=counts.clone();
            //如果某个计数值大于0就递减
            for (char c:w.toCharArray()){
                if(cnts[c-'a']-->0){
                    n--;//总数也递减
                }
            }

            //如果n=0，说明这个单词里面的单词和要找到的单词由重合，符合我们的要找的规律，
            //同时，如果后面出现多个这样规律的单词时，我们取长度短的作为返回值
            if(n==0&&(res==null||w.length()<res.length())){
                res=w;
            }

        }
        return res;

    }


    public static void main(String[] args) {

    }


}

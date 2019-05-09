package leetcode.easy.array_all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/find-common-characters/
 * 给定一个全英文字母小写的字符串数组
 * 统计出里面最小的公共字符的个数，最后输出到一个List<String>里面
 * 举例
 * [aooo, aoo, boo] , 输出是oo，注意oo需要拆分成2个字符放入List<String>里面
 */
public class FindCommonsCharacters {


    public static List<String> commonChars(String[] A) {

        List<String> ans=new ArrayList<>();
        //声明数组，用来保存最终的公共字符的个数
        int count[]=new int[26];
        //初始化填充最大值，便于统一处理
        Arrays.fill(count,Integer.MAX_VALUE);

        for (String str:A){

            // 对每一个字符串声明一个字符数组
            int[] cnt=new int[26];
            //统计在这一个字符串里面，每个字符出现的字数
            for(char c:str.toCharArray()){
                cnt[c-'a']++;
            }

            //拿当前字符串的数组统计值，与count数组里面的统计值进行比较，取最小值就是公共字符（木桶短板决定）
            //注意，如果第一个字符串里面出现某个字符，第二个字符串里面没有出现，那么取最小值就是没有出现，这一点需要注意
            for (int i = 0; i < 26; i++) {
                count[i]=Math.min(count[i],cnt[i]);
            }

        }

        //依次循环处理完所有的字符串后，进行遍历输出组装，就是所有的公共字符
        for(char c='a';c<='z';c++){
            while (count[c-'a']-->0){
                ans.add(c+"");
            }

        }

        return ans;
    }


    public static void main(String[] args) {

        System.out.println(commonChars(new String[]{"bella","label","roller"}));

    }



}

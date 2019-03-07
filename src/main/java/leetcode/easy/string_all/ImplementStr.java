package leetcode.easy.string_all;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ImplementStr {
    @Test
    @Parameters({"hello, ll"})
    public int strStr(String haystack, String needle) {

        System.out.println(haystack+"  "+needle);

        int s1=haystack.length();
        int s2=needle.length();

        if(s1<s2){
            return -1;
        }else if(s2==0){
            return 0;
        }

        int threshold = s1 - s2;

        for (int i = 0; i <=threshold ; ++i) {
            if(haystack.substring(i,i+s2).equals(needle)){
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

}

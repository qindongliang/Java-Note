package leetcode.easy.string_all;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LastWordLength {

    @Test
    @Parameters({"Hello  adf  dfdfdf dfdgdfdf dddx Worl  "})
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int len=s.length() - s.lastIndexOf(" ")-1;
        System.out.println(len);
        return len;
    }



}

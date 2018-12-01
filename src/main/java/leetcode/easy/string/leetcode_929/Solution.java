package leetcode.easy.string.leetcode_929;

import java.util.HashSet;

/**
 * Created by qindongliang on 2018/12/1.
 */
public class Solution {

    public static int numUniqueEmails2(String[] emails) {
        HashSet<String > sets=new HashSet<>();
        for (String email:emails) {
            String parts[]=email.split("@");//split by "@"
            String local[]= parts[0].split("\\+");
            StringBuilder sb=new StringBuilder();
            sb.append(local[0].replace(".",""));
            sb.append("@");
            sb.append(parts[1]);
            sets.add(sb.toString());
        }

        return sets.size();

    }

    public static int numUniqueEmails(String[] emails) {
        HashSet<String > sets=new HashSet<>();
        for (String email:emails) {
            String suffix=email.substring(email.indexOf("@"));
            sets.add(suffix);

        }


        return sets.size();

    }

    public static void main(String[] args) {

        String datas[]={"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};


        System.out.println(numUniqueEmails(datas));


    }

}

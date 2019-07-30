package leetcode.easy.hash_table_all;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        char arr1[]=s.toCharArray();
        char arr2[]=t.toCharArray();
        if(arr1.length!=arr2.length){
            return false;
        }
        int ct[]=new int[26];

        for (int i = 0; i < arr1.length; i++) {
           ct[arr1[i]-'a']++;
           ct[arr2[i]-'a']--;
        }

        for (int i : ct) {
            if(i!=0) return false;
        }

        return  true;
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("abe","bca"));
    }

}

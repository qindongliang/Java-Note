package leetcode.easy.string_all.reverse_only_letters;

public class ReverseOnlyLetters {

    public static boolean isalphabet(char c){
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')) return true;
        else return false;
    }

    public static String reverseOnlyLetters(String S) {

        char array[]=S.toCharArray();

        int start=0;
        int end=S.length()-1;


        while(start<end){

            char leftChar=array[start];
            char rightChar=array[end];

            boolean left=isalphabet(leftChar);
            boolean right=isalphabet(rightChar);

            if(left&&right){
                char temp=leftChar;
                array[start]=rightChar;
                array[end]=temp;
                start++;
                end--;
            }else if(left==false){
                start++;
            }else{
                end--;
            }

        }

        return new String(array);

    }


    public static void main(String[] args) {

//        String str="ab-cd";
//        String str="a-bC-dEf-ghIj";
        String str="Test1ng-Leet=code-Q!";


        System.out.println(reverseOnlyLetters(str));




    }


}

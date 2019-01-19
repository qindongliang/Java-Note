package leetcode.easy.string_all.detect_capital;

public class DetectCapital {

    public static boolean detectCapitalUse(String word) {

        int  upperCount=0;
        int  lowwerCount=0;
        char letters[]=word.toCharArray();
        char firstLetter=letters[0];

        for (int i = 0; i < letters.length ; i++) {
            char c=letters[i];
            if(c>=65 && c<=90){
                upperCount++;
            }else{
                lowwerCount++;
            }
        }

        if(upperCount==letters.length||lowwerCount==letters.length){
            return true;
        }



        if( upperCount==1 && (firstLetter>=65 && firstLetter<=90 )){
            return true;
        }

        return false;
    }




    public static void main(String[] args) {

        System.out.println(detectCapitalUse("Faaab"));

    }

}

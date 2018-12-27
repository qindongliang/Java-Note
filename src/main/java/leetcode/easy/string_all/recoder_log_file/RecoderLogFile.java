package leetcode.easy.string_all.recoder_log_file;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/***
 *
 * 给定一个字符串log数组
 *
 * 所有的字符串都是通过空格分隔，第一个代表标识符，之后的是整个log信息，log的开头可以是字符串和数字
 * 现在要求如下：
 *
 * 对数组里面的数据，进行排序，如果开头是字母的则按照字母序排列，如果开头是数字的则保持数字顺序。
 * 如果字母顺序相等则可以按照前面的序号进行排序。
 *
 */
public class RecoderLogFile {


    public static void main(String[] args) {

        //通过优先级队列，来实现排序
        PriorityQueue<String> queue=new PriorityQueue<String>(new LetterComparator());

        List<String> digitLogs = new ArrayList();

        String []logs=new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

        List<String> results = new ArrayList<String>();

        for(String log:logs){
            if(isDigitLog(log)){//判断第一个字符
                digitLogs.add(log);
            }else{
                queue.add(log);
            }

        }

        while(!queue.isEmpty()){
            results.add(queue.poll());
        }

        results.addAll(digitLogs);


        System.out.println(results);


    }

    private static boolean isDigitLog(String logLine) {
        return Character.isDigit(logLine.charAt(logLine.indexOf(' ') + 1));
    }





  static  public class IntegerComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
//            return o2.compareTo(o1);
            return o1.compareTo(o2);
        }
    }



  static  public class LetterComparator implements Comparator<String>{

        @Override
        public int compare(String str1, String str2) {

            int spaceIndex1=str1.indexOf(' ');
            int spaceIndex2=str2.indexOf(' ');

            String word1=str1.substring(spaceIndex1+1);
            String word2=str2.substring(spaceIndex2+1);
            int status=word1.compareTo(word2);

            if(status==0){
                String identifier1=str1.substring(0,spaceIndex1);
                String identifier2=str1.substring(0,spaceIndex2);
                return identifier2.compareTo(identifier1);
            }

            return status;
        }
    }




}

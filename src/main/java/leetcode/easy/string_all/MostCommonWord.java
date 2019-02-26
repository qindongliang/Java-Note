package leetcode.easy.string_all;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostCommonWord {

    static String filter="[!?',;.]";

    static class Word{
       public String word;
       public Integer count;

        public Word(String word, Integer count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    static  public class WordComparator implements Comparator<Word>{

        @Override
        public int compare(Word o1, Word o2) {
//            return o2.compareTo(o1);
            return o2.count.compareTo(o1.count);
        }
    }


    static  PriorityQueue<Word> queue=new PriorityQueue<Word>(new WordComparator());

    public static String mostCommonWord2(String paragraph, String[] banned) {
        queue.clear();
        paragraph=paragraph.replaceAll(filter," ");

        String array[]=paragraph.split(" ");
        HashMap<String,Integer> map=new HashMap<>();
        for(String word:array){
            word=word.toLowerCase().trim();
            Integer count=map.get(word);
            if(count!=null){
                map.put(word,count+1);
            }else{
                map.put(word,1);
            }
        }

        for (String stopWord:banned){
         map.remove(stopWord);
        }
        map.remove("");
        for(Map.Entry<String,Integer> kv:map.entrySet()){
            queue.add(new Word(kv.getKey(),kv.getValue()));
        }
        return queue.peek().word;
    }



    public static String mostCommonWord(String paragraph, String[] banned) {
        //split不需要的字符
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        //放入hashMap做统计词频
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        //移除禁用词
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        System.out.println(map);
        //遍历一遍依次比较相邻两个值的大小，最后记录结果返回
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;

    }




    public static void main(String[] args) {

//        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c",new String[]{"a"}));
        System.out.println(mostCommonWord("Bob. hIt, baLl",new String[]{"bob","hit"}));

    }

}

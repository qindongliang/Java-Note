package leetcode.easy.tree;

public class TrieByArray {


   static   class TrieNode{


       TrieNode[] children;
       boolean endFlag;

       public TrieNode(){
           children=new TrieNode[26];
       }
    }


    TrieNode root;

   public TrieByArray(){
       root=new TrieNode();
   }


   public void insert(String word){

       TrieNode prev=root;

       for (int i = 0; i < word.length(); i++) {

           if(prev.children[word.charAt(i)-'a']==null){
               prev.children[word.charAt(i)-'a']=new TrieNode();
           }

           prev=prev.children[word.charAt(i)-'a'];

       }

       prev.endFlag=true;

   }

   public boolean search(String word){
       TrieNode result=checkExists(word);
       if(result!=null&&result.endFlag){
           return true;
       }
       return false;

   }


   public TrieNode checkExists(String query){

       TrieNode cur=root;

       for (int i = 0; i < query.length(); i++) {
           //待查询的字符不存在
           if(cur.children[query.charAt(i)-'a']==null){
               return cur.children[query.charAt(i)-'a'];
           }else{
               cur=cur.children[query.charAt(i)-'a'];;
           }
       }

       return cur;
   }




   public boolean startsWith(String prefix){
       TrieNode result=checkExists(prefix);
       if(result!=null){
           return true;
       }
       return false;
    }







    public static void main(String[] args) {
        TrieByArray trie = new TrieByArray();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true

        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

}

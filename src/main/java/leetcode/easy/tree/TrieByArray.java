package leetcode.easy.tree;

public class TrieByArray {


   static   class TrieNode{


       TrieNode[] children;
       boolean isWord;

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

       prev.isWord =true;

   }

   public boolean search(String word){
       TrieNode result=checkExists(word);
       if(result!=null&&result.isWord){
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


   public void delete(String key){
     if(root==null||key==null){
         return;
     }

       deleteWord(root,key,key.length(),0);

   }

   private boolean hasChildren(TrieNode currentNode){
       for (int i = 0; i < currentNode.children.length; i++) {
           if(currentNode.children[i]!=null){
               return true;
           }
       }
       return false;
   }


   public boolean deleteWord(TrieNode currentNode,String word,int length,int level){
       boolean deletedSelf=false;
       if(level==length){
            //如果当前节点是最后，并且没有孩子节点
           if(!hasChildren(currentNode)){
               currentNode=null;
               deletedSelf=true;
           }else{//有孩子节点
               currentNode.isWord =false;//则将其置为非单词属性即可
               deletedSelf=false;
           }

       }else {
           //由下而上递归删除
           TrieNode childNode=currentNode.children[word.charAt(level)-'a'];
           boolean childDeleted=deleteWord(childNode,word,length,level+1);
           if(childDeleted){//如果单词的最后的字符没有孩子节点，就可以被删除，然后需要继续向上递归判断其前一个字符是否是需要删除
               currentNode.children[word.charAt(level)-'a']=null;//设置子节点为null
               if(currentNode.isWord){//判断父节点是否是一个word的结束，如果是说明是公共前缀就不能再删除了
                   deletedSelf=false;
               }else if(hasChildren(currentNode)){//如果这个父节点还有孩子节点，说明也是公共前缀，也不能再删除了
                  deletedSelf=false;
               }else{//到这一步，说明父节点也是要删除单词唯一的的字符，可以继续向上删除
                   currentNode=null;
                   deletedSelf=true;
               }
           }else {//如果不需要被删除，则向上传递false即可
               deletedSelf=false;
           }
       }

       return deletedSelf;
   }



   public boolean startsWith(String prefix){
       TrieNode result=checkExists(prefix);
       if(result!=null){
           return true;
       }
       return false;
    }







    public static void main(String[] args) {

       TrieByArray trie=new TrieByArray();
       trie.example1();
//       trie.example2();
//       trie.example3();


   }

   private void example1(){
       TrieByArray trie = new TrieByArray();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true

        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
   }

   private void example2(){
       TrieByArray trie = new TrieByArray();

       trie.insert("gat");
       trie.insert("gag");
       System.out.println(trie.search("gat"));//true
       System.out.println(trie.startsWith("ga"));//true
       trie.delete("gat");
       System.out.println(trie.search("gat"));//false
       System.out.println(trie.startsWith("ga"));//true
       System.out.println(trie.search("gag"));//true
   }

   private void example3(){
       TrieByArray trie = new TrieByArray();
       trie.insert("abcd");
       trie.insert("abc");

       System.out.println(trie.search("abc"));
       System.out.println(trie.startsWith("abc"));

       trie.delete("abc");

       System.out.println(trie.search("abc"));
       System.out.println(trie.search("abcd"));
       System.out.println(trie.startsWith("abc"));
   }


}

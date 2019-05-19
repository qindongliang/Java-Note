package leetcode.easy.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieByMap {

    static class TrieNode{
        Map<Character,TrieNode> children;
        boolean isWord;
        public TrieNode(){
            children=new HashMap<>();
        }
    }


    TrieNode head;

    public TrieByMap(){
        head=new TrieNode();
    }

    public void insert(String word){
        TrieNode prev=head;
        for (int i = 0; i < word.length(); i++) {

            char c=word.charAt(i);
            //HashMap不包含这个字符的映射
            if(prev.children.containsKey(c)==false){
                prev.children.put(c,new TrieNode());
            }
            prev=prev.children.get(c);
        }

        prev.isWord =true;
    }

    public boolean search (String word){
       TrieNode node= checkExists(word);
       if(node!=null&&node.isWord){
           return true;
       }
       return false;
    }

    public boolean startsWith(String prefix){
        TrieNode node= checkExists(prefix);
        if(node!=null){
            return true;
        }
        return false;
    }


    public TrieNode checkExists(String query){

        TrieNode cur=head;

        for (int i = 0; i < query.length(); i++) {
            if(!cur.children.containsKey(query.charAt(i))){
                return null;
            }
            cur=cur.children.get(query.charAt(i));
        }
        return cur;

    }


    public void delete(String word){
        if(head==null||word==null){
            return;
        }
        deleteWord(head,word,word.length(),0);

    }

    private boolean hasChildren(TrieNode currentNode){
         if(currentNode.children!=null && currentNode.children.size()>0){
             return true;
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
            TrieNode childNode=currentNode.children.get(word.charAt(level)-'a');
            boolean childDeleted=deleteWord(childNode,word,length,level+1);
            if(childDeleted){//如果单词的最后的字符没有孩子节点，就可以被删除，然后需要继续向上递归判断其前一个字符是否是需要删除
                currentNode.children.remove(word.charAt(level)-'a');//设置子节点为null
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


    public static void main(String[] args) {
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






}

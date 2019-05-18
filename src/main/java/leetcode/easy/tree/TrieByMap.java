package leetcode.easy.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieByMap {

    static class TrieNode{
        Map<Character,TrieNode> children;
        boolean isComplete;
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

        prev.isComplete=true;
    }

    public boolean search (String word){
       TrieNode node= checkExists(word);
       if(node!=null&&node.isComplete){
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








}

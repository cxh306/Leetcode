package Hot100;

import org.junit.Test;

public class Trie {
    private Trie[] childrens=new Trie[26];
    private boolean isEnd;
    public Trie() {
    }

    public void insert(String word) {
        int len=word.length();
        Trie node=this;
        for (int i = 0; i < len; i++) {
            int idx=word.charAt(i)-'a';
            if(node.childrens[idx]==null) node.childrens[idx]=new Trie();
            node=node.childrens[idx];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        Trie node = searchWords(word);
        if(node!=null&&node.isEnd) return true;
        else return false;
    }

    public boolean startsWith(String prefix) {
        Trie trie = searchWords(prefix);
        if(trie==null) return false;
        else return true;
    }

    private Trie searchWords(String word){
        int len=word.length();
        Trie node=this;
        for (int i = 0; i < len; i++) {
            int idx=word.charAt(i)-'a';
            node=node.childrens[idx];
            if(node==null) return null;
        }
        return node;
    }

    @Test
    public void test(){
        Trie a=new Trie();
        a.insert("apple");
    }
}

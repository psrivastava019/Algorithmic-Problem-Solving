class Trie {
    
    Trie[] children=null;
    /** Initialize your data structure here. */
    public Trie() {
        this.children=new Trie[26];        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.length()>0){
            int index=word.charAt(0)-'a';
            if(children[index]==null){
                children[index]=new Trie();
            }
            else{
                children[index].insert(word.substring(1));
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return this.startsWith(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int index=prefix.charAt(0)-'a';
        if(children[index]!=null){
            System.out.println(prefix);
            if(prefix.length()==1){
                return true;
            }
            else{
                return children[index].startsWith(prefix.substring(1));
            }
        }
        else{
            return false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class Trie1{
	public static void main(String args[]) {
		Trie obj = new Trie();
		 obj.insert("apple");
		 boolean param_2 = obj.search("apple");
		 boolean param_3 = obj.startsWith("app");
	}
}
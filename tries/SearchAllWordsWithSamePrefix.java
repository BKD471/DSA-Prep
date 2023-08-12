package tries;

class Node{
    Node[] data=new Node[26];
    int count;
    boolean isEnd;
    Node(){
        for(int i=0;i<25;i++) data[i]=null;
        count=0;
        isEnd=false;
    }
}


public class SearchAllWordsWithSamePrefix {

}

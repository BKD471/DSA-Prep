package tries;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

class Tries{
    public Tries[] node;
    public ArrayList<Integer> idx;
    public boolean isEnd;
    Tries(){
        this.node=new Tries[26];
        this.idx=new ArrayList<>();
        this.isEnd=false;
    }
}

class Pair{
    String words;
    int weight;
    Pair(String words,int weight){
        this.words=words;
        this.weight=weight;
    }
}

public class AutoComplete {
    private static void createTrie(Tries root,String word,int indx){
        int n=word.length();
        if(n==0) return;

        Tries curr=root;
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(curr.node[index]==null){
                curr.node[index]=new Tries();
            }
            curr=curr.node[index];
            if(curr.idx.size()<5) curr.idx.add(indx);
        }

    }

    private static  void display(Tries root,String prefix,Pair[] pair){
        int n=prefix.length();
        if(n==0) return;


        Tries curr=root;
        for(int i=0;i<n;i++){
            int index=prefix.charAt(i)-'a';
            if(curr.node[index]==null){
                System.out.println("-1 ");
                return;
            }
            else curr=curr.node[index];
        }
        for(int i:curr.idx){
            System.out.print(pair[i].words+" ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        int t=0;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t-->0){
            int m=sc.nextInt();
            int n=sc.nextInt();
            String[] words=new String[m];
            String[] prefix=new String[n];

            int[] weight=new int[m];

            for(int i=0;i<m;i++) words[i]=sc.next();
            for(int i=0;i<m;i++) weight[i]=sc.nextInt();
            for(int i=0;i<n;i++) prefix[i]=sc.next();

            Pair[] pair=new Pair[m];
            for(int i=0;i<m;i++) pair[i]=new Pair(words[i],weight[i]);

            Comparator<Pair> sortPair=(a, b) -> (a.weight>b.weight)? -1:(a.weight<b.weight)? 1:0;
            Arrays.sort(pair,sortPair);

            Tries root=new Tries();
            for(int i=0;i<m;i++) createTrie(root,pair[i].words,i);
            for(int i=0;i<n;i++) display(root,prefix[i],pair);
        }
        sc.close();
    }
}

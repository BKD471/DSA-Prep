package Greedy;

import java.util.Arrays;

class Item{
    int value,weight;
    Item(int value,int weight){
        this.value=value;
        this.weight=weight;
    }
}

class Pair{
    int weight;
    int price;
    double pricePerWeight;
    Pair(int price,int weight,double pricePerWeight){
        this.price=price;
        this.weight=weight;
        this.pricePerWeight=pricePerWeight;
    }
}
public class FractionalKnapSack {
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        Pair[] items=new Pair[n];

        for(int i=0;i<n;i++) {
            double pricePerWeight=(double)(arr[i].value/arr[i].weight);
            items[i]=new Pair(arr[i].value,arr[i].weight,pricePerWeight);
        }

        Arrays.sort(items,(a,b)-> (a.pricePerWeight>b.pricePerWeight)?-1
                :(a.pricePerWeight<b.pricePerWeight)? 1:0 );

        double cost=0.0;
        int k=W;
        for(int i=0;i<n;i++){
            if(k>=items[i].weight){
                cost+=(items[i].price);
                k-=items[i].weight;
            }else{
                cost+=(k*items[i].pricePerWeight);
                break;
            }
        }
        return cost;

    }
}


/*
  123456789
1 ooooooooo
2 ococococo
3 occcooocc
4 occoooooc
5 occocoocc
6 occoccooc
7 occocccoc
8 occoccccc
9 occocccco

--> 3

1 4 9 will be opned becauze they have odd #factors

#nof of factors 1 2 3 4 5 6 7 8 9 10
        state   o c o c 0 c 0 c 0 c

we know  perfect square have od factors
so prblem gets reduced to count no of perfect square from 1-->n

from maths we know %factors from 1->n=Sqrt(n)
*/
public class DoorBell {
    public int count(int n){
        return (int)Math.sqrt(n);
    }
}

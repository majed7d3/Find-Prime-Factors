import java.util.Random;
import java.lang.Math;

public class factorization {
    private DLL list = new DLL();
    private int factures = 1;
    int counter = 0;

    public void findFactor(int n){
        int x = 2, y = 2;
        int c = (new Random()).nextInt();
        c = c == 0? c++: c;
        int output;
        boolean flag = false;
        while (counter < 10) {
            if(flag){
                c = (new Random()).nextInt();
                c = c == 0? c++: c;
                flag = false;
            }
            output = recursive_findFactor(x,y,n,c);
            if(output <= 0){
                flag = true;
            }
            if(output == 1){
                break;
            }
        }
        if(!list.empty()){
            printFact();
        }
        else{
            System.out.println(n+" is a prime");
        }
    }

    private int recursive_findFactor(int x, int y, int n, int c){
        try{
            x = randomFunction(x, c, n);
            y = randomFunction(randomFunction(y, c, n), c, n);
            if(x == y){
                counter++;
                return -1;
            }
            int d = gcd(Math.abs(x-y), n);
            if(d > 1 && d < n){
                list.insert(d);
                factures = factures*d;
                if(factures == n){
                    return 1;
                }
                if(factures > n || Math.floor(((double) n)/((double) factures)) != (((double) n)/((double) factures))){
                    counter++;
                    list.delete();
                    factures = factures/d;
                    return -1;
                }
                if(factures < n){
                    counter--;
                    return 0;
                }
            }
            return recursive_findFactor(x,y,n,c);
        }catch (Exception e){
            return -2;
        }
    }

    public int gcd(int a, int b){
        int max,min;
        max = a > b? a:b;
        min = a < b? a:b;
        return recursive_gcd(max, min);
    }

    private int recursive_gcd(int a, int b){
        if(b == 0)
            return a;
        return recursive_gcd(b,(a%b));
    }

    public int randomFunction(int x, int c, int n){
        return ((x*x)+c)%n;
    }

    public void printFact(){
        list.goFirst();
        while(!list.last()) {
            System.out.print(list.getVal()+"*");
            list.next();
        }
        System.out.print(list.getVal());
    }
}

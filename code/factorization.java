import java.util.Random;
import java.lang.Math;

public class factorization {
    private DLL list = new DLL();
    private int factures = 1;
    private int gole = 0;

    public void findFactor(int n){
        if(!isPrime(n)){
            int x = 2, y = 2;
            int c = Math.abs((new Random()).nextInt(n)+1);
            int output;
            gole = n;
            int count = 0;
            while (count++ < 100) {
                c = Math.abs((new Random()).nextInt(gole)+1);
                output = recursive_findFactor(x,y,n,c);
                if(output > 1){
                    list.insert(output);
                    n = (int) Math.floor(((double) n)/((double) output));
                }
                if(factures == gole){
                    break;
                }
            }
            printFact();
        }
        else{
            System.out.println(n+" is a prime");
        }
    }

    private int recursive_findFactor(int x, int y, int n, int c){
        if(n%2 == 0){
            factures *= 2;
            return 2;
        }
        if(n%3 == 0){
            factures *= 3;
            return 3;
        }
        if(isPrime(n)){
            factures *= n;
            return n;
        }


        x = randomFunction(x, c, n);
        y = randomFunction(randomFunction(y, c, n), c, n);
        if(x == y){
            return -1;
        }
        int d = gcd(Math.abs(x-y), n);
        if(1 < d && d < n){
            factures *= d;
            if(isPrime(d) && Math.floor(((double) gole)/((double) factures)) == (((double) gole)/((double) factures))){
                return d;
            }
            factures /= d;
            return 1; 
        }
        return recursive_findFactor(x, y, n, c);
    }

    public boolean isPrime(int n){
        for(int i = 2; i < (int) Math.sqrt(n)+1; i++){
            if(n%i == 0)
                return false;
        }
        return true;
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

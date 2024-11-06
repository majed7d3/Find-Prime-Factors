import java.util.Scanner;

public class run {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        factorization func = new factorization();
        System.out.println("inter a number to finde it factorize: ");
        int n = input.nextInt();
        func.findFactor(n);
    }
}

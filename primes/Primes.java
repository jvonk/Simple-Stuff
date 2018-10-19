import java.util.*; 

public class Primes {
    public static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> primeNumbers = new LinkedList<>();
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
    public static void main (String[] args) {
        if(args.length>0) System.out.println(sieveOfEratosthenes(Integer.parseInt(args[0])));
    }
}
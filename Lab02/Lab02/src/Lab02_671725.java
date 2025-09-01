import Lab02.pack.L2_IsPrimeInterface;
import Lab02.pack.IsPrime0;
import Lab02.pack.IsPrime1;
import Lab02.pack.IsPrime2;

public class Lab02_671725 {
    static int NN = 100_000;
    public static void main(String[] args) {
        testIsPrime012();
        L2_IsPrimeInterface [] obj = new L2_IsPrimeInterface[3];
        obj[0] = new IsPrime0();
        obj[1] = new IsPrime1();
        obj[2] = new IsPrime2();
        for (int i = 0; i < 3; i++)
            bench_isPrime(obj[i]);
    }
    private static void testIsPrime012() {
        int N = 100;
        int count = 0;
        L2_IsPrimeInterface obj = new IsPrime0();
        for (int n = 1; n < N; n++) {
            if (obj.isPrime(n)) count++;
        }
        System.out.println("Pi ("+ N + ")= " + count);
        count = 0;
        obj = new IsPrime1();
        for (int n = 1; n < N; n++) {
            if (obj.isPrime(n)) count++;
        }
        System.out.println("Pi ("+ N + ")= " + count);
        count = 0;
        obj = new IsPrime2();
        for (int n = 1; n < N; n++) {
            if (obj.isPrime(n)) count++;
        }
        System.out.println("Pi ("+ N + ")= " + count);
    }
public static void bench_isPrime(L2_IsPrimeInterface obj) { 
    System.out.println("starting measuring runtime");
    int your_cpu_factor = 1; /* increase by 10 times */
    int N = 100;
    int count = 0;
    for (N = 100_000; N <= 1_000_000 * your_cpu_factor; N+= 100_000 * your_cpu_factor) {
        count = 0;
        long start = System.currentTimeMillis();
        for (int n = 1; n < N; n++) {
            if (obj.isPrime(n)) count++;
        }
        long time = (System.currentTimeMillis() - start);
        System.out.println(N + "\t" + count + "\t" + time);
        // System.out.printf("%s\t %s\t %s",String.format("%,d",N), String.format("%,d",count), String.format("%,d",time));
    }
}
}
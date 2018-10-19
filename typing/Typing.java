import java.util.*;
import java.io.*;

public class Typing {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int count = 0;
        List<Double> times = new ArrayList<Double>();
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 5000) {
            double temp = 5.0 - ((System.currentTimeMillis() - start) / 1000.0);
            System.out.print("\r" + Math.round(temp * 1000) / 1000.0);
        }
        System.out.println("\n");
        while (true) {
            int num = 0;
            start = System.currentTimeMillis();
            String line = kb.nextLine();
            if (line.equals("end"))
                break;
            StringTokenizer l = new StringTokenizer(line);
            while (l.hasMoreTokens()) {
                num += l.nextToken().length() + 1;
            }
            long end = System.currentTimeMillis();
            System.out.println(12000.0 * num / (end - start));
            times.add(12000.0 * num / (end - start));
            while (System.currentTimeMillis() - end < 5000) {
                double temp = 5.0 - ((System.currentTimeMillis() - end) / 1000.0);
                System.out.print("\r" + Math.round(temp * 1000) / 1000.0);
            }
            System.out.print("\r\n");
        }
        double total = 0.0;
        double min = Double.MAX_VALUE;
        for (double t : times) {
            if (t < min) {
                min = t;
            }
        }
        for (int i = 0; i < times.size(); i++) {
            total += times.get(i);
            System.out.print(times.get(i) + "\t");
            for (int j = (int) (Math.log(min) / Math.log(1.02)) * 2 - 1; j < Math.log(times.get(i)) / Math.log(1.02)
                    * 2; j++) {
                System.out.print('|');
            }
            System.out.println();
        }
        double temp = total / times.size();
        System.out.print(temp + "\t");
        for (int j = (int) (Math.log(min) / Math.log(1.02)) * 2 - 1; j < Math.log(temp) / Math.log(1.02)
                * 2; j++) {
            System.out.print('|');
        }
        System.out.println();
    }
}
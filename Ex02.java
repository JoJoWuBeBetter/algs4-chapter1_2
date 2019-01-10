/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;

public class Ex02 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] interval1DS = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            double lo = Math.random();
            double hi = Math.random();

            if (lo > hi) {  // 第一个值一定要比后一个值小
                interval1DS[i] = new Interval1D(hi, lo);
            }
            else {
                interval1DS[i] = new Interval1D(lo, hi);
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (interval1DS[i].intersects(interval1DS[j])) {
                    StdOut.println(interval1DS[i] + " intersect " + interval1DS[j]);
                }
            }
        }
    }
}

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex03 {
    public static Interval1D makeInerval1D(double lo, double hi) {
        if (lo > hi) {
            return new Interval1D(hi, lo);
        }
        else {
            return new Interval1D(lo, hi);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        Interval2D[] interval2DS = new Interval2D[N];
        Point2D[][] diagonalPoints = new Point2D[N][2];

        for (int i = 0; i < N; i++) {

            double xlo, xhi, ylo, yhi;

            xlo = StdRandom.uniform(min, max);
            xhi = StdRandom.uniform(xlo, max);
            ylo = StdRandom.uniform(min, max);
            yhi = StdRandom.uniform(ylo, max);

            interval2DS[i] = new Interval2D(new Interval1D(xlo, xhi), new Interval1D(ylo, yhi));
            diagonalPoints[i][0] = new Point2D(xlo, ylo);
            diagonalPoints[i][1] = new Point2D(xhi, yhi);
            interval2DS[i].draw();
        }

        int intersectCount = 0;
        int indexCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (interval2DS[i].intersects(interval2DS[j])) {
                    intersectCount++;
                }
                
                if (interval2DS[i].contains(diagonalPoints[j][0]) && interval2DS[i]
                        .contains(diagonalPoints[j][1])) {
                    indexCount++;
                }

                if (interval2DS[j].contains(diagonalPoints[i][0]) && interval2DS[j]
                        .contains(diagonalPoints[i][1])) {
                    indexCount++;
                }
            }
        }
        StdOut.println("intersectCount:" + intersectCount);
        StdOut.println("indexCount:" + indexCount);
    }
}

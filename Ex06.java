/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex06 {
    public static void main(String[] args) {
        String s = StdIn.readString();
        StdOut.println("s:" + s);
        String t = StdIn.readString();
        StdOut.println("t:" + t);
        if (s.length() == t.length() && s.concat(s).contains(t)) {
            StdOut.println("s is circular rotation of t");
        }
        else {
            StdOut.println("s is not circular rotation of t");
        }
    }
}

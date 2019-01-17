/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class VisualCounter {
    private int N;
    private int max;
    private int count;

    public VisualCounter(int N, int max) {
        this.N = N;
        this.max = max;
    }

    public void increment() {
        if (N > 0 && Math.abs(max) > Math.abs(count)) {
            count++;
            N--;
            max--;
        }
    }

    public void reduction() {
        if (N > 0 && Math.abs(max) > Math.abs(count)) {
            count--;
            N--;
            max--;
        }
    }
}

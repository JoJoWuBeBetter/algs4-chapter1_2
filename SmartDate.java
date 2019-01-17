/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class SmartDate {
    private int month;
    private int day;
    private int year;

    public SmartDate(int m, int d, int y) {
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (d > 0 && d <= 31) {
                    month = m;
                    day = d;
                    year = y;
                }
                else {
                    throw new IllegalArgumentException("Illegal date");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (d > 0 && d <= 30) {
                    month = m;
                    day = d;
                    year = y;
                }
                else {
                    throw new IllegalArgumentException("Illegal date");
                }
                break;
            case 2:
                if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
                    if (d > 0 && d <= 29) {
                        month = m;
                        day = d;
                        year = y;
                    }
                    else {
                        throw new IllegalArgumentException("Illegal date");
                    }
                }
                else {
                    if (d > 0 && d <= 28) {
                        month = m;
                        day = d;
                        year = y;
                    }
                    else {
                        throw new IllegalArgumentException("Illegal date");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal date");
        }


    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String dayOfTheWeek() {
        int y, m;
        if (month == 1 || month == 2) {
            m = month + 12;
            y = year - 1;
        }
        else {
            y = year;
            m = month;
        }

        int week = (day + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400 + 1) % 7;

        switch (week) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                throw new IllegalArgumentException("error date");
        }
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public static void main(String[] args) {
        SmartDate a = new SmartDate(1, 11, 2019);
        StdOut.println(a.dayOfTheWeek());
    }
}

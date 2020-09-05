package exercises;

import java.util.Scanner;

import static java.lang.System.*;

/*
 *   Program to calculate the day number for same day in a given year.
 *   - To check solution, see http://mistupid.com/calendar/dayofyear.htm
 *
 *   This is exercising functional decomposition
 *   Assume you have a top level method solving the problem. Break down
 *   top level method into smaller methods solving parts of the problem etc.
 *   During this we run tests to make sure the methods works as expected.
 *   Combine the method to solve the problem.
 *
 */
public class Ex8DayNumber {

    public static void main(String[] args) {
        new Ex8DayNumber().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        //test();                // <--------- Uncomment to test only

        // -- In ----------------
        out.print("Input the year > ");
        int year = sc.nextInt();
        out.print("Input the month number > ");
        int month = sc.nextInt();
        out.print("Input the day number > ");
        int day = sc.nextInt();

        // --- Process ---------

        // Write the code to call top level method here
        // Then break the method down in smaller methods, call them etc.
        int dayNbr = DayOfYear(year, month, day);    // TODO Replace 0 with a method that solves it!

        // ---- Out ----
        printResult(year, month, day, dayNbr);

    }

    int DayOfYear(int y, int m, int d){
        if(m < 3){
            return dayMonth(m) + d;
        }
        return dayMonth(m) + d + leepYear(y);
    }

    int dayMonth(int mon){
        int[] montharr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayM = 0;
        for(int i = 1; i < mon; i++){
            dayM += montharr[i - 1];
        }
        return dayM;
    }

    int leepYear(int year){
        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % 400 == 0)
                    return 1;
                else
                    return 0;
            }
            else
                return 1;
        }
        else {
            return 0;
        }
    }


    void printResult(int year, int month, int day, int dayNbr) {
        // TODO
        out.println("Ordinal number for " + day + "/" + month + " in " + year + " is: " + dayNbr);
        if(leepYear(year) == 1){
            out.println(year + " is a leap year");
        }
        else{
            out.println(year + " is not a leap year");
        }
    }


    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {

        // TODO

        exit(0);  // Never use except for here (will end program)
    }


}
/*8.  See Ex8DayNumber. Implement a program that calculates the day number for a given year.
    NOTE: Main task here is functional decomposition. Assume a top level method and decompose.
    Test any non trivial method!

    If new to programming: Make a plan and discuss with assistant before staring to implement!

    Program should run like:

    Input the year > 2018
    Input the month number > 8
    Input the day number > 27
    Ordinal number for 27/8 in 2018 is: 239
    2018 is not a leap year

    TIP: See web how to calculate leap year.
 */
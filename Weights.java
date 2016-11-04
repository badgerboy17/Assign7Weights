/**
 * Name:  Bryce Sulin (sulin) 
 * Course:  CSCI-241 - Computer Science I
 * Section: 001
 * Assignment: 7
 * 
 * Project/Class Description:
 * Uses separate class-level methods to work with different arrays of integers.
 * 
 * The default Algorithm steps include:
 *      1. Ask user to choose between inputting a original 12-element,
 *         or a random-sized array.
 *      2. Print original array contents.
 *      3. Print original weights in pounds and ounces.
 *      4. Sum the array's ounces and print the total in pounds.
 *      5. Extract and print values over 8 pounds.
 *      6. Count and print the number of weights in each 4-pound block.
 *      
 * Random Array Test Cases:
 *      1. Entered 20 for random array size and it ran.
 *      2. Entered 30 for random array size and it ran
 *      3. Entered 40 for random array size and it ran.
 * 
 * Known Bugs:  none.
 */

import java.util.*;

public class Weights
{

    /** The main method declares, creates, and fills an array of 
     *  12 integers. Each integer is a random number ranging from 1-319, and each
     *  number represents a number of ounces.
     */
    public static void main (String [] args)
    {
        int [] myWeights = {258, 58, 209, 91, 79, 182, 172, 27, 7, 29, 128, 198};

        // ask the user whether to use fixed array or a new one of random size
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter 1 for fixed 12-element array, 2 for random array: ");
        int selection = keyboard.nextInt();
        if (selection == 2)
        {

            /** Save the value entered by the user and make an integer array of that size
            // Assign that new space to the array named myWeights (declared above) 
            // Fill all locations in the array with a random value between 1 and 320.
            */  
            System.out.print("Enter # of elements in array: ");
            int elements = keyboard.nextInt();
            myWeights = new int[elements];
            for (int i = 0; i < elements; i++)
            {
                myWeights[i] = (int)(Math.random() * 320);
            }
        }

        // call the printArrayValues() method to print the values in the array (1)
        System.out.println();
        System.out.println("Printing original weights");
        System.out.println("-------------------------");
        printArrayValues(myWeights);
        System.out.println();

        // call the printWeights() method to print values in pound/ounce format (2)
        System.out.println("Printing original weights in pound/ounce form");
        System.out.println("---------------------------------------------");
        printWeights(myWeights);
        System.out.println();

        // Call sumWeights method to add all weights and print the sum in pounds, without ounces(3)
        System.out.println("Weights in this array total over " + sumWeights(myWeights) + " pounds");
        System.out.println();

        // find all weights that exceed 8 pounds, return that array, and print it
        // call the printWeights() method to print the over array values in pound-ounce format (4)
        System.out.println("Printing Weights over 8 Pounds");
        System.out.println("------------------------------");   
        int [] overGivenPounds = overGivenPounds(8, myWeights);
        printWeights(overGivenPounds);
        System.out.println();

        // Call blocks method and print the blocks array contents, using printArrayValues (5)
        System.out.println("Printing blocks (4 pound increments) ...");
        System.out.println();
        System.out.println("  1st  2nd  3rd  4th  5th");
        System.out.println("  ---  ---  ---  ---  ---"); 
        int [] blocks = blocks(myWeights);
        printArrayValues(blocks);
    }

    /** The method printArrayValues will take an array of ints as a parameter, 
     *  print it with 5 integers per line, and use 5 positions
     *  to print each array value. It is void so it doesn't return a value.
     */
    public static void printArrayValues (int[] myWeights)
    {
        for (int i = 0; i < myWeights.length; i++) 
        {
            System.out.printf("%5d", myWeights[i]); 
            if (i != 0 && i == 4 || i == 9 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34)
            {
                System.out.println();
            }
        }
        System.out.println();
    }

    /** The method printWeights will take an array of ints as a parameter,
     *  and separate each array value into pounds and ounces. It then prints
     *  one time per line. It is void so it doesn't return a value.
     */
    public static void printWeights (int[] myWeights)
    {
        for (int i = 0; i < myWeights.length; i++)
        {
            System.out.printf("%3d ounces = %2d lbs, %2d oz.", myWeights[i], (myWeights[i] / 16), (myWeights[i] % 16)); 
            System.out.println();
        }
    }

    /** The method sumWeights will take an array of ints as a parameter.
     *  It adds all entries in the array, converts the value to pounds, and
     *  truncates any leftover ounces. The int variable sum holds
     *  the myWeights sum each time the method loops. It returns
     *  the pounds value as an integer. Variable sumWeights is assigned the
     *  first value in the myWeights array to begin the summing process.
     */
    public static int sumWeights (int[] myWeights)
    {
        int sumWeights = myWeights[0];
        for (int i = 1; i < myWeights.length; i++)
        {
            sumWeights += myWeights[i];
        }
        sumWeights = sumWeights / 16;
        return sumWeights;
    }

    /** The method overGivenPounds will take an integer (threshold of pounds) and
     *  an array of ints (ounces) as its two parameters. This method examines each
     *  entry in the array to see if its weight exceeds the number of pounds given
     *  in the first parameter. The method creates an array of ints that holds values
     *  from the original array that exceed that threshold of pounds. The method returns
     *  this new array to the calling method. Variable ouncesThreshold is assigned
     *  the value of 8 pounds in equivalent ounces so we're dealing with the same
     *  measurement of weight.
     */
    public static int [] overGivenPounds (int threshold, int[] myWeights)
    {
        int j = 0;
        int ouncesThreshold = threshold * 16;
        int [] over = new int[myWeights.length];
        for (int i = 0; i < myWeights.length; i++)
        {
            if (myWeights[i] > ouncesThreshold)
            {
                over[j++] = myWeights[i];   
            }
        }

        /** I used the Arrays class from the java.util package to create a new array (overGivenPounds), 
         *  with the proper length, and containing the values from the old array (over).
         *  I also used an if-statement to filter out the incorrect values from
         *  the overGivenPounds array, using j as a different holder, and only
         *  keep the weights above the threshold.
         */ 
        int [] overGivenPounds = Arrays.copyOfRange(over, 0, j);
        return overGivenPounds;
    }

    /** The method blocks will take an array of ints as a parameter. This method builds
     *  an array that holds the counts of the weights falling into each block's range.
     *  The method returns this new array to the calling method. The block variables are
     *  each assigned a value to separate them in different weight ranges.
     */
    public static int [] blocks (int[] myWeights)
    {
        int block0 = 63;
        int block1 = 127;
        int block2 = 191;
        int block3 = 255;
        int block4 = 319;
        int [] blockCount = new int[5];
        for (int i = 0; i < myWeights.length; i++)
        {
            if (myWeights[i] <= block0)
            {
                blockCount[0]++;
            }
            else if (myWeights[i] > block0 && myWeights[i] <= block1)
            {
                blockCount[1]++;
            }
            else if (myWeights[i] > block1 && myWeights[i] <= block2)
            {
                blockCount[2]++;
            }
            else if (myWeights[i] > block2 && myWeights[i] <= block3)
            {
                blockCount[3]++;
            }
            else if (myWeights[i] > block3 && myWeights[i] <= block4)
            {
                blockCount[4]++;
            }
            else 
            {
            }
        }
        return blockCount;
    }
}

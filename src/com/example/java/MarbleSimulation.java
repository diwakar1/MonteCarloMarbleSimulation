
/*Estimate probability of getting 3 same color marbles out of a bowl which contains 3 blue /3 white
* Algorithm
Create unique variables for blue or white
Add variables to count attempts/success
Loop simulation
Create an array to simulate the bowl
Create an array to hold marbles selected
Create a loop to draw three
Inside a loop randomly choose one marble
Add it to array that already contains marble
Reduce the size of bowl by one
Update the bowl without the selected marble.
Test to see if all three marbles are same.
Add to success if match
Calculate success rate number of successes/ number of attempts
Return value that to main program
*/



package com.example.java;

import java.lang.reflect.Array;
import java.util.Random;

  public class MarbleSimulation
  {

    public static void main(String[] args) {
        System.out.println("The probability of drawing 100 marbles of same color is: " + getSimulation(100));
        System.out.println("The probability of drawing 1000 marbles of same color is: " + getSimulation(1000));
        System.out.println("The probability of drawing 10000 marbles of same color is: " + getSimulation(10000));
    }
    public static double getSimulation(int numOfCounts)
    {
        //create unique variables for blue and white

      int W = 1;
      int B = 2;

      // create variable attempts as results and same colors as success

      double success = 0.0;
      double results = 0.0;

      //loop simulation for total number of attempts

      for(int count = 0; count < numOfCounts; count++)
      {
          results++;

          //create an array to simulate the bowl

          int [] bowl = {W,W,W,B,B,B};

          //create an array to hold the marbles selected

          int [] drawMarbles = new int[3];


          //create a loop to to draw three

          for(int draw = 0; draw < drawMarbles.length; draw++ )
          {
              // it selects randomly one
             int index = (int)(Math.random()*bowl.length) ;

             // it adds marble to array created to hold
             drawMarbles[draw] = bowl[index];

             // it reduces th size of an array bowl by one

             int[] newBowl = new int[bowl.length-1];
             int j= 0;

             // it loops for all in bowl array to check all

             for( int i = 0; i < bowl.length; i++)
             {
                 //it skips if the marble is already chosen

                 if( i == index)
                     continue;
                 newBowl[j] = bowl[i];
                 j++;
             }
            newBowl = bowl;

          }

          //it tests if all drawn marbles are the same color

          if(drawMarbles[0]==drawMarbles[1] && drawMarbles[1]== drawMarbles[2])
          {
              //it adds the same color marbles drawn from bowl
             success++;
          }

      }
      //Calculate success rate  of successes of same color marbles taken out of total number of attempts

        double result = success/results;

       //it returns value to main program

      return result;

    }
}

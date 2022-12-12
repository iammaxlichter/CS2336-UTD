package CS2336.Labs;

import java.util.Scanner;

public class GasCost {
  static int numStations = 0; //# of gas stations
  static double distances[]; //index 0 is the starting position
  static double prices[];
  static double range; //range of the car, distance it can go with full tank of gas

// WRITE YOUR CODE HERE
  static int gasStops(int currentIndex, double destDistance){
    double maxDist = distances[currentIndex]+range;

    if(maxDist >= destDistance)
      return 0;

    int finalIndex = LastIndex(maxDist);;
    int newfinalIndex = minGasPriceIndex(currentIndex+1, finalIndex);
    return 1 + gasStops(newfinalIndex, destDistance);
  }

  static int minGasPriceIndex(int currentIndex, int destDistance){
    double minPrice = prices[currentIndex];
    int minIndex = currentIndex;

    for(int i = currentIndex+1; i<= destDistance; i++)
      if(prices[i] < minPrice){
        minPrice = prices[i];
        minIndex = i;
      }
    System.out.println(minIndex);
    return minIndex;
  }

  static int LastIndex(double actualDistance){
    int Index = numStations;
    while(distances[Index] > actualDistance)
      Index--;
      return Index;
          
    
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String line = input.nextLine();
    String pieces[] = line.split(" ");
    numStations = pieces.length;
    distances = new double [numStations+1];
    distances[0] = 0;
    for(int i=0; i<numStations; i++)
      distances[i+1] = Double.parseDouble(pieces[i]);

    line = input.nextLine();
    pieces = line.split(" ");
    prices = new double [numStations+1];
    prices[0] = 100;
    for(int i=0; i<numStations; i++)
      prices[i+1] = Double.parseDouble(pieces[i]);
    
    range = input.nextDouble();
    double distToDestination = input.nextDouble(); 
    int gas = gasStops(0, distToDestination);


    System.out.println(gas);
    input.close();
  }
}

/* CHECK 1
100 200 300 400 500 600
2.10 2.20 2.30 2.40 2.50 2.60
210 450*.

/* CHECK 2
100 200 300 400 500 600
2.10 2.20 2.30 2.40 2.50 2.60
510 450*/ 

/* CHECK 3
100 200 300 400 500 600
2.60 2.50 2.40 2.30 2.20 2.10
210 450*/

/* CHECK 4
100 200 300 400 500 600
2.60 2.10 2.40 2.15 2.20 2.30
210 450*/

/*CHECK 5
100 200 300 400 500 600
2.60 2.10 2.40 2.15 2.20 2.30
110 450*/

/*CHECK 6
10 20 30 40 50 60 70 80 90 100
2.1 2.2 2.3 2.4 2.5 2.6 2.7 2.8 2.9 3.0
55 107*/
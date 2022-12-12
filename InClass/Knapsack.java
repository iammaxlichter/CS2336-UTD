package CS2336.InClass;

public class Knapsack {
    
    static int weights[] = {40,10,46,23,22,16,27,6};

    static int bestOne(int target){
        int bestWeight = 0;
        for(int i = 0; i<weights.length; i++){
            if(weights[i]> bestWeight && weights[i] <= target){
                bestWeight = weights[i];
            }
        }

        return bestWeight;
    }

    static int bestTwo(int target){
        int bestTotal = 0;
        for(int i = 0; i < weights.length; i++){
            for( int j = 1; j < weights.length; j++){
                if(i != j){
                    if (weights[i]+weights[j] > bestTotal && weights[i] + weights[j] <= target){
                        bestTotal = weights[i] + weights[j];
                    }
                }

            }
        }
        return bestTotal;
    }

    static int knapsack(int index, int totalSoFar, int target){
        if(totalSoFar > target){
            return 0;
        }
        if(totalSoFar == target){
            return totalSoFar;
        }
        if(index == weights.length){
            return totalSoFar;
        }
        return Math.max( 
            //Path #1: exclude weights[index]
            knapsack(index+1, totalSoFar, target),
            //Path #2: include weights[index]
            knapsack(index+1, totalSoFar+weights[index], target));
    }

    //Allow taking multiple pieces of same item!
    static int knapsack2(int index, int totalSoFar, int target){
        if(totalSoFar > target){
            return 0;
        }
        if(totalSoFar == target){
            return totalSoFar;
        }
        if(index == weights.length){
            return totalSoFar;
        }
        return Math.max( 
            //Path #1: exclude weights[index]
            knapsack2(index+1, totalSoFar, target),
            //Path #2: include weights[index]
            knapsack2(index, totalSoFar+weights[index], target));
    }
    public static void main(String[] args){

        for(int target = 1; target <=100; target++){
            //System.out.println("bestOne("+ i + "): " + bestOne(i));
            //System.out.println("bestTwo("+ i + "): " + bestTwo(i));
            //System.out.println("knapsack(" + target + "): " + knapsack(0,0,target));
            System.out.println("knapsack2(" + target + "): " + knapsack2(0,0,target));
        }

    }
}

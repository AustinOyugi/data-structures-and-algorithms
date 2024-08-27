package stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/*
   @author Austin Oyugi
   @since 27/08/2024
   @mail austinoyugi@gmail.com
*/
public class CarFleet {

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();

        //Expect 3
        System.out.println(carFleet.carFleet(10, new int[]{4, 1, 0, 7}, new int[]{2, 2, 1, 1}));

        //Expect 1
        System.out.println(carFleet.carFleet(10, new int[]{1, 4}, new int[]{3, 2}));

        //Expect 2
        System.out.println(carFleet.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }

    public int carFleet(int target, int[] position, int[] speed) {

        List<double[]> carGroup = new ArrayList<>();

        // We group the values
        for (int i = 0; i < position.length; i++) {
            double[] carEntry = new double[3];

            //position
            carEntry[0] = position[i];

            //speed
            carEntry[1] = speed[i];

            //time it takes
            carEntry[2] = (double) (target - position[i]) / speed[i];

            carGroup.add(carEntry);
        }

        // We make sure the closest element to the target is first on the list
        carGroup.sort(Comparator.comparingDouble(value -> ((double[]) value)[0]).reversed());

        Stack<double[]> evaluationStack = new Stack<>();

        for (double[] car : carGroup) {

            if (evaluationStack.isEmpty())
                evaluationStack.push(car);
            else {
                double[] carInFront = evaluationStack.peek();

                // If the car catches up with the car in front
                //We assume that they are at the same position
                if (car[2] <= carInFront[2]) continue;

                evaluationStack.push(car);
            }
        }

        return evaluationStack.size();
    }
}

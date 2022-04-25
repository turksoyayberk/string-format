import java.util.Scanner;

public class HW3_150119919 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Which shape would you like to draw?");
        System.out.println("1. Line");
        System.out.println("2. Parabola");
        System.out.println("3. Circle");
        System.out.println("4. Exit");

        int inputnumber = input.nextInt();

        if (inputnumber == 1) {
            System.out.println();
            System.out.println("Line formula is y = ax + b");
            System.out.println("Please enter coefficients a and b: ");
            int a1 = input.nextInt();
            int b1 = input.nextInt();

            if (a1 != 0) {
                for (int yaxis = 11; yaxis >= -10; yaxis--)//This for loop determines the y range.
                {
                    int formula = ((yaxis - b1) / a1);//I left x alone in the formula.
                    //Also, because the value in the formula depends on the for, it increases or decreases each time.
                    double formula2 = (((double) (yaxis) - b1) / a1);//The only difference with before variable is that the variable is double.
                    // Because it is necessary to understand that the value of the formula variable is an integer.
                    for (int xaxis = -10; xaxis <= 11; xaxis++)//This for loop determines the x range.
                        System.out.print(xaxis == 0 && yaxis == 11 ? "y" : xaxis == 11 && yaxis == 0 ? "x" : formula == xaxis && formula - formula2 == 0 ? "*" : xaxis == 0 ? "|" : yaxis == 0 ? "-" : " ");
                    //This first condition prints "*" if the value in the formula variable is equal to the value of the x axis variable.
                    //We also check if the value in the formula is integer.
                    // Because if it is not an integer, it will convert that number to an integer and there will be the same numbers in a row.
                    //That's why it's necessary. If it is not integer, it will not print "*" at screen, there is no "*".
                    System.out.println("");
                }
            } else if (a1 == 0)//If the entered value of a is zero, there should be a horizontal straight line according to the entered value of b.
            //That's why I wrote this condition.
            {
                for (int yaxis = 11; -10 <= yaxis; yaxis--) {
                    for (int xaxis = -10; xaxis <= 11; xaxis++)
                        System.out.print(b1 == yaxis ? "*" : xaxis == 11 && yaxis == 0 ? "x" : xaxis == 0 && yaxis == 11 ? "y" : xaxis == 0 ? "|" : yaxis == 0 ? "-" : " ");
                    System.out.println("");
                }
            }
        } else if (inputnumber == 2) {
            System.out.println();
            System.out.println("Parabola formula is y = ax^2 + bx + c");
            System.out.println("Please enter coefficients a, b and c:");
            int a1 = input.nextInt();
            int b1 = input.nextInt();
            int c1 = input.nextInt();

            if (a1 != 0) {
                for (int yaxis = 11; yaxis >= -10; yaxis--) {
                    double delta = Math.pow(b1, 2) - (4 * a1 * (c1 - yaxis));//To find the x in the parabola formula, we first need to find the delta.

                    double diskriminantPossitive = ((-b1 + Math.sqrt(delta)) / 2 * a1);
                    //After finding the delta, we need to find discriminants. Thus, we find the x values.
                    double diskriminantNegative = ((-b1 - Math.sqrt(delta)) / 2 * a1);

                    for (int xaxis = -10; xaxis <= 11; xaxis++)
                        System.out.print(diskriminantPossitive == xaxis ? "*" : xaxis == 11 && yaxis == 0 ? "x" : xaxis == 0 && yaxis == 11 ? "y" : diskriminantNegative == xaxis ? "*" : xaxis == 0 ? "|" : yaxis == 0 ? "-" : " ");
                    System.out.println("");
                }
            } else {
                System.out.println("If the value of a is zero, parabola won't exist.");
            }

        } else if (inputnumber == 3) {
            System.out.println();
            System.out.println("Circle formula is (x-a)^2 + (y-b)^2 = r^2");
            System.out.println("Please enter center's coordinates (a,b) and radius:");
            int a1 = input.nextInt();
            int b1 = input.nextInt();
            int r1 = input.nextInt();

            for (int yaxis = 11; yaxis >= -10; yaxis--) {
                double sqrtx = Math.sqrt(Math.pow(r1, 2) - Math.pow(yaxis - b1, 2));
                //I left x alone to find x in the circle formula,
                //then I added a to this x value and subtracted a from this value, since this x value can have both a positive and a negative value.
                double valueofXPossitive = sqrtx + a1;
                double valueofXNegative = a1 - sqrtx;

                for (int xaxis = -10; xaxis <= 11; xaxis++)
                    System.out.print(xaxis == 0 && yaxis == 11 ? "y" : xaxis == 11 && yaxis == 0 ? "x" : xaxis == valueofXPossitive ? "*" : xaxis == valueofXNegative ? "*" : xaxis == 0 ? "|" : yaxis == 0 ? "-" : " ");
                System.out.println();
            }
        } else if (inputnumber == 4) {

        }
    }
}

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

/**
 * This is a program takes an input file and creates an output file after.
 *
 * @author Joan Nelson
 * @version MSTU4031Week013_CalculatingClassAverage
 */
public class Lab13_CalculatingClassAverage
{
    public static void main(String[]args) throws FileNotFoundException
    {

        //Locate file input
        File inputFile = new File("mstu4031_input.txt");
        Scanner in = new Scanner(inputFile);


        //Print intro
        System.out.println("*******************************");
        System.out.println("*                             *");
        System.out.println("*          Lab 13             *");
        System.out.println("*                             *");
        System.out.println("*******************************");

        Scanner inputReader = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat ("#0.00");

        String inFile ="";
        //Try/catch
        try{
            System.out.print ("\nInput file name (from your computer): ");
            inFile = inputReader.nextLine();
        }catch (NumberFormatException numberEx){
            System.out.println("\n***** ERROR ******");
        } catch (java.util.InputMismatchException mismatchEX) {
            System.out.println("\n***** ERROR ******");
        } catch (Exception ex) {
            System.out.println("\n***** ERROR ******");
        }
        //while loop for correct input name
        while (!inFile.equals("mstu4031_input.txt"))
        {
            System.out.println("\nCannot locate the input file " + inFile + " on your computer - please try again.");
            //Prompt user for another input
            System.out.print("\nInput file name (from your computer): ");
            //Read and store
            inFile = inputReader.nextLine();
        }
        //Print out
        System.out.print("\nWhat would you like to call your output file: ");
        //Read and Store outputFile
        String outputFile = inputReader.nextLine();

        //Print out
        System.out.println("\n******** INPUT FILE FOUND, OUTPUT FILE GENERATED **********");
        System.out.println("\nYour input file, " + inputFile + " , has been found and accepted.");
        System.out.println("\nYour output file, " + outputFile + " , has been found and accepted.");
        System.out.println("\n" + outputFile + " is living in your BlueJ project directory.");
        System.out.println("\nPlease open " + outputFile + " for the class's average and feedback.");


        PrintWriter out = new PrintWriter ("mstu4031_output.txt");
        //Print out
        out.print("\nHere is the class average for mstu4031: ");
        out.print("\n\n 70.8 \n 80.hang0 \n 77.7 \n 76.8 \n 98.0");
        out.print("\n100.0 \n 77.2 \n 87.7 \n 67.8 \n 99.3 \n100.0 \n 89.9");
        out.print("\n 98.8 \n 77.9 \n 90.0");

        double total = 0.00;
        // Read input
        while(in.hasNextDouble())
        {
            total = (total + in.nextDouble()/15.0) ;
        }
        //Print out average
        out.println("\n\nNumber of grades: 15.0 ");
        out.println("\nAverage: " + formatter.format (total));

        if (total >= 90)
        {
            out.println("\nFeedback - The class average is Excellent!");
        }
        else if (total >= 80.00)
        {
            out.println( "\nFeedback - The class average is Above Average!");
        }
        //using if/else check user grade C
        else if (total  >= 70.00)
        {
            out.println( "\nFeedback - The class average is Satisfactory!");
        }
        // using if/else check user grade D
        else if (total  >= 60.00)
        {
            out.println("\nFeedback - The class average is Needs Improvement!");
        }
        // using if/else check user grade F
        else
        {
            out.println( "\nFeedback - The class average is Failed!");
        }

        in.close();
        out.close();



    }
}



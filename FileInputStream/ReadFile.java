/**
 * This class outputs the average of three columns from an input file
 * that contains six integers.
 *
 * In this version:
 * 1. The size of the array 'sum' is fixed after the object is created.
 * 2. The code assumes that there are six integers in the input file.
 *
 * The class can be executed with: java ReadFile input.txt
 *
 * @author Natalie Anna
 * @version November 2020
 *
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile
{
	public static void main(String[] args) throws IOException
	{
		// program stops if no parameter values are specified for method 'main'
        	if ( args.length == 0 )
		{
           		System.out.println("File name expected.");
            		System.exit(0);
        	}
        	System.out.println("Opening file " + args[0] + "...");

        	// declares new FileInputStream object and opens input file
        	FileInputStream fileStream = new FileInputStream(args[0]);
        	System.out.println("Opening of file " + args[0] + " successful.");

		// outputs average of 3 columns where there are 6 integers in the input file
        	Scanner sc = new Scanner(fileStream);
        	int num;
        	int count = 0;
		int columns = 3;
        	long [] sum = new long[columns];

	        while ( sc.hasNextInt() )
		{
			for ( int i = 0; i < columns; ++i )
			{
	            		num = sc.nextInt();
        	    		sum[i] = sum[i] + num;
			}
			++count;
        	}

	        if ( count == 0 )
        		System.out.println("No integers in file.");
        	else
		{
			for ( int i = 0; i < columns; ++i )
			{
	            		System.out.print(Math.round((double)sum[i]/(double)count) + " ");
        		}
			System.out.println();
		}
        	fileStream.close();
    	}
}

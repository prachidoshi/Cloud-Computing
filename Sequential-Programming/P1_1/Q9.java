import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Q9 {
	public static void main(String[] args) throws FileNotFoundException {
		Pattern pattern1 = null;
		Matcher myMatch1 = null;
		Pattern pattern2 = null;
		Matcher myMatch2 = null;
		int count2014 = 0;
		int count2015 = 0;
		String aLine;
                // match if the movie is a 2014 movie  
		pattern1 = Pattern.compile("(2014_film)");
                // match if the movie is a 2015 movie
		pattern2 = Pattern.compile("(2015_film)");
		Scanner scanner = new Scanner(new File("output"));
        scanner.useDelimiter(" ");
        while(scanner.hasNext()){
        	aLine = scanner.nextLine();
       	    String[] split = aLine.split("\t");
        	myMatch1 = pattern1.matcher(split[0]); 
        	myMatch2 = pattern2.matcher(split[0]);
        	if(myMatch1.find())
                // add views for movie from 2014
        		count2014 = count2014 + Integer.parseInt(split[1]);
        	else if (myMatch2.find())
                // add view for movie from 2015 
        		count2015 = count2015 + Integer.parseInt(split[1]);    	
        }      
        // year with most number of views 
        if(count2014>count2015)
        	System.out.println("2014");
        else
        	System.out.println("2015");
            scanner.close();
    		System.exit(0);
	}
}


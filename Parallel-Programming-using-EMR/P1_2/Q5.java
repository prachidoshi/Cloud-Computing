import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Q5 {
	public static void main(String[] args) throws FileNotFoundException {
		
		//System.out.println(args[0]);
		//System.out.println(args[1]);
		String aLine; 
		Pattern pattern1 = null;
		Matcher myMatch1 = null;
		Pattern pattern2 = null;
		Matcher myMatch2 = null;
		int noofdays = 0;
		String outputTwitter = "";
		String outputApple = "";
		int[] datesTwitter = new int[32];
		int[] dateApple = new int[32];
		pattern1 = Pattern.compile("(\\s|^)"+args[0]+"(\\s|$)");
		pattern2 = Pattern.compile("(\\s|^)"+args[1]+"(\\s|$)");
		//pattern1 = Pattern.compile("(?)(\\s|^)Twitter(\\s|$)");
		//pattern2 = Pattern.compile("(?)(\\s|^)Apple_Inc.(\\s|$)");
		Scanner scanner = new Scanner(new File("output"));
        scanner.useDelimiter(" ");
        while(scanner.hasNext()){
        	aLine = scanner.nextLine();
        	 String[] split = aLine.split("\t");
         	myMatch1 = pattern1.matcher(split[1]);        	
         	myMatch2 = pattern2.matcher(split[1]);
         	if(myMatch1.find())
         	    outputTwitter = aLine;
         	if(myMatch2.find())
         		outputApple = aLine;
        }	
        //System.out.println(outputTwitter);
        //System.out.println(outputApple);
        String[] splitoutputTwitter = outputTwitter.split("\t");
        String[] splitoutputApple = outputApple.split("\t");
        for(int i=1;i<=31;i++){
        	datesTwitter[i] = Integer.parseInt(splitoutputTwitter[i+1].split(":")[1]);
        	dateApple[i] = Integer.parseInt(splitoutputApple[i+1].split(":")[1]);
                if(datesTwitter[i]>dateApple[i])
                      noofdays = noofdays+1;
        }
        
       // for(int i=1;i<=31;i++){
       // 	if(datesTwitter[i]>dateApple[i])
       // 		noofdays = noofdays+1;
        	  
        //}
        System.out.println(noofdays);
            scanner.close();
    		System.exit(0);
	}
}

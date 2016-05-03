import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Q6 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
	
	String aLine;
	String inputfromQ6File ;
	//read q6 file and store in array
	Scanner scannerq6 = new Scanner(new File("q6"));
	scannerq6.useDelimiter("\n");
	ArrayList<String> articleNames = new ArrayList<String>();
	 //this adds an element to the list. 
    while(scannerq6.hasNext()){
    	inputfromQ6File = scannerq6.nextLine();
    	articleNames.add(inputfromQ6File);
    }
	Scanner scanner = new Scanner(new File("output"));
    scanner.useDelimiter(" ");
    while(scanner.hasNext()){
    	boolean flagtoconsider = false;
    	aLine = scanner.nextLine();
    	String[] eachlinesplit = aLine.split("\t");
    	//System.out.println(eachlinesplit[1]);
    	for (int i = 0; i < articleNames.size(); i++) {
   		 //System.out.println(articleNames.get(i));	
   		 if(articleNames.get(i).equals(eachlinesplit[1]) )
   			 flagtoconsider = true;
   	     }
    	 if(flagtoconsider){
    		 int[] singledayview = new int[32];
        	 int highestSingleDayViewsCount = 0;
        	//find highest count for single day
        	 for(int i=1;i<=31;i++){  		 
        		 singledayview[i]= Integer.parseInt(eachlinesplit[i+1].split(":")[1]);
        		 //System.out.println(eachlinesplit[i+1]);  		 
        	 }
        	 //compare and find highest 
        	 for(int i=1;i<=31;i++){
        		 if(singledayview[i]>highestSingleDayViewsCount)
        			 highestSingleDayViewsCount = singledayview[i];
        	 }
        	 System.out.println(eachlinesplit[1]+"\t"+highestSingleDayViewsCount);
    	 }
    	/* int[] singledayview = new int[32];
    	 int highestSingleDayViewsCount = 0;
    	 //find highest count for single day
    	 for(int i=1;i<=31;i++){  		 
    		 singledayview[i]= Integer.parseInt(eachlinesplit[i+1].split(":")[1]);
    		 //System.out.println(eachlinesplit[i+1]);  		 
    	 }
    	 //compare and find highest 
    	 for(int i=1;i<=31;i++){
    		 if(singledayview[i]>highestSingleDayViewsCount)
    			 highestSingleDayViewsCount = singledayview[i];
    	 }
    	 for (int i = 0; i < articleNames.size(); i++) {
    		 //System.out.println(articleNames.get(i));	
    		 if(articleNames.get(i) == eachlinesplit[1] )
    			 System.out.println(eachlinesplit[1]+"\t"+highestSingleDayViewsCount);
    	 }
    	 //System.out.println(eachlinesplit[1]+"\t"+highestSingleDayViewsCount);
    	 */
    }	
    
        scanner.close();
		System.exit(0);
	}
}


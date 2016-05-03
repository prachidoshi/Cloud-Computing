import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Q7 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
	
	String aLine;
	String inputfromQ6File ;
	//read q7 file and store in array
	Scanner scannerq6 = new Scanner(new File("q7"));
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
        	 System.out.println(eachlinesplit[1]+"\t"+eachlinesplit[0]);
    	 }
    	 
    	
    }	   
        scanner.close();
		System.exit(0);
	}
}


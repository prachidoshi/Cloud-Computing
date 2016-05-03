import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Q8 {
	public static void main(String[] args) throws FileNotFoundException {
		//read output file
		String aLine; 
		Pattern pattern1 = null;
		Matcher myMatch1 = null;
		Pattern pattern2 = null;
		Matcher myMatch2 = null;
		Pattern pattern3 = null;
		Matcher myMatch3 = null;
		Pattern pattern4 = null;
		Matcher myMatch4 = null;
		int countSamePairMoviesTV = 0;
		//pattern1 = Pattern.compile("(\\d{4}_film\\)(\\s|$))");
		//pattern2 = Pattern.compile("(\\d{4}_TV_series\\)(\\s|$))");
		pattern1 = Pattern.compile("(\\d{4}_film\\)(\\s|$))|(\\(film\\)(\\s|$))");
		pattern2 = Pattern.compile("(\\d{4}_TV_series\\)(\\s|$))|(\\(TV_series\\)(\\s|$))");
		//pattern2 = Pattern.compile("(d{4}_TV_series\\)(\\s|$))|(\\(TV_series\\)(\\s|$)");
		pattern3 = Pattern.compile("film\\)(\\s|$)");
		pattern4 = Pattern.compile("TV_series\\)(\\s|$)");
		Scanner scanner = new Scanner(new File("output"));
        scanner.useDelimiter(" ");
        ArrayList<String> films = new ArrayList<String>();
        ArrayList<String> tv = new ArrayList<String>();
        while(scanner.hasNext()){
        	aLine = scanner.nextLine();
        	String[] eachlinesplit = aLine.split("\t");
        	//check if match film
        	 myMatch1 = pattern1.matcher(eachlinesplit[1]);
        	 if (myMatch1.find()) { 
        		 films.add(eachlinesplit[1].split("\\(")[0]); 
        		  //System.out.println(eachlinesplit[1]);
        	 }
        	//check if match tv series
        	 myMatch2 = pattern2.matcher(eachlinesplit[1]);
        	 if (myMatch2.find()) { 
        		 //movies.add(eachlinesplit[1]); 
        		 tv.add(eachlinesplit[1].split("\\(")[0]); 
        		 //System.out.println(eachlinesplit[1]);
        	 }
        }
        for (int i = 0; i < films.size(); i++) {
        	String articlenametotestfilms = films.get(i);
        	for(int j=0;j<tv.size();j++){
        		String articlenametotesttv = tv.get(j);
        		if(articlenametotestfilms.equals(articlenametotesttv)){
        			//System.out.println(films.get(i));
        			//System.out.println(tv.get(j));
        			countSamePairMoviesTV=countSamePairMoviesTV +1;
        			films.remove(i);
        			tv.remove(j);
        		}
        	}
        	
        }
        System.out.println(countSamePairMoviesTV);
            scanner.close();
    		System.exit(0);
	}
}

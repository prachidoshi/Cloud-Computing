import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Mapper {
	public static void main (String args[]) {
		Pattern pattern1 = null;
		Matcher myMatch1 = null;
		Pattern pattern2 = null;
		Matcher myMatch2 = null;
		Pattern pattern3 = null;
		Matcher myMatch3 = null;
		Pattern pattern4 = null;
		Matcher myMatch4 = null;
		Pattern pattern5 = null;
		Matcher myMatch5 = null;
		String aLine;
		String fileName;
		String fileDate;
		String fileLastPart;
		//String DateMonth;
		fileName = System.getenv("mapreduce_map_input_file");
		//fileName = "s3://cmucc-datasets/wikipediatraf/201512/pagecounts-20151201-000000";
		String[] fileDetails = fileName.split("/");
		fileLastPart = fileDetails[fileDetails.length - 1];
		String[] fileSplitLastPart = fileLastPart.split("-");		
		fileDate = fileSplitLastPart[1];
		//System.out.println(fileDate);
		//System.out.println(fileDate);
		//DateMonth = 
		//System.out.println(fileDate);
		//Condition 1: log lines should start with en (case sensitive), without any suffix attached
		pattern1 = Pattern.compile("(?)(\\s|^)en(\\s|$)");
		//Condition 2: Exclude any pages whose title starts with the following strings (case sensitive)
		pattern2 = Pattern.compile("(?)(\\s|^)(Media:|Special:|Talk:|User:|User_talk:|Project:|Project_talk:|File:|File_talk:|MediaWiki:|MediaWiki_talk:|Template:|Template_talk:|Help:|Help_talk:|Category:|Category_talk:|Portal:|Wikipedia:|Wikipedia_talk:).*");
        //Condition 3: Page titles that are exactly (case sensitive) any of the following strings should be excluded
		pattern3 = Pattern.compile("(?)(\\s|^)(404_error/|Main_Page|Hypertext_Transfer_Protocol|Search)(\\s|$)");
        //Condition 4: Exclude any page title that ends with the following extensions.Do not use case-insensitive matching, remove exactly those file extensions 
		pattern4 = Pattern.compile("(?)(\\.jpg|\\.gif|\\.png|\\.JPG|\\.GIF|\\.PNG|\\.txt|\\.ico)(\\s|$)");
        //Condition 5: Filter out all page titles that start with lowercase English characters. You may notice that some page titles start with non-English characters, you should choose to retain them in the analysis.
		pattern5 = Pattern.compile("(\\s|^)[a-z]+");
		try{
			BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
	        String input;
	        //While we have input on stdin
			while((input=br.readLine())!=null){
			    //Initialize Tokenizer on string input
	            //StringTokenizer tokenizer = new StringTokenizer(input);
				//System.out.println(input);
				aLine = input;
				//System.out.println(aLine);
				String[] split = aLine.split(" ");
	        	String outputEntry = "";
	            //Condition 0 ; Remove lines with 3 or fewer elements
                if(!split[1].isEmpty()) {
        		//Condition 1:
        	  myMatch1 = pattern1.matcher(split[0]);     	  
        	  if (myMatch1.find()) { 
        		//Condition 2:  
        		myMatch2 = pattern2.matcher(split[1]);
        		if(!myMatch2.find()){
        			//Condition 3:
        			myMatch3 = pattern3.matcher(split[1]);
        			if(!myMatch3.find()){
        				//Condition 4:
        			   myMatch4 = pattern4.matcher(split[1]);
        			   if(!myMatch4.find()){
        				   //Condition 5:
        				   myMatch5 = pattern5.matcher(split[1]);
        				   if(!myMatch5.find()){
        				      //outputEntry = split[1]+"\t"+split[2];
        					  outputEntry = split[1]+"\t"+fileDate+"\t"+split[2];
    			              System.out.println(outputEntry);      					   
        				   }
        			   }
        			}
        		}
    		  }
           }
	        	
	            /*while(tokenizer.hasMoreTokens())
	            {
	                String word = tokenizer.nextToken();  //Get the next word
	                System.out.println(word+"\t"+"1");    //Output word\t1
	            }*/
			}
	 
		}catch(IOException io){
			io.printStackTrace();
		}	
	}
}


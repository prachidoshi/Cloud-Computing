import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reducer {
	public static void main (String args[]) {
		 
		try{
			BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
	        //Initialize Variables
	        String input;
	        String articleName = null;
	        //String word = null;
	        String currentArticle = null;
	        long totalViews = 0;
	        long[] viewsofDate = new long[32];
	        int articleDay = 0;
	        
	        //While we have input on stdin
			while((input=br.readLine())!=null){
			    try{
	                String[] parts = input.split("\t");
	               // String[] values = parts[1].split("\t");
	                String articleDate = parts[1];
	                //System.out.println("ArticleDate"+articleDate);
	                articleName = parts[0];
	                articleDay = Integer.parseInt(articleDate.substring(6,8));
	                //System.out.println(articleDay);
	                //if the article name has not changed 
	                
	                //same article name                
	                if(currentArticle!=null && currentArticle.equals(articleName)){
	                	totalViews = totalViews + Integer.parseInt(parts[2]);         		
	                	viewsofDate[articleDay] = viewsofDate[articleDay]+Integer.parseInt(parts[2]);
	                }
	                else //The article name has changed 
	                {
	                	if(currentArticle != null && totalViews > 100000) {//Is this the first word, if not output count
	                		System.out.print(totalViews+"\t"+currentArticle+"\t");
	                		for(int i=1;i<=31;i++){
	                			
	                			if(i<10)
	                			    System.out.print("2015120"+i+":"+viewsofDate[i]+"\t");
	                			else
	                				System.out.print("201512"+i+":"+viewsofDate[i]+"\t");
	                            viewsofDate[i] = 0;
	                		}
	                		
	                		System.out.println();
	                	}
	                	currentArticle = articleName;
	                	totalViews=Integer.parseInt(parts[2]);
	                	for(int a =1;a<=31;a++){
	                		viewsofDate[a] = 0;
	                	}
	                	viewsofDate[articleDay] = Integer.parseInt(parts[2]);
	                	//viewsofDate[articleDay] = viewsofDate[articleDay]+Integer.parseInt(values[1]);
	                	//System.out.println(currentArticle+"\t"+totalViews+"\t"+articleDay+"\t"+viewsofDate[articleDay]);
	                	
	                }
	               
	            }
	            catch(NumberFormatException e){
	                continue;
	            }
			}
			 //Print out last word if missed
	        if(currentArticle!=null && currentArticle.equals(articleName) && totalViews > 100000)
	        {   
	        	System.out.print(totalViews+"\t"+currentArticle+"\t");
	        	for(int i=1;i<=31;i++){
        			if(i<10)
        			System.out.print("2015120"+i+":"+viewsofDate[i]+"\t");
        			else
        				System.out.print("201512"+i+":"+viewsofDate[i]+"\t");
                    viewsofDate[i] = 0;
        		}

        		for(int a =1;a<=31;a++){
	                		viewsofDate[a] = 0;
	                	}
	                		System.out.println();
	        	//System.out.println(currentArticle+"\t"+totalViews);
	        }   
	 
		}catch(IOException io){
			io.printStackTrace();
		}	
	}
}


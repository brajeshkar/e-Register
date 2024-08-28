import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.util.*;

public class pdftotext
{
	public static String line,name,pno,mode,fup,prem ;
	static int p = 2;
	static void extractData(String file, Map<String , Object[]> studentData) {
		
		try {
			File pdfFile = new File(file);
			PDDocument pdDocument = PDDocument.load(pdfFile);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(pdDocument);
			String[] lines = text.split("\n");
		
		   
		   // name list to name set
		   
		    for(int i = 0; i< lines.length;i++)    
		    {
		    	name = pno = mode = fup = prem = "";
		    	line = lines[i];
		    	line = line.replace("\n","").replace("\r", "");
		    	try {
		    		Integer.parseInt(line.split(" ")[0]);
		    		//get name
		    		String words[] = line.split("/")[0].split(" ");
			        for(int j = 2; j<words.length-1 ; j++)
			        	name += words[j]+" ";
		    		words = line.split(" ");
		    		pno = words[1];
			        prem = words[words.length - 2];
			        int flag = words[words.length - 8].length() == 3 ?8:7;
			        mode  = words[words.length - flag];
			        fup = words[words.length - flag + 1];
			        
			        switch(display.month_selected)
			        {
			        case "January" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("01")||
			        				 fup.split("/")[0].equalsIgnoreCase("04")||
			        				  	fup.split("/")[0].equalsIgnoreCase("07")||
			        				  	fup.split("/")[0].equalsIgnoreCase("10"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("01")||
			        				 fup.split("/")[0].equalsIgnoreCase("07"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("01"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "February" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("02")||
			        				 fup.split("/")[0].equalsIgnoreCase("05")||
			        				  	fup.split("/")[0].equalsIgnoreCase("08")||
			        				  	fup.split("/")[0].equalsIgnoreCase("11"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("02")||
			        				 fup.split("/")[0].equalsIgnoreCase("08"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("02"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        
			        
			        case "March" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("03")||
			        				 fup.split("/")[0].equalsIgnoreCase("06")||
			        				  	fup.split("/")[0].equalsIgnoreCase("09")||
			        				  	fup.split("/")[0].equalsIgnoreCase("12"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("03")||
			        				 fup.split("/")[0].equalsIgnoreCase("09"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("03"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "April" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("04")||
			        				 fup.split("/")[0].equalsIgnoreCase("07")||
			        				  	fup.split("/")[0].equalsIgnoreCase("10")||
			        				  	fup.split("/")[0].equalsIgnoreCase("01"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("04")||
			        				 fup.split("/")[0].equalsIgnoreCase("10"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("04"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "May" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("05")||
			        				 fup.split("/")[0].equalsIgnoreCase("08")||
			        				  	fup.split("/")[0].equalsIgnoreCase("11")||
			        				  	fup.split("/")[0].equalsIgnoreCase("02"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("05")||
			        				 fup.split("/")[0].equalsIgnoreCase("11"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("05"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "June" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("03")||
			        				 fup.split("/")[0].equalsIgnoreCase("06")||
			        				  	fup.split("/")[0].equalsIgnoreCase("09")||
			        				  	fup.split("/")[0].equalsIgnoreCase("12"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("06")||
			        				 fup.split("/")[0].equalsIgnoreCase("12"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("06"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "July" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("07")||
			        				 fup.split("/")[0].equalsIgnoreCase("10")||
			        				  	fup.split("/")[0].equalsIgnoreCase("01")||
			        				  	fup.split("/")[0].equalsIgnoreCase("04"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("07")||
			        				 fup.split("/")[0].equalsIgnoreCase("01"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("07"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "August" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("08")||
			        				 fup.split("/")[0].equalsIgnoreCase("11")||
			        				  	fup.split("/")[0].equalsIgnoreCase("02")||
			        				  	fup.split("/")[0].equalsIgnoreCase("05"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("08")||
			        				 fup.split("/")[0].equalsIgnoreCase("02"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("08"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "September" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("03")||
			        				 fup.split("/")[0].equalsIgnoreCase("06")||
			        				  	fup.split("/")[0].equalsIgnoreCase("09")||
			        				  	fup.split("/")[0].equalsIgnoreCase("12"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("03")||
			        				 fup.split("/")[0].equalsIgnoreCase("09"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("09"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "October" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("10")||
			        				 fup.split("/")[0].equalsIgnoreCase("01")||
			        				  	fup.split("/")[0].equalsIgnoreCase("04")||
			        				  	fup.split("/")[0].equalsIgnoreCase("07"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("10")||
			        				 fup.split("/")[0].equalsIgnoreCase("04"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("10"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "November" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("11")||
			        				 fup.split("/")[0].equalsIgnoreCase("02")||
			        				  	fup.split("/")[0].equalsIgnoreCase("05")||
			        				  	fup.split("/")[0].equalsIgnoreCase("08"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("11")||
			        				 fup.split("/")[0].equalsIgnoreCase("05"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("11"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        case "December" : 
			        	if(mode.equalsIgnoreCase("Mly"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	else if(mode.equalsIgnoreCase("QLY") )
			        	    {
			        		  if(fup.split("/")[0].equalsIgnoreCase("03")||
			        				 fup.split("/")[0].equalsIgnoreCase("06")||
			        				  	fup.split("/")[0].equalsIgnoreCase("09")||
			        				  	fup.split("/")[0].equalsIgnoreCase("12"))
			        			  studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        		}
			        	else if(mode.equalsIgnoreCase("HLY"))
			        	{
			        		 if(fup.split("/")[0].equalsIgnoreCase("12")||
			        				 fup.split("/")[0].equalsIgnoreCase("06"))
			        	     studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});  			 
			        	}
			        	else 
			        	{
			        		if(fup.split("/")[0].equalsIgnoreCase("12"))
			        		studentData.put(String.valueOf(p++), new Object[] {name,pno,prem,Character.toString(mode.charAt(0)),fup});
			        	}
			        	break;
			        	
			        
			        }
			        
			        
			        
			       	}
		    	catch(Exception e){
		    		continue;
		    }
		    	    	
		    	
		    }		    		  
		     
		     		    
			  pdDocument.close();		
			}
		
			catch(Exception e)
			{
				//e.printStackTrace();
			}
		
		
	}
	
}
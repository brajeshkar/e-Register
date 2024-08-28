import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.util.Map;

public class pdftotext
{
	public static String pname, bocno ,date, amt , cash , chq, chqno,line, agcd ,agname,merid;	 
	static int p = 2;
	static void extractData(String file, Map<String , Object[]> studentData) {
		
		try {
			File pdfFile = new File(file);
			PDDocument pdDocument = PDDocument.load(pdfFile);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(pdDocument);
			String[] lines = text.split("\n");
		   pname = bocno = date = amt = cash = chq = chqno = agcd = agname =merid =  "";
		    
		   int i ;
		    for( i = lines.length - 2; i>0 ;i--)    
		    {
		    	line = lines[i];
		    	line = line.replace("\n","").replace("\r", "");
			     if ((line.contains("counterfoil")))
			    		 break;
		    }   		
				
			int flag = lines.length-2 - i  ;
			switch(flag)
			{
			case 7 : 
				//get BOC, DATE
				line = lines[i+1]; line = line.replace("\n","").replace("\r", "");
				String words[] = line.split(" ");
				bocno = words[2];
				date = words[5].substring(0,10);
				
				//get Proposer Name
				line = lines[i+3]; line = line.replace("\n","").replace("\r", "");
			    words = line.split(":");
				pname = words[1];
				
				//get agent details
				line = lines[i+4]; line = line.replace("\n","").replace("\r", "");
			    words = line.split(":");
				agcd = words[1].trim();
				agcd = agcd.split(" ")[0];
				agname = words[2].trim();
				
				//get amount
				line = lines[i+6]; line = line.replace("\n","").replace("\r", "");
				words = line.split(" ");
				amt = words[3].substring(3,words[3].length());
				
				//get cash, chq
				line = lines[i+7]; line = line.replace("\n","").replace("\r", "");
				words = line.split(" ");
				cash = words[3].substring(1);
				chq = words[7].substring(1);
				
				//get merchant id
				line = lines[i-3]; line = line.replace("\n","").replace("\r", "");
				words = line.split("\\(");
				words = words[1].split("\\)");
				merid = "A"+words[0];
			
				//get chq details
				line = lines[i-5]; line = line.replace("\n","").replace("\r", "");
				 words = line.split(" ");
				chqno = words[2].substring(1)+"/";
				chqno += words[5].substring(1);
				
				break;
			case 5 :	
				//get BOC, DATE
				line = lines[i+1]; line = line.replace("\n","").replace("\r", "");
			    words = line.split(" ");
				bocno = words[2];
				date = words[5].substring(0,10);
				
				//get Proposer Name
				line = lines[i+3]; line = line.replace("\n","").replace("\r", "");
			    words = line.split(":");
				pname = words[1];
				
				//get agent details
				line = lines[i+4]; line = line.replace("\n","").replace("\r", "");
			    words = line.split(":");
				agcd = words[1].trim();
				agcd = agcd.split(" ")[0];
				agname = words[2].trim();
				
				//get merchant id
				line = lines[i-2]; line = line.replace("\n","").replace("\r", "");
				words = line.split("\\(");
				words = words[1].split("\\)");
				merid = "A"+words[0];
				
			    //get amount,cash,chq
				line = lines[i-9]; line = line.replace("\n", "").replace("\r","");
				words = line.split(" ");
				amt = words[4];
				cash = amt;
				
				break;
			}
			  
		      studentData.put(String.valueOf(p++), new Object[] {pname,bocno,date,amt,cash,chq,chqno,agcd,agname,merid});
			  pdDocument.close();		
			}
		
			catch(Exception e)
			{
				//e.printStackTrace();
			}
		
		
	}
	
}
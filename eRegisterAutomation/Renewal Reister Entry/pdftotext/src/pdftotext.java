import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.util.Map;

public class pdftotext
{
	public static String pno , name, fup, amt,cash,chq,chqno, tno, mode, line, date, agcd,merid;	 
	static int p = 2;
	static void extractData(String file, Map<String , Object[]> studentData) {
		
		try {
			File pdfFile = new File(file);
			PDDocument pdDocument = PDDocument.load(pdfFile);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(pdDocument);
			String[] lines = text.split("\n");
		    pno = name =fup= amt = tno = line= mode = date =cash = chq = chqno = agcd =merid =  "" ;
		    
		    for(int i = 0 ; i<lines.length - 1; i++)   
			{
		    	line = lines[i];
		    	line = line.replace("\n","").replace("\r", "");
		    	//System.out.println(line);
																							//get transaction number
					if (line.length() == "Transaction No. : 01234567".length())
					{
					    String words[] = line.split(" ");
						if (words[0].equals("Transaction"))
						{   
							tno = words[3];
						}
								
					}
					if(line.contains("Paid by Cash/Card/Sr :"))
					{
						String words[] = line.split(":");
						cash = words[1];
						words = lines[i+1].split(":");
						chq = words[1];
						words = lines[i+2].split(":");
						chqno = words[1];
					}
					if (line.length() == "553 |02834553".length())						      // get agency code
					{
					
						String words[] = line.split(" ");
						if (line.charAt(4)=='|')
						{   
							agcd = words[1].substring(1, words[1].length());
						}
					
					}
					if(i == lines.length -3 || i == lines.length - 4)
						if(line.contains("01669553")||line.contains("02069553"))													//get merchant id
					{
						merid = "A"+line.substring(line.length()-9,line.length()-1);
					}
					if (line.length() == "Date ( Time ): 15/02/2022 ( 21:07:00 )".length())  //get Date of Transaction
					{
					    String words[] = line.split(" ");
						if (words[0].equals("Date"))
						{   
							date = words[4];
						}
					
					}																		// get name & amount	
					 if (line.length() > "Received with thanks Rs. 50.00 from policyholder Shri/Smt.om ".length())
					{
						String words[] = line.split(" ");
						if (words[0].equals("Received"))
						{
							amt = words[4];
							int j = 7;
							while(j < words.length)
							name += words[j++]+" ";
							name = name.substring(9,name.length());
							
						}
					}
					 																		// get mode,fup,policy num
					if (line.contains("QLY") || line.contains("YLY") || line.contains("HLY") || line.contains("MLY") && line.length() == 3)
					{
						
						mode = line;
						pno = lines[i-7].replace("\n","").replace("\r", "");;
						int flag = i+2;
						int n = Integer.parseInt(lines[flag].trim());
						
						while(n-->0)
						{
							fup += lines[++flag].replace("\n","").replace("\r", "")+",";
						}
					
						}
							
					}
		      studentData.put(String.valueOf(p++), new Object[] { pno , name ,fup, amt,cash,chq,chqno, mode,agcd, tno, date,merid });
			  pdDocument.close();		
			}
			catch(Exception e)
			{
				//e.printStackTrace();
			}
		
		
	}
	
}
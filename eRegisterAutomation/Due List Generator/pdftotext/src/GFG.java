import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


 
public class GFG {
	
	static void RecursivePrint(File[] arr, int index, int level,String path, Map<String,Object[]> studentData)
    {
    	    String fname ="";
            if (index == arr.length)
            return;
          	fname = arr[index].getName();
          	fname = path + "\\"+fname;
            pdftotext.extractData(fname,studentData);          
            RecursivePrint(arr, ++index, level,path,studentData);
    }
   

 
     public static void xlfunc(String maindirpath) throws Exception
    {
         String t = maindirpath;
         String w[] = t.split("\\\\");
         String fn = w[w.length - 1];
         fn = "/"+fn+".xlsx";
    	 XSSFWorkbook workbook = new XSSFWorkbook();
         
         XSSFSheet spreadsheet = workbook.createSheet("Monthly due list ");
     	  
         XSSFRow row;
      
         Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
     	      
         studentData.put(String.valueOf(1), new Object[] { "Name","BOC No", "Total Premium" ,"Mode","FUP" });
     	                     
        
        File maindir = new File(maindirpath);
 
        if (maindir.exists() && maindir.isDirectory()) {
             
            File arr[] = maindir.listFiles();
 
            RecursivePrint(arr, 0, 0,maindirpath,studentData);
        }
        
       
        Set<String> keyid = studentData.keySet();
        
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
        
  
        FileOutputStream out = new FileOutputStream(new File(maindirpath+fn));
  
        workbook.write(out);
        out.close();
        
        
    }
}
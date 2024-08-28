import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.*;
import java.awt.event.*;
class display extends JFrame{
	static String path = "";
	public static String month_selected = null;
	JRadioButton[] month = new JRadioButton[12];
    String m[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    JButton jButton;
	ButtonGroup G1;
    JLabel L1;
    public display() throws Exception
	{

		// Setting layout as null of JFrame.
		this.setLayout(null);
		for(int i = 0; i<12; i++)
		month[i] = new JRadioButton();
		
		jButton = new JButton("Submit");

		G1 = new ButtonGroup();

		L1 = new JLabel("Generate Due List for Month: ");

		for(int i = 0; i<12; i++)
		month[i].setText(m[i]);
		int h = 50, w = 200;
		for(int i = 0;i<4;i++)
			month[i].setBounds(h+(100 * i),h,100 ,h*2);
		for(int i = 0;i<4;i++)
			month[i+4].setBounds(h+(100 * i),h*3,100 ,h*2);
		for(int i = 0;i<4;i++)
			month[i+8].setBounds(h+(100 * i),h*5,100 ,h*2);

		
		jButton.setBounds(185,400,100,25);
		L1.setBounds(160, 0 , 200 , 25);

		for(int i = 0; i<12; i++)
		this.add(month[i]);

		this.add(jButton);
		this.add(L1);

		for(int i = 0; i<12; i++)
		G1.add(month[i]);
		
		jButton.addActionListener(new ActionListener() {
  
	            public void actionPerformed(ActionEvent e)
	            {
	  
	             for(int i = 0; i<12; i++)
	             {	 
	                if (month[i].isSelected()) {
	  
	                    month_selected = m[i];
	                    break;
	                }
	             }
	             try {createWindow();} catch(Exception ex) {}
	           //  JOptionPane.showMessageDialog(Demo.this, month_selected);
	             }
	            
	        });
		
		
	}

	
   
public static void main(String args[]) throws Exception
{ 
	display f = new display();
	f.setBounds(800, 100, 500, 500);
	f.setTitle("Monthly Due List Generator");
	f.setVisible(true);
}
     
   
   public static void createWindow() throws Exception {    
      JFrame frame = new JFrame("Select folder containing LIC due lists");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      createUI(frame);
      frame.setSize(560, 200);      
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
      
   }

   public static void createUI(final JFrame frame) throws Exception{  
      JPanel panel = new JPanel();
      LayoutManager layout = new FlowLayout();  
      panel.setLayout(layout);      
     
      JButton button = new JButton("Browse Folder");
      final JLabel label = new JLabel();

      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	button.setText("please wait");
        	JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = fileChooser.showOpenDialog(frame);
            if(option == JFileChooser.APPROVE_OPTION){
               File file = fileChooser.getSelectedFile();
               label.setText("Folder Selected: " + file.getName());
               path = file.getAbsolutePath();
              try {
				GFG.xlfunc(path);
		     	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
               frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
             
            }else{
               label.setText("Open command canceled");
            }
         }
      });

      panel.add(button);
      panel.add(label);
      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }  

}
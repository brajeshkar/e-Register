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

class display {
	static String path = "";
   
public static void main(String args[]) throws Exception
{
	createWindow();
}
     
   
   public static void createWindow() throws Exception {    
      JFrame frame = new JFrame("Swing Tester");
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
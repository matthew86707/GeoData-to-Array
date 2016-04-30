import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class SaveFile {
	public static void save(){
		 try {
			 
			 String file = JOptionPane.showInputDialog("Save To:");
			 
		        ObjectOutputStream toFile = new ObjectOutputStream(new FileOutputStream(file));
		        toFile.writeObject(Data.grid);
		        toFile.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
}

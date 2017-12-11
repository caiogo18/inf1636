package salvamento;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class RestaurarObjeto {
	public static Object restaurar() {
		Object objeto=null;
		File file;
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filtro=new FileNameExtensionFilter("blackjack","bj");
		fileChooser.addChoosableFileFilter(filtro);
		fileChooser.showSaveDialog(null);
		file = fileChooser.getSelectedFile();
		try {
			FileInputStream restFile = new FileInputStream(file);
			ObjectInputStream stream = new ObjectInputStream(restFile);
			objeto = stream.readObject();
			stream.close();
		} 
		catch (Exception e) {
 	        e.printStackTrace();
		}
		return objeto;
	}
}

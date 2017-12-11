package salvamento;
import java.io.File;
import java.io.FileOutputStream;

import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

 

public class SalvarObjeto {

 

    public static void salvar(Object objeto) {
    	String filepath;
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filtro=new FileNameExtensionFilter("blackjack","bj");
		fileChooser.addChoosableFileFilter(filtro);
		fileChooser.showSaveDialog(null);
		if (fileChooser.getFileFilter()== filtro) {
			filepath = fileChooser.getSelectedFile().getPath().concat(".bj");
			try {
				 File arquivo = new File(filepath);
	             FileOutputStream saveFile = new FileOutputStream(arquivo);
	             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
	             stream.writeObject(objeto);
	             stream.close();

	           } catch (Exception exc) {

	             exc.printStackTrace();

	           }
		} 
		
    }

}
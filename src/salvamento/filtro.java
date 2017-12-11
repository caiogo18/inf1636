package salvamento;

import java.io.File;


public class filtro extends javax.swing.filechooser.FileFilter{
	 public boolean accept(File file) {
         String filename = file.getName();
         return filename.endsWith(".java");
     }
     public String getDescription() {
         return "*.java";
     }
}

package parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JPanel;

public class SplitClass extends JPanel{

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/WassimAjjali/Desktop/Rd-Metal/prototype/test.txt");
		String fileContent = readFileAsString(file.getAbsolutePath());
		String[] tabLigne = fileContent.split("\n");
		String[] temp = tabLigne[0].split("\t");
		Object[][] data = new Object[tabLigne.length-1][21];
		String[] title = new String[temp.length + 2];
		for(int k=0; k < temp.length ; k++){
		title[k] = temp[k];	
		}
		title[temp.length] = "Niveau";
		title[temp.length+1] = "Quantité";
		for (int j = 1; j < tabLigne.length; j++) {
			String[] tabColone = tabLigne[j].split("\t");
			for (int i = 0; i < tabColone.length; i++) {
			
				data[j-1][i] =tabColone[i] ;
			}
			String[] temp2 = tabLigne[j].split("\t");
			data[j-1][19] = spacecounter(temp2[0]);
		}

		Fenetre fen = new Fenetre(data,title);
		fen.setVisible(true);
	}

	
	/*open file function*/
	private static String readFileAsString(String filePath) throws java.io.IOException {
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ignored) {
				}
		}
		return new String(buffer);
	}
	/*count the number of space in th begining of a string*/
	public static int spacecounter(String myStr){
		int i=0;
		String[] t = myStr.split(" ");
		if(t.length >1){
			
		while(i<t.length && t[i].equals("")){
		i++;
		}
		return i/2;
		}else if(t.length==1){
		return 0;	
		}else{
			return -1;
			}
	}


}

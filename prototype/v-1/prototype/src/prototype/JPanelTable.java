package prototype;

import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JPanelTable extends JPanel {

	public JPanelTable()
	{
		
	}
	
	public Object[][] getData()
	{
		return data;
	}
	
	public Object[] getColumnNames()
	{
		return title;
	}
	
	public JTable getTable()
	{
		return tableau;
	}

	public JTable init(String filename) throws IOException {

		file = new File(
				filename);
		fileContent = readFileAsString(file.getAbsolutePath());
		tabLigne = fileContent.split("\n");
		temp = tabLigne[0].split("\t");
		data = new Object[tabLigne.length - 1][21];
		title = new Object[temp.length + 2];
		System.out.println(" ");
		for (int k = 0; k < temp.length; k++) {
			title[k] = temp[k];
			System.out.println(" " + title[k]);
		}
		title[temp.length] = "Niveau";
		title[temp.length + 1] = "Quantité";
		System.out.println("TabLigne.length : " + tabLigne.length);
		//System.out.println("TabColonne.length : " + tabCo.length);
		for (int j = 1; j < tabLigne.length; j++) {
			String[] tabColone = tabLigne[j].split("\t");
			for (int i = 0; i < tabColone.length; i++) {

				data[j - 1][i] = tabColone[i];
			}
			String[] temp2 = tabLigne[j].split("\t");
			data[j - 1][19] = spacecounter(temp2[0]);
			System.out.println("TabColonne.length : " + tabColone.length);
		}
		
		//DefaultTableModel defaultTableModel = new DefaultTableModel(data, title);
		//tableau = new JTable(defaultTableModel);
		
		// System.out.println(tableau);
		// Nous ajoutons notre tableau à notre contentPane dans un scroll
		// Sinon les titres des colonnes ne s'afficheront pas !

		// this.getRootPane().add(new JScrollPane(tableau));
		// pane = new JScrollPane(this);
		
		// getRootPane().add(pane, BorderLayout.CENTER);
		treeQuantity = new TreeQuantity(tableau);
		tableau = treeQuantity.createTree(title, data);
		
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableau.setAutoCreateRowSorter(true);
		//RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(defaultTableModel);
		//tableau.setRowSorter(sorter);
		//System.out.println(title[20]);
		//JScrollPane scrollPane = new JScrollPane(tableau);
		
		//add(scrollPane,BorderLayout.CENTER);
		
		return tableau;
	}

	/* open file function */
	private static String readFileAsString(String filePath)
			throws java.io.IOException {
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

	/* count the number of space in th begining of a string */
	public static int spacecounter(String myStr) {
		int i = 0;
		String[] t = myStr.split(" ");
		if (t.length > 1) {

			while (i < t.length && t[i].equals("")) {
				i++;
			}
			return i / 2;
		} else if (t.length == 1) {
			return 0;
		} else {
			return -1;
		}
	}

	private JTable tableau;
	private TreeQuantity treeQuantity;
	private Object[][] data;
	private Object[] title;
	private String[] temp;
	private File file;
	private String fileContent;
	private String[] tabLigne;
	// private JScrollPane pane;

}


package prototype;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeQuantity {
	
	
	
	public TreeQuantity(JTable dataTable) {
		super();
		this.dataTable = dataTable;
	}
	
	/* Create the JTree to show the different levels */
	public JTable createTree(Object columnNames[], Object rowData[][])
	{
		
		//root = new DefaultMutableTreeNode("Racine");
		
		int level = 0;
		int quantite = 0;
		int total = 0;
		Object valeurLevel0 = 0;
		Object valeurLevel1 = 0;
		Object valeurLevel2 = 0;
		Object valeurLevel3 = 0;
		
		//System.out.println(rowData[0][19]);
		for(int i = 0; i < rowData.length; i++)
		{
			//level = Integer.valueOf(rowData[i][19]);
			//level = (int) rowData[i][19];
			//quantite = (int) ;
			//total = (int) rowData[i][20];
			
			if((int)rowData[i][19] == 0)
			{	
				/*level0 = new DefaultMutableTreeNode(quantite);
				root.add(level0);*/
				valeurLevel0 = rowData[i][6];
				rowData[i][20] = rowData[i][6];
				
			}
			else if((int)rowData[i][19] == 1)
			{
				valeurLevel1 = Integer.valueOf(valeurLevel0.toString()) * Integer.valueOf(rowData[i][6].toString());
//				level1 = new DefaultMutableTreeNode(quantite);
//				level0.add(level1);
//				root.add(level0);
				rowData[i][20] = valeurLevel1;
				
			}
			else if((int)rowData[i][19] == 2)
			{
				
				valeurLevel2 = Integer.valueOf(valeurLevel1.toString()) * Integer.valueOf(rowData[i][6].toString());
//				level2 = new DefaultMutableTreeNode(quantite);
//				level1.add(level2);
//				level0.add(level1);
//				root.add(level0);
				rowData[i][20] = valeurLevel2;
			}
			else if((int)rowData[i][19] == 3)
			{
				valeurLevel3 = Integer.valueOf(valeurLevel2.toString()) * Integer.valueOf(rowData[i][6].toString());
//				level3 = new DefaultMutableTreeNode(quantite);
//				level2.add(level3);
//				level1.add(level2);
//				level0.add(level1);
//				root.add(level0);
				rowData[i][20] = valeurLevel3;
			}
		}
		
		return new JTable(rowData, columnNames);
		
		//initFrame(scrollPane);
		
		//mainFrame.add(new JScrollPane(new JTree(root)));
	}
	
	// Attributs
	
	private JTable dataTable;
	private JFrame mainFrame;
	private JScrollPane scrollPane;
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode level0;
	private DefaultMutableTreeNode level1;
	private DefaultMutableTreeNode level2;
	private DefaultMutableTreeNode level3;
}

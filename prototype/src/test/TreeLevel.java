package test;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeLevel {

	public static void main(String[] args) {
		System.out.println("Starting program ...");
		populateTable();
		System.out.println("End of program ...");

	}
	
	/* Initialize the main frame of the application */
	public static void initFrame(JScrollPane myScrollPane)
	{
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(myScrollPane, BorderLayout.EAST);
		mainFrame.setSize(600, 400);
		mainFrame.setVisible(true);
	}
	
	/* Populate the JTable */
	public static void populateTable()
	{
		Object columnNames[] = {"Quantités", "Niveau", "Total"};
		Object rowData[][] = {{0, -10, -100}, {5, 0, 5}, {0, -1, -1}, {2, 0, 2}, {3, 1, 0}, {20, 1, 0}, {30, 1, 0}, {7, 2, 0}, {2, 3, 0}, {20, 0, 20}, {30, 1, 0}};
		
		createTree(columnNames, rowData);
	}
	
	/* Create the JTree to show the different levels */
	public static void createTree(Object columnNames[], Object rowData[][])
	{
		System.out.println("Create tree ...");
		
		root = new DefaultMutableTreeNode("Racine");
		
		int level = 0;
		int quantite = 0;
		int total = 0;
		int valeurLevel0 = 0;
		int valeurLevel1 = 0;
		int valeurLevel2 = 0;
		int valeurLevel3 = 0;
		for(int i = 0; i < rowData.length; i++)
		{
			level = (int) rowData[i][1];
			quantite = (int) rowData[i][0];
			total = (int) rowData[i][2];
			
			if(level == 0)
			{	
				level0 = new DefaultMutableTreeNode(quantite);
				root.add(level0);
				valeurLevel0 = quantite;
				
			}
			else if(level == 1)
			{
				valeurLevel1 = valeurLevel0 * quantite;
				level1 = new DefaultMutableTreeNode(quantite);
				level0.add(level1);
				root.add(level0);
				rowData[i][2] = valeurLevel1;
				
			}
			else if(level == 2)
			{
				valeurLevel2 = valeurLevel1 * quantite;
				level2 = new DefaultMutableTreeNode(quantite);
				level1.add(level2);
				level0.add(level1);
				root.add(level0);
				rowData[i][2] = valeurLevel2;
			}
			else if(level == 3)
			{
				valeurLevel3 = valeurLevel2 * quantite;
				level3 = new DefaultMutableTreeNode(quantite);
				level2.add(level3);
				level1.add(level2);
				level0.add(level1);
				root.add(level0);
				rowData[i][2] = valeurLevel3;
			}
		}
		
		dataTable = new JTable(rowData, columnNames);
		scrollPane = new JScrollPane(dataTable);
		initFrame(scrollPane);
		System.out.println(Arrays.deepToString(rowData));

		mainFrame.add(new JScrollPane(new JTree(root)));
	}
	
	// Attributs
	
	private static JTable dataTable;
	private static JFrame mainFrame;
	private static JScrollPane scrollPane;
	private static DefaultMutableTreeNode root;
	private static DefaultMutableTreeNode level0;
	private static DefaultMutableTreeNode level1;
	private static DefaultMutableTreeNode level2;
	private static DefaultMutableTreeNode level3;
}

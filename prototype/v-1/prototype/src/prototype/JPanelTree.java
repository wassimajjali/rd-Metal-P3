package prototype;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JPanelTree extends JPanel {
	public JPanelTree(Object rowData[][])
	{
		this.rowData = rowData;
	}
	
	public JTree initJTree()
	{
		root = new DefaultMutableTreeNode("Racine");
		Object titre;
		Object level;
		
		for(int i = 0; i < rowData.length; i++)
		{
			titre = rowData[i][0];
			level = rowData[i][19];
			switch(Integer.valueOf(level.toString()))
			{
			case 0:
				level0 = new DefaultMutableTreeNode(titre);
				root.add(level0);
				break;
			case 1:
				level1 = new DefaultMutableTreeNode(titre);
				level0.add(level1);
				root.add(level0);
				break;
			case 2:
				level2 = new DefaultMutableTreeNode(titre);
				level1.add(level2);
				level0.add(level1);
				root.add(level0);
				break;
			case 3:
				level3 = new DefaultMutableTreeNode(titre);
				level2.add(level3);
				level1.add(level2);
				level0.add(level1);
				root.add(level0);
				break;
			}
		}
		
		return new JTree(root);
	}
	
	private Object rowData[][];
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode level0;
	private DefaultMutableTreeNode level1;
	private DefaultMutableTreeNode level2;
	private DefaultMutableTreeNode level3;
}

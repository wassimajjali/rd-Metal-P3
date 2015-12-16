package prototype;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class JPanelControl extends JPanel {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelControl(JPanelTable jPanelTable) throws IOException {
		// gca
		this.jPanelTable=jPanelTable;
		geometry();
		control();
		appearance();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	

	private void appearance() {
		// rien.
		setBorder(BorderFactory.createTitledBorder("Control Fonction"));
	}

	private void control() throws IOException {
		table = jPanelTable.getTable();
//		System.out.println(table);

		rechercher.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String value = rechercher.getText();

				for (int row = 0; row <= table.getRowCount() - 1; row++) {

					for (int col = 0; col <= table.getColumnCount() - 1; col++) {

						if (value.equals(table.getValueAt(row, col))) {

							// this will automatically set the view of the
							// scroll in the location of the value
							table.scrollRectToVisible(table.getCellRect(row, 0,
									true));

							// this will automatically set the focus of the
							// searched/selected row/value
							table.setRowSelectionInterval(row, row);

							for (int i = 0; i <= table.getColumnCount() - 1; i++) {
								table.getColumnModel()
										.getColumn(i)
										.setCellRenderer(
												new HighlightRenderer());
							}
						}
					}
				}
			}
		});
		/*addLine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			table.setEnabled(false);
			}
		});
		*/
		checkEditable.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				table.setEnabled(true);
				if (e.getStateChange() == ItemEvent.DESELECTED) {
				table.setEnabled(false);
		        }
				
			}
		});
		checkSort.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				table.setAutoCreateRowSorter(true);

				if (e.getStateChange() == ItemEvent.DESELECTED) {
				table.setAutoCreateRowSorter(false);		        }
				
			}
		});
	}

	private void geometry() {
		checkEditable=new JCheckBox();
		rechercher = new JTextField("");
		Hierarchie = new JButton("Afficher Arbre");
		find = new JLabel("Rechercher element");
		labelEdition = new JLabel("Editer: ");
		checkEditable.setSelected(true);

		addLine = new JButton("Ajouter Ligne");
		checkSort=new JCheckBox();
		labelSort = new JLabel("Trier: ");

		
		boxV = Box.createVerticalBox();
		boxH = Box.createHorizontalBox();
		boxH2 = Box.createHorizontalBox();
		boxH3 = Box.createHorizontalBox();
		boxH4 = Box.createHorizontalBox();
		boxH5 = Box.createHorizontalBox();
		//boxH2.add(Hierarchie);
		boxV.add(boxH2);
		//boxH.add(addLine);
		boxH3.add(find);
		boxV.add(boxH3);
		boxV.add(rechercher);
		boxV.add(Box.createVerticalStrut(20));
		boxH4.add(labelEdition);
		boxH4.add(checkEditable);
		boxV.add(boxH4);

		boxV.add(Box.createVerticalStrut(20));
		boxV.add(boxH);

		boxV.add(Box.createVerticalStrut(20));
		
		boxH5.add(labelSort);
		boxH5.add(checkSort);

		//boxH5.add(area);
		boxV.add(boxH5);
		boxV.add(Box.createVerticalStrut(50));

		// boxV.add(btnFonction);
	

		add(boxV, BorderLayout.WEST);

	}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//rechcher
	private JTextField rechercher;
	private JLabel find;
	//edition
	private JLabel labelEdition;
	private JCheckBox checkEditable;
	//tri
	
	private JLabel labelSort;
	private JCheckBox checkSort;
	
	
	private JButton Hierarchie;
	private JButton addLine;
	

	// Box
	private Box boxV;
	private Box boxH;
	private Box boxH2;
	private Box boxH3;
	private Box boxH4;
	private Box boxH5;

	private JTable table;
	private JPanelTable jPanelTable;
	private JPanelTree jPanelTree;


	private class HighlightRenderer extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {

			// everything as usual
			super.getTableCellRendererComponent(table, value, isSelected,
					hasFocus, row, column);

			// added behavior
			if (row == table.getSelectedRow()) {

				// this will customize that kind of border that will be use to
				// highlight a row
				setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1,
						Color.BLACK));
			}

			return this;
		}
	}

}

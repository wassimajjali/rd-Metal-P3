
package prototype;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JPanelControl extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelControl()
		{
		//gca
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	private void appearance()
		{
		//rien.
		setBorder(BorderFactory.createTitledBorder("Control Fonction"));
		}

	private void control()
		{


		
		}

	private void geometry()
		{
		rechercher = new JTextField("");
		btnFonction = new JButton("Calcule Quantite");
		find=new JLabel("Rechercher element");
		sort=new JLabel("Trier par");
		addLine=new JButton("Ajouter Ligne");
		Object[] elements = new Object[]{"Numéro piéce", "Dossier", "Groupe ", "Position", "Norme"};
		liste=new JComboBox(elements);
		area=new JTextArea(content);
		area.setEditable(false);
		area.setBackground(Color.LIGHT_GRAY);
		
		boxV = Box.createVerticalBox();
		boxH = Box.createHorizontalBox();
		boxH2 = Box.createHorizontalBox();
		boxH3 = Box.createHorizontalBox();
		boxH4 = Box.createHorizontalBox();
		boxH5 = Box.createHorizontalBox();




		
		boxH.add(addLine);
		boxH3.add(find);
		boxV.add(boxH3);
		boxV.add(rechercher);
		boxV.add(Box.createVerticalStrut(20));
		boxH4.add(sort);
		boxV.add(boxH4);
		boxV.add(liste);
		boxV.add(Box.createVerticalStrut(20));
		boxV.add(boxH);
		
		boxV.add(Box.createVerticalStrut(20));

		
		boxH5.add(area);
		boxV.add(boxH5);
		boxV.add(Box.createVerticalStrut(50));

		
		
		//boxV.add(btnFonction);
		boxH2.add(btnFonction);
		boxV.add(boxH2);
		

		


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
	private JTextField rechercher;
	private JLabel find;
	private JLabel sort;
	private JButton btnFonction;
	private JButton addLine;;


	//Box
	private Box boxV;
	private Box boxH;
	private Box boxH2;
	private Box boxH3;
	private Box boxH4;
	private Box boxH5;

	//Trier
	private JComboBox liste;
	private static String content = "Vous pouvez faire des\n"
								  + "modification directemet \n"
								  + "sur le tableau.";

	private JTextArea area;
	
	}

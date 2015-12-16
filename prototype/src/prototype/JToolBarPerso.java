
package prototype;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class JToolBarPerso extends JToolBar
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JToolBarPerso(JFrameMain jf)
		{
		jFrameMain = jf;
		geometry();
		control();
		apparence();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		buttonNouveauSchema = new JButton();
		buttonNouveauSchema.setToolTipText("Nouveau Schéma");

		buttonOuvrirSchema = new JButton();
		buttonOuvrirSchema.setToolTipText("Ouvrir Schéma");

		buttonEnregistrer = new JButton();
		buttonEnregistrer.setToolTipText("Enregistrer");

		buttonEnregistrerSous = new JButton();
		buttonEnregistrerSous.setToolTipText("Enregistrer sous");

		buttonExporter = new JButton();
		buttonExporter.setToolTipText("Exporter");

		URL imageurl = getClass().getResource("../images/nouveauButton.png");
		Image myPicture = Toolkit.getDefaultToolkit().getImage(imageurl);
		buttonNouveauSchema.setIcon(new ImageIcon(myPicture));

		imageurl = getClass().getResource("../images/ouvrirButton.png");
		myPicture = Toolkit.getDefaultToolkit().getImage(imageurl);
		buttonOuvrirSchema.setIcon(new ImageIcon(myPicture));

		imageurl = getClass().getResource("../images/sauverButton.png");
		myPicture = Toolkit.getDefaultToolkit().getImage(imageurl);
		buttonEnregistrer.setIcon(new ImageIcon(myPicture));

		imageurl = getClass().getResource("../images/sauversousButton.png");
		myPicture = Toolkit.getDefaultToolkit().getImage(imageurl);
		buttonEnregistrerSous.setIcon(new ImageIcon(myPicture));

		imageurl = getClass().getResource("../images/exportButton.png");
		myPicture = Toolkit.getDefaultToolkit().getImage(imageurl);
		buttonExporter.setIcon(new ImageIcon(myPicture));

		}

	private void control()
		{
		//createActions();

		add(buttonNouveauSchema);
		add(buttonOuvrirSchema);
		add(buttonEnregistrer);
		add(buttonEnregistrerSous);

		addSeparator();

		addSeparator();

		add(buttonExporter);

		addSeparator();
		}

	private void apparence()
		{
		setBorder(BorderFactory.createLineBorder(Color.black, 1));

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Attributs
	private JButton buttonNouveauSchema;
	private JButton buttonOuvrirSchema;
	private JButton buttonEnregistrer;
	private JButton buttonEnregistrerSous;

	private JButton buttonExporter;

	private JFrameMain jFrameMain;

	}

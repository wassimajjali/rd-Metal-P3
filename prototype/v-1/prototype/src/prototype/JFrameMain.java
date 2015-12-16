package prototype;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import parser.SplitClass;

public class JFrameMain extends JFrame {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args) throws IOException {
		
		if (initializeFileWindow() == JFileChooser.APPROVE_OPTION) {
			new JFrameMain();
		}
	}

	public JFrameMain() throws IOException {
		geometry();
		control();
		appearance();

	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	private void appearance() {
		setSize(1280, 720);
		setMinimumSize(new Dimension(1280, 720));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void geometry() throws IOException {

		setLayout(new BorderLayout());
		jPanelTable = new JPanelTable();
		table = jPanelTable.init(fileopen.getSelectedFile().getName());
		//table = new JTable(jPanelTable.getData(), jPanelTable.getColumnNames());
		export = new JPanelExport(jPanelTable.getData(), jPanelTable.getColumnNames());
		jPanelControl = new JPanelControl();
		toolBar = new JToolBarPerso(this);
		jPanelTree = new JPanelTree(jPanelTable.getData());
		JTree test = jPanelTree.initJTree();
		// jScrollPane=new JScrollPane(jPanelTable);
		add(toolBar, BorderLayout.NORTH);
		add(jPanelControl, BorderLayout.WEST);
		add(export, BorderLayout.SOUTH);
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(new JScrollPane(test), BorderLayout.EAST);

		addMenu();
	}

	private void control() {
		// resize de la fenetre
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void apparence() {
		setVisible(true);
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
	private void addMenu() {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu = new JMenu("Fichier");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription(
				"Ouvrir, Sauvegarder, Charger, Exporter");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("Nouveau Calcul", KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		// menuItem.getAccessibleContext().setAccessibleDescription("Ouvrir un fichier");

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// newSchema();
			}
		});

		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Sauvegarder", KeyEvent.VK_S);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// saveSchema();

			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Sauvegarder sous...");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// saveSchemaUnder();

			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Charger");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		menuItem.setMnemonic(KeyEvent.VK_L);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// loadFile();

			}
		});
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Exporter");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		menuItem.setMnemonic(KeyEvent.VK_E);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// export();
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Fermer");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				ActionEvent.CTRL_MASK));
		menuItem.setMnemonic(KeyEvent.VK_U);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// close();
			}
		});
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Quitter");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				ActionEvent.ALT_MASK));
		menuItem.setMnemonic(KeyEvent.VK_F4);

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrameMain.this.dispose();
			}
		});
		menu.add(menuItem);

		menu = new JMenu("Aide");
		menu.setMnemonic(KeyEvent.VK_F);
		// menu.getAccessibleContext().setAccessibleDescription("?");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("?", KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
				ActionEvent.CTRL_MASK));
		// menuItem.getAccessibleContext().setAccessibleDescription("Ouvrir un fichier");

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// openHelp();
			}
		});
		menu.add(menuItem);
		this.setJMenuBar(menuBar);

	}
	
	private static int initializeFileWindow()
	{
		fileopen = new JFileChooser();
		FileTypeFilter fileTypeFilter = new FileTypeFilter("txt", "text files");
		fileTypeFilter.disableNewFolderButton(fileopen);
		FileFilter filter = new FileNameExtensionFilter("text files", "txt");
		int ret;
		
		do {
			fileopen.addChoosableFileFilter(filter);
			ret = fileopen.showDialog(null, "Open text file");

			if (ret == JFileChooser.CANCEL_OPTION) {
				break;
			}
		} while (!fileTypeFilter.accept(fileopen.getSelectedFile()));
		
		return ret;
	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// private static final File FILE_PROPERTIES = new File("./config.ini");
	private JPanelTable jPanelTable;
	private JPanelExport export;
	private JPanelControl jPanelControl;
	// private String filePath = "";
	// private String imagePath = "";
	private JToolBarPerso toolBar;
	private SplitClass class1;
	// private Stack<Schema> pileZ, pileY;
	private JScrollPane jScrollPane;
	private JPanelTree jPanelTree;
	private static JFileChooser fileopen;
	private JTable table;
}

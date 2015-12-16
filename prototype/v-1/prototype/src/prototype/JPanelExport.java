package prototype;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class JPanelExport extends JPanel {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	

	public JPanelExport(Object[][] data, Object[] columnNames) {
		this.data = data;
		this.columnNames = columnNames;
		geometry();
		control();
		appearance();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	private void appearance() {
		setBorder(BorderFactory.createTitledBorder("Export Table"));
		// this.setLayout(new BorderLayout());
		setBackground(Color.GREEN);
		// setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

	}

	private void control() {
		exportPdf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// print2();
				String pdfFilename = "";
				GeneratePDF generatePDF = new GeneratePDF();

				pdfFilename = "goodTest.pdf";
				generatePDF.createPDF(pdfFilename, data, columnNames);
			}
		});
		
		exportcsv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!exportInProgress) {
                    exportInProgress = true;
                    new Thread() {
                        public void run() {
                            exp.exportTable(new JTable(data, columnNames),
                                    new File("foooo.csv"));
                            exportInProgress = false;
                        }
                    }.start();
                }
				
			}
		});
	}

	private void geometry() {

		Icon warnIcon = new ImageIcon("images/exportButton.png");
		exportcsv = new JButton("Export CSV ", warnIcon);
		exportPdf = new JButton("Export PDF");
		exp = new ExcelExporter();
		exportInProgress = false;

		add(Box.createVerticalGlue());
		add(exportcsv);
		add(Box.createVerticalGlue());
		add(exportPdf);

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

	private JButton exportcsv;
	private JButton exportPdf;
	private JPanelTable jPanelTable;
	private JTable table;
	private ExcelExporter exp;
	private Object[][] data; 
	private Object[] columnNames;
	private boolean exportInProgress;

}

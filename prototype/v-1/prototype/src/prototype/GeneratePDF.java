package prototype;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * source : http://www.mysamplecode.com/2012/10/generate-pdf-using-java-and-itext.html
 * @author Wassim Ajjali
 *
 */

public class GeneratePDF {
	public void createPDF(String pdfFilename, Object[][] data,
			Object[] columnNames) {
		this.data = data;
		this.columnNames = columnNames;
		Document doc = new Document();
		PdfWriter docWriter = null;
		initializeFonts();

		try {
			String path = pdfFilename;
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
			doc.addAuthor("Wassim Ajjali");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("MySampleCode.com");
			doc.addTitle("Invoice");
			doc.setPageSize(PageSize.LETTER);

			doc.open();
			PdfContentByte cb = docWriter.getDirectContent();

			boolean beginPage = true;
			int y = 0;

			for (int i = 0; i < data.length; i++) {
				if (beginPage) {
					beginPage = false;
					generateLayout(doc, cb);
					generateHeader(doc, cb);
					y = 615;
				}
				generateDetail(doc, cb, i, y);
				y = y - 15;
				if (y < 50) {
					printPageNumber(cb);
					doc.newPage();
					beginPage = true;
				}
			}
			printPageNumber(cb);

		} catch (DocumentException dex) {
			dex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (doc != null) {
				doc.close();
			}
			if (docWriter != null) {
				docWriter.close();
			}
		}
	}

	private void generateLayout(Document doc, PdfContentByte cb) {

		try {

			cb.setLineWidth(1f);

			// Invoice Header box layout
			cb.rectangle(420, 700, 150, 40);
			cb.moveTo(420, 740);
			cb.lineTo(570, 740);
			cb.moveTo(420, 740);
			cb.lineTo(570, 740);
			cb.moveTo(480, 700);
			cb.lineTo(480, 740);
			cb.moveTo(420, 717);
			cb.lineTo(570, 717);
			cb.stroke();

			// Invoice Header box Text Headings
			// createHeadings(cb, 422, 743, "Account No.");
			createHeadings(cb, 422, 723, "Heure : ");
			createHeadings(cb, 422, 703, "Date : ");

			// Invoice Detail box layout
			cb.rectangle(20, 50, 550, 600);
			cb.moveTo(20, 630);
			cb.lineTo(570, 630);
			cb.moveTo(120, 50);
			cb.lineTo(120, 650);
			cb.moveTo(158, 50);
			cb.lineTo(158, 650);
			cb.moveTo(430, 50);
			cb.lineTo(430, 650);
			cb.moveTo(500, 50);
			cb.lineTo(500, 650);
			cb.stroke();

			// Invoice Detail box Text Headings
			createHeadings(cb, 22, 633, "Numéro de pièce");
			createHeadings(cb, 122, 633, "Quantité");
			createHeadings(cb, 160, 633, "Description");
			createHeadings(cb, 432, 633, "Niveau");
			createHeadings(cb, 502, 633, "Quantité totale");

			// add the images
			Image companyLogo = Image.getInstance("images/logo_moyen.png");
			companyLogo.setAbsolutePosition(25, 720);
			companyLogo.scalePercent(65);
			doc.add(companyLogo);

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void generateHeader(Document doc, PdfContentByte cb) {

		try {

			createHeadings(cb, 200, 750,
					"Nom de l'entreprise : ...............................................");
			createHeadings(
					cb,
					200,
					735,
					"NPA : .........................................................................");
			createHeadings(cb, 200, 720,
					"Adresse : ..................................................................");
			createHeadings(
					cb,
					200,
					705,
					"Ville : .........................................................................");
			createHeadings(
					cb,
					200,
					690,
					"Pays : ........................................................................");

			// createHeadings(cb, 482, 743, "ABC0001");
			// createHeadings(cb, 482, 723, "123456");
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			
			
			createHeadings(cb, 482, 723, sdf.format(cal.getTime()));
			createHeadings(cb, 482, 703, cal.get(Calendar.DATE)+"."+ (cal.get(Calendar.MONTH)+1) + "." + cal.get(Calendar.YEAR));

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void generateDetail(Document doc, PdfContentByte cb, int index,
			int y) {
		DecimalFormat df = new DecimalFormat("0.00");

		try {
			createContent(cb, 25, y, String.valueOf(data[index][0]),
					PdfContentByte.ALIGN_LEFT);
			/*
			 * createContent(cb, 48, y, String.valueOf(index + 1),
			 * PdfContentByte.ALIGN_RIGHT);
			 */
			createContent(cb, 125, y, String.valueOf(data[index][6]),
					PdfContentByte.ALIGN_LEFT);
			createContent(cb, 163, y, String.valueOf(data[index][7]),
					PdfContentByte.ALIGN_LEFT);

			// double price = Double.valueOf(df.format(Math.random() * 10));
			// double extPrice = price * (index + 1);
			createContent(cb, 435, y, String.valueOf(data[index][19]),
					PdfContentByte.ALIGN_LEFT);
			createContent(cb, 505, y, String.valueOf(data[index][20]),
					PdfContentByte.ALIGN_LEFT);

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void createHeadings(PdfContentByte cb, float x, float y, String text) {

		cb.beginText();
		cb.setFontAndSize(bfBold, 8);
		cb.setTextMatrix(x, y);
		cb.showText(text.trim());
		cb.endText();

	}

	private void printPageNumber(PdfContentByte cb) {

		cb.beginText();
		cb.setFontAndSize(bfBold, 8);
		cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page "
				+ (pageNumber + 1), 570, 25, 0);
		cb.endText();

		pageNumber++;

	}

	private void createContent(PdfContentByte cb, float x, float y,
			String text, int align) {

		cb.beginText();
		cb.setFontAndSize(bf, 8);
		cb.showTextAligned(align, text.trim(), x, y, 0);
		cb.endText();

	}

	private void initializeFonts() {

		try {
			bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD,
					BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252,
					BaseFont.NOT_EMBEDDED);

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private BaseFont bfBold;
	private BaseFont bf;
	private int pageNumber = 0;
	private JTable table;
	private Object[][] data;
	private Object[] columnNames;
}

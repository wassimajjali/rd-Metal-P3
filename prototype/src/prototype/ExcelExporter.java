package prototype;

import java.awt.image.ReplicateScaleFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTable;

public class ExcelExporter {
	public ExcelExporter() {
	}

	public void exportTable(JTable table, File file) {
		try {
			file.createNewFile();

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			bw.newLine();

			bw.write("Nom de l'entreprise : ");
			bw.newLine();
			bw.write("NPA : ");
			bw.newLine();
			bw.write("Adresse : ");
			bw.newLine();
			bw.write("Ville : ");
			bw.newLine();
			bw.write("Pays : ");
			bw.newLine();

			bw.newLine();
			bw.newLine();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

			bw.write("Heure : ");
			bw.write(sdf.format(cal.getTime()));
			bw.newLine();
			bw.write("Date : ");
			bw.write(cal.get(Calendar.DATE) + "."
					+ (cal.get(Calendar.MONTH) + 1) + "."
					+ cal.get(Calendar.YEAR));

			bw.newLine();
			bw.newLine();
			System.out.println("Column count : " + table.getColumnCount());
			for (int h = 0; h < table.getColumnCount(); h++) {
				
				bw.write(table.getColumnName(h).toString().replaceAll("[\r\n]+", "").toUpperCase());
				System.out.println(table.getColumnName(h).toString());
				if (h + 1 != table.getColumnCount())
					bw.write(";");
			}
			bw.newLine();
			bw.newLine();

			for (int clmCnt = table.getColumnCount(), rowCnt = table
					.getRowCount(), i = 0; i < rowCnt; i++) {
				for (int j = 0; j < clmCnt; j++) {
					if (table.getValueAt(i, j) != null) {
						String value = table.getValueAt(i, j).toString().replaceAll("[\r\n]+", "");
						bw.write(value);
					}
					if (j + 1 != clmCnt)
						bw.write(";");
				}
				bw.newLine();
			}

			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

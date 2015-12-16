package prototype;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class JPanelBrowseFile extends JPanel {
	public JPanelBrowseFile()
	{
		geometry();
		control();
		apparence();
	}

	private void apparence() {
		this.setSize(100, 50);
	}

	private void control() {
		// TODO Auto-generated method stub
		
	}

	private void geometry() {
		jFileChooser = new JFileChooser();
		this.add(jFileChooser);
		
	}
	
	private JFileChooser jFileChooser;
}

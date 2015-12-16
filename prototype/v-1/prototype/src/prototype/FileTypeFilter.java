package prototype;

import java.awt.Component;
import java.awt.Container;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

public class FileTypeFilter extends FileFilter {

	public FileTypeFilter(String extension, String description) {
		this(description, new String[] { extension });
	}
	
	public FileTypeFilter(String description, String extensions[]) {
	    if (description == null) {
	      this.description = extensions[0] + "{ " + extensions.length + "} ";
	    } else {
	      this.description = description;
	    }
	    this.extensions = (String[]) extensions.clone();
	    toLower(this.extensions);
	  }

	  private void toLower(String array[]) {
	    for (int i = 0, n = array.length; i < n; i++) {
	      array[i] = array[i].toLowerCase();
	    }
	  }
	
	@Override
		public boolean accept(File file) {
		    if (file.isDirectory()) {
		      return true;
		    } else {
		      String path = file.getAbsolutePath().toLowerCase();
		      for (int i = 0, n = extensions.length; i < n; i++) {
		        String extension = extensions[i];
		        if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
		          return true;
		        }
		      }
		    }
		    return false;
		  }
		
	

	@Override
	public String getDescription() {
		return description;
	}
    
    public void disableNewFolderButton(Container c) {
        int len = c.getComponentCount();
        for (int i = 0; i < len; i++) {
          Component comp = c.getComponent(i);
          if (comp instanceof JButton) {
            JButton b = (JButton) comp;
            Icon icon = b.getIcon();
            if (icon != null
                && icon == UIManager.getIcon("FileChooser.newFolderIcon"))
              b.setEnabled(false);
          } else if (comp instanceof Container) {
            disableNewFolderButton((Container) comp);
          }
        }
      }
    
    private String extensions[];
    private String description;

}

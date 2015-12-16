package parser;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fenetre extends JFrame {

public Fenetre(Object[][] data , String[] title){
 

  
  JTable tableau = new JTable(data, title);
  //Nous ajoutons notre tableau à notre contentPane dans un scroll
  //Sinon les titres des colonnes ne s'afficheront pas !
  this.getContentPane().add(new JScrollPane(tableau));
}


 
}
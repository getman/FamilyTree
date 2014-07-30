package getman.family_tree.ui;

//import java.awt.Frame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

/**Represents application main window with the common canvas for viewing person widgets
 * @author getman
 * @since 4.12.13
 * @version 0.1*/
public class MainWindow extends JFrame {
	//---------Data--------
	
	//---------Methods----------
	/**Default constructor*/
	public MainWindow(){
		buildWidgets();
	}
	
	/**Constructs widgets*/
	private void buildWidgets(){
		//Building main layout manager
		GridBagLayout mainGBL = new GridBagLayout();
		this.setLayout(mainGBL);
		
		/**Building main window*/
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Family Tree");
		this.setSize(600, 400);
		this.setVisible(true);
		this.setBounds(200, 200, this.getWidth(), this.getHeight() );
		
		//Building list of person
		PersonListWidget personListWidget = new PersonListWidget();
		
		GridBagConstraints gbcPersonListWidget = new GridBagConstraints();
		gbcPersonListWidget.gridx = 1;//2nd column
		gbcPersonListWidget.gridx = 0;//1st row
		gbcPersonListWidget.fill = GridBagConstraints.HORIZONTAL;
		
		
		personListWidget.createWidget(gbcPersonListWidget, this);
		personListWidget.show();
	}
	
	//---------App entry point---------
	public static void main(String [] args){
		MainWindow mainWin = new MainWindow();
	}
}


package getman.family_tree.ui;

import getman.family_tree.model.Article;
import getman.family_tree.model.Person;
import getman.family_tree.model.Person.PersonBuilder;
import getman.family_tree.model.Photo;
import getman.family_tree.model.RelativeLink;
import getman.family_tree.model.Support.Age;
import getman.family_tree.model.Support.Name;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**Represents panel with list of person 
 * @author getman
 * @since 30.01.14
 * @version 0.1*/
public class PersonListWidget extends PersonWidgetPanel{
	//-----------Data members--------
	private JList<Person> mPersonList = null;
	
	//-----------Methods-----------
	/**Fills current widget by according data*/
	@Override
	public void fillByData() {
		//creating List
		DefaultListModel<Person> listModel = new DefaultListModel<Person>();
		mPersonList = new JList<Person>(listModel);		

		//DB request for pulling Person data
		//...
		
		Person p1 = new PersonBuilder().name( new Name("Ivan") ).
					age(new Age( (short) 36) ).buildPerson();
		
		Person p2 = new PersonBuilder().name( new Name("Petr") ).
				age(new Age( (short) 33) ).buildPerson();
		
		listModel.addElement(p1);
		listModel.addElement(p2);
		
		this.addComponent(mPersonList, new GridBagConstraints() );
		
		//adding listener of selections of list items
		mPersonList.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//starting to fill all the panels for this particular Person
				Person currentPerson = mPersonList.getSelectedValue();
				//requesting in DB all currentPerson data:
				// - photos
				// - relative links
				// - articles
				//...
				
				Photo ph1 = new Photo();
				RelativeLink rl1 = new RelativeLink();
				Article a1 = new Article();
//				...
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

}

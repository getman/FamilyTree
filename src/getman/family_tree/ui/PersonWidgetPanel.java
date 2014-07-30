package getman.family_tree.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.Panel;

/**Represents abstract GUI panel for showing person`s data widget
 * @author getman
 * @since 25.03.14
 * @version 0.1*/
public abstract class PersonWidgetPanel implements IPersonWidget {
	//--------Data members--------
	public Panel mPanelWidget = null;
	public Frame mParent = null;
	
	//--------Methods------------
	/**Creates widget for this object, initiates it`s LayoutManager and parent widget
	 * @return void
	 * @param gbc GridBagConstraints - for widget layout manager
	 * @param parentWidget Frame - parent widget*/
	public void createWidget(GridBagConstraints gbc, Frame parentWidget){
		mPanelWidget = new Panel(new GridBagLayout() );
		mParent = parentWidget;
		mParent.add(mPanelWidget, gbc);
		
		this.fillByData();
		//...
	}
	
	/**Adds to this widget new component with specific GridBagConstraints
	 * @return void
	 * @param newComponent Component - new component to add
	 * @param gbc GridBagConstraints - new component GridBagConstraints*/
	public void addComponent(Component newComponent, GridBagConstraints gbc){
		this.mPanelWidget.add(newComponent, gbc);
	}
	
	/**Shows created widget*/
	@Override
	public void show(){
		mPanelWidget.setVisible(true);
	}
	
	/**Hides created widget*/
	@Override
	public void hide(){
		mPanelWidget.setVisible(false);
	}

	/**Assigns parent Frame*/
	public void setParent(Frame parentFrame){
		mParent = parentFrame;
	}
}

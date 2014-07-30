package getman.family_tree.ui;

/**Represents a person abstract widget JAVA interface with standart functionality
 * @author getman
 * @since 4.12.13
 * @version 0.1*/
public interface IPersonWidget{
	//---------Methods-----------
	/**Shows created widget*/
	public void show();
	/**Hides created widget*/
	public void hide();
	/**Fills current widget by according data*/
	public void fillByData();
}

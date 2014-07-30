package getman.family_tree.model;

/**Accumulates infrastructure enums, classes etc.
 * @author getman
 * @since 7-04-2014*/
public abstract class Support {
	//----------Data members--------------
	
	//-----------Nested classes-------------
	/**Represents Person`s age*/
	public static class Age{
		//------------Data members--------------
		/**age value*/
		private short mValue = 0;
		
		//----------Methods--------------
		/**Parameter constructor*/
		public Age(short age){
			this.mValue = age;
		}
		
		/**sets age to new value
		 * @param newAge short - new age value*/
		public void setAge(short newAge){
			this.mValue = newAge;
		}
		
		/**returns age value
		 * @return short age*/
		public short getAge(){
			return this.mValue;
		}
	}
	
	/**Represents Person`s name*/
	public static class Name{
		//------------Data members--------------
		/**Name content*/
		private String mValue = "";
		
		//----------Methods--------------
		/**Parameter constructor*/
		public Name(String name){
			this.mValue = name;
		}
		
		/**sets name to new value
		 * @param newName String - new name*/
		public void setName(String newName){
			this.mValue = newName;
		}
		
		/**returns name content
		 * @return String name*/
		public String getName(){
			return this.mValue;
		}
	}
	
}

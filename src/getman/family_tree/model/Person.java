package getman.family_tree.model;

import getman.family_tree.model.Support.Age;
import getman.family_tree.model.Support.Name;

/**Represents a single person
 * @author getman
 * @since 7-04-14*/
public class Person {
	//---------Data members-----------
	private Name mName;
	private Age mAge;
	
	//----------Methods---------
	/**Default constructor*/
	public Person(){
	}
	
	/**Returns person string representation*/
	@Override
	public String toString(){
		return this.mName.getName();
	}
	
	//----------Getters and Setters----------
	/**Returns age*/
	public Age getAge(){
		return this.mAge;
	}
	
	/**Returns name*/
	public Name getName(){
		return this.mName;
	}
	
	/**Sets age*/
	public void setAge(Age newAge){
		this.mAge = newAge;
	}
	
	/**Sets name*/
	public void setName(Name newName){
		this.mName = newName;
	}
	
	//----------Nested classes-------------
	
	/**Represents the Person builder according Builder pattern*/
	public static class PersonBuilder{
		//----------Data members--------
		private Name mName = null;
		private Age mAge = null;
		//-----------Methods-----------
		/**Builds empty Person object
		 * @return {@link Person} built Person object*/
		public Person buildPerson(){
			Person result = new Person();
			result.setAge(mAge);
			result.setName(mName);
			return result;
		}
		
		/**Sets person`s name
		 * @param newName {@link Name} builder object new name
		 * @return {@link PersonBuilder} builder object*/
		public PersonBuilder name(Name newName){
			this.mName = newName;
			return this;
		}
		
		/**Sets person`s age
		 * @param newAge {@link Age} builder object new age
		 * @return {@link PersonBuilder} builder object*/
		public PersonBuilder age(Age newAge){
			this.mAge = newAge;
			return this;
		}
	}
}

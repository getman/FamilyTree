package ru.getman.familytree.servlet.model;

/**Represents a single person
 * @author getman
 * @since 7-04-14*/
public class Person {
	//---------Data members-----------
    private int id;
	private String name;
	private short age;
	
	//----------Methods---------

	/**Returns person string representation*/
	@Override
	public String toString(){
		return this.name;
	}
	
	//----------Getters and Setters----------
	public short getAge(){
		return this.age;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(short newAge){
		this.age = newAge;
	}
	
	public void setName(String newName){
		this.name = newName;
	}

}

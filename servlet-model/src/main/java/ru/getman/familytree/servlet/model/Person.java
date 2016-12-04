package ru.getman.familytree.servlet.model;

/**Represents a single person
 * @author getman
 * @since 7-04-14*/
public class Person {
	//---------Data members-----------
    /**Person unique identifier*/
    private int id;
    /**Person name*/
	private String name;
    /**Person age*/
	private short age;
	
	//----------Methods---------
    public Person(int id) {
        this.id = id;
    }

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

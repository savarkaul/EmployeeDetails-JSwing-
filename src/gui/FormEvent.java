package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {

	private String name;
	private String occupation;
	private int salary;
	private int ageCatergory;
	private String empCat;
	private String taxId;
	private boolean iCitizen;
	private String gender;
	
	public FormEvent(Object source) {
		super(source);
		
	}
	
	public FormEvent(Object source, String name, String occupation, int salary, int ageCat, 
			String empCat, String taxId, boolean iCitizen, String gender) {
		super(source);
		this.name= name;
		this.occupation= occupation;
		this.salary= salary;
		this.ageCatergory= ageCat;
		this.empCat= empCat;
		this.taxId= taxId;
		this.iCitizen= iCitizen;
		this.gender= gender;
	}
	
	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getAgeCatergory() {
		return ageCatergory;
	}
	
	public String getEmployementCatergory() {
		return empCat;
	}

	public String getTaxId() {
		return taxId;
	}

	public boolean isiCitizen() {
		return iCitizen;
	}
}
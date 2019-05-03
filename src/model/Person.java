package model;

public class Person {
	private int id;
	private String name;
	private String occupation;
	private String salary;
	private AgeCatergory ageCatergory;
	private EmployementCatergory empCat;
	private String taxId;
	private boolean iCitizen;
	private Gender gender;
	
	public Person(String name, String occupation, AgeCatergory ageCatergory,
			EmployementCatergory employementCatergory, String taxId, 
			boolean iCitizen, Gender gender) {
			this.name= name;
			this.occupation= occupation;
			this.salary= salary;
			this.ageCatergory= ageCatergory;
			this.empCat= employementCatergory;
			this.taxId= taxId;
			this.iCitizen= iCitizen;
			this.gender= gender;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public AgeCatergory getAgeCatergory() {
		return ageCatergory;
	}
	public void setAgeCatergory(AgeCatergory ageCatergory) {
		this.ageCatergory = ageCatergory;
	}
	public EmployementCatergory getEmpCat() {
		return empCat;
	}
	public void setEmpCat(EmployementCatergory empCat) {
		this.empCat = empCat;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public boolean isiCitizen() {
		return iCitizen;
	}
	public void setiCitizen(boolean iCitizen) {
		this.iCitizen = iCitizen;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}

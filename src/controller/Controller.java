package controller;

import java.util.List;
import gui.FormEvent;
import model.AgeCatergory;
import model.Database;
import model.EmployementCatergory;
import model.Gender;
import model.Person;

public class Controller {
	
	Database db= new Database();
	
	public List<Person> getPeople() {
		return db.getPeople();
		
	}
	
	public void addPerson(FormEvent ev) {
		String name= ev.getName();
		String occupation= ev.getOccupation();
		int salary= ev.getSalary();
		int ageCatId= ev.getAgeCatergory();
		String empCat= ev.getEmployementCatergory();
		boolean isiCitizen= ev.isiCitizen();
		String taxId= ev.getTaxId();
		String gender= ev.getGender();
		
		AgeCatergory ageCatergory= null;
		
		switch(ageCatId) {
		case 0:
			ageCatergory = AgeCatergory.child;
			break;
		case 1:
			ageCatergory = AgeCatergory.adult;
			break;
		case 2:
			ageCatergory = AgeCatergory.senior;
			break;
		}
		
		EmployementCatergory empCatergory= null;
		
		if(empCat.equals("Development")) {
			empCatergory= EmployementCatergory.development;
		}
		else if(empCat.equals("Testing")) {
			empCatergory= EmployementCatergory.testing;
		}
		else if(empCat.equals("Human Resources")) {
			empCatergory= EmployementCatergory.humanResources;
		}
		else {
			empCatergory= EmployementCatergory.marketing;
		}
		
		Gender genderCat;
		if(gender.equals("Male")) {
			genderCat= Gender.male;
		}
		else {
			genderCat= Gender.female;
		}
		
		Person person= new Person(name, occupation, ageCatergory,
				empCatergory, taxId, isiCitizen, genderCat);
		
		db.addPerson(person);
	
		
	}

}

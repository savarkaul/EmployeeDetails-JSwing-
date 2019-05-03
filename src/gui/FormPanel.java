package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JLabel salaryLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JTextField salaryField;
	private JButton okBtn;
	private FormListener formListener;
	private JList ageList;
	private JComboBox empCombo;
	private JCheckBox citizenCheck;
	private JTextField taxField;
	private JLabel taxLabel;
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;
	
	

public FormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel= new JLabel("Name: ");
		occupationLabel = new JLabel("Position: ");
		salaryLabel = new JLabel("Salary:");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		salaryField = new JTextField(10);
		ageList= new JList();
		empCombo = new JComboBox();
		
		citizenCheck = new JCheckBox();
		taxField = new JTextField(10);
		taxLabel = new JLabel("Tax ID: ");
		okBtn = new JButton("OK");
		
		//set up mnemonics
		
		okBtn.setMnemonic(KeyEvent.VK_O);
		
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nameLabel.setLabelFor(nameField);
		
		
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");
		maleRadio.setActionCommand("Male");
		femaleRadio.setActionCommand("Female");
		genderGroup= new ButtonGroup();
		
		maleRadio.setSelected(true);
		
		//set up gender radio buttons
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		
		
		//set up tax ID
		
		taxLabel.setEnabled(false);
		taxField.setEnabled(false);
		
		citizenCheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				boolean isTicked = citizenCheck.isSelected();
				taxLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);
			}
		});
		
		//set up list box
		DefaultListModel ageModel = new DefaultListModel();
		ageModel.addElement(new AgeCatergory(0, "Under 18"));
		ageModel.addElement(new AgeCatergory(1, "18 to 60"));
		ageModel.addElement(new AgeCatergory(2, "Over 60"));
		ageList.setModel(ageModel);	
		
		ageList.setPreferredSize(new Dimension(110,66));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);

		
		//set up combo box
		DefaultComboBoxModel empModel= new DefaultComboBoxModel();
		empModel.addElement("Development");
		empModel.addElement("Testing");
		empModel.addElement("Human Resources");
		empModel.addElement("Marketing");	
		empCombo.setModel(empModel);
		
		
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				String salary1= salaryField.getText();
				int salary= Integer.parseInt(salary1);
				AgeCatergory ageCat = (AgeCatergory)ageList.getSelectedValue();
				String empCat = (String)empCombo.getSelectedItem();
				String taxId = taxField.getText();
				boolean iCitizen = citizenCheck.isSelected(); 
				
				String gender = genderGroup.getSelection().getActionCommand();
				System.out.println(empCat);
				
				FormEvent ev= new FormEvent(this, name, occupation, salary, 
						ageCat.getId(), empCat, taxId, iCitizen, gender ) ;
				
				if(formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
			
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Details of employee");
		Border outerBorder =BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder ));
		
		layoutComponents();
		
}

public void layoutComponents() {
	
	setLayout(new GridBagLayout());
	
	GridBagConstraints gc= new GridBagConstraints();
	
	
	//Row 1
	 
	gc.gridy= 0;     //increase in y goes top to bottom
	
	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.1;
	
	gc.gridx= 0;     //increase in x goes left to right
	gc.fill= GridBagConstraints.NONE;		//tells component whether to take up all the space or not
	gc.anchor= GridBagConstraints.LINE_END;
	gc.insets= new Insets(0, 0, 0, 5);
	add (nameLabel, gc);
	
	gc.gridy=0;
	gc.gridx=1;
	gc.insets= new Insets(0, 0, 0, 0);
	gc.anchor= GridBagConstraints.LINE_START;
	add(nameField, gc);
	
	//Row 2
	gc.gridy++;
	
	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.1;
	
	gc.gridx=0;
	gc.anchor= GridBagConstraints.LINE_END;
	gc.insets= new Insets(0, 0, 0, 5);
	add (occupationLabel, gc);
	
	gc.gridy=1;
	gc.gridx=1;
	gc.anchor= GridBagConstraints.LINE_START;
	gc.insets= new Insets(0, 0, 0, 0);
	add(occupationField,gc);
	
	//Row 3
	gc.gridy++;
	
	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.1;
	
	gc.gridx=0;
	gc.anchor= GridBagConstraints.LINE_END;
	gc.insets= new Insets(0, 0, 0, 5);
	add(salaryLabel,gc);
	
	gc.gridy=2;
	gc.gridx=1;
	gc.anchor= GridBagConstraints.LINE_START;
	gc.insets= new Insets(0, 0, 0, 0);
	add(salaryField,gc);
	
	//Row 4
	gc.gridy++;
	
	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.2;
	
	gc.gridx=0;
	gc.insets = new Insets(0, 0, 0, 5);
	gc.anchor= GridBagConstraints.FIRST_LINE_END;
	add(new JLabel("Age: "), gc);
	
	gc.gridx= 1;
	gc.anchor= GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0, 0, 0, 0);	
	add(ageList, gc);
	
	//Row 5
	gc.gridy++;

	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.2;
	
	gc.gridx=0;
	gc.insets = new Insets(0, 0, 0, 5);
	gc.anchor= GridBagConstraints.FIRST_LINE_END;
	add(new JLabel("Field: "), gc);
	
	gc.gridx=1;
	gc.anchor= GridBagConstraints.FIRST_LINE_START;
	add(empCombo, gc);
	
	//Row 6
	gc.gridy++;
	
	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.2;
	
	gc.gridx=0;
	gc.insets = new Insets(0, 0, 0, 5);
	gc.anchor= GridBagConstraints.FIRST_LINE_END;
	add(new JLabel("Indian Citizen: "), gc);
	
	gc.gridx= 1;
	gc.anchor= GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0, 0, 0, 0);	
	add(citizenCheck, gc);
	
	//Row 7
	gc.gridy++;
	
	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.2;
	
	gc.gridx=0;
	gc.insets = new Insets(0, 0, 0, 5);
	gc.anchor= GridBagConstraints.FIRST_LINE_END;
	add(taxLabel, gc);
	
	gc.gridx= 1;
	gc.anchor= GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0, 0, 0, 0);	
	add(taxField, gc);
	
	//Row 8  Male Radio button
	gc.gridy++;
		
	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.05;
	
	gc.gridx=0;
	gc.insets = new Insets(0, 0, 0, 5);
	gc.anchor= GridBagConstraints.LINE_END;
	add(new JLabel("Gender: "), gc);
		
	gc.gridx= 1;
	gc.anchor= GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0, 0, 0, 0);	
	add(maleRadio, gc);
		

	//Row 9  Female Radio button
	gc.gridy++;
			
	gc.weightx= 1; 	//size of cells
	gc.weighty= 0.2;
			
			
	gc.gridx= 1;
    gc.anchor= GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0, 0, 0, 0);	
	add(femaleRadio, gc);
	
		
	//Row 10
	gc.gridy++;
	
	gc.weightx= 1; 	//size of cells
	gc.weighty= 2;
	
	gc.gridx=1;
	gc.anchor= GridBagConstraints.FIRST_LINE_START;
	add(okBtn, gc);
}

public void setFormListener(FormListener listener) {
	this.formListener = listener;		
}

}

class AgeCatergory {
	private int id;
	private String text;
	public AgeCatergory(int id, String text) {
		this.id= id;
		this.text=text;
	}
	public String toString() {
		return text;
	}
	public int getId() {
		return id;
	}
}

package org.miernik.refreshtableview;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Person {

	private static int counter = 0;
	
	private final int id;
	private final SimpleStringProperty firstName;
	private final SimpleStringProperty lastName;
	private final SimpleIntegerProperty numberOfChanges;
	private final ChangeListener<String> listener = new ChangeListener<String>() {
		
		@Override
		public void changed(ObservableValue<? extends String> arg0, String arg1,
				String arg2) {
			if (arg1!=arg2)
				numberOfChanges.set(numberOfChanges.get()+1);
		}
	};

	public Person(String fName, String lName) {
		this.id = ++counter;
		this.firstName = new SimpleStringProperty(fName);
		this.firstName.addListener(listener);
		this.lastName = new SimpleStringProperty(lName);
		this.lastName.addListener(listener);
		this.numberOfChanges = new SimpleIntegerProperty(0);
	}

	public int getId() {
		return id;
	}
		
	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String fName) {
		firstName.set(fName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String fName) {
		lastName.set(fName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	public IntegerProperty numberOfChangesProperty() {
		return numberOfChanges;
	}
}

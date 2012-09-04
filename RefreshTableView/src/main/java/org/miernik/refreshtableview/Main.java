package org.miernik.refreshtableview;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Main implements Initializable {

	final ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("Jan", "Kowalski"), new Person("Kazimierz", "Latawiec"),
			new Person("Agnieszka", "Ziemiec"));

	@FXML
	private TableView<Person> tableView;
	@FXML
	private Button saveButton;
	@FXML
	private Button addButton;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tableView.setItems(data);
		tableView.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<Person>() {

					@Override
					public void changed(ObservableValue<? extends Person> arg0,
							Person arg1, Person arg2) {
						if (arg2 != null) {
							firstNameField.setText(arg2.getFirstName());
							lastNameField.setText(arg2.getLastName());
						} else {
							firstNameField.setText(null);
							lastNameField.setText(null);
						}
					}
				});
		saveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (!firstNameField.getText().isEmpty()
						&& !lastNameField.getText().isEmpty()) {
					Person p = tableView.getSelectionModel().getSelectedItem();
					if (p != null) {
						p.setFirstName(firstNameField.getText());
						p.setLastName(lastNameField.getText());
					}
				}
			}
		});
		addButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (!firstNameField.getText().isEmpty()
						&& !lastNameField.getText().isEmpty()) {
					Person p = new Person(firstNameField.getText(), lastNameField.getText());
					data.add(p);
					tableView.getSelectionModel().select(p);
				}
			}
		});
	}

}

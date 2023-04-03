package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {
	
	private Libretto model;
	
	
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button btnInserisci;

	    @FXML
	    private ComboBox<Integer> cmbVoti;

	    @FXML
	    private DatePicker txtData;

	    @FXML
	    private TextField txtNomeCorso;
	    
	    @FXML
	    private TextArea txtRisultato;

	    @FXML
	    void doInserisci(ActionEvent event) {
	    	
	    	String corso = this.txtNomeCorso.getText();
	    	Integer punti = this.cmbVoti.getValue();
	    	LocalDate data = this.txtData.getValue();
	    			
	    	Voto v = new Voto(corso, punti, data);
	    	this.model.add(v);
	    	
	    	this.txtRisultato.setText(this.model.toString());

	    }

	    @FXML
	    void initialize() {
	        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'main.fxml'.";
	        assert cmbVoti != null : "fx:id=\"cmbVoti\" was not injected: check your FXML file 'main.fxml'.";
	        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'main.fxml'.";
	        assert txtNomeCorso != null : "fx:id=\"txtNomeCorso\" was not injected: check your FXML file 'main.fxml'.";
	        
	        for(int p = 18; p < 31; p++) {
		    	cmbVoti.getItems().add(p);
		    }

	    }
	    
	    public void setModel(Libretto model) {
			this.model = model;
			this.txtRisultato.setText(this.model.toString());
		}

	}


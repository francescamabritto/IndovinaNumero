//package it.polito.tdp.indonumero;

//public class IndoNumeroController {
//	
//}


/**
 * Sample Skeleton for 'IndoNumero.fxml' Controller Class
 */

package it.polito.tdp.indonumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndoNumeroController {
	
	// inizializzazioni per il gioco
	/*
	private int NMAX = 100 ;
	private int TMAX = 7 ;  //num max tentativi
	
	private int segreto ;   // numero da indovinare
	private int tentativi ; //tentativi gia fatti
	
	private boolean inGame = false;
	
	*/
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuova"
    private Button btnNuova; // Value injected by FXMLLoader

    @FXML // fx:id="txtCurrent"
    private TextField txtCurrent; // Value injected by FXMLLoader

    @FXML // fx:id="txtMax"
    private TextField txtMax; // Value injected by FXMLLoader

    @FXML // fx:id="boxGioco"
    private HBox boxGioco; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativo"
    private TextField txtTentativo; // Value injected by FXMLLoader

    @FXML // fx:id="txtLog"
    private TextArea txtLog; // Value injected by FXMLLoader

    @FXML
    void handleNuova(ActionEvent event) {
    	
    		// implemento questo metodo:
    		// decido il numero segreto
    	/*
    		this.segreto = (int)(Math.random()*NMAX)+1 ;
    		
    		this.tentativi = 0 ;
    		this.inGame = true ;
    		
    		*/
    		this.model.newGame();
    		
    		// disabilito il bottone Nuova Partita
    		btnNuova.setDisable(true);
    		boxGioco.setDisable(false);
    		txtCurrent.setText(String.format("%d", model.getTentativi()));
    		txtMax.setText(String.format("%d", model.getTMAX()));
    		txtLog.clear();
    		txtTentativo.clear();
    		
    		txtLog.setText(String.format("Inserisci un numero da %d a %d \n", 1, model.getNMAX()));

    }

    @FXML
    void handleProva(ActionEvent event) {
    		
    		String numS = txtTentativo.getText() ;
    		
    		// se l'utente non inserisce nessun numero
    		if(numS.length()==0) {
    			txtLog.appendText("Devi inserire un numero\n");
    			return;
    		}
    		// se l'utente inserisce un numero
    		try {
    			//converto la stringa in intero:
    			int num = Integer.parseInt(numS) ;
    			//il numero era effettivamente un intero
    			
    			if (!model.valoreValido(num)) {
    				txtLog.appendText("Valore fuori dall'intervallo consentito\n");
    				return;
    			}
    			
    			
    			int risultato = model.tentativo(num);
    			
    			if (risultato==0)
    				txtLog.appendText("Hai vinto!");
    			else if(risultato>0)
    				txtLog.appendText("Troppo alto");
    			else if(risultato<0)
    				txtLog.appendText("Troppo basso");
    			
    			
    			if(!model.isInGame()) {
    				//la partita è finita
    				if(risultato!=0) {
    					txtLog.appendText("La partita è finita");
    					txtLog.appendText(String.format("Il numero segreto era: %d\n", model.getSegreto()));
    				}
    				
    				boxGioco.setDisable(true);
    				btnNuova.setDisable(false);
    				
    			}
    		
   	
    			
    		//da qui 
    			/*	
    			if(num==this.segreto()) {
    			
    				//ha indovinato
    				txtLog.appendText("Hai vinto!!\n");
    				// chiudi partita
    				boxGioco.setDisable(true);
    				btnNuova.setDisable(false);
    				this.model.setInGame(false);
    			}else {
    				//tentativo errato
    				this.model.setTentativi(model.getTentativi()+1);
    				txtCurrent.setText(String.format("%d",this.model.getTentativi()));
    				// se è l'ultimo hai perso
    				if(this.model.getTentativi()==model.getTMAX()) {
    					txtLog.appendText(String.format("Hai perso il numero era %d \n", this.model.getSegreto()));
    					boxGioco.setDisable(true);
        				btnNuova.setDisable(false);
    				}else {
    				//se non è l'ultimo puoi riprovare
    					if(num<model.getSegreto()) {
    						txtLog.appendText("Troppo basso\n");
    					}else {
    						txtLog.appendText("Troppo alto\n");
    					}
    				}
    			}
    			// il numero inserito era effettivamente un intero
    		// a qui	 
    			*/
    		} catch(NumberFormatException ex) {
    			txtLog.appendText("Il dato inserito non è numerico");
    			return ;
    		}
    		
    }
    
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtCurrent != null : "fx:id=\"txtCurrent\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtMax != null : "fx:id=\"txtMax\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert boxGioco != null : "fx:id=\"boxGioco\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtTentativo != null : "fx:id=\"txtTentativo\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'IndoNumero.fxml'.";

    }
    
    public Model getModel() {
    		return model;
    }
    
    public void setModel(Model model) {
    		this.model= model;
    		
    		/* dico a una proprietà dell interfaccia di collegarsi a 
    		   una proprietà del modello: */
    		// txtCurrent.textProperty().bind(model.tentativiProperty);
    }
}

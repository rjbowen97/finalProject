package rocket.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController implements Initializable {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//FOR EXCEPTIONS, the exceptions work and are thrown when appropriate, but
	//There is not a message that appears to the user
	
	@FXML
    private TextField txtIncome;
	
	@FXML
    private TextField txtExpenses;
	
	@FXML
    private TextField txtCreditScore;
	
	@FXML
    private TextField txtHouseCost;
	
	@FXML
    private ComboBox cmbLoanTerm;
	
	@FXML
    private Button btnCalculate;
	
	@FXML
    private TextField txtPayment;
	
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		
		double incomeValue = Double.parseDouble(txtIncome.getText());
		double expensesValue = Double.parseDouble(txtExpenses.getText());
		int creditScoreValue = Integer.parseInt(txtCreditScore.getText());
		int houseCostValue = Integer.parseInt(txtHouseCost.getText());
		//double comboBoxValue = (double) cmbLoanTerm.getValue();
		
		lq.setdIncome(incomeValue);
		System.out.print("INCOME VALUE: " + incomeValue);
		lq.setdExpenses(expensesValue);
		lq.setiCreditScore(creditScoreValue);
		lq.setdAmount(houseCostValue);
		lq.setiTerm(30); //manually set this because i cant get value from combo box
		

		
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		String paymentAsString = new Double(lRequest.getdPayment()).toString();
		txtPayment.setText(paymentAsString);
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cmbLoanTerm.getItems().addAll(
			    "15",
			    "30"
			);
		
	}
}

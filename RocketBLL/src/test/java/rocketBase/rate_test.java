package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	@Test
	public void knownCreditScoreTest() throws RateException
	{

		System.out.println("RATE " + RateBLL.getRate(650));
		assertTrue(RateBLL.getRate(650) == 4.5);
		
		System.out.println(RateBLL.getPayment(0.04/12, 360, 300000, 0, false));
		
		assertTrue(RateBLL.getPayment(RateBLL.getRate(700)/1200, 360, 300000, 0, false) == -1432.2458863963616);
		
	}
	
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test(expected = RateException.class)
	public void loanTests() throws RateException {		

		LoanRequest loanTestHighIncome = new LoanRequest();
		loanTestHighIncome.setdIncome(6000);
		loanTestHighIncome.setdExpenses(0);
		loanTestHighIncome.setdPayment(1500);
		assertTrue(RateBLL.incomeExpenseRule(loanTestHighIncome)== true);
		
		LoanRequest loanTestHighPayment = new LoanRequest();
		loanTestHighPayment.setdIncome(6000);
		loanTestHighPayment.setdExpenses(0);
		loanTestHighPayment.setdPayment(2000);
		try
		{
			RateBLL.incomeExpenseRule(loanTestHighPayment);
		}
		catch (RateException a)
		{
			System.out.println("Rate exception caught");
		}
		
		LoanRequest loanTestLowExpense = new LoanRequest();
		loanTestLowExpense.setdIncome(6000);
		loanTestLowExpense.setdExpenses(1000);
		loanTestLowExpense.setdPayment(1500);
		assertTrue(RateBLL.incomeExpenseRule(loanTestLowExpense)== true);
		
		LoanRequest loanTestHighExpense = new LoanRequest();
		loanTestHighExpense.setdIncome(6000);
		loanTestHighExpense.setdExpenses(2000);
		loanTestHighExpense.setdPayment(1500);
		try
		{
			RateBLL.incomeExpenseRule(loanTestHighExpense);
		}
		catch (RateException b)
		{
			System.out.println("Rate exception caught");
		}
	}

} //combo box

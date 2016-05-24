package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static boolean incomeExpenseRule(LoanRequest lrInput) throws RateException
	{
		boolean bReturn = false;
		
		System.out.println("VALUE OF PAYMENT: " + lrInput.getdPayment());
		
		if (lrInput.getdIncome() * 0.28 > lrInput.getdPayment()) //if 28% of income is lower than amount needed
		{
			if ((lrInput.getdIncome() - lrInput.getdExpenses()) * .36 > lrInput.getdPayment())
			{
				bReturn = true;
			}	
		}	
		
		if (bReturn == false)
		{
			throw new RateException(lrInput);
		}
		return bReturn;
	}
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate
		
		ArrayList<RateDomainModel> RDMlist = RateDAL.getAllRates();
		
		double iRate = 0;
		double minScore = 800;
		
		for(RateDomainModel a : RDMlist)
		{
			minScore = a.getiMinCreditScore();
		}
		
		for(RateDomainModel n : RDMlist)
		{
			if (GivenCreditScore <= n.getiMinCreditScore() & (GivenCreditScore > minScore)) 
			{
				iRate = n.getdInterestRate();
			}
		}
		
		if (iRate == 0)
		{
			LoanRequest lq = new LoanRequest();
			lq.setiCreditScore(GivenCreditScore);
			throw new RateException(lq);
			
		}
		return iRate;
		
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}

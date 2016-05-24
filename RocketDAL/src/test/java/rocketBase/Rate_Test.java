package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	@Test
	public void returnRateTest() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();

		System.out.println(rates.get(0).getiMinCreditScore());
		System.out.println(rates.get(1).getiMinCreditScore());
		System.out.println(rates.get(2).getiMinCreditScore());
		System.out.println(rates.get(3).getiMinCreditScore());
		System.out.println(rates.get(4).getiMinCreditScore());
		
		
		assertTrue(rates.get(0).getiMinCreditScore()==800);
		assertTrue(rates.get(1).getiMinCreditScore()==750);
		assertTrue(rates.get(2).getiMinCreditScore()==700);
		assertTrue(rates.get(3).getiMinCreditScore()==650);
		assertTrue(rates.get(4).getiMinCreditScore()==600);
		
		assertTrue(rates.get(0).getdInterestRate()==3.5);
		assertTrue(rates.get(1).getdInterestRate()==3.75);
		assertTrue(rates.get(2).getdInterestRate()==4.0);
		assertTrue(rates.get(3).getdInterestRate()==4.5);
		assertTrue(rates.get(4).getdInterestRate()==5.0);
		
		assert(rates.size() > 0);
	
	}
	
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
	}

}

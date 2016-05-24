package exceptions;

import rocketData.LoanRequest;

public class RateException extends Exception {

	private LoanRequest lq;

	public RateException(LoanRequest lq) {
		super();
		this.lq = lq;
		
	}

	public LoanRequest getLq() {
		return lq;
	}
	
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	
	
}

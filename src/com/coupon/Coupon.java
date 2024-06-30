package com.coupon;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Coupon class implementing the Delayed interface. 
 * 
 * Author: Aadarsh Patil
 */
public class Coupon implements Delayed {
	private String code; // Coupon code
	private long expirationTime; // Expiration time in milliseconds

	/**
	 * Constructor to initialize Coupon object.
	 * 
	 * @param code  Coupon code
	 * @param delay Time in milliseconds before the coupon expires
	 */
	public Coupon(String code, long delay) {
		this.code = code;
		// Set the expiration time by adding current time and delay
		this.expirationTime = System.currentTimeMillis() + delay;
	}

	/**
	 * Method to get the remaining delay for the coupon.
	 * 
	 * @param unit Time unit of the delay
	 * @return Remaining delay
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		long diff = expirationTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	/**
	 * Method to compare two Coupon objects based on their delay.
	 * 
	 * @param other The other Delayed object
	 * @return Comparison result
	 */
	@Override
	public int compareTo(Delayed other) {
		if (this.expirationTime < ((Coupon) other).expirationTime) {
			return -1;
		}
		if (this.expirationTime > ((Coupon) other).expirationTime) {
			return 1;
		}
		return 0;
	}

	/**
	 * Method to get the coupon code.
	 * 
	 * @return Coupon code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Method to get the expiration time.
	 * 
	 * @return Expiration time in milliseconds
	 */
	public long getExpirationTime() {
		return expirationTime;
	}
}

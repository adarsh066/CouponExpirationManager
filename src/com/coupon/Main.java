package com.coupon;

/**
 * Main class to test the CouponManager. 
 * 
 * Author: Aadarsh Patil
 */
public class Main {
	public static void main(String[] args) {
		// Create a CouponManager instance
		CouponManager manager = new CouponManager();

		// Add coupons with different expiration delays
		manager.addCoupon(new Coupon("SAVE10", 5000)); // Expires in 5 seconds
		manager.addCoupon(new Coupon("DISCOUNT20", 10000)); // Expires in 10 seconds
		manager.addCoupon(new Coupon("FREESHIP", 15000)); // Expires in 15 seconds

		// Start processing expired coupons
		manager.startProcessing();

		// Main thread sleeps for demonstration purposes
		try {
			Thread.sleep(20000); // Sleep for 20 seconds to allow processing of all coupons
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

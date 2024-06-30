package com.coupon;

import java.util.concurrent.DelayQueue;

/**
 * CouponManager class to manage the DelayQueue of coupons. 
 * 
 * Author: Aadarsh Patil
 */
public class CouponManager {
	private DelayQueue<Coupon> delayQueue;

	/**
	 * Constructor to initialize the CouponManager.
	 */
	public CouponManager() {
		// Initialize the DelayQueue
		delayQueue = new DelayQueue<>();
	}

	/**
	 * Method to add a coupon to the DelayQueue.
	 * 
	 * @param coupon The Coupon object to add
	 */
	public void addCoupon(Coupon coupon) {
		delayQueue.offer(coupon);
		System.out
				.println("Added coupon: " + coupon.getCode() + " with expiration time: " + coupon.getExpirationTime());
	}

	/**
	 * Method to start processing expired coupons.
	 */
	public void startProcessing() {
		Thread processor = new Thread(() -> {
			try {
				while (true) {
					// Take an expired coupon from the DelayQueue
					Coupon coupon = delayQueue.take();
					System.out.println("Processing expired coupon: " + coupon.getCode());
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.err.println("Coupon processing thread interrupted");
			}
		});
		processor.setDaemon(true);
		processor.start();
	}
}

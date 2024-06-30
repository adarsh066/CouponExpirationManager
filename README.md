# CouponExpirationManager

A Java project to manage expiring coupons using `DelayQueue`. The project includes a `Coupon` class that implements the `Delayed` interface and a `CouponManager` class to manage the `DelayQueue` and process expired coupons. Detailed line-by-line documentation is provided.

## Features

- **Coupon Class**: Implements the `Delayed` interface and stores coupon code and expiration time.
- **CouponManager Class**: Manages a `DelayQueue` of `Coupon` objects, adding coupons and processing expired ones in a separate thread.
- **Main Class**: Demonstrates the functionality by adding coupons with different expiration delays and starting the processing thread.

  

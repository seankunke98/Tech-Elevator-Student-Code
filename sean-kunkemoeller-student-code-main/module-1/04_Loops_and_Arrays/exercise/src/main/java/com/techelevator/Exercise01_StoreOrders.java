package com.techelevator;

public class Exercise01_StoreOrders {

    /*
    Sally's Pizza is bringing its pizza ordering system into the digital age
    to get better customer insights.

    They've encoded each of Sally's pizzas and other dishes as an integer:
	 * 10: small, cheese       20: medium, cheese       30: large, cheese
	 * 11: small, pepperoni    21: medium, pepperoni    31: large, pepperoni
	 * ---
	 * 40: calzone
	 * 41: spaghetti pie
	 * 42: baked ziti
     */

    // You can use these constants in your solutions.
    final int SMALL_CHEESE = 10;
    final int SMALL_PEPPERONI = 11;

    final int MEDIUM_CHEESE = 20;
    final int MEDIUM_PEPPERONI = 21;

    final int LARGE_CHEESE = 30;
    final int LARGE_PEPPERONI = 31;

    final int CALZONE = 40;
    final int SPAGHETTI_PIE = 41;
    final int BAKED_ZITI = 42;

    /*
    Each customer order, consisting of one or more pizzas, is represented as an array
    where each value represents an item in that order.

    Create an "order" that contains the following items:
	 * - small, cheese (SMALL_CHEESE)
	 * - calzone (CALZONE)
	 * - large, pepperoni (LARGE_PEPPERONI)
	 * - spaghetti pie (SPAGHETTI_PIE)

	 Examples:
	 createOrder() → [10, 40, 31, 41]
     */
    public int[] createOrder() {
        int[] order = new int[]{SMALL_CHEESE, CALZONE, LARGE_PEPPERONI, SPAGHETTI_PIE};
        return order;
    }

    /*
    Sally realized that she needed to know how many calzones her shop sells per day.

    Implement the logic to count the number of calzones sold per day when given an
    array representing each item that her customers ordered that day.

    Examples:
    getCalzoneSales([40, 30, 31, 40, 10]) → 2
    getCalzoneSales([30, 31, 10]) → 0
    getCalzoneSales([]) → 0
     */
    public int getCalzoneSales(int[] orders) {
        int calzoneCount = 0;

        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == CALZONE) {
                calzoneCount += 1;
            }

        }
        return calzoneCount;
    }

    /*
    Sally also needs to know the total revenue for all cheese pizzas sold on any given day.
        * Each small cheese pizza costs $8.
        * Each medium cheese pizza costs $11.
        * Each large cheese pizza costs $14.

    Implement the logic to return the total revenue of all cheese pizzas when given
    an array representing each item that her customers ordered that day.

    Examples:
    getCheesePizzaRevenue([10]) → 8
    getCheesePizzaRevenue([10, 11, 20]) → 19
    getCheesePizzaRevenue([11, 21]) → 0
     */
    public int getCheesePizzaRevenue(int[] orders) {

        int totalCheeseRevenue = 0;
        int smallCheeseRevenue = 0;
        int mediumCheeseRevenue = 0;
        int largeCheeseRevenue = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == SMALL_CHEESE || orders[i] == MEDIUM_CHEESE || orders[i] == LARGE_CHEESE) {
                smallCheeseRevenue += 8;
                mediumCheeseRevenue += 11;
                largeCheeseRevenue += 14;
            }
        }

        return totalCheeseRevenue = smallCheeseRevenue + mediumCheeseRevenue + largeCheeseRevenue;
    }

}
package v_collections

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    return customers.maxBy { it.orders.count() }
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    return orders.flatMap { it.products } maxBy { it.price }
}

package v_collections

fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> {
    return customers.sortBy { it.orders.count() }
}

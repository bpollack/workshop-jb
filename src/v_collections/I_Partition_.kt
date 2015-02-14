package v_collections

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    return customers.filter { it.orders.count { it.isDelivered } < it.orders.count { !it.isDelivered }}.toSet()
}

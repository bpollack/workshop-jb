package v_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    return customers.filter { product in it.orderedProducts }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap { it.orders }.flatMap { it.products }.count { it == product }
}

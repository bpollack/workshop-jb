package v_collections

fun Customer.getTotalOrderPrice(): Double {
    return orders.flatMap { it.products }.map { it.price }.sum()
}

package v_collections

fun Shop.groupCustomersByCity(): Map<City, List<Customer>> {
    return customers.groupBy { it.city }
}

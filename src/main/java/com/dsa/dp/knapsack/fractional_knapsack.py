def fractional_knapsack(values, weights, capacity):
    items = list(zip(values, weights))
    items.sort(key=lambda x:x[0] / x[1], reverse=True)

    max_cost = 0

    for value, weight in items:
        if weight <= capacity:
            capacity -= weight
            max_cost += value

        else:
            max_cost += (value / weight) * capacity
            break

    return max_cost

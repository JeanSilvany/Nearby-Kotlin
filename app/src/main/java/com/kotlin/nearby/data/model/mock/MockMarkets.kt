package com.kotlin.nearby.data.model.mock

import com.kotlin.nearby.data.model.Market
import com.kotlin.nearby.data.model.Rule

val mockMarkets = listOf<Market>(
    Market(
        id = "1",
        categoryId = "1",
        name = "Supermercado",
        description = "Churrascaria e Lanchonete do João da Silva com cortes nobres e buffet variado. Experiência completa para você e sua família.",
        coupons = 10,
        rules = emptyList<Rule>(),
        latitude = -23.5505199,
        longitude = -46.6333094,
        address = "Rua do João, 123",
        phone = "(11) 99999-9999",
        cover = "https://via.placeholder.com/150"
    ),
    Market(
        id = "2",
        categoryId = "2",
        name = "Cinema",
        description = "Churrascaria e Lanchonete do João da Silva com cortes nobres e buffet variado. Experiência completa para você e sua família.",
        coupons = 10,
        rules = emptyList<Rule>(),
        latitude = -23.5505199,
        longitude = -46.6333094,
        address = "Rua do João, 123",
        phone = "(11) 99999-9999",
        cover = "https://via.placeholder.com/150"
    ),
)
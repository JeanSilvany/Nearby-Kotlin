package com.kotlin.nearby.data.model.mock

import com.kotlin.nearby.data.model.Rule

val mockRules = listOf<Rule>(
    Rule(
        id = "1",
        description = "Disponível até 31/12/2024",
        marketId = "2"
    ),
    Rule(
        id = "2",
        description = "Válido apenas para consumo no local",
        marketId = "2"
    ),
)
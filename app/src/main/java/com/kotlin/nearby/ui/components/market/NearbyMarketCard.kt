package com.kotlin.nearby.ui.components.market

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlin.nearby.R
import com.kotlin.nearby.data.model.Market
import com.kotlin.nearby.data.model.Rule
import com.kotlin.nearby.ui.theme.Gray100
import com.kotlin.nearby.ui.theme.Gray200
import com.kotlin.nearby.ui.theme.Gray400
import com.kotlin.nearby.ui.theme.Gray500
import com.kotlin.nearby.ui.theme.RedBase
import com.kotlin.nearby.ui.theme.Typography

@Composable
fun NearbyMarketCard(
    modifier: Modifier = Modifier, market: Market, onClick: (Market) -> Unit
) {
    Card(modifier = modifier
        .clip(RoundedCornerShape(12.dp))
        .background(Gray100)
        .border(
            width = 1.dp, color = Gray200, shape = RoundedCornerShape(12.dp)
        ), onClick = {
        onClick(market)
    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth(0.3f)
                    .height(IntrinsicSize.Min)
                    .aspectRatio(1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.img_burger), // TODO: Switch to market.cover
                contentDescription = "Imagem do Estabelecimento"

            )

            Column {
                Text(text = market.name, style = Typography.headlineSmall.copy(fontSize = 14.sp))
                Spacer(
                    modifier = Modifier.height(9.dp)
                )
                Text(
                    text = market.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Gray500,
                    style = Typography.headlineSmall.copy(fontSize = 12.sp)
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Icon(
                        modifier = Modifier.size(24.dp),
                        tint = if (market.coupons > 0) RedBase else Gray400,
                        painter = painterResource(R.drawable.ic_ticket),
                        contentDescription = "Ícone de Cupom"
                    )

                    Text(
                        text = "${market.coupons} cupons disponíveis",
                        color = Gray400,
                        style = Typography.bodyMedium.copy(fontSize = 12.sp),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NearbyMarketCardPreview() {
    NearbyMarketCard(modifier = Modifier.fillMaxWidth(), market = Market(
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
    ), onClick = {})
}

@Preview
@Composable
private fun NearbyMarketCardNoCouponsPreview() {
    NearbyMarketCard(modifier = Modifier.fillMaxWidth(), market = Market(
        id = "1",
        categoryId = "1",
        name = "Supermercado",
        description = "Churrascaria e Lanchonete do João da Silva com cortes nobres e buffet variado. Experiência completa para você e sua família.",
        coupons = 0,
        rules = emptyList<Rule>(),
        latitude = -23.5505199,
        longitude = -46.6333094,
        address = "Rua do João, 123",
        phone = "(11) 99999-9999",
        cover = "https://via.placeholder.com/150"
    ), onClick = {})
}
package fr.lucasgarcia.f1dex.display.api

import fr.lucasgarcia.f1dex.models.Ranking

data class RankingResponse (
    val results: Int,
    val response: List<Ranking>)
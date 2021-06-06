package fr.lucasgarcia.f1dex.display.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface RankingApi{
    @GET("/rankings/drivers")
    fun getRankList(
        //integration de la clé dans le cadre d'une API privée (payante)
        @Header("x-rapidapi-host") xRapidApiHost: String,
        @Header("x-rapidapi-Key") xRapidApiKey: String,
        //trie par saison
        @Query("season")sort:String
    ): Call<RankingResponse>
}
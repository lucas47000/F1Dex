package fr.lucasgarcia.f1dex.models

data class Ranking (
    val position: Int,
    val driver: Driver,
    val team: Team,
    val points: Int,
    val wins: Int,
    val behind: Int,
    val season: Int
)

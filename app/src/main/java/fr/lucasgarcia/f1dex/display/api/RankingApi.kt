package fr.lucasgarcia.f1dex.display.api


import jdk.nashorn.internal.runtime.PropertyDescriptor.GET


interface GitHubService {
    @GET("drivers)
    fun getDriversList(): Call<List<Repo>>
}
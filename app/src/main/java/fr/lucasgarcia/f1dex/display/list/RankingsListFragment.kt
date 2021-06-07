package fr.lucasgarcia.f1dex.display.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import fr.lucasgarcia.f1dex.R
import fr.lucasgarcia.f1dex.models.Ranking
import fr.lucasgarcia.f1dex.display.api.RankingApi
import fr.lucasgarcia.f1dex.display.api.RankingResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RankingsListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val adapter = RankingsAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rankings_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.rankings_recyclerview)
        recyclerView.apply {
            layoutManager = this@RankingsListFragment.layoutManager
            adapter=this@RankingsListFragment.adapter
        }


        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
        var httpClient = OkHttpClient.Builder()

        val rankingApi = Retrofit.Builder()
            .baseUrl("https://api-formula-1.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
            .create(RankingApi::class.java)


        rankingApi.getRankList("api-formula-1.p.rapidapi.com","2d4819f0e0msh39d5073aa6d6a99p13d476jsn31e18b3821d2", "2021").enqueue(object : Callback<RankingResponse>{
            override fun onFailure(call: Call<RankingResponse>, t: Throwable) {
                val RankingsList : List<Ranking> = arrayListOf<Ranking>().apply {
                    //add(1, Driver(1,"lewis hamilton","CECI EST UNE IMAGE"), Team(1,"Mercedes","CECI EST UNE IMAGE DU LOGO"),1,2,3,4)
                }

                adapter.updateList(RankingsList)
            }

            override fun onResponse(call: Call<RankingResponse>, response: Response<RankingResponse>)
            {
                if(response.body() != null){
                    val rankingResponse : RankingResponse? = response.body()!!
                    if (rankingResponse != null) {
                        adapter.updateList(rankingResponse.response.toList())
                    }
                }
            }
        })
    }



}
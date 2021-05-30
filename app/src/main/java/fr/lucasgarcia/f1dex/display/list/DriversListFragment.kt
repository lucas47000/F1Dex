package fr.lucasgarcia.f1dex.display.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.lucasgarcia.f1dex.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DriversListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val adapter = DriversAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drivers_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.drivers_recyclerview)
        recyclerView.apply {
            layoutManager = layoutManager
            adapter=adapter
        }

        val driversList = arrayListOf<String>().apply {
            add("Kimi Raikkonen")
            add("Antonio Giovinazzi")
            add("Pierre Gasly")
            add("Yuki Tsunoda")
            add("Esteban Ocon")
            add("Fernando Alonso")
            add("Sebastian Vettel")
            add("Lance Stroll")
            add("Charles Leclerc")
            add("Carlos Sainz")
            add("Nikita Mazepin")
            add("Mick Schumacher")
            add("Daniel Ricciardo")
            add("Lando Norris")
            add("Lewis Hamilton")
            add("Valtteri Bottas")
            add("Max Verstappen")
            add("Sergio Perez")
            add("George Russell")
            add("Nicholas Latifi")
        }
    }
}
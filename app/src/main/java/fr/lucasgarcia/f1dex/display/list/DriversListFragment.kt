package fr.lucasgarcia.f1dex.display.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.lucasgarcia.f1dex.Driver
import fr.lucasgarcia.f1dex.R
import kotlin.collections.ArrayList

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
            layoutManager = this@DriversListFragment.layoutManager
            adapter=this@DriversListFragment.adapter
        }

        val driversList : ArrayList<Driver> = arrayListOf<Driver>().apply {
            add(Driver(id =1, firstName = "Kimi", lastName = "Raikkonen", birthDate = "" , nationality = ""))
            add(Driver(id =2, firstName = "Antonio", lastName = "Giovinazzi", birthDate ="" , nationality = ""))
            add(Driver(id =3, firstName = "Pierre", lastName = "Gasly", birthDate = "", nationality = ""))
            add(Driver(id =4, firstName = "Yuki", lastName = "Tsunoda", birthDate ="" , nationality = ""))
            add(Driver(id =5, firstName = "Esteban", lastName = "Ocon", birthDate ="" , nationality = ""))
            add(Driver(id =6, firstName = "Fernando", lastName = "Alonso", birthDate ="" , nationality = ""))
            add(Driver(id =7, firstName = "Sebastian", lastName = "Vettel", birthDate ="" , nationality = ""))
            add(Driver(id =8, firstName = "Lance", lastName = "Stroll", birthDate ="" , nationality = ""))
            add(Driver(id =9, firstName = "Charles", lastName = "Leclerc", birthDate ="" , nationality = ""))
            add(Driver(id =10, firstName = "Carlos", lastName = "Sainz", birthDate ="" , nationality = ""))
            add(Driver(id =11, firstName = "Nikita", lastName = "Mazepin", birthDate ="" , nationality = ""))
            add(Driver(id =12, firstName = "Mick", lastName = "Schumacher", birthDate ="" , nationality = ""))
            add(Driver(id =13, firstName = "Daniel", lastName = "Ricciardo", birthDate ="", nationality = ""))
            add(Driver(id =14, firstName = "Lando", lastName = "Norris", birthDate ="" , nationality = ""))
            add(Driver(id =15, firstName = "Lewis", lastName = "Hamilton", birthDate ="" , nationality = ""))
            add(Driver(id =16, firstName = "Valtteri", lastName = "Bottas", birthDate = "", nationality = ""))
            add(Driver(id =17, firstName = "Max", lastName = "Verstappen", birthDate ="" , nationality = ""))
            add(Driver(id =18, firstName = "Sergio", lastName = "Perez", birthDate ="" , nationality = ""))
            add(Driver(id =19, firstName = "George", lastName = "Russell", birthDate ="" , nationality = ""))
            add(Driver(id =20, firstName = "Nicholas", lastName = "Latifi", birthDate ="" , nationality = ""))
        }

        adapter.updateList(driversList)

    }
}
package fr.lucasgarcia.f1dex.display.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.lucasgarcia.f1dex.R
import fr.lucasgarcia.f1dex.models.Ranking


class RankingsAdapter(private var dataSet: List<Ranking>) :
    RecyclerView.Adapter<RankingsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.driver_name)
        }
    }

    fun updateList(list: List<Ranking>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.driver_element, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val ranking : Ranking = dataSet[position]
        viewHolder.textView.text =
                ranking.position.toString() + "." + ranking.driver.name +
                " (" + ranking.points.toString() + ".pts)/ " +
                ranking.team.name + System.getProperty("line.separator") +
                ranking.driver.image
//               ranking.points.toString() + "Pts" + System.getProperty("line.separator") +
//              "Wins : " + ranking.wins.toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.sevilla.japdictionnary.R
import com.sevilla.japdictionnary.domain.entity.Kanji

class RecyclerViewAdapter(private val dataSet: LiveData<ArrayList<Kanji>>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {



    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val kanji_textView: TextView
        val reading_textView: TextView
        val meaning_textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            kanji_textView = view.findViewById(R.id.kanji_text_view)
            meaning_textView = view.findViewById(R.id.meaning_text_view)
            reading_textView = view.findViewById(R.id.reading_text_view)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.kanji_textView.text = dataSet.value!![position].slug
        viewHolder.reading_textView.text = dataSet.value!![position].japanese[0].reading
        viewHolder.meaning_textView.text = dataSet.value!![position].senses[0].english_definitions[0]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int = dataSet.value!!.size

}
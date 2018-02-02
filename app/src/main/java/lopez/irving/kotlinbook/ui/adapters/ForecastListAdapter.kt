package lopez.irving.kotlinbook.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import lopez.irving.kotlinbook.domain.model.ForecastList

/**
 *
 * @author irving.lopez
 * @since 11/01/2018.
 */
class ForecastListAdapter(private val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int {
        return weekForecast.size
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
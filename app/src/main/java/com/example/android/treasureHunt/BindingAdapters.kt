package com.example.android.treasureHunt

import android.widget.TextView
import androidx.databinding.BindingAdapter
import timber.log.Timber

@BindingAdapter("hintText")
fun bindTextViewToHintText(textView: TextView, index: Int?) {
    val context = textView.context
    if (index==null){
        textView.text = ""
        return
    }
    val geofenceHintResourceId = when {
        index < 0 -> R.string.not_started_hint
        index < GeofencingConstants.NUM_LANDMARKS -> GeofencingConstants.LANDMARK_DATA[index].hint
        else -> R.string.geofence_over
    }
    Timber.i("hint: ${context.getString(geofenceHintResourceId)} - index: $index")
    textView.text = context.getString(geofenceHintResourceId)
}
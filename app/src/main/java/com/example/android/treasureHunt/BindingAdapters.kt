package com.example.android.treasureHunt

import android.widget.ImageView
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


@BindingAdapter("hintImage")
fun bindImageViewToHintImage(imageView: ImageView, index: Int?) {
    if (index==null){
        imageView.setImageResource(R.drawable.android_map)
        return
    }
    val geofenceImageResourceId = when {
        index < GeofencingConstants.NUM_LANDMARKS -> R.drawable.android_map
        else -> R.drawable.android_treasure
    }
    Timber.i("hint-imgResourceId: $geofenceImageResourceId - img-index: $index")
    imageView.setImageResource(geofenceImageResourceId)
}
package com.rim.tramforecast.data

import android.databinding.BindingAdapter
import android.databinding.BindingMethod
import android.databinding.BindingMethods
import android.support.v4.widget.SwipeRefreshLayout

//import androidx.databinding.BindingAdapter
//import androidx.databinding.BindingMethod
//import androidx.databinding.BindingMethods
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


//import androidx.databinding.BindingAdapter
//import androidx.databinding.BindingMethod
//import androidx.databinding.BindingMethods
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingMethods(
    BindingMethod(
        type = SwipeRefreshLayout::class,
        attribute = "android:onRefresh",
        method = "setOnRefreshListener"
    )
)
object SwipeRefreshLayoutBindings {

    @BindingAdapter("refreshing")
    @JvmStatic
    fun setRefreshing(v: SwipeRefreshLayout, refreshing: Boolean) {
        // If we invoke setRefreshing(true) while the SwipeRefreshLayout isn't added to the root view,
        // its progress indicator won't be shown up. In order to deal with that, we schedule the first
        // call of setRefreshing() until it's added to the root view via this post().
        v.post { v.isRefreshing = refreshing }
    }
}

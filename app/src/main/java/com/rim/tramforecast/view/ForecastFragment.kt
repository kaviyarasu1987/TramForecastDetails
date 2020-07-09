package com.rim.tramforecast.view

import android.content.Context
import android.net.Uri
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.rim.tramforecast.BR
import com.rim.tramforecast.R


import com.rim.tramforecast.data.ForecastViewModel
import com.rim.tramforecast.data.TramDetails
import com.rim.tramforecast.databinding.ForecastListBinding
import dagger.android.support.DaggerFragment
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.LayoutManagers

import javax.inject.Inject
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder

import android.widget.Button


class ForecastFragment : DaggerFragment1() {
    // TODO: Rename and change types of parameters

    @Inject
    lateinit var viewModel: ForecastViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadForecast()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = ForecastListBinding.inflate(inflater)
        binding.swipeRefreshLayout.isEnabled = false
        binding.tramView.layoutManager = LayoutManagers
            .grid(resources.getInteger(R.integer.galleryColumns))
            .create(binding.tramView)
       // addDividers(binding.photosView)
        setAnimationForRefresh(binding.refresh)
        binding.tramItemBinding = ItemBinding.of<TramDetails>(BR.viewModel, R.layout.forecast_item)
        binding.viewModel = viewModel

        return binding.root
    }



    override fun onDestroy() {
        viewModel.onCleared()
        super.onDestroy()
    }

    fun setAnimationForRefresh(view: Button)
    {
        //
        val scaleDown = ObjectAnimator.ofPropertyValuesHolder(
            view,
            PropertyValuesHolder.ofFloat("scaleX", 1.2f),
            PropertyValuesHolder.ofFloat("scaleY", 1.2f)
        )
        scaleDown.duration = 410

        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.REVERSE

        scaleDown.start()

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */



}

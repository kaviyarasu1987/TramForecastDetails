package com.rim.tramforecast.view


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
//import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class DaggerFragment1 : Fragment(), HasSupportFragmentInjector {
  @Inject lateinit var injector: DispatchingAndroidInjector<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun supportFragmentInjector(): AndroidInjector<Fragment> = this.injector


}

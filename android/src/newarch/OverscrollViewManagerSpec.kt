package com.overscroll

import android.view.ViewGroup
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.viewmanagers.OverscrollViewManagerDelegate
import com.facebook.react.viewmanagers.OverscrollViewManagerInterface

abstract class OverscrollViewManagerSpec<T : ViewGroup> : ViewGroupManager<T>(), OverscrollViewManagerInterface<T> {
  private val mDelegate: ViewManagerDelegate<T>

  init {
    mDelegate = OverscrollViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<T>? {
    return mDelegate
  }
}

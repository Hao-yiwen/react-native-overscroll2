package com.overscroll

import android.view.ViewGroup
import com.facebook.react.uimanager.ViewGroupManager

abstract class OverscrollViewManagerSpec<T : ViewGroup> : ViewGroupManager<T>() {
  abstract fun setBounce(view: T?, value: Boolean)
}

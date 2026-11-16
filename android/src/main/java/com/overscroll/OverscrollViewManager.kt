package com.overscroll

import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.overscroll.events.OnOverScrollEvent

@ReactModule(name = OverscrollViewManager.NAME)
class OverscrollViewManager :
  OverscrollViewManagerSpec<OverscrollView>() {
  override fun getName(): String {
    return NAME
  }

  @ReactProp(name = "bounce")
  override fun setBounce(view: OverscrollView?, value: Boolean) {
    view?.setBounce(value)
  }

  public override fun createViewInstance(context: ThemedReactContext): OverscrollView {
    return OverscrollView(context)
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any>? {
    return mutableMapOf(
      OnOverScrollEvent.EVENT_NAME to
        mapOf("registrationName" to "onOverscroll")
    )
  }

  companion object {
    const val NAME = "OverscrollView"
  }
}

package com.overscroll.events

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTEventEmitter

class OnOverScrollEvent(
  surfaceId: Int,
  viewId: Int,
  private val state: Int,
  private val offset: Float
) :
  Event<OnOverScrollEvent>(surfaceId, viewId) {
  companion object {
    const val EVENT_NAME = "onOverscroll"
  }

  override fun getEventName(): String {
    return EVENT_NAME
  }

  private fun serializeEventData(): WritableMap {
    val eventData = Arguments.createMap()
    eventData.putInt("state", state)
    eventData.putDouble("offset", offset.toDouble())
    return eventData
  }

  override fun getEventData(): WritableMap? {
    return serializeEventData()
  }
}

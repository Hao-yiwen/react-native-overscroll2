package com.overscroll

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.ListView
import android.widget.ScrollView
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.uimanager.UIManagerModule
import com.overscroll.events.OnOverScrollEvent
import me.everything.android.ui.overscroll.IOverScrollDecor
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class OverscrollView : FrameLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context, attrs, defStyleAttr
  )

  var mBounce = false

  fun getThemeReactContext(): ThemedReactContext {
    return this.context as ThemedReactContext
  }

  override fun addView(child: View?, index: Int) {
    if (childCount > 0) {
      throw IllegalStateException("OverscrollView can only host one direct child")
    }
    super.addView(child, index)

    if (mBounce) {
      setUpOverScroll(child)
    }
  }

  fun setBounce(bounce: Boolean) {
    mBounce = bounce
    if (mBounce) {
      setUpOverScroll(getChildAt(0))
    }
  }

  private fun setUpOverScroll(child: View?) {
    if (child != null) {
      var decor: IOverScrollDecor? = null;
      if (child is ScrollView) {
        decor = OverScrollDecoratorHelper.setUpOverScroll(child as ScrollView);
      } else if (child is HorizontalScrollView) {
        decor = OverScrollDecoratorHelper.setUpOverScroll(child as HorizontalScrollView);
      } else if (child is ListView) {
        decor = OverScrollDecoratorHelper.setUpOverScroll(child as ListView?)
      } else {
        decor = OverScrollDecoratorHelper.setUpStaticOverScroll(
          child,
          OverScrollDecoratorHelper.ORIENTATION_VERTICAL
        )
      }

      decor?.setOverScrollUpdateListener { _, state, offset ->
        sendOverScrollEvent(
          state,
          offset
        )
      }
    }
  }

  private fun sendOverScrollEvent(state: Int, offset: Float) {
    Log.d("OverscrollView", "sendOverScrollEvent: $state, $offset")
    val mContext = getThemeReactContext()
    val dispatcher = UIManagerHelper.getEventDispatcherForReactTag(mContext, id)
    val surfaceId: Int = UIManagerHelper.getSurfaceId(this)
    dispatcher?.dispatchEvent(OnOverScrollEvent(surfaceId, id, state, offset))
  }
}

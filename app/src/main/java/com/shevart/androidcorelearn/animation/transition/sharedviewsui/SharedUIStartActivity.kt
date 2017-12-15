package com.shevart.androidcorelearn.animation.transition.sharedviewsui

import android.os.Bundle
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity

class SharedUIStartActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_uistart)
        enableToolbarBackButton()
    }
}
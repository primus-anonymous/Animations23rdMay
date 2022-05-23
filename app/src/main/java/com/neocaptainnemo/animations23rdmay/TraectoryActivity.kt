package com.neocaptainnemo.animations23rdmay

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updateLayoutParams
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager

class TraectoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traectory)

        var isMoved = false

        val root: FrameLayout = findViewById(R.id.root)
        val animate: Button = findViewById(R.id.animate)

        animate.setOnClickListener {

            isMoved = isMoved.not()

            ChangeBounds()
                .apply {
                    setPathMotion(ArcMotion().apply {
                        this.maximumAngle = 90.0f
                    })
                    duration = 2000L
                }
                .also {
                    TransitionManager.beginDelayedTransition(root, it)
                }

            animate.updateLayoutParams<FrameLayout.LayoutParams> {
                gravity =
                    if (isMoved) Gravity.END or Gravity.BOTTOM else Gravity.TOP or Gravity.START
            }
        }

    }
}
package com.epam.airportlayouts

import android.os.Bundle
import android.os.PersistableBundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.constraint_fragment.*

/**
 * An [AppCompatActivity] which holds two fragments
 * [ConstraintFragment] which uses [ConstraintLayout] as base layout
 * and [NonConstraintFragment] which uses any layouts as opposite to [ConstraintFragment]
 *
 * @author Vlad Korotkevich
 */

class MainActivity : AppCompatActivity() {

    private val departFlight by lazy { departFlight() }
    private val returnFlight by lazy { returnFlight() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constraintButton.setOnClickListener {
            initConstraintButton()
        }

        nonConstraintButton.setOnClickListener {
            initNonConstraintFragment()
        }

        if (savedInstanceState == null) {
            initConstraintButton()
        }
    }

    private fun initConstraintButton() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.itemsScrollView, ConstraintFragment.newInstance(departFlight, returnFlight))
            .commit()
    }

    private fun initNonConstraintFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.itemsScrollView, NonConstraintFragment.newInstance(departFlight, returnFlight))
            .commit()
    }
}

package com.epam.airportlayouts

import android.content.res.Configuration.*
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * An [AppCompatActivity] which holds two fragments
 * [ConstraintFragment] which uses [ConstraintLayout] as base layout
 * and [NonConstraintFragment] which uses any layouts as opposite to [ConstraintFragment]
 *
 * @author Vlad Korotkevich
 */

class MainActivity : AppCompatActivity(), NightThemeChangeListener {

    override fun onThemeChange() {
        when(resources.configuration.uiMode and UI_MODE_NIGHT_MASK) {
            UI_MODE_NIGHT_YES, UI_MODE_NIGHT_UNDEFINED -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Toast.makeText(this, getString(R.string.changed_to_light), Toast.LENGTH_SHORT).show()
            }
            UI_MODE_NIGHT_NO -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                Toast.makeText(this, getString(R.string.changed_to_night), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val departFlight by lazy { departFlight() }
    private val returnFlight by lazy { returnFlight() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
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

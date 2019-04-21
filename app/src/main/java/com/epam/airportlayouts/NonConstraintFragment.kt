package com.epam.airportlayouts

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.nonconstraint_layout.*

/**
 * A [Fragment] which uses any layouts as opposite to [ConstraintFragment]
 *
 * @author Vlad Korotkevich
 */

class NonConstraintFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.nonconstraint_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDepartInformation()
        initReturnInformation()

        fab.setOnClickListener {
            initFloatingActionButton()
        }
    }

    private fun initDepartInformation() {
        arguments?.getParcelable<Flight>(DEPART_DATA)?.apply {
            departStatus.text = status
            departDate.text = date
            departSeatsNumber.text = seatsAmount.toString()
            departCost.text = cost.toString()
            departCurrency.text = currency
            departFrom.text = fromPoint
            departTo.text = toPoint
            departTakeOffTime.text = takeOffTime
            departLandTime.text = landTime
            departDuration.text = duration
        }
    }

    private fun initReturnInformation() {
        arguments?.getParcelable<Flight>(RETURN_DATA)?.apply {
            returnStatus.text = status
            returnDate.text = date
            returnSeatsNumber.text = seatsAmount.toString()
            returnCost.text = cost.toString()
            returnCurrency.text = currency
            returnFrom.text = fromPoint
            returnTo.text = toPoint
            returnTakeOffTime.text = takeOffTime
            returnLandTime.text = landTime
            returnDuration.text = duration
        }
    }

    private fun initFloatingActionButton() {
        Toast.makeText(context, getString(R.string.confirmedText), Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val DEPART_DATA = "DEPART_DATA"
        private const val RETURN_DATA = "RETURN_DATA"

        fun newInstance(
            departFlight: Flight,
            returnFlight: Flight
        ) = NonConstraintFragment().apply {
            arguments = Bundle().apply {
                putParcelable(DEPART_DATA, departFlight)
                putParcelable(RETURN_DATA, returnFlight)
            }
        }
    }
}

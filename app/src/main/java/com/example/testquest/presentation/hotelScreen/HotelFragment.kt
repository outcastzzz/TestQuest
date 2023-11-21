package com.example.testquest.presentation.hotelScreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testquest.R
import com.example.testquest.databinding.FragmentHotelBinding
import com.example.testquest.presentation.HotelApp
import com.example.testquest.presentation.ViewModelFactory
import com.example.testquest.presentation.roomsScreen.RoomItemAdapter
import javax.inject.Inject

class HotelFragment: Fragment() {

    private lateinit var viewModel: HotelViewModel

    private val component by lazy {
        (requireActivity().application as HotelApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentHotelBinding? = null
    private val binding: FragmentHotelBinding
        get() = _binding ?: throw RuntimeException("FragmentHotelBinding == null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[HotelViewModel::class.java]
        viewModel.getHotelInfo().observe(viewLifecycleOwner) {
            with(binding) {
                hotelPlace.text = it.address
                minPrice.text = it.minimalPrice.toString()
                priceForIt.text = it.priceForIt
                rating.text = it.rating.toString()
                ratingTitle.text = it.ratingName
                it.aboutHotel.description.let {
                    hotelDescription.text = it
                }
                it.aboutHotel.peculiarities.let {
                    line.text = it[1]
                    wiFi.text = it[0]
                    airportDistance.text = it[3]
                    beachDistance.text = it[2]
                }
            }
        }
        binding.buttonNextScreen.setOnClickListener {
            launchRoomsFragment()
        }
    }

    private fun launchRoomsFragment() {
        findNavController().navigate(R.id.action_hotelFragment_to_roomsFragment)
    }
}
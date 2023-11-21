package com.example.testquest.presentation.bookingScreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testquest.databinding.FragmentBookingBinding
import com.example.testquest.presentation.HotelApp
import com.example.testquest.presentation.ViewModelFactory
import javax.inject.Inject

class BookingFragment : Fragment() {

    private lateinit var viewModel: BookingViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as HotelApp).component
    }

    private var _binding: FragmentBookingBinding? = null
    private val binding: FragmentBookingBinding
        get() = _binding ?: throw RuntimeException("FragmentBookingBinding == null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val a = 1
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
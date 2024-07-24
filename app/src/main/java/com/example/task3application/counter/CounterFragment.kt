package com.example.task3application.counter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.task3application.databinding.FragmentCounterBinding
import com.example.task3application.extensions.observe

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!
    private var countNumber = 0
    private var checkSwitch = false
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
        setObserver()
    }

    private fun setListeners() {
        with(binding) {
            bCounter.setOnClickListener {
                increaseCounter()
            }
            sViewModel.setOnCheckedChangeListener { _, switch ->
                checkSwitch = switch
            }
        }
    }

    private fun increaseCounter() {
        if (checkSwitch) {
            viewModel.incrementCount()
        } else {
            countNumber++
            binding.tvCount.text = countNumber.toString()
        }
    }

    private fun setObserver() {
        observe(viewModel.counterNum) {
            binding.tvCount.text = it.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


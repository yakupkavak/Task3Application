package com.example.task3application.counter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.task3application.R
import com.example.task3application.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!
    private var countNumber = 0
    private var checkSwitch = false
    private val model: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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
                if (switch) {
                    checkSwitch = true
                    println("switch true")
                } else {
                    checkSwitch = false
                    println("switch false")
                }
            }
        }
    }

    private fun increaseCounter() {
        if (checkSwitch) {
            model.incrementCount()
        } else {
            countNumber++
            binding.tvCount.text = countNumber.toString()
        }
    }

    private fun setObserver() {
        val counterListener: LiveData<Int> = model.counterNum
        counterListener.observe(viewLifecycleOwner) { newCount ->
            binding.tvCount.text = newCount.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


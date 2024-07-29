package com.example.task3application.guess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.task3application.R
import com.example.task3application.SharedViewModel
import com.example.task3application.databinding.FragmentGuessBinding
import com.example.task3application.extensions.navigate
import com.example.task3application.extensions.observe

class GuessFragment : Fragment() {

    private var _binding: FragmentGuessBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GuessViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var randomNumber = 0
    private var randomChar = 'A'

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGuessBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObserve()
    }

    private fun setObserve() {
        observe(viewModel.char) {
            with(binding) {
                tvChar.isVisible = true
                tvChar.text = it.toString()
                randomChar = it
            }
        }
    }

    private fun setListeners() {
        with(binding) {
            btnReset.setOnClickListener {
                viewModel.resetGame()
                tvInfo.text = getString(R.string.failure)
            }

            btnGuess.setOnClickListener {
                if (viewModel.checkGame(randomNumber)) {
                    tvInfo.text = getString(R.string.success)
                    tvChar.text = randomNumber.toString()
                    sharedViewModel.updateChar(randomChar)
                    navigate(GuessFragmentDirections.actionGuessFragmentToDetailFragment())
                } else {
                    tvInfo.text = getString(R.string.failure)
                }
            }

            val buttonList = listOf(
                btnZero, btnOne, btnTwo, btnThree,
                btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine
            )
            val integerResources = listOf(
                R.integer.zero, R.integer.one,
                R.integer.two, R.integer.three, R.integer.four, R.integer.five,
                R.integer.six, R.integer.seven, R.integer.eight, R.integer.nine
            )
            val stringResources = listOf(
                R.string.zero, R.string.one, R.string.two, R.string.three,
                R.string.four, R.string.five, R.string.six, R.string.seven,
                R.string.eight, R.string.nine
            )

            buttonList.forEachIndexed { index, button ->
                button.setOnClickListener {
                    randomNumber = resources.getInteger(integerResources[index])
                    tvInfo.text = getString(stringResources[index])
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
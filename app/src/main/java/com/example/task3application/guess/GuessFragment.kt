package com.example.task3application.guess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.task3application.R
import com.example.task3application.databinding.FragmentGuessBinding
import com.example.task3application.extensions.observe

class GuessFragment : Fragment() {

    private var _binding: FragmentGuessBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GuessViewModel by viewModels()
    private var number = 0

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
                tvChar.visibility = View.VISIBLE
                tvChar.text = it.toString()
            }
        }
    }

    private fun setListeners() {
        with(binding) {
            bReset.setOnClickListener {
                viewModel.resetGame()
                tvInfo.text = getString(R.string.failure)
            }
            bGuess.setOnClickListener {
                if (viewModel.checkGame(number)) {
                    tvInfo.text = getString(R.string.success)
                    tvChar.text = viewModel.randomNum.value.toString()
                } else {
                    tvInfo.text = getString(R.string.failure)
                }
            }
            bZero.setOnClickListener {
                number = 0
                tvInfo.text = getString(R.string.zero)
            }
            bOne.setOnClickListener {
                number = 1
                tvInfo.text = getString(R.string.one)
            }
            bTwo.setOnClickListener {
                number = 2
                tvInfo.text = getString(R.string.two)
            }
            bThree.setOnClickListener {
                number = 3
                tvInfo.text = getString(R.string.three)
            }
            bFour.setOnClickListener {
                number = 4
                tvInfo.text = getString(R.string.four)
            }
            bFive.setOnClickListener {
                number = 5
                tvInfo.text = getString(R.string.five)
            }
            bSix.setOnClickListener {
                number = 6
                tvInfo.text = getString(R.string.six)
            }
            bSeven.setOnClickListener {
                number = 7
                tvInfo.text = getString(R.string.seven)
            }
            bEight.setOnClickListener {
                number = 8
                tvInfo.text = getString(R.string.eight)
            }
            bNine.setOnClickListener {
                number = 9
                tvInfo.text = getString(R.string.nine)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.task3application.guess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import com.example.task3application.R
import com.example.task3application.SharedViewModel
import com.example.task3application.databinding.FragmentGuessBinding
import com.example.task3application.extensions.navigate
import com.example.task3application.extensions.observe

class GuessFragment : Fragment() {

    private var _binding: FragmentGuessBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GuessViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by navGraphViewModels(R.id.main_nav)
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
                tvChar.visibility = View.VISIBLE
                tvChar.text = it.toString()
                randomChar = it
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
                if (viewModel.checkGame(randomNumber)) {
                    tvInfo.text = getString(R.string.success)
                    tvChar.text = randomNumber.toString()
                    sharedViewModel.updateChar(randomChar)
                    val action = GuessFragmentDirections.actionGuessFragmentToDetailFragment()
                    navigate(action)
                } else {
                    tvInfo.text = getString(R.string.failure)
                }
            }
            bZero.setOnClickListener {
                randomNumber = 0
                tvInfo.text = getString(R.string.zero)
            }
            bOne.setOnClickListener {
                randomNumber = 1
                tvInfo.text = getString(R.string.one)
            }
            bTwo.setOnClickListener {
                randomNumber = 2
                tvInfo.text = getString(R.string.two)
            }
            bThree.setOnClickListener {
                randomNumber = 3
                tvInfo.text = getString(R.string.three)
            }
            bFour.setOnClickListener {
                randomNumber = 4
                tvInfo.text = getString(R.string.four)
            }
            bFive.setOnClickListener {
                randomNumber = 5
                tvInfo.text = getString(R.string.five)
            }
            bSix.setOnClickListener {
                randomNumber = 6
                tvInfo.text = getString(R.string.six)
            }
            bSeven.setOnClickListener {
                randomNumber = 7
                tvInfo.text = getString(R.string.seven)
            }
            bEight.setOnClickListener {
                randomNumber = 8
                tvInfo.text = getString(R.string.eight)
            }
            bNine.setOnClickListener {
                randomNumber = 9
                tvInfo.text = getString(R.string.nine)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
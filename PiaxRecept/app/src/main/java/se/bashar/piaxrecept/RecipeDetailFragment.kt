package se.bashar.piaxrecept

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import se.bashar.piaxrecept.databinding.FragmentRecipeDetailBinding
import se.bashar.piaxrecept.databinding.FragmentStartBinding

class RecipeDetailFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    val model: RecipteVewModel by activityViewModels()

    var currentrecipe = Recipe()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_start, container, false)
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recipeTitelEdittext.setText(currentrecipe.title)

        binding.recipeSaveButton.setOnClickListener {

            //TODO: Validera så inmatning är korrekt


            currentrecipe.title = binding.recipeTitelEdittext.text.toString()

            model.saveRecipe(currentrecipe)
        }

        val savestatusobserver = Observer<Boolean> {
            Log.i ("PIAXDEBUG", "Save status något hände")
            if (it == true)
            {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        model.saveRecipeStatus.observe(requireActivity(), savestatusobserver)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}
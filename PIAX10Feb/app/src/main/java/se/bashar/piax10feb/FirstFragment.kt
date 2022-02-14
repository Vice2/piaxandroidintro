package se.bashar.piax10feb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import se.bashar.piax10feb.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    var _binding: FragmentFirstBinding? = null

    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false)

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.firstTextView.text = "Tjena"

        binding!!.firstTextView.setOnClickListener(){

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
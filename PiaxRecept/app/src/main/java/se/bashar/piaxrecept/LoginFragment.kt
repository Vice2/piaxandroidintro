package se.bashar.piaxrecept

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import se.bashar.piaxrecept.databinding.FragmentLoginBinding
import se.bashar.piaxrecept.databinding.FragmentStartBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id. fragContainer, StartFragment()).commit()
        }

        binding.registerButton.setOnClickListener {

        }
    }
    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

}
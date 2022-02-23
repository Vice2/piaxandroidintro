package se.bashar.piaxrecept

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import se.bashar.piaxrecept.databinding.FragmentLoginBinding
import se.bashar.piaxrecept.databinding.FragmentStartBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val model: RecipteVewModel by activityViewModels()

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
            val email = binding.loginEmailEdittext.text.toString()
            val password = binding.loginPasswordEdittext.text.toString()
            model.login(email, password)
        }

        binding.registerButton.setOnClickListener {
            val email = binding.loginEmailEdittext.text.toString()
            val password = binding.loginPasswordEdittext.text.toString()
            model.signup(email, password)
        }

        val loginobserver = Observer<LoginResult> {
            Log.i ("PIAXDEBUG", "Login STATUS")
            if(it == LoginResult.LOGINFAIL)
            {
                Log.i("PIAXDEBUG", "LOGIN FAIL")
                Snackbar.make(view, "Felatig inloggning", Snackbar.LENGTH_LONG).show()
            }
            if(it == LoginResult.REGISTERFAIL)
            {
                Log.i("PIAXDEBUG", "REGISTER FAIL")
                Snackbar.make(view, "Felatig registrering", Snackbar.LENGTH_LONG).show()
            }
        }
        model.loginStatus.observe(requireActivity(), loginobserver)
    }
    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

}
package se.bashar.piaxfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class StartFragment : Fragment() {

    var thecounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.startCountTV).text = "Hepp"

        view.findViewById<Button>(R.id.startAddButton).setOnClickListener {
            thecounter = thecounter + 1

            view.findViewById<TextView>(R.id.startCountTV).text = thecounter.toString()
        }
            view.findViewById<Button>(R.id.startReadmoreButton).setOnClickListener {

                var readmorefrag = ReadmoreFragment()
                readmorefrag.thenumber = thecounter

                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragConatiner, readmorefrag).commit()
            }
    }
}
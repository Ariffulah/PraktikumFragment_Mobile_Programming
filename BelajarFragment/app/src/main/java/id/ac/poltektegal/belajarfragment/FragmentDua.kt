package id.ac.poltektegal.belajarfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dua.*
import kotlinx.android.synthetic.main.fragment_satu.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDua.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDua : Fragment() {

    var dsec: String? = null

    companion object{
        val EXTRA_NAME = "extra_name"
        val EXTRA_DESC = "extra_desc"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentSatu = FragmentSatu()
        btn_satu.setOnClickListener(){
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container, fragmentSatu, FragmentSatu::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null){
            val description: String? = savedInstanceState.getString(EXTRA_DESC)
            desc= description
        }

        if (arguments != null){
            val name :String? = arguments?.getString(EXTRA_NAME)
            tv_name.text = name
            tv_desc.text = desc
        }
    }
}
package id.ac.poltektegal.belajarfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_satu.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSatu.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSatu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_satu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentDua = FragmentDua()
        btn_dua.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString(FragmentDua.EXTRA_NAME, "ini data dari FRAGMENT SATU")
            val desc = "Fragment ini akan menerima data dari FRAGMENT SATU"

            fragmentDua.arguments = bundle
            fragmentDua.dsec = desc
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container, fragmentDua, FragmentDua::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

}
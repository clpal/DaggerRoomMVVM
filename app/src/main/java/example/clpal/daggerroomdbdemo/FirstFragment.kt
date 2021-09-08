package example.clpal.daggerroomdbdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import example.clpal.daggerroomdbdemo.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.GlobalScope

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    lateinit var viewModel: MainActivityViewModel
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        // _binding?.buttonFirst?.setOnClickListener {   }
        // initViewModel()
        return binding.root

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecordsObserver()
            .observe(viewLifecycleOwner, object : Observer<List<UserEntity>> {
                override fun onChanged(t: List<UserEntity>?) {
                    resulttextview.setText("")
                    t?.forEach { resulttextview.append(it.name + "\n") }
                }

            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        binding.buttonFirst.setOnClickListener {
            // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            val userEntity = UserEntity(name = enter_description.text.toString())
            viewModel.insertRecord(userEntity)
            resulttextview.setText("")

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
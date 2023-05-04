package icu.fur93.android_1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import icu.fur93.android_1.activity.FirstActivity
import icu.fur93.android_1.activity.SecondActivity
import icu.fur93.android_1.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonHomworkDialogFragment.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_HomeworkDialogFragment)
        }

        binding.buttonDemoHandlerFragment.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_demoHandlerFragment)
        }

        // 显式启动 activity
        binding.buttonHomeworkFirstActivity.setOnClickListener{
            val intent = Intent(context, FirstActivity::class.java)
            startActivity(intent)
        }

        // 隐式启动 activity
        binding.buttonHomeworkSecondActivity.setOnClickListener{
            val intent = Intent()
            intent.action = "icu.fur93.android_1.activity.SecondActivity"
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
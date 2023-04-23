package icu.fur93.android_1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import icu.fur93.android_1.R
import icu.fur93.android_1.databinding.FragmentHomeworkDialogBinding

class HomeworkDialogFragment : Fragment() {

    private var _binding: FragmentHomeworkDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeworkDialogBinding.inflate(inflater, container, false)

        // 简单对话框
        binding.buttonSimpleDialog.setOnClickListener{
            val dialogBuilder = AlertDialog.Builder(requireContext())

            dialogBuilder
                .setTitle("这是一条信息")
                .setIcon(R.drawable.icon)
                .setMessage("我叫${R.string.value_name}，学号${R.string.value_id}，来自${R.string.value_class}")
                .setNegativeButton("取消") { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton("确定") { dialog, _ ->
                    dialog.dismiss()
                }

            val dialog = dialogBuilder.create()
            dialog.show()
        }

        // 自定义 view 对话框
        binding.buttonViewDialog.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(requireContext())

            dialogBuilder
                .setTitle("这是一个自定义View对话框")
                .setView(R.layout.fragment_homework_dialog_register_form)

            val dialog = dialogBuilder.create()
            dialog.show()
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
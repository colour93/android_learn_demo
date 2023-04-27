package icu.fur93.android_1.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import icu.fur93.android_1.R
import icu.fur93.android_1.databinding.FragmentDemoHandlerBinding
import kotlin.random.Random

class DemoHandlerFragment : Fragment() {

    private var _binding: FragmentDemoHandlerBinding? = null
    private val binding get() = _binding!!

    private val CHANGEID = 0
    private val SHOWIMAGE = 1

    private val images = intArrayOf(
        R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5,
        R.drawable.f6, R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f10, R.drawable.f11
    )

    lateinit var iv_show: ImageView
    private var choiceImage = 0
    private lateinit var myThread: MyThread
    private lateinit var mainHandler: MainHandler

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDemoHandlerBinding.inflate(inflater, container, false)

        iv_show = binding.imageViewDemoHandler

        mainHandler = MainHandler(this)

        myThread = MyThread()
        myThread.start()

        binding.buttonDemoHandler.setOnClickListener{
            showImage()
        }

        return binding.root
    }

    //标签中绑定的按钮事件
    private fun showImage() {
        myThread.myHandle.sendEmptyMessage(CHANGEID)
    }

    //一个子线程，Handler用于随机产生一个图片索引
    inner class MyThread : Thread() {
        lateinit var myHandle: Handler

        override fun run() {
            //为子线程准备Looper
            Looper.prepare() //创建Looper对象
            myHandle = @SuppressLint("HandlerLeak")
            object : Handler() {  //创建Handler实例
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    Log.d("myHandler", msg.what.toString())
                    when (msg.what) {
                        CHANGEID -> {
                            val random = Random(System.currentTimeMillis())
                            //从images数组长度中随机取出一个数
                            val imageID = random.nextInt(images.size)
                            choiceImage = imageID
                            //给主线程中的Handler发送消息，用以更新图片
                            mainHandler.sendEmptyMessage(SHOWIMAGE)
                            val tv_show = binding.textViewDemoHandler
                            tv_show.text = "随机选择了第 $choiceImage 张图片"
                        }
                        else -> {
                        }
                    }
                }
            }
            Looper.loop() //启动Looper
        }
    }

    //主线程中的Handler，用于显示图片
    class MainHandler(private val activity: DemoHandlerFragment) : Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            Log.d("mainHandler", msg.what.toString())
            if (msg.what == activity.SHOWIMAGE) {
                Log.d("show", "${activity.choiceImage}")
                activity.iv_show.setImageResource(activity.images[activity.choiceImage])
            }
        }
    }
}

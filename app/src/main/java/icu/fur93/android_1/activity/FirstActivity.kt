package icu.fur93.android_1.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import icu.fur93.android_1.R
import icu.fur93.android_1.model.Information


class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val submit = findViewById<View>(R.id.submit) as Button
        submit.setOnClickListener {
            val name = findViewById<View>(R.id.name) as EditText
            val age = findViewById<View>(R.id.age) as EditText
            val male = findViewById<View>(R.id.male) as RadioButton
            val female = findViewById<View>(R.id.female) as RadioButton
            val qualifications = findViewById<View>(R.id.qualifications) as EditText
            val phone = findViewById<View>(R.id.phone) as EditText
            val gender = if (male.isChecked) "男" else "女"
            val studentNumber = findViewById<View>(R.id.studentNumber) as EditText
            val information = Information(
                name.text.toString(),
                age.text.toString(),
                gender,
                qualifications.text.toString(),
                phone.text.toString(),
                studentNumber.text.toString()
            )
            //创建Bundle对象
            val bundle = Bundle()
            //向Bundle中放入一个可序列化的对象
            bundle.putSerializable("information", information)
            val intent = Intent(this, SecondActivity::class.java)
            //向Intent中放入需要携带的数据包
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}

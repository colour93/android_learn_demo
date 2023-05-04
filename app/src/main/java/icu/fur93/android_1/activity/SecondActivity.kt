package icu.fur93.android_1.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import icu.fur93.android_1.R
import icu.fur93.android_1.model.Information


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "学生信息"
        val nickName = findViewById<View>(R.id.text1) as TextView
        val age = findViewById<View>(R.id.text2) as TextView
        val gender = findViewById<View>(R.id.text3) as TextView
        val qualifications = findViewById<View>(R.id.text4) as TextView
        val phone = findViewById<View>(R.id.text5) as TextView
        val studentNumber = findViewById<View>(R.id.text6) as TextView

        val info: Information? = intent.getSerializableExtra("information") as Information?

        if (info != null) {
            nickName.text = "姓名：" + info.name
            age.text = "年龄：" + info.age
            gender.text = "性别：" + info.sex
            qualifications.text = "学历：" + info.qualifications
            phone.text = "电话：" + info.phone
            studentNumber.text = "学号：" + info.studentNumber
        }

    }
}

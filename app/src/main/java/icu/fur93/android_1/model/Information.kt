package icu.fur93.android_1.model

import java.io.Serializable

class Information(
    var name: String,
    var age: String,
    var sex: String,
    var qualifications: String,
    var phone: String,
    var studentNumber: String
) :
    Serializable {

    override fun toString(): String {
        return "Information{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", qualifications='" + qualifications + '\'' +
                ", phone='" + phone + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                '}'
    }
}
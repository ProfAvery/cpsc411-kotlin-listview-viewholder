package edu.fullerton.ecs.cpsc411.kotlinviewholderlistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

data class Person(val name: String, val email: String)

// Courtesy of <https://www.fakenamegenerator.com/>
val people = arrayOf(
    Person("Victor S. Balch", "VictorSBalch@rhyta.com"),
    Person("Robert S. Morgan", "RobertSMorgan@jourrapide.com "),
    Person("Corine J. Day", "CorineJDay@armyspy.com "),
    Person("David P. Craig", "DavidPCraig@jourrapide.com "),
    Person("Stella R. Kingsley", "StellaRKingsley@dayrep.com "),
    Person("Leonor C. Coleman", "LeonorCColeman@jourrapide.com"),
    Person("Gregory B. Peck", "GregoryBPeck@jourrapide.com"),
    Person("Alex R. Brady", "AlexRBrady@dayrep.com"),
    Person("Patrice S. Ponce", "PatriceSPonce@rhyta.com"),
    Person("Eva D. Simmons", "EvaDSimmons@jourrapide.com"),
    Person("David V. Higgins", "DavidVHiggins@rhyta.com"),
    Person("Beatrice J. Hernadez", "BeatriceJHernadez@dayrep.com")
)

class MainActivity : AppCompatActivity() {

    data class ViewHolder(val text1: TextView, val text2: TextView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = object : ArrayAdapter<Person>(this, R.layout.item, R.id.nameTextView, people) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val item = super.getView(position, convertView, parent)
                var holder: ViewHolder? = item.tag as ViewHolder?

                if (holder == null) {
                    holder = ViewHolder(item.nameTextView, item.emailTextView)
                    item.tag = holder
                }

                holder.text1.text = people[position].name
                holder.text2.text = people[position].email

                return item
            }

        }

        listView.setOnItemClickListener { _, _, position, _ ->
            textView.text = "\"${people[position].name}\" <${people[position].email}>"
        }

    }
}

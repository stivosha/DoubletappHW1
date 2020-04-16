package ru.stivosha.doubletapphw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ru.stivosha.doubletapphw1.HW1Application.Companion.logger

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY_OF_NUM: String = "NUM_KEY"
    }

    private lateinit var numTextView: TextView
    private lateinit var startSecondActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        numTextView.text = (savedInstanceState?.getInt(KEY_OF_NUM) ?: 0).toString()
        startSecondActivityButton.setOnClickListener {
            var intent = Intent(
                this,
                SecondActivity::class.java
            ).apply {
                putExtra(KEY_OF_NUM, mathPow2(numTextView.text.toString().toInt()))
            }
            startActivity(intent)
        }
        logger.writeInLog(this.localClassName + " onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_OF_NUM, numTextView.text.toString().toInt() + 1)
        super.onSaveInstanceState(outState)
    }

    private fun mathPow2(num: Int) : Int{
        return num * num
    }

    private fun initComponents(){
        numTextView = findViewById(R.id.num_text_view)
        startSecondActivityButton = findViewById(R.id.start_second_activity_button)
    }

    override fun onStart() {
        super.onStart()
        logger.writeInLog(this.localClassName + " onStart")
    }

    override fun onResume() {
        super.onResume()
        logger.writeInLog(this.localClassName + " onResume")

    }

    override fun onPause() {
        super.onPause()
        logger.writeInLog(this.localClassName + " onPause")
    }

    override fun onStop() {
        super.onStop()
        logger.writeInLog(this.localClassName + " onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.writeInLog(this.localClassName + " onDestroy")
    }
}

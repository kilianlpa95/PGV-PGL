package com.example.firstprojectclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import android.os.StrictMode



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            requestToServer()
        }

        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        button3.setOnClickListener{
            var intent = Intent(this, ExtraActvity::class.java)
            startActivity(intent)
        }
    }

    private fun requestToServer(){
        val queue = Volley.newRequestQueue(this)

        val inCar = editText.text.toString()
        val url = "http://192.168.103.63:40000/cars?state=$inCar"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                textView.text = "Response: %s".format(response.toString())
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        queue.add(jsonObjectRequest)
    }
}

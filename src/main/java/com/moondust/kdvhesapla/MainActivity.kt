package com.moondust.kdvhesapla;

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.DecimalFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import kotlin.math.round
import androidx.annotation.RequiresApi
import com.moondust.kdvhesapla.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.nextUp
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonhesapla.setOnClickListener {

            var tutar:Double = binding.edittutar.text.toString().toDouble()
            var kdv = binding.editkdvorani.text.toString().toInt()
            if (binding.edittutar.text.isNotEmpty() && binding.editkdvorani.text.isNotEmpty()) {

                if (kdv == 18) {
                    var kdvdahilislem = tutar / 1.18
                    val number1 = kdvdahilislem
                    val rounded1 = String.format("%.2f", number1) // rounds to 3 decimal places

                    var kdvtutari = tutar - kdvdahilislem
                    val number2 = kdvtutari
                    val rounded2 = String.format("%.2f", number2) // rounds to 3 decimal places

                    var kdvharictutari = tutar*(0.18)
                    val number3 = kdvharictutari
                    val rounded3 = String.format("%.2f", number3) // rounds to 3 decimal places

                    var toplamtutar = tutar+kdvharictutari
                    val number4 = toplamtutar
                    val rounded4 = String.format("%.2f", number4) // rounds to 3 decimal places
                    binding.textViewislemtutari1.text = rounded1.toString()
                    binding.textViewikdvtutari1.text = rounded2.toString()
                    binding.textViewtoplamtutar1.text = tutar.toString()

                    binding.textViewislemtutari2.text = tutar.toString()
                    binding.textViewkdvtutari2.text= rounded3.toString()
                    binding.textViewtoplamtutar2.text= rounded4.toString()
                } else if (kdv==8){
                    var kdvdahilislem = tutar / 1.08
                    val number1 = kdvdahilislem
                    val rounded1 = String.format("%.2f", number1) // rounds to 3 decimal places

                    var kdvtutari = tutar - kdvdahilislem
                    val number2 = kdvtutari
                    val rounded2 = String.format("%.2f", number2) // rounds to 3 decimal places

                    var kdvharictutari = tutar*(0.08)
                    val number3 = kdvharictutari
                    val rounded3 = String.format("%.2f", number3) // rounds to 3 decimal places

                    var toplamtutar = tutar+kdvharictutari
                    val number4 = toplamtutar
                    val rounded4 = String.format("%.2f", number4) // rounds to 3 decimal places


                    binding.textViewislemtutari1.text = kdvdahilislem.toString()
                    binding.textViewikdvtutari1.text = kdvtutari.toString()
                    binding.textViewtoplamtutar1.text = tutar.toString()

                    binding.textViewislemtutari2.text = tutar.toString()
                    binding.textViewkdvtutari2.text= kdvharictutari.toString()
                    binding.textViewtoplamtutar2.text= toplamtutar.toString()
                }
                else {
                    var kdvdahilislem = tutar / 1.01
                    val number1 = kdvdahilislem
                    val rounded1 = String.format("%.2f", number1) // rounds to 3 decimal places

                    var kdvtutari = tutar - kdvdahilislem
                    val number2 = kdvtutari
                    val rounded2 = String.format("%.2f", number2) // rounds to 3 decimal places


                    var kdvharictutari = tutar*(0.01)
                    val number3 = kdvharictutari
                    val rounded3 = String.format("%.2f", number3) // rounds to 3 decimal places

                    var toplamtutar = tutar+kdvharictutari
                    val number4 = toplamtutar
                    val rounded4 = String.format("%.2f", number4) // rounds to 3 decimal places
                    binding.textViewislemtutari1.text = kdvdahilislem.toString()
                    binding.textViewikdvtutari1.text = kdvtutari.toString()
                    binding.textViewtoplamtutar1.text = tutar.toString()

                    binding.textViewislemtutari2.text = tutar.toString()
                    binding.textViewkdvtutari2.text= kdvharictutari.toString()
                    binding.textViewtoplamtutar2.text= toplamtutar.toString()
                }

            }

            else{
                binding.textViewislemtutari1.text ="TUTAR GİRİNİZ."
                binding.textViewislemtutari1.setTextColor(getColor(R.color.red))

            }
            hideKeyboard(edittutar)
        }
    }


    fun btnkdvtik(view: View) {
        var btnkdvsec = view as Button
        var btntikkdv:String = editkdvorani.text.toString()
        when(btnkdvsec.id){
            buttonyuzde1.id->{
                btntikkdv="1"
            }
            buttonyuzde8.id->{
                btntikkdv="8"
            }
            buttonyuzde18.id->{
                btntikkdv="18"
            }
        }
        editkdvorani.setText(btntikkdv).toString()

    }

    private fun hideKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}






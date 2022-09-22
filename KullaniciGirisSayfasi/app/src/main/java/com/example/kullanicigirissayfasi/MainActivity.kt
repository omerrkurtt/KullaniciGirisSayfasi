package com.example.kullanicigirissayfasi

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.kullanicigirissayfasi.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)//constraint layout'u çalıştır

        //hangi dosyadan aldığını bilmediğimiz için
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)//bilgiler xml dosyasını getir, preferences içine aktarıldıktan sonra kullanici ve parola adındaki değişkenleri çekebiliriz

    binding.btnGiris.setOnClickListener{

        //xml den verileri çekebilmek için referansSharedPreferences tanımlıyoruz böylece bilgiler.xml deki verilere ulaşabiliyoruz
        var kayitliKullanici = preferences.getString("kullanici","")//kullanicinin içerisinden bilgileri al, hangi değerden alcağını bilmedğimiz için boş bırakıyoruz
        var kayitliParola = preferences.getString("parola","")

        var girisKullanici = binding.girisKullaniciAdi.text.toString()
        var girisParola = binding.girisParola.text.toString()

        if ((kayitliKullanici==girisKullanici && kayitliParola==girisParola)){

            intent = Intent(applicationContext,MainHosgeldiniz::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext,"Giris Bilgileri Hatalı",Toast.LENGTH_LONG).show()
        }
    }
        binding.btnKayTOl.setOnClickListener{
            intent = Intent(applicationContext,MainKayitOl::class.java)//Kayıtol Sayfasına gidecek
            startActivity(intent)
        }

    }
}
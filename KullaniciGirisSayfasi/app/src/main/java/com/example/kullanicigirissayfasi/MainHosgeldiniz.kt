package com.example.kullanicigirissayfasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kullanicigirissayfasi.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainHosgeldinizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)
        var kayitliKullanici = preferences.getString("kullanici","")
        var kayitliParola = preferences.getString("parola","")
        //textview lere kayıtlı bilgileri aktarıyoruz
        binding.kullaniciBilgisi.text="Kullanıcı Adı: "+kayitliKullanici.toString()
        binding.kullaniciParola.text="Kullanıcı Parola: "+kayitliParola.toString()


        binding.btnCikisYap.setOnClickListener{
            intent = Intent(applicationContext,MainActivity::class.java)//Mainactivity ye gidecek
            startActivity(intent)

            //xml den verileri çekiyoruz

        }
    }
}
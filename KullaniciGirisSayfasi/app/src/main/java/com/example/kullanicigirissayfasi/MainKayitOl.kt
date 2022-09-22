package com.example.kullanicigirissayfasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kullanicigirissayfasi.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKaydet.setOnClickListener{
            var kullaniciBilgisi = binding.kayitKullaniciAdi.text.toString()
            var kullaniciParola = binding.kayitParola.text.toString()
            //verileri alıp değişkenlere attık
            //xml dosyasına kaydetmek için SharedPrefences Kullanacağız
            var sharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)//bilgiler adında xml oluşturduk, MODEPRİVATE İLE KİMSE ERİŞEMESİN
            var editor = sharedPreferences.edit()//verileri düzenlemek edit i kullanıyoruz

            //veri eklmek
            editor.putString("kullanici","$kullaniciBilgisi").apply()
            editor.putString("parola","$kullaniciParola").apply()//parola sayıda olabilir
        //"kullanici" adında anahtar oluşturduk, kullaniciBilgisinin içerisine aktardık
            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            binding.kayitKullaniciAdi.text.clear()
            binding.kayitParola.text.clear()
        }






        binding.btnGiriseDon.setOnClickListener{
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
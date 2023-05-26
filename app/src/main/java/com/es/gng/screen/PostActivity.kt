package com.es.gng.screen

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.es.gng.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    lateinit var uploadBtn: TextView
    lateinit var requestResultContracts: ActivityResultLauncher<Intent>


    companion object {
        const val REQUEST_FIRST = 1000
        const val REQUEST_GET_IMAGE = 2000
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        uploadBtn = binding.uploadBtn

        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {Log.d("daeYoung", "grant success")}
            else {Log.d("daeYoung", "grant fail")}
        }

        requestPermissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE")

        requestResultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                kotlin.runCatching {
                    var inputStream = contentResolver.openInputStream(it!!.data!!.data!!)
                    val bitmap = BitmapFactory.decodeStream(inputStream, null, null)
                    inputStream!!.close()
                    inputStream = null
                    bitmap?.let {
                        binding.galleryResult.setImageBitmap(bitmap)
                    } ?: let {
                        Log.d("daeYoung", "${binding.galleryResult}")
                    }
                }.onFailure {
                    Log.d("daeYoung", "image load fail")
                }
            }

        val status =
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (status == PackageManager.PERMISSION_GRANTED) {
            Log.d("daeYoung", "success")
        } else {
            Log.d("daeYoung", "fail")
        }

        uploadBtn.setOnClickListener {
//            navigatePhotos()
        }
        binding.btn.setOnClickListener {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 0)
        }

    }

    private fun navigatePhotos() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        requestResultContracts.launch(intent)
    }


}
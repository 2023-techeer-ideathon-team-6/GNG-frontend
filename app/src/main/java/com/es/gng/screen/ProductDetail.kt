package com.es.gng.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.es.gng.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = com.es.gng.databinding.ActivityProductDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.bidDialogBtn.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        bottomSheetDialog.setContentView(bottomSheetView)

        val closeButton: Button = bottomSheetView.findViewById(R.id.bidBtn)
        closeButton.setOnClickListener {
//            val intent =
        }

        bottomSheetDialog.show()
    }
}
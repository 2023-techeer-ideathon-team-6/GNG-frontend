package com.es.gng.screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.getSystemService
import com.es.gng.R
import com.es.gng.databinding.ActivitySharedBinding
import com.es.gng.data.ItemDTO
import com.es.gng.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SharedActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchView.isSubmitButtonEnabled = true

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // 검색어가 변경될 때마다 호출되는 메서드
                // 실시간으로 검색어를 처리하거나 검색 결과를 업데이트할 수 있습니다.
                return true
            }
        })
    }

    private fun searchItems(query: String) {
        val apiService = ApiClient.create().searchItems(query)
        apiService.enqueue(object : Callback<ItemDTO> {
            override fun onResponse(call: Call<ItemDTO>, response: Response<ItemDTO>) {
                if (response.isSuccessful) {
                    val itemList = response.body()
                    if (itemList != null && itemList.isNotEmpty()) {
                        // 상품 리스트가 있을 경우 처리
                        showItems(itemList)
                    } else {
                        // 상품 리스트가 없을 경우 처리
                        binding.searchEmpty.visibility = View.VISIBLE
                    }
                } else {
                    // API 호출 실패 처리
                    Log.e("API Error", response.message())
                }
            }
            override fun onFailure(call: Call<ItemDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun showItems(itemList: ItemDTO) {
        val layoutInflater = LayoutInflater.from(this)
        val parentLayout = findViewById<LinearLayout>(R.id.searchParentLayout)
        parentLayout.removeAllViews()

        if (itemList != null) {
            for (i in itemList) {
                val itemView = layoutInflater.inflate(R.layout.activity_search_sub_layout, parentLayout, false)

                val productImg = itemView.findViewById<ImageView>(R.id.productImg)
                val productName = itemView.findViewById<TextView>(R.id.productName)
    //            val productStatus = itemView.findViewById<TextView>(R.id.productStatus)
    //            val productHeartCount = itemView.findViewById<TextView>(R.id.productHeartCount)

                // 데이터 설정
                // 상품 이미지 설정
                // Glide 또는 Picasso 등의 라이브러리를 사용하여 이미지 로딩 가능
                // 예: Glide.with(this).load(item.imageUrl).into(productImg)

                // 상품 상태 설정
                val itemid = i.itemId
                val mixbid = i.maxBid
                val starcount = i.starCount
                val title = i.title
                val url = i.url

//                val choiceLayout = createLayout(itemid,mixbid,starcount, title, url)
//                parentLayout.addView(choiceLayout)

                // 상품 하트 개수 설정
    //            productHeartCount.text = "${item.starCount}하트"


            }
        }
    }
}


//@SuppressLint("SetTextI18n")
//fun createLayout(itemid:Int, maxbid:Int, starcount : Int, title:String, url:String ): View {
//    val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//    val layout = inflater.inflate(R.layout.activity_search_sub_layout, null) as LinearLayout




//    layout.setOnClickListener {
//        val intent = Intent(applicationContext, ::class.java)
//
//        startActivity(intent)
//    }

//    return layout
//}
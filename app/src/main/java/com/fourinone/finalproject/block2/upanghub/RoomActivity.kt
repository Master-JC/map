package com.fourinone.finalproject.block2.upanghub

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.appcompat.widget.SearchView
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fourinone.finalproject.block2.upanghub.adapter.RoomAdapter
import com.fourinone.finalproject.block2.upanghub.databinding.ActivityRoomBinding
import com.fourinone.finalproject.block2.upanghub.model.Room
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var roomList : MutableList<Room>
    private lateinit var roomAdapter: RoomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        getRoomList()

        binding.button.setOnClickListener {
            val intent = Intent(this, ParkingActivity::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, SecurityParkActivity::class.java)
            startActivity(intent)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val imm = applicationContext?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.searchView.windowToken, 0)

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    // Filter your list based on the newText
                    val filteredList = roomList.filter { roomList ->
                                (roomList.room_code?.contains(newText, ignoreCase = true) == true)
                    }.toMutableList()

                    // Update your adapter with the filtered results
                    roomAdapter.updateData(filteredList)

                    // Notify the adapter that the dataset has changed
                    roomAdapter.notifyDataSetChanged()
                }
                return true
            }

        })


    }

    private fun init(){
        recyclerView = binding.rvRoom
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        roomList = mutableListOf()
        roomAdapter = RoomAdapter(roomList)
        recyclerView.adapter = roomAdapter

    }
    private fun getRoomList(){
        val retrofit = Retrofitbuilder.buildService(ApiService::class.java)
        val call = retrofit.getRoomsList()
        call.enqueue(object : Callback<List<Room>> {
            override fun onResponse(p0: Call<List<Room>>, p1: Response<List<Room>>) {
                if (p1.isSuccessful){
                    roomList.clear()
                    roomList.addAll(p1.body()!!)
                    roomAdapter.notifyDataSetChanged()
                    Toast.makeText(applicationContext, "hi", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(p0: Call<List<Room>>, p1: Throwable) {
                TODO("Not yet implemented")
                Toast.makeText(applicationContext, "falied", Toast.LENGTH_SHORT).show()
            }

        })
    }

}
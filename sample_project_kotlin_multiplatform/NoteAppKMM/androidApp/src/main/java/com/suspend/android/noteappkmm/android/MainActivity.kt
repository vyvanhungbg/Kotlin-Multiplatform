package com.suspend.android.noteappkmm.android

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.suspend.android.noteappkmm.DatabaseDriverFactory
import com.suspend.android.noteappkmm.android.add.AddActivity
import com.suspend.android.noteappkmm.android.databinding.ActivityMainBinding
import com.suspend.android.noteappkmm.data.note.SqlDelightNoteDataSource
import com.suspend.android.noteappkmm.database.MyNoteDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by lazy { MainViewModel(SqlDelightNoteDataSource(MyNoteDatabase.invoke(DatabaseDriverFactory(this).createDriver())))}

    private val adapter = ListAdapterItem {
        it.id?.let {
            viewModel.deleteNote(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        viewModel.getNotes()
        viewModel.notes.observe(this){
            adapter.submitList(it)
        }

        viewModel.stateDelete.observe(this){
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show()
            viewModel.getNotes()
        }


        binding.floatingActionButtonAdd.setOnClickListener{
            startActivity(Intent(this@MainActivity, AddActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }
}


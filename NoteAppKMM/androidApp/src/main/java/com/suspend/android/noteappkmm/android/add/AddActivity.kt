package com.suspend.android.noteappkmm.android.add

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.suspend.android.noteappkmm.DatabaseDriverFactory
import com.suspend.android.noteappkmm.android.databinding.ActivityAddBinding
import com.suspend.android.noteappkmm.data.note.SqlDelightNoteDataSource
import com.suspend.android.noteappkmm.database.MyNoteDatabase

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    private val viewModel by lazy {
        AddViewModel(
            SqlDelightNoteDataSource(
                MyNoteDatabase.invoke(
                    DatabaseDriverFactory(this).createDriver()
                )
            )
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButtonAdd.setOnClickListener {
            viewModel.addNote(
                binding.editTextTitle.text.toString(),
                binding.editTextContent.text.toString()
            )
        }

        viewModel.stateAdd.observe(this){
            if(it){
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
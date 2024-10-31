package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Mengaktifkan Edge to Edge mode
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cities = resources.getStringArray(R.array.cities_array)
        val spinner = findViewById<Spinner>(R.id.cities_spinner)

        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        this@OrderActivity,
                        getString(R.string.selected_item) + " " + cities[position],
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Tidak perlu implementasi jika tidak ada yang dipilih
                }
            }
        }

        // Mengambil data dari ListFoodActivity
        val foodName = intent.getStringExtra("foodName")
        val etFoodName: TextView = findViewById(R.id.etFoodName)
        etFoodName.text = foodName

        val etServings: EditText = findViewById(R.id.etServings)
        val etName: EditText = findViewById(R.id.etName)
        val etNotes: EditText = findViewById(R.id.etNotes)
        val btnOrder: Button = findViewById(R.id.btnOrder)

        // Klik tombol untuk meneruskan data ke ConfirmationActivity
        btnOrder.setOnClickListener {
            val servings = etServings.text.toString()
            val name = etName.text.toString()
            val notes = etNotes.text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("foodName", foodName)
                putExtra("servings", servings)
                putExtra("name", name)
                putExtra("notes", notes)
            }
            startActivity(intent)
        }

        // Inisialisasi tombol untuk kembali ke ListFoodActivity
        val backToListButton: Button = findViewById(R.id.backToList)
        backToListButton.setOnClickListener {
            // Kembali ke ListFoodActivity
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish() // Mengakhiri OrderActivity
        }
    }
}

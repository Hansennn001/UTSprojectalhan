package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val backToListButton: Button = findViewById(R.id.backToList) // Pastikan ID sesuai dengan layout XML
        backToListButton.setOnClickListener {
            // Kembali ke ListFoodActivity
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish() // Mengakhiri OrderActivity
        }
    }
}

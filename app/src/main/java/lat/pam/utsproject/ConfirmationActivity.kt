package lat.pam.utsproject

import android.content.Intent // Impor Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data dari OrderActivity
        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val name = intent.getStringExtra("name")
        val notes = intent.getStringExtra("notes")

        // Tampilkan data pesanan
        val tvFoodName: TextView = findViewById(R.id.tvFoodName)
        val tvServings: TextView = findViewById(R.id.tvServings)
        val tvName: TextView = findViewById(R.id.tvName)
        val tvNotes: TextView = findViewById(R.id.tvNotes)

        tvFoodName.text = "Food Name: $foodName"
        tvServings.text = "Number of Servings: $servings pax"
        tvName.text = "Ordering Name: $name"
        tvNotes.text = "Additional Notes: $notes"

        // Inisialisasi tombol
        val backToMenuButton: Button = findViewById(R.id.backtoMenu)
        backToMenuButton.setOnClickListener {
            // Kembali ke ListFoodActivity
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish() // Mengakhiri ConfirmationActivity
        }
    }
}

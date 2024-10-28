package lat.pam.utsproject

import android.content.Intent // Impor Intent
import android.os.Bundle
import android.widget.Button // Impor Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cireng", "Camilan khas Bandung yang renyah", R.drawable.cireng), // Menu baru
            Food("Kopi Hitam", "Kopi hitam yang nikmat dan kuat", R.drawable.kopi_hitam), // Menu baru
            Food("Mie Goreng", "Mie goreng dengan bumbu spesial", R.drawable.mie_goreng), // Menu baru
            Food("Nasi Goreng", "Nasi goreng dengan telur dan ayam", R.drawable.nasigoreng), // Menu baru
            Food("Sparkling", "Minuman bersoda yang segar", R.drawable.sparkling_tea), // Menu baru
            Food("Cheesecake", "Kue keju yang lembut dan manis", R.drawable.cheesecake) // Menu baru
        )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter

        // Inisialisasi tombol untuk kembali ke MainActivity
        val backToMainButton: Button = findViewById(R.id.backToMain)
        backToMainButton.setOnClickListener {
            // Kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Mengakhiri ListFoodActivity
        }

        // Menangani padding untuk tampilan Edge to Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

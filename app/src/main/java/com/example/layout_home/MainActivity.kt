package com.example.layout_home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.layout_home.databinding.ActivityMainBinding
import com.example.layout_home.model.Catalog
import com.example.layout_home.model.Category
import androidx.recyclerview.widget.GridLayoutManager


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val categoryAdapter = CategoryAdapter()
    private lateinit var catalogAdapter: CatalogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAction()
        setListCategory()
        setupCatalogRecyclerView()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_dessert, name = "Dessert"),
            Category(image = R.drawable.img_ayam, name = "Lunch"),
            Category(image = R.drawable.img_drink, name = "Drink"),
            Category(image = R.drawable.img_lunch, name = "Meat")
        )
        binding.rvCategory.adapter = categoryAdapter
        categoryAdapter.submitData(data)
    }

    private fun setupCatalogRecyclerView() {
        catalogAdapter = CatalogAdapter()
        // Set the layout manager to GridLayoutManager with 2 columns
        binding.rvCatalog.layoutManager = GridLayoutManager(this, 2)
        binding.rvCatalog.adapter = catalogAdapter

        // Example of filling data into the adapter
        val exampleCatalogList = listOf(
            Catalog(image = R.drawable.img_1, name = "Salad", price = 40.000),
            Catalog(image = R.drawable.img_2, name = "Nasi Padang", price = 29.000),
            Catalog(image = R.drawable.img_3, name = "Ayam Bakar", price = 30.000),
            Catalog(image = R.drawable.img_4, name = "Ayam Gulai", price = 25.000),
            Catalog(image = R.drawable.img_5, name = "Martabak", price = 50.000),
            Catalog(image = R.drawable.img_6, name = "Ayam Goreng", price = 45.000)
        )

        catalogAdapter.submitData(exampleCatalogList)
    }


    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.tvName.text = "HAI, HASSAN!!"
    }
}

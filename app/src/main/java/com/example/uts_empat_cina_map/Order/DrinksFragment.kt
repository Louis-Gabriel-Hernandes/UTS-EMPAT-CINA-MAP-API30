package com.example.uts_empat_cina_map.Order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_empat_cina_map.OrderData.FoodItem
import com.example.uts_empat_cina_map.R
import com.google.firebase.firestore.FirebaseFirestore

class DrinksFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodItemAdapter
    private val drinkItems = mutableListOf<FoodItem>()
    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_drinks, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        foodAdapter = FoodItemAdapter(requireContext(), drinkItems)
        recyclerView.adapter = foodAdapter

        fetchDrinkItems() // Call the function to fetch drink items
        return view
    }

    private fun fetchDrinkItems() {
        firestore.collection("items") // Ensure this matches your Firestore collection name
            .whereEqualTo("category", "Drinks") // Query for Drinks items
            .get()
            .addOnSuccessListener { documents ->
                drinkItems.clear()
                for (document in documents) {
                    val foodItem = document.toObject(FoodItem::class.java)
                    drinkItems.add(foodItem)
                }
                foodAdapter.updateData(drinkItems) // Update the adapter with new data
            }
            .addOnFailureListener { exception ->
                // Handle any errors
            }
    }
}

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

class FavoritesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodItemAdapter
    private val favoriteItems = mutableListOf<FoodItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        foodAdapter = FoodItemAdapter(requireContext(), favoriteItems)
        recyclerView.adapter = foodAdapter

        fetchFavoriteItems()
        return view
    }

    private fun fetchFavoriteItems() {
        val db = FirebaseFirestore.getInstance()
        db.collection("food_items")
            .whereEqualTo("isFavorite", true)
            .get()
            .addOnSuccessListener { documents ->
                favoriteItems.clear()
                favoriteItems.addAll(documents.toObjects(FoodItem::class.java))
                foodAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                // Handle the error
            }
    }
}
package com.example.uts_empat_cina_map.Order

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_empat_cina_map.OrderData.FoodItem
import com.example.uts_empat_cina_map.R


class AllFoodFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodItemAdapter
    private val foodItemList = listOf(
        FoodItem("Pizza",
            R.drawable.pizza, isFavorite = true, description = "Delicious cheesy pizza", price = 9.99, imageUrl = "url_to_pizza_image"),
        FoodItem("Burger",
            R.drawable.burger, isFavorite = false, description = "Juicy beef burger", price = 5.99, imageUrl = "url_to_burger_image"),
        FoodItem("Sushi",
            R.drawable.sushi, isFavorite = true, description = "Fresh sushi rolls", price = 12.99, imageUrl = "url_to_sushi_image"),
        FoodItem("Pasta",
            R.drawable.pasta, isFavorite = false, description = "Creamy pasta with herbs", price = 7.99, imageUrl = "url_to_pasta_image"),
        FoodItem("Salad",
            R.drawable.salad, isFavorite = false, description = "Healthy green salad", price = 4.99, imageUrl = "url_to_salad_image"),
        FoodItem("Coffee",
            R.drawable.coffee, isFavorite = false, description = "Rich aromatic coffee", price = 2.99, imageUrl = "url_to_coffee_image"),
        FoodItem("Tea",
            R.drawable.tea, isFavorite = false, description = "Soothing herbal tea", price = 2.49, imageUrl = "url_to_tea_image"),
        FoodItem("Smoothie",
            R.drawable.smoothie, isFavorite = true, description = "Fruity smoothie", price = 5.49, imageUrl = "url_to_smoothie_image"),
        FoodItem("Juice",
            R.drawable.juice, isFavorite = false, description = "Freshly squeezed juice", price = 3.49, imageUrl = "url_to_juice_image"),
        FoodItem("Babyoil",
            R.drawable.babyoil, isFavorite = false, description = "Soothing baby oil", price = 4.99, imageUrl = "url_to_babyoil_image")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_food, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 3)

        foodAdapter = FoodItemAdapter(requireContext(), foodItemList)
        recyclerView.adapter = foodAdapter

        return view
    }
}
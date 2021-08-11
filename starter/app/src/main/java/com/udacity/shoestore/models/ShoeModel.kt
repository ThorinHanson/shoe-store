package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoeModel: ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>(getMovies())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {

    }

    private fun getMovies(): MutableList<Shoe> {
        val movieList = listOf(
            Shoe("Air Jordan", 12.0, "Nike", "These are the classic Air Jordan", emptyList()),
            Shoe("Air Jordan", 11.5, "Nike", "These are the classic Air Jordan", emptyList()),
            Shoe("Air Jordan", 11.0, "Nike", "These are the classic Air Jordan", emptyList()),
            Shoe("Air Jordan", 10.5, "Nike", "These are the classic Air Jordan", emptyList()),
            Shoe("Air Jordan", 10.0, "Nike", "These are the classic Air Jordan", emptyList()),
            Shoe("Samba", 12.0, "Adidas", "The best soccer shoe ever", emptyList()),
            Shoe("Samba", 11.5, "Adidas", "The best soccer shoe ever", emptyList()),
            Shoe("Samba", 11.0, "Adidas", "The best soccer shoe ever", emptyList()),
            Shoe("Samba", 10.5, "Adidas", "The best soccer shoe ever", emptyList()),
            Shoe("Samba", 10.0, "Adidas", "The best soccer shoe ever", emptyList())
        )

        return movieList.toMutableList()
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        var shoe = Shoe(name, size, company, description, emptyList())
        _shoeList.value?.add(shoe)

    }
}
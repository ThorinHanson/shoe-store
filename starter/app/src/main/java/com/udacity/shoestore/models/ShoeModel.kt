package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoeModel: ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>(getMovies())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    var shoeName = MutableLiveData<String>("")

    var company = MutableLiveData<String>("")

    var size = MutableLiveData<String>("")

    var description = MutableLiveData<String>("")

    private val _wordAdded = MutableLiveData<Boolean>()
    val wordAdded: LiveData<Boolean>
    get() = _wordAdded

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

    private fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        _wordAdded.value = true
    }

    fun addShoeHandler() {
        var shoe = Shoe(
            this.shoeName.value!!.toString(),
                this.size.value!!.toDouble(),
                this.company.value!!.toString(),
                this.description.value!!.toString(),
                emptyList()
            )
        addShoe(shoe)
    }
}
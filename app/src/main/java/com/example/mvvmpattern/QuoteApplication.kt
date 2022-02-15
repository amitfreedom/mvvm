package com.example.mvvmpattern

import android.app.Application
import com.example.mvvmpattern.api.QuoteService
import com.example.mvvmpattern.api.RetrofitHelper
import com.example.mvvmpattern.db.QuoteDatabase
import com.example.mvvmpattern.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}
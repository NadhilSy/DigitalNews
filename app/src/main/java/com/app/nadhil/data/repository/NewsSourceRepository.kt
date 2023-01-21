package com.app.nadhil.data.repository

import com.app.nadhil.data.api.response.Source


interface NewsSourceRepository {
    suspend fun getByCategory(category: String): List<Source>
}
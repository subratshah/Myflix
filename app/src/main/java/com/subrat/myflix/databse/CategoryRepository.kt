package com.subrat.myflix.databse

import com.subrat.myflix.service.FlixterService
import com.subrat.myflix.util.networkBoundResource
import toCategories
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val api: FlixterService,
    private val db: CategoryDatabase
) {
    private val dao = db.dao()

    fun getCategories() = networkBoundResource(
        query = {
            dao.getCategories()
        }, fetch = {
            api.getUpcoming()
        },
        saveFetchResult = { response ->
            db.runInTransaction {
                dao.deleteAllCategories()
                dao.insertCategories(response.data.upcoming.toCategories())
            }
        }
    )
}
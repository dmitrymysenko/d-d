package dmitry.mysenko.clean.domain.categories.repository

import dmitry.mysenko.clean.domain.categories.models.CategoryItem
import dmitry.mysenko.clean.domain.response.ResultWrapper

interface CategoryRepository {

    suspend fun getCategoryItems(category: String, name: String = ""): ResultWrapper<List<CategoryItem>>
}
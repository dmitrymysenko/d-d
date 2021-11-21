package dmitry.mysenko.clean.domain.categories.usecases

import dmitry.mysenko.clean.domain.categories.models.CategoryItem
import dmitry.mysenko.clean.domain.categories.repository.CategoryRepository
import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class GetCategoryItemsUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    suspend fun execute(category: String, name: String = ""): ResultWrapper<List<CategoryItem>> {
        return categoryRepository.getCategoryItems(category, name)
    }
}
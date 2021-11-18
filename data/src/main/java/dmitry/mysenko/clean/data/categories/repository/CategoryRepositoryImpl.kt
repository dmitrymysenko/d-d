package dmitry.mysenko.clean.data.categories.repository

import dmitry.mysenko.clean.data.categories.converter.CategoryConverter
import dmitry.mysenko.clean.data.categories.datasource.remote.CategoriesRemoteDataSource
import dmitry.mysenko.clean.data.classes.converter.CharacterClassesConverter
import dmitry.mysenko.clean.data.classes.datasource.remote.CharacterClassesRemoteDataSource
import dmitry.mysenko.clean.domain.categories.models.CategoryItem
import dmitry.mysenko.clean.domain.categories.repository.CategoryRepository
import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoriesRemoteDataSource: CategoriesRemoteDataSource,
    private val converter: CategoryConverter
) : CategoryRepository {

    override suspend fun getCategoryItems(category: String): ResultWrapper<List<CategoryItem>> {
        return when (val response =
            categoriesRemoteDataSource.getAllCharacterClassesShort(category)) {
            is ResultWrapper.Success -> ResultWrapper.Success(response.value.results.map { remote ->
                converter.remoteCategoryShortToCategoryItem(
                    remote
                )
            })
            is ResultWrapper.GenericError -> response
        }
    }
}
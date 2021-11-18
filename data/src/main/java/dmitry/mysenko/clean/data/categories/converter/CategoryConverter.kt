package dmitry.mysenko.clean.data.categories.converter

import dmitry.mysenko.clean.data.categories.datasource.remote.models.RemoteCategoryShort
import dmitry.mysenko.clean.domain.categories.models.CategoryItem
import javax.inject.Inject

class CategoryConverter @Inject constructor() {

    fun remoteCategoryShortToCategoryItem(remoteCategoryShort: RemoteCategoryShort) =
        CategoryItem(
            index = remoteCategoryShort.index,
            name = remoteCategoryShort.name,
            url = remoteCategoryShort.url
        )
}
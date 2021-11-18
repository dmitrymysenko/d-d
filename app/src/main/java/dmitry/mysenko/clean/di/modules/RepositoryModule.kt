package dmitry.mysenko.clean.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dmitry.mysenko.clean.data.categories.repository.CategoryRepositoryImpl
import dmitry.mysenko.clean.data.classes.repository.CharacterClassesRepositoryImpl
import dmitry.mysenko.clean.data.races.repository.CharacterRacesRepositoryImpl
import dmitry.mysenko.clean.domain.categories.repository.CategoryRepository
import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository
import dmitry.mysenko.clean.domain.races.repository.CharacterRacesRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Binds
    abstract fun bindCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository

    @Binds
    abstract fun bindCharacterClassesRepository(
        characterClassesRepositoryImpl: CharacterClassesRepositoryImpl
    ): CharacterClassesRepository

    @Binds
    abstract fun bindCharacterRacesRepository(
        characterRacesRepositoryImpl: CharacterRacesRepositoryImpl
    ): CharacterRacesRepository
}
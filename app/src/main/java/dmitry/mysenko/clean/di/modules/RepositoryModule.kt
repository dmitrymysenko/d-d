package dmitry.mysenko.clean.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dmitry.mysenko.clean.data.classes.repository.CharacterClassesRepositoryImpl
import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Binds
    abstract fun bindCharacterClassesRepository(
        characterClassesRepositoryImpl: CharacterClassesRepositoryImpl
    ): CharacterClassesRepository
}
package dmitry.mysenko.clean.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dmitry.mysenko.clean.data.classes.datasource.remote.CharacterClassesService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkServicesModule {

    @Provides
    @Singleton
    fun provideCharacterClassesService(retrofit: Retrofit): CharacterClassesService =
        retrofit.create(CharacterClassesService::class.java)
}
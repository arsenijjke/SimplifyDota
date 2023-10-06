package app.arsenijjke.simplifydota.di.data.service

import android.content.Context
import app.arsenijjke.data.service.PreferenceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun providePreferencesService(@ApplicationContext context: Context): PreferenceService {
        return PreferenceService(context)
    }
}
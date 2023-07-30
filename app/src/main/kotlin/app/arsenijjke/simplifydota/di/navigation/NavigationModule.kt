package app.arsenijjke.simplifydota.di.navigation

import app.arsenijjke.navigation.impl.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object NavigationModule {

    @Provides
    fun provideNavigator(): NavigatorImpl = NavigatorImpl()
}
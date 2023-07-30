package app.arsenijjke.simplifydota.di.navigation

import app.arsenijjke.navigation.impl.NavigatorImpl
import app.arsenijjke.navigation.navigator.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Singleton
    @Binds
    fun bindAppNavigator(appNavigatorImpl: NavigatorImpl): Navigator
}

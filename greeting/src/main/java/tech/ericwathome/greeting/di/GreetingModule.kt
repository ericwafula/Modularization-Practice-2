package tech.ericwathome.greeting.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.ericwathome.greeting.preach.SpreadTheWord
import tech.ericwathome.greeting.preach.SpreadTheWordImpl

@Module
@InstallIn(SingletonComponent::class)
object GreetingModule {

    @Provides
    fun provideSpreadTheWord(): SpreadTheWord = SpreadTheWordImpl()

}
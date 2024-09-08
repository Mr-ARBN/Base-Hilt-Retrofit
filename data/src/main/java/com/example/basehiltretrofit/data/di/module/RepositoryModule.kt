package com.example.basehiltretrofit.data.di.module

import com.example.basehiltretrofit.data.source.remote.repository.TestRepo
import com.example.basehiltretrofit.data.source.remote.repository.TestRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    abstract fun provideTestRepository(testRepoImpl: TestRepoImpl): TestRepo
}

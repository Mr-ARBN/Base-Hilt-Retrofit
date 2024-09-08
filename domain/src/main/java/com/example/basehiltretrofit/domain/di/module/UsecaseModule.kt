package com.example.basehiltretrofit.domain.di.module

import com.example.basehiltretrofit.domain.use_case.TestUseCase
import com.example.basehiltretrofit.domain.use_case.TestUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UsecaseModule {
    @Binds
    abstract fun provideTestUseCase(testUseCaseImpl: TestUseCaseImpl): TestUseCase
}

package mr.arbn.basehiltretrofit.domain.di.module

import mr.arbn.basehiltretrofit.domain.use_case.TestUseCase
import mr.arbn.basehiltretrofit.domain.use_case.TestUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UseCaseModule {
    @Binds
    abstract fun provideTestUseCase(testUseCaseImpl: TestUseCaseImpl): TestUseCase
}

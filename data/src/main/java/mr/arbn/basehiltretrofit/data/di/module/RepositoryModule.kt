package mr.arbn.basehiltretrofit.data.di.module

import mr.arbn.basehiltretrofit.data.source.remote.repository.TestRemoteRepo
import mr.arbn.basehiltretrofit.data.source.remote.repository.TestRemoteRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    abstract fun provideTestRepository(testRepoImpl: TestRemoteRepoImpl): TestRemoteRepo
}
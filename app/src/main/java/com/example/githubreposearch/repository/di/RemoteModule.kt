package com.example.githubreposearch.repository.di

import com.apollographql.apollo.ApolloClient
import com.example.githubreposearch.repository.remote.GitHubReposRepository
import com.example.githubreposearch.repository.remote.GitHubReposRepositoryImpl
import com.example.githubreposearch.schedulers.BaseSchedulerProvider
import com.example.githubreposearch.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module(includes = [NetModule::class])
class RemoteModule {

    @Provides
    fun providesGitHubReposRepository(client: ApolloClient): GitHubReposRepository = GitHubReposRepositoryImpl(client)

    @Provides
    fun providesScheduler(): BaseSchedulerProvider = SchedulerProvider()
}
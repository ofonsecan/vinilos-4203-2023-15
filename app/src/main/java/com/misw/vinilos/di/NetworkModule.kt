package com.misw.vinilos.di

import com.misw.vinilos.data.remote.services.AlbumService
import com.misw.vinilos.data.remote.services.ArtistService
import com.misw.vinilos.data.remote.services.CollectorService
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3001")
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAlbumService(retrofit: Retrofit): AlbumService {
        return retrofit.create(AlbumService::class.java)
    }

    @Provides
    fun provideArtistService(retrofit: Retrofit): ArtistService {
        return retrofit.create(ArtistService::class.java)
    }

    @Provides
    fun provideCollectorService(retrofit: Retrofit): CollectorService {
        return retrofit.create(CollectorService::class.java)
    }
}
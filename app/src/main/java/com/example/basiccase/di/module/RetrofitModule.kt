package com.example.basiccase.di.module

import com.example.basiccase.api.CaseApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(ApplicationComponent::class)
open class RetrofitModule {

    val baseUrl: String = "http://www.google.com"

    val contentType = "application/json".toMediaType()


    @Provides
    @Singleton
    fun provideRetrofitJson(OkHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true

                }
                    .asConverterFactory(contentType)

            )
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideJsonApi(retrofit: Retrofit): CaseApi {
        return retrofit.create(CaseApi::class.java)
    }


    @Provides
    @Singleton
    fun provideOkHttp(builder: OkHttpClient.Builder): OkHttpClient {
        return builder.build()
    }

    @Provides
    @Singleton
    fun setLogLevel(): HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.HEADERS

    @Provides
    @Singleton
    fun setupOkHttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .also {
                        it.level = setLogLevel()
                    }
            )
            .followRedirects(true)
            .followSslRedirects(true)
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
    }
}
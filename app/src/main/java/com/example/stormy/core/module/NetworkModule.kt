package com.example.stormy.core.module

import com.example.stormy.core.model.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideApi(): Api =
        Api(baseUrl = "api.weatherapi.com/v1", key = "ec5020275ddb43258b785230222106")

    @Provides
    @Singleton
    fun provideKtorClient(): HttpClient {

        return HttpClient(OkHttp) {

            expectSuccess = true

            defaultRequest {
                host = provideApi().baseUrl
                url {
                    protocol = URLProtocol.HTTPS
                }
            }

            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

}
package com.example.stormy.core.base

import com.example.stormy.core.di.Api
import io.ktor.client.*
import javax.inject.Inject

abstract class BaseRemoteDataSource {


    @Inject
    lateinit var api: Api

    @Inject
    lateinit var client: HttpClient
}
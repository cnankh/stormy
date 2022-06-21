package com.example.stormy.core.base

import io.ktor.client.*
import javax.inject.Inject

abstract class BaseRemoteDataSource {
    @Inject
    lateinit var client: HttpClient
}
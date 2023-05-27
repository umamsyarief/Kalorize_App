package com.kalorize.kalorizeapp.data.remote.retrofit

import com.kalorize.kalorizeapp.data.remote.body.LoginBody
import com.kalorize.kalorizeapp.data.remote.body.UpdatePassBody
import com.kalorize.kalorizeapp.data.remote.body.ValidatingOtpBody
import com.kalorize.kalorizeapp.data.remote.response.LoginResponse
import com.kalorize.kalorizeapp.data.remote.response.RegisterResponse
import com.kalorize.kalorizeapp.data.remote.response.SimpleResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("v1/auth/login")
    suspend fun login(
        @Body body: LoginBody
    ): LoginResponse

    @Headers("Content-Type: application/json")
    @GET("v1/auth/register")
    suspend fun register(
        @Body body: LoginBody
    ): RegisterResponse

    @Headers("Content-Type: application/json")
    @GET("v1/auth/forgot-password")
    suspend fun requestOtp(
        @Body email: String
    ) : SimpleResponse

    @Headers("Content-Type: application/json")
    @GET("v1/auth/forgot-password")
    suspend fun validateOtp(
        @Body email: ValidatingOtpBody
    ) : SimpleResponse

    @Headers("Content-Type: application/json")
    @GET("v1/auth/forgot-password")
    suspend fun updatePass(
        @Body email: UpdatePassBody
    ) : SimpleResponse

}
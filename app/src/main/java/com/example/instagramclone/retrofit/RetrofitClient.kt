package com.example.instagramclone.retrofit

import android.util.Log
import com.example.instagramclone.utils.Constants.TAG
import com.example.instagramclone.utils.isJsonArray
import com.example.instagramclone.utils.isJsonObject
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.concurrent.TimeUnit

//object -> 싱글턴
object RetrofitClient {
    // 래트로핏 클라이언트 선언

    private lateinit var retrofitClient: Retrofit

    //레트로핏 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "getClient: ")


        if (retrofitClient == null) {
            val client = OkHttpClient.Builder()

            val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    when {
                        message.isJsonObject() ->
                            Log.d(TAG, JSONObject(message).toString(4))
                        message.isJsonArray() ->
                            Log.d(TAG, JSONObject(message).toString(4))
                        else ->
                            try {
                                Log.d(TAG, JSONObject(message).toString(4))
                            } catch (e: Exception) {
                                Log.d(TAG, "log: $message")
                            }
                    }
                }
            })

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            client.addInterceptor(loggingInterceptor)
    
            //기본 파라미터 인터셉터
//            val baseParameterInterceptor: Interceptor = (object: Interceptor{
//                override fun intercept(chain: Interceptor.Chain): Response {
//                    val originalRequest = chain.request()
//
//                    //쿼리 파라미터 추가하기
//                    val addedUrl = originalRequest.url.newBuilder().addQueryParameter("test", "test").build()
//
//                    val finalRequest = originalRequest.newBuilder().url(addedUrl).method(originalRequest.method, originalRequest.body).build()
//                    return chain.proceed(finalRequest)
//                }
//            })
//            client.addInterceptor(baseParameterInterceptor)

            // 커넥션 타임아웃
            client.connectTimeout(10, TimeUnit.SECONDS)
            client.readTimeout(10, TimeUnit.SECONDS)
            client.writeTimeout(10, TimeUnit.SECONDS)
            client.retryOnConnectionFailure(true)

            //레트로핏 빌더 패턴
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()

        }

        return retrofitClient
    }
}
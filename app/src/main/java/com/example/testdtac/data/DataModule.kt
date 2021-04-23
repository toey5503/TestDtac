package com.example.testdtac.data


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class DataModule {

    companion object {
        private var retrofit: Retrofit? = null
        private var gson: Gson? = null
        private const val BASE_URL = "https://randomuser.me"

        @Synchronized
        private fun getInstance(): Retrofit? {
/*            if (retrofit == null) {
                if (gson == null) {*/
            gson = GsonBuilder().setLenient().create()
            //               }
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson!!))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
            //           }
            return retrofit
        }

        fun instance(): APIService? {
            return getInstance()!!.create(APIService::class.java)
        }
    }


}
package gun0912.ted.enumretrofit.api

import gun0912.ted.enumretrofit.enums.User
import gun0912.ted.enumretrofit.model.GitHubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface ApiService {
    @Headers("Authorization: token $TOKEN")
    @GET("users/{userName}")
    fun getUser(@Path("userName") user: User): Call<GitHubUser>

    @Headers("Authorization: token $TOKEN")
    @GET("users/{userName}")
    fun getUserLegacy(@Path("userName") userName: String): Call<GitHubUser>

    companion object {
        const val TOKEN = "PLACE_YOUR_TOKEN"
    }
}

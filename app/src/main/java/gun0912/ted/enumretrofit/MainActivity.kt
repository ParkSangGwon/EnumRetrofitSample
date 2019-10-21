package gun0912.ted.enumretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import gun0912.ted.enumretrofit.api.ApiService.Companion.TOKEN
import gun0912.ted.enumretrofit.api.createApiService
import gun0912.ted.enumretrofit.enums.LegacyUser
import gun0912.ted.enumretrofit.enums.User
import gun0912.ted.enumretrofit.model.GitHubUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkApiToken()
        val apiService = createApiService()

        apiService.getUser(User.TED).enqueue(object : Callback<GitHubUser?> {
            override fun onFailure(call: Call<GitHubUser?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<GitHubUser?>, response: Response<GitHubUser?>) {
                Log.d("ted", "${response.body()}")
            }
        })

        apiService.getUserLegacy(LegacyUser.TED.value).enqueue(object : Callback<GitHubUser?> {
            override fun onFailure(call: Call<GitHubUser?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<GitHubUser?>, response: Response<GitHubUser?>) {
                Log.d("ted", "${response.body()}")
            }
        })
    }

    private fun checkApiToken() {

        if (TOKEN == "PLACE_YOUR_TOKEN") {
            throw IllegalAccessError(
                "You have to change your ApiService.TOKEN"
                        + "(ApiService의 TOKEN정보를 입력해야 API결과를 받을 수 있습니다)"
                        + "\nhttps://docs.cachethq.io/docs/github-oauth-token"
            )
        }
    }
}


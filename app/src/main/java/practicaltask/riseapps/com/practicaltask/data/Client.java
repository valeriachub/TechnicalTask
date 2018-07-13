package practicaltask.riseapps.com.practicaltask.data;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private final String ENDPOINT = "https://restcountries.eu/rest/v2/";
    private Api api;
    private static Client instance;

    private static Client getInstance() {
        if (instance != null) {
            return instance;
        }
        return new Client();
    }

    public static Api getAPI() {
        return getInstance().api;
    }

    private Client() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }
}

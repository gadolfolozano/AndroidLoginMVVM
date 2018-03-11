package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by adolfo on 10/03/18.
 */

public class ApiClient {
    private static final String BASE_URL = "http://104.131.189.211:8085/";

    private ApiClient() {
        throw new IllegalStateException("Utility class");
    }

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit != null) {
            return retrofit;
        }

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).cache(null).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
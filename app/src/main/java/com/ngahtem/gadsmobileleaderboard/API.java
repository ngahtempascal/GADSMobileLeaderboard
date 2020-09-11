package com.ngahtem.gadsmobileleaderboard;

import android.content.Context;

import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class API {

    private final Api api;

    public API() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public API(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public void getTopLearnersHours(Context context,
                        RequestListener<List<LearnerHourModel>> listener) {
        api.getTopLearnersHours().enqueue(new
                ApiCallback<>(context, listener));
    }

    public void getTopSkills(Context context, RequestListener<List<SkillsModel>> listener){
        api.getTopSkills().enqueue(new ApiCallback<>(context, listener));
    }

    public interface Api {
        @GET("/api/hours")
        Call<List<LearnerHourModel>> getTopLearnersHours();

        @GET("/api/skilliq")
        Call<List<SkillsModel>> getTopSkills();

        @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
        @FormUrlEncoded
        Call<JsonElement> submitProject(@Field("entry.1824927963") String name,
                                        @Field("entry.1877115667") String lastname,
                                        @Field("entry.2006916086") String email,
                                        @Field("entry.284483984") String projectLink);
    }

    public interface RequestListener<T> {
        void onSuccess(T response);

        void onResponse();

        void onError();
    }

    public class ApiCallback<T> implements Callback<T> {
        protected RequestListener<T> listener;
//        protected Context context;

        public ApiCallback(Context context, RequestListener<T> listener) {
            this.listener = listener;
//            this.context = context;
        }

        @Override
        public void onResponse(Call<T> call, retrofit2.Response<T> response) {
            listener.onResponse();
            listener.onSuccess(response.body());
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            listener.onResponse();
            listener.onError();
        }
    }
}

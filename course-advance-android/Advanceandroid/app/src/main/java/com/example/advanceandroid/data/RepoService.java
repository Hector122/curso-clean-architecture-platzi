package com.example.advanceandroid.data;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();

    //Single:RX Is a String that want only met onw item or error. better git for network request that observer.

}

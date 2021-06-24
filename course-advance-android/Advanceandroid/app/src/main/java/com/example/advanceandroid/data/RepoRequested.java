package com.example.advanceandroid.data;

import com.example.advanceandroid.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RepoRequested {
 private final RepoService repoService;

    @Inject
    public RepoRequested(RepoService repoService) {
        this.repoService = repoService;
    }

    public Single<List<Repo>> getTrendingRepos(){
        return  repoService.getTrendingRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }
}

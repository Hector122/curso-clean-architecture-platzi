package com.example.advanceandroid.trending;

import com.example.advanceandroid.data.RepoRequested;
import com.example.advanceandroid.di.ScreenScope;

import javax.inject.Inject;

@ScreenScope
public class TrendingRepoPresenter {
    private TrendingResponseViewModel viewModel;
    private RepoRequested repoRequested;

    @Inject //Constructor injector.
    public TrendingRepoPresenter(TrendingResponseViewModel viewModel, RepoRequested repoRequested) {
        this.viewModel = viewModel;
        this.repoRequested = repoRequested;
        loadRepos();
    }

    private void loadRepos(){
        repoRequested.getTrendingRepos()
                .doOnSubscribe( dummy -> viewModel.loadingUpdate().accept(true))
                .doOnEvent((data, throwable) -> viewModel.loadingUpdate().accept(true))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }
}

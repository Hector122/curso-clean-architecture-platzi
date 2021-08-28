package com.example.advanceandroid.trending;

import com.example.advanceandroid.R;
import com.example.advanceandroid.data.TrendingReposResponse;
import com.example.advanceandroid.testutils.TestUtils;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.Collections;

import io.reactivex.observers.TestObserver;

public class TrendingResponseViewModelTest extends TestCase {

    private TrendingResponseViewModel viewModel;

    public void setUp() {
        viewModel = new TrendingResponseViewModel();
    }

    public void testLoading() throws Exception {
        TestObserver<Boolean> loadingObserver = viewModel.loading().test();
        viewModel.loadingUpdate().accept(true);
        viewModel.loadingUpdate().accept(false);

        loadingObserver.assertValues(true, false);
    }


    public void testRepos() throws Exception {
        TrendingReposResponse response = TestUtils.loadJson("./mock/get_trending_repo", TrendingReposResponse.class);
        viewModel.reposUpdated().accept(response.repos());

        viewModel.repos().test().assertValue(response.repos());

    }

    public void testError() throws Exception{
        TestObserver<Integer> errorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.reposUpdated().accept(Collections.emptyList());

        errorObserver.assertValues(R.string.api_error_repos, -1);

    }
}
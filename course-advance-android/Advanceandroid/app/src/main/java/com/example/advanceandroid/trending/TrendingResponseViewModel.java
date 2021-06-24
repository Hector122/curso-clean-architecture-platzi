package com.example.advanceandroid.trending;

import com.example.advanceandroid.R;
import com.example.advanceandroid.di.ScreenScope;
import com.example.advanceandroid.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
class TrendingResponseViewModel {
    //Behavior Relay = Transmision de comportamiento.
    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    TrendingResponseViewModel() {
    }

    Observable<List<Repo>> repos() {
        return reposRelay;
    }

    Observable<Integer> error() {
        return errorRelay;
    }

    Observable<Boolean> loading() {
        return loadingRelay;
    }


    Consumer<List<Repo>> reposUpdated() {
        errorRelay.accept(-1);
        return reposRelay;
    }

    Consumer<Boolean> loadingUpdate() {
        return loadingRelay;
    }


    Consumer<Throwable> onError() {
        return Throwable -> {
            Timber.e(Throwable, "Repo error");
            errorRelay.accept(R.string.api_error_repos);
        };
    }
}

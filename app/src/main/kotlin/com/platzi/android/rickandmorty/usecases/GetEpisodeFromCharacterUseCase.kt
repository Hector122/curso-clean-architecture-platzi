package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.data.EpisodeRepository
import com.platzi.android.rickandmorty.domain.Episode
import io.reactivex.Single

class GetEpisodeFromCharacterUseCase(
    //private val episodeRequest: EpisodeRequest
    private val episodeRepository: EpisodeRepository
) {

//    fun invoke(episodeUrlList: List<String>): Single<List<Episode>> = Observable.fromIterable(episodeUrlList)
//        .flatMap { episode: String ->
//            episodeRequest.baseUrl = episode
//            episodeRequest
//                .getService<EpisodeService>()
//                .getEpisode()
//                .map(EpisodeServer::toEpisodeDomain)
//                .toObservable()
//        }
//        .toList()
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribeOn(Schedulers.io())

    fun invoke(episodeUrlList: List<String>): Single<List<Episode>> =
        episodeRepository.getEpisodeFromCharacter(episodeUrlList)

}
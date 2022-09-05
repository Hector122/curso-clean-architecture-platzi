package com.platzi.android.rickandmorty.domain

data class CharacterOld(
    val id: Int,
    val name: String,
    val image: String?,
    val gender: String,
    val species: String,
    val status: String,
    val origin: OriginOld,
    val location: LocationOld,
    val episodeList: List<String>
)

data class LocationOld(
    val name: String,
    val url: String
)

data class OriginOld(
    val name: String,
    val url: String
)

data class EpisodeOld(
    val id: Int,
    val name: String
)


package com.platzi.android.rickandmorty.databasemanager;

import java.lang.System;

@androidx.room.Entity(tableName = "character")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u000bH\u00c6\u0003J\t\u00104\u001a\u00020\rH\u00c6\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u00c6\u0003Jk\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u00c6\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020\u0003H\u00d6\u0001J\t\u0010;\u001a\u00020\u0005H\u00d6\u0001R$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018\u00a8\u0006<"}, d2 = {"Lcom/platzi/android/rickandmorty/databasemanager/CharacterEntity;", "", "id", "", "name", "", "image", "gender", "species", "status", "origin", "Lcom/platzi/android/rickandmorty/databasemanager/OriginEntity;", "location", "Lcom/platzi/android/rickandmorty/databasemanager/LocationEntity;", "episodeList", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/platzi/android/rickandmorty/databasemanager/OriginEntity;Lcom/platzi/android/rickandmorty/databasemanager/LocationEntity;Ljava/util/List;)V", "getEpisodeList", "()Ljava/util/List;", "setEpisodeList", "(Ljava/util/List;)V", "getGender", "()Ljava/lang/String;", "setGender", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getImage", "setImage", "getLocation", "()Lcom/platzi/android/rickandmorty/databasemanager/LocationEntity;", "setLocation", "(Lcom/platzi/android/rickandmorty/databasemanager/LocationEntity;)V", "getName", "setName", "getOrigin", "()Lcom/platzi/android/rickandmorty/databasemanager/OriginEntity;", "setOrigin", "(Lcom/platzi/android/rickandmorty/databasemanager/OriginEntity;)V", "getSpecies", "setSpecies", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "databasemanager_debug"})
public final class CharacterEntity {
    @androidx.room.ColumnInfo(name = "character_id")
    @androidx.room.PrimaryKey()
    private int id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "character_name")
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "character_image")
    private java.lang.String image;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "character_gender")
    private java.lang.String gender;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "character_species")
    private java.lang.String species;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "character_status")
    private java.lang.String status;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private com.platzi.android.rickandmorty.databasemanager.OriginEntity origin;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private com.platzi.android.rickandmorty.databasemanager.LocationEntity location;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "character_episode_list")
    private java.util.List<java.lang.String> episodeList;
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGender() {
        return null;
    }
    
    public final void setGender(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSpecies() {
        return null;
    }
    
    public final void setSpecies(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.platzi.android.rickandmorty.databasemanager.OriginEntity getOrigin() {
        return null;
    }
    
    public final void setOrigin(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.databasemanager.OriginEntity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.platzi.android.rickandmorty.databasemanager.LocationEntity getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.databasemanager.LocationEntity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getEpisodeList() {
        return null;
    }
    
    public final void setEpisodeList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    public CharacterEntity(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String gender, @org.jetbrains.annotations.NotNull()
    java.lang.String species, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.databasemanager.OriginEntity origin, @org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.databasemanager.LocationEntity location, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> episodeList) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.platzi.android.rickandmorty.databasemanager.OriginEntity component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.platzi.android.rickandmorty.databasemanager.LocationEntity component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.platzi.android.rickandmorty.databasemanager.CharacterEntity copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String gender, @org.jetbrains.annotations.NotNull()
    java.lang.String species, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.databasemanager.OriginEntity origin, @org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.databasemanager.LocationEntity location, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> episodeList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}
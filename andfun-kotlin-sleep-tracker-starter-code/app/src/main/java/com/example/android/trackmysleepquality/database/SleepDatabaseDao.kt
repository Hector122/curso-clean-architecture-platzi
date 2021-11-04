/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDatabaseDao {
    
    @Insert
  suspend  fun insert(sleepNight: SleepNight)
    
    /**
     *  When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param night new value to write
     */
    @Update
    suspend  fun update(sleepNight: SleepNight)
    
    /**
     * Selects and returns the row that matches the supplied start time, which is our key.
     *
     * @param key startTimeMilli to match
     */
    @Query("SELECT * FROM daily_sleep_quality_table WHERE nightId= :key")
    suspend fun get(key: Long): SleepNight?
    
    @Query("DELETE FROM daily_sleep_quality_table")
    suspend fun clear()
    
    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in descending order.
     */
    
    //Room keeps this LiveData updated for us, and we don't have to specify an observer for it.
    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
      fun getAllNights(): LiveData<List<SleepNight>>
    
    /**
     * Selects and returns the latest night.
     */
    //returned SleepNight nullable, so that it can handle if the table is empty.
    @Query("SELECT * FROM DAILY_SLEEP_QUALITY_TABLE  ORDER BY nightId DESC LIMIT 1")
    suspend fun getTonight(): SleepNight?
    
}

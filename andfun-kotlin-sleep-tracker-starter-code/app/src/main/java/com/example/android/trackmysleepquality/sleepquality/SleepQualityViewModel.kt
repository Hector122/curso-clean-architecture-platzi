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

package com.example.android.trackmysleepquality.sleepquality

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import kotlinx.coroutines.*

/**
 * ViewModel for SleepQualityFragment.
 *
 * @param sleepNightKey The key of the current night we are working on.
 */
class SleepQualityViewModel(private val sleepNightKey: Long, val databaseDao: SleepDatabaseDao) :
    ViewModel() {
    
    
   // val viewModelJob = Job()
    //val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    
    //Variable that tells the fragment whether it should navigate to [SleepTrackerFragment].
    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()
    val navigateToSleepTracker: LiveData<Boolean?> get() = _navigateToSleepTracker
    
    
    //Call this immediately after navigating to [SleepTrackerFragment]
    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }
    
    
    fun onSetSleepQuality(quality: Int) {
        viewModelScope.launch {
            val tonight = databaseDao.get(sleepNightKey) ?: return@launch
            tonight.sleepQuality = quality
            databaseDao.update(tonight)
    
            // Setting this state variable to true will alert the observer and trigger navigation.
            _navigateToSleepTracker.value = true
        }

//        uiScope.launch {
//            withContext(Dispatchers.IO){
//                val tonight = databaseDao.get(sleepNightKey) ?: return@withContext
//                tonight.sleepQuality = quality
//
//                databaseDao.update(tonight)
//            }
//
//            _navigateToSleepTracker.value = true
//        }
    }
    
    
    override fun onCleared() {
        super.onCleared()
        
        viewModelScope.launch {
            databaseDao.clear()
        }
    }
    
}
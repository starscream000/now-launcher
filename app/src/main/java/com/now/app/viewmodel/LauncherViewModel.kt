package com.now.app.viewmodel


import android.app.Application
import android.content.pm.PackageManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.now.app.data.model.InstalledApp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LauncherViewModel(application: Application) : AndroidViewModel(application) {

    private val _apps = MutableStateFlow<List<InstalledApp>>(emptyList())
    val apps: StateFlow<List<InstalledApp>> = _apps

    init {
        loadInstalledApps()
    }

    private fun loadInstalledApps() {
        viewModelScope.launch {
            val pm = getApplication<Application>().packageManager
            val intent = pm.getLaunchIntentForPackage("android.intent.action.MAIN")
            val apps = intent?.let {
                pm.queryIntentActivities(it, PackageManager.MATCH_ALL)
                    .map {
                        InstalledApp(
                            name = it.loadLabel(pm).toString(),
                            packageName = it.activityInfo.packageName,
                            icon = it.loadIcon(pm)
                        )
                    }
            }
            if (apps != null) {
                _apps.value = apps.sortedBy { it.name.lowercase() }
            }
        }
    }
}
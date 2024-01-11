package com.coderGtm.yantra.commands.openf

import android.content.Context
import android.content.pm.LauncherApps
import android.os.Build
import com.coderGtm.yantra.models.AppBlock

fun launchApp(command: Command, app: AppBlock) {
    val launcher = command.terminal.activity.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
    val component = launcher.getActivityList(app.packageName, app.user).first().componentName
    try {
        launcher.startMainActivity(component, app.user, null, null)
        command.output(":: Rendering Display to ${Build.MANUFACTURER} ${Build.MODEL}...")
    } catch (e: Exception) {
        command.output("Failed to open app :(", command.terminal.theme.errorTextColor)
    }
}
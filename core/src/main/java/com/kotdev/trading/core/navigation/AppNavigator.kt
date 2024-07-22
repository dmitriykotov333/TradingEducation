package com.kotdev.trading.core.navigation

import androidx.navigation.NavHostController
import com.kotdev.trading.core.navigation.extensions.popUpToTop
import java.util.concurrent.ConcurrentHashMap

object AppNavigator {

    var graph = ConcurrentHashMap<String, NavHostController>()

    fun addGraph(name: String, controller: NavHostController) {
        graph[name] = controller
    }
    fun back(controller: AppGraph) {
        graph.getValue(controller.route).popBackStack()
    }
    fun navigateWithClearPreviousScreen(controller: AppGraph, to: AppGraph) {
        with(graph.getValue(controller.route)) {
            navigate(to.route) {
                popUpToTop(this@with)
            }
        }
    }

    fun push(controller: AppGraph, to: String) {
        graph.getValue(controller.route).run {
            navigate(to) {
                popUpTo(to) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    fun push(controller: AppGraph, to: AppGraph) {
        graph.getValue(controller.route).run {
            navigate(to.route) {
                popUpTo(to.route) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }
}
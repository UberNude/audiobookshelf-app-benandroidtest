package com.audiobookshelf.app.device

import android.util.Log
import com.audiobookshelf.app.data.DbManager
import com.audiobookshelf.app.data.DeviceData
import com.audiobookshelf.app.data.ServerConnectionConfig

object DeviceManager {
  val tag = "DeviceManager"
  val dbManager:DbManager = DbManager()
  var deviceData:DeviceData = dbManager.getDeviceData()
  var serverConnectionConfig: ServerConnectionConfig? = null

  val serverAddress get() = serverConnectionConfig?.address ?: ""
  val token get() = serverConnectionConfig?.token ?: ""

  init {
    Log.d(tag, "Device Manager Singleton invoked")
  }

  fun getBase64Id(id:String):String {
    return android.util.Base64.encodeToString(id.toByteArray(), android.util.Base64.DEFAULT)
  }
}
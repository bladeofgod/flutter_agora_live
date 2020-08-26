/*
* Author : LiJiqqi
* Date : 2020/8/26
*/

import 'dart:io';

import 'package:flutter/services.dart';

const String kChannelName = 'agora_live_plugin';

class NativeMethodInvoker{

  static const MethodChannel _channel = const MethodChannel(kChannelName);

  static const String kLivePage = 'live_page';

  static NativeMethodInvoker _singleton;

  static NativeMethodInvoker getInstance(){
    if(_singleton == null){
      _singleton = new NativeMethodInvoker._();
    }
    return _singleton;
  }

  NativeMethodInvoker._();


  ///
  goLivePage()async{
    if(Platform.isAndroid){
      await _channel.invokeMethod(kLivePage);
    }
  }

}
























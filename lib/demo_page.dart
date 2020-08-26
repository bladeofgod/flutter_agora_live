/*
* Author : LiJiqqi
* Date : 2020/8/25
*/


import 'package:flutter/material.dart';
import 'package:permission_handler/permission_handler.dart';
import 'native_method_invoker.dart';

class DemoPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return DemoPageState();
  }

}

class DemoPageState extends State<DemoPage> {

  @override
  void initState() {
    requestPermission();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    return Material(
      child: Container(
        width: size.width,height: size.height,
        color: Colors.white,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            RaisedButton(
              child: Text('go live page'),
              onPressed: (){
                NativeMethodInvoker.getInstance().goLivePage();
              },
            ),
          ],
        ),

      ),
    );
  }

  void requestPermission() async{
    await <Permission>[
      Permission.camera,Permission.microphone,Permission.storage,
//      Permission.speech,
//      Permission.contacts,Permission.phone
    ].request();
  }
}




















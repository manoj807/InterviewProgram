package com.valleytech.interviewprogram.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;



       //Looper: A Looper is a class in Android that manages a thread's message queue and dispatches messages to the appropriate Handler. It continuously loops through the message queue, processing messages one by one. Each thread can have at most one Looper, and it must be prepared using Looper.prepare() before creating a Handler.
       // Handler: A Handler is a utility class used to send and process Message or Runnable objects associated with a thread's Looper. It allows communication between threads by posting tasks or messages to the thread's message queue. The Handler processes these messages in its handleMessage() method.
        //Message Queue: A MessageQueue is a data structure that holds messages and tasks for a thread. It is managed by the Looper and is responsible for queuing messages until they are processed. The MessageQueue operates in a FIFO (First In, First Out) manner.

    //In Android, the Handler sends messages to the MessageQueue. When you call methods like sendMessage() or post() on a Handler, it places the Message or Runnable into the MessageQueue associated with the thread's Looper. The Looper then processes these messages sequentially.
public class WorkedThread extends Thread
{
    Handler mainHandler;
    public  WorkedThread(String name, Handler mainHandler)
    {
        super(name);
        this.mainHandler = mainHandler;
    }

    Handler handler;

    @Override
    public void run() {

        Looper.prepare();
         handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(android.os.Message msg) {
                // Handle messages here
                System.out.println("workedthread" + getName() + ": " + msg.obj);
                Message message = Message.obtain();
                message.obj=msg.obj+"hhhhhhh";
                mainHandler.sendMessage(message);

            }
        };

        Looper.loop();
      }

    public void  addTask(int i) {
          Message message = Message.obtain();
          message.obj = i;
         handler.sendMessage(message);
    }
}

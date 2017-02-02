package com.android.myandroidtuts;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akanksha on 11/1/17.
 */

public class MainListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        new FetchDbAsyncTask().execute();
    }

    private void initList(List<Topic> topics) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new TopicsListAdapter(MainListActivity.this, topics));
    }


    /**
     * Fetch from Db
     */
    private class FetchDbAsyncTask extends AsyncTask<Void, Void, List<Topic>> {
        @Override
        protected List<Topic> doInBackground(Void... params) {
            List<Topic> topics = new ArrayList<>();
            topics.add(new Topic(1, "Framework", "<font color='blue'>React Native</font><br>comes from the stables of renowned Facebook<br><br>" +
                    "<font color='blue'>Corona SDK</font><br>(Games)<br>easy to use even for novice and new developers thanks to its quick and effortless adaptation feature<br><br>" +
                    "<font color='blue'>PhoneGap</font><br>(Html,CSS,JS)<br>PhoneGap allows you to make and create with the technologies you love to use<br><br>" +
                    "<font color='blue'>Xamarin</font><br>(C#)<br><br>" +
                    "<font color='blue'>Sencha Space</font><br>(JS, HTML5)<br>(Secure business apps)<br>a huge upgrade from the first version; the platform is considered very efficient by developers<br><br>" +
                    "<font color='blue'>Titanium SDK - Appcelerator</font><br>(JS)<br>use the framework to create apps with the help of only one JavaScript base<br><br>" +
                    "<font color='blue'>Basic4Android - RAD tool</font><br>(Visual Basic)<br><br>" +
                    "<font color='blue'>JQuery Mobile</font><br>entirely based upon the popular jQuery, but it is a lightweight tool<br><br>" +
                    "<font color='blue'>Dojo</font><br>(HTML5,JS)<br><br>" +
                    "<font color='blue'>Sproutcore</font><br><br>" +
                    "<font color='blue'>Theappbuilder</font><br>regarded as the world’s leading enterprise mobile application platform<br><br>" +
                    "<font color='blue'>DHTMLX Touch</font><br><br>" +
                    "<font color='blue'>NativeScript</font><br>it offers cross-platform code sharing; hence, you can use it for iOS as well<br><br>" +
                    "<font color='blue'>Mobile Angular UI</font><br>the framework combines both the Angular JS and the slightly changed Twitter’s Bootstrap<br><br>" +
                    "<font color='blue'>MoSync SDK</font><br>with it, you can develop applications with one single code base<br><br>"));
            topics.add(new Topic(2, "1. Architecture", "<font color='blue'>1. Application</font><br>Native and third party android apps<br><br>" +
                    "<font color='blue'>2. Application Framework</font><br>Activity Manager, Window Manager, Notification Manager, View System, XMPP Service, Location Manager, Package Manager, Resource Manager, Content Providers<br><br>" +
                    "<font color='blue'>3. Libraries</font><br>SQLITE, WebKit, Open GL ES, Free Type, Surface Manager, Media framework, SSL, SGL, libc<br>3. Android Runtime<br>Core Libraries, DVM<br><br>" +
                    "<font color='blue'>4. Linux Kernel</font><br>Display Driver, Wifi Driver, Audio Drivers, Binder(IPC) Drivers, Bluetooth Driver, Camera Driver, Power Management, Process Management, Memory Management, Flash Memory Driver<br><br>" +
                    "http://www.techotopia.com/index.php/An_Overview_of_the_Android_Architecture"));
            topics.add(new Topic(3, "Different types of storage", "Shared Preferences<br>" +
                    "SQLITE/ORM<br>" +
                    "Content provider<br>" +
                    "File(Internal/External)<br>" +
                    "Cloud"));
            topics.add(new Topic(4, "Process and Thread of components", ""));
            topics.add(new Topic(5, "Looper Vs Message Queue Vs Handler", ""));
            topics.add(new Topic(6, "Advantages and disadvantages", ""));
            topics.add(new Topic(7, "Handling of super in onCreate", ""));
            topics.add(new Topic(8, "Conversion of java to dex process", "DVM vs JVM<br>1. DVM is Register based which is designed to run on low memory, uses its own byte code and runs .Dex file. JVM is Stack based which uses java byte code and runs .class file having JIT.<br>" +
                    "2. Java source code is compiled by the Java compiler into .class files. Then the dx (dexer) tool, part of the Android SDK processes the .class files into a file format called DEX that contains Dalvik bytecode. The dx tool eliminate all the redundant information that is present in the classes. In DEX all the classes of the application are packed into one file. DVM has been designed so that a device can run multiple instances of the VM efficiently.<br>" +
                    "3. stack-based machines must use instructions to load data on the stack and manipulate that data, and, thus, require more instructions than register machines to implement the same high level code, but the instructions in a register machine must encode the source and destination registers and, therefore, tend to be larger.<br>" +
                    "4. Both use a VM code model. However, the DVM uses register-based opcodes that are comparable to the register-based bytecode instructions that most of the target platforms already execute. This includes architectures such as those available from ARM and MIPS and the x86-compatible architectures from Intel, AMD, and VIA Technologies.<br>" +
                    "Google developed Android and chose DVM for several reasons. First, there were licensing issues with most JVMs. Next, the DVM should be more efficient in terms of memory usage and performance on a register-based machine. DVM is also supposed to be more efficient when running multiple instances of the DVM. Applications are given their own instance. Hence, multiple active applications require multiple DVM instances. Like most Java implementations, the DVM has an automatic garbage collector.<br><br>" +
                    "AAPT(Android Asset Packaging Tool)<br>This tool is part of the SDK (and build system) and allows you to view, create, and update Zip-compatible archives (zip, jar, apk). It can also compile resources into binary assets.<br><br>" +
                    "SDK(software development kit)<br>enables developers to create applications for the Android platform. The Android SDK includes sample projects with source code, development tools, an emulator, and required libraries to build Android applications.<br>" +
                    "DDMS(Dalvik Debug Monitor Service)<br>debugging tool used in the Android platform. The Dalvik Debug Monitor Service is downloaded as part of the Android SDK. Some of the services provided by the DDMS are port forwarding, on-device screen capture, on-device thread and heap monitoring, and radio state information.<br>" +
                    "ADB(Android Debug Bridge)<br>client-server program used in Android application development. The Android Debug-Bridge is part of the Android SDK and is made up of three components: a client, a daemon, and a server. It is used to manage either an emulator instance or an actual Android device." +
                    "AIDL(Android Interface Definition Language)<br>similar to other IDLs you might have worked with. It allows you to define the programming interface that both the client and service agree upon in order to communicate with each other using interprocess communication (IPC).<br>" +
                    "APK(Android application package)<br>package file format used by the Android operating system for distribution and installation of mobile apps and middleware. APK files are analogous to other software packages such as APPX in Microsoft Windows or Deb packages in Debian-based operating systems like Ubuntu.<br>" +
                    "ADT(Android Development Tools)<br>Although the SDK can be used to write Android programs in the command prompt, the most common method is by using an integrated development environment (IDE). The recommended IDE is Eclipse with the Android Development Tools (ADT) plug-in. However, other IDEs, such as NetBeans or IntelliJ, will also work.<br>" +
                    "AVD(Android Virtual Device )<br>is an emulator configuration that lets you model an actual device by defining hardware and software options to be emulated by the Android Emulator.<br><br>"));
            topics.add(new Topic(9, "Tools", ""));
            topics.add(new Topic(10, "Stock android Vs Cyanogen Mod", "Cyanogen OS is a version of Android that’s been modified to include additional functionality."));
            topics.add(new Topic(11, "Android system handling", "Linux OS<br>" +
                    "apps<br>" +
                    "shared preferences<br>" +
                    "database<br>" +
                    "datatypes"));
            topics.add(new Topic(12, "Features across various android versions", ""));
            topics.add(new Topic(13, "Nifty features", ""));
            topics.add(new Topic(14, "Diff types of context", "Activity.getApplicationContext(): Returns the context for the entire application (the process all the Activities are running inside of). Use this instead of the current Activity context if you need a context tied to the lifecycle of the entire application, not just the current Activity.<br>" +
                    "activity/this<br>" +
                    "ContextWrapper.getBaseContext(): If you need access to a Context from within another context, you use a ContextWrapper. The Context referred to from inside that ContextWrapper is accessed via getBaseContext().<br>" +
                    "View.getContext(): Returns the context the view is currently running in. Usually the currently active Activity.<br>"));
            topics.add(new Topic(15, "Memory", "Memory Leak example<br>" +
                    "Type blinder vs ashmen"));
            topics.add(new Topic(16, "ANR", "example"));
            topics.add(new Topic(17, "diff types of Intent", "Intent<br>" +
                    "Intent - is a message passing mechanism between components of android, except for Content Provider. You can use intent to start any component.<br>" +
                    "<br>" +
                    "Sticky Intent - Sticks with android, for future broad cast listeners. For example if BATTERY_LOW event occurs then that intent will be stick with android so that if any future user requested for BATTER_LOW, it will be fired;<br>" +
                    "<br>" +
                    "Pending Intent - If you want some one to perform any Intent operation at future point of time on behalf of you, then we will use Pending Intent.<br>" +
                    "Implicit Intents do not directly specify the Android components which should be called , it only specifies action to be performed.An Uri can be used with the implicit intent to specify data type.<br>" +
                    "Explicit intents are used in the application itself wherein one activity can switch to other activty...Example Intent intent = new Intent(this,Target.class); this causes switching of activity from current context to the target activity. Explicit Intents can also be used to pass data to other activity using putExtra method and retrieved by target activity by getIntent().getExtras() methods..."));
            topics.add(new Topic(18, "Activity", "Lifecycle<br>onCreate()\tonStart()\tonResume()\tonPause()\tonStop()\tonDestroy()\t" +
                    "finish vs onBackPressed<br>First of all Hardware back button itself calls finish() method. If you are defining onBackPressed() Method in your activity it means you are overriding the default behavior of backButton as onBackPressed() method gets called when you press back button.\t Now whether to create a single instance of activity or not depends on your requirement, for e.g. splash screen can be made of a single Instance as it will be visible only once during start of app and there is no need to keep this activity in back stack. The activity you are going to use very often should not be single Instanced otherwise a rare activity can be made a single Instance.<br><br>" +
                    "onActivityResult" +
                    "saveInstanceState\t It's used when the Activity is forcefully terminated by the OS (ex: when your Activity is in the background and another task needs resources). When this happens, onSaveInstanceState(Bundle outstate) will be called and it's up to your app to add any state data you want to save in outstate.When the user resumes your Activity, onCreate(Bundle savedInstanceState) gets called and savedInstanceState will be non-null if your Activity was terminated in a scenario described above. Your app can then grab the data from savedInstanceState and regenerate your Activity's state to how it was when the user last saw it. Basically in onCreate, when savedInstanceState is null, then it means this is a 'fresh' launch of your Activity. And when it's non-null (if your app saved the data in onSaveInstanceState(...), it means the Activity state needs to be recreated."));
            topics.add(new Topic(19, "Fragment", "Lifecycle<br>onAttach\tonCreate()\tonCreateView()\tonActivityCreated\tonStart\tonResume\tonPause()\tonStop\tonDestroyView\tonDestroy\tonDetach"));
            topics.add(new Topic(20, "Services", "How it allows binding<br>" +
                    "types(bound<br>A service is bound when an application component binds to it by calling bindService(). A bound service offers a client-server interface that allows components to interact with the service, send requests, get results, and even do so across processes with interprocess communication (IPC). When the last client unbinds from the service, the system destroys the service EXCEPT If the service was started by startService<br>" +
                    "<br>unbound A service is started when an application component, such as an activity, starts it by calling startService(). Once started, a service can run in the background indefinitely, even if the component that started it is destroyed.)<br>" +
                    "3 ways of implementation<br><br><br>" +
                    "IntentService is a subclass of Service that uses a worker thread to handle all start asynchronous requests (expressed as Intents) on demand, one at a time. Clients send requests through startService(Intent) calls; the service is started as needed, handles each Intent in turn using a worker thread, and stops itself when it runs out of work.<br><br><br>"));
            topics.add(new Topic(21, "Content provider", "Content providers let you centralize content in one place and have many different applications access it as needed. A content provider behaves very much like a database where you can query it, edit its content, as well as add or delete content using insert(), update(), delete(), and query() methods. In most cases this data is stored in an SQlite database.<br>" +
                    "Example\tpublic class My Application extends  ContentProvider {}"));
            topics.add(new Topic(22, "Broadcast Receiver", "Types(send,send ordered, send sticky)<br>" +
                    "Types :- Local,Normal,Ordered and Sticky<br>" +
                    "<br>" +
                    "Normal Broadcast<br>" +
                    "<br>" +
                    ":- use sendBroadcast()<br>" +
                    "<br>" +
                    ":- asynchronous broadcast<br>" +
                    "<br>" +
                    ":- any receiver receives broadcast not any particular order<br>" +
                    "<br>" +
                    "Ordered Broadcast<br>" +
                    "<br>" +
                    ":- use sendOrderedBroadcast()<br>" +
                    "<br>" +
                    ":- synchronous broadcast<br>" +
                    "<br>" +
                    ":- receiver receives broadcast in priority base<br>" +
                    "<br>" +
                    ":- we can also simply abort broadcast in this type<br>" +
                    "<br>" +
                    "Local Broadcast<br>" +
                    "<br>" +
                    ":- use only when broadcast is used only inside same process<br>" +
                    "<br>" +
                    "Sticky Broadcast<br>" +
                    "<br>" +
                    ":- normal broadcast intent is not available any more after is was send and processed by the system.<br>" +
                    "<br>" +
                    ":- use sendStickyBroadcast(Intent)<br>" +
                    "<br>" +
                    ":- the corresponding intent is sticky, meaning the intent you are sending stays around after the broadcast is complete.<br>" +
                    "<br>" +
                    ":- because of this others can quickly retrieve that data through the return value of registerReceiver(BroadcastReceiver, IntentFilter).<br>" +
                    "<br>" +
                    ":- apart from this same as sendBroadcast(Intent)."));
            topics.add(new Topic(23, "Manifest", "action : Declares the intent action accepted, in the name attribute. The value must be the literal string value of an action, not the class constant.<br>" +
                    "category: Declares the intent category accepted, in the name attribute. The value must be the literal string value of an action, not the class constant.<br>" +
                    "android:name The name of the action. Some standard actions are defined in the Intent class as ACTION_string constants. To assign one of these actions to this attribute, prepend \"android.intent.action.\" to the string that follows ACTION_."));
            topics.add(new Topic(24, "Permissions", "internal vs external"));
            topics.add(new Topic(25, "sensors", ""));
            topics.add(new Topic(26, "intent filters", "Specifies the types of intents that an activity, service, or broadcast receiver can respond to. An intent filter declares the capabilities of its parent component — what an activity or service can do and what types of broadcasts a receiver can handle.<br>An intent filter is an expression in an app's manifest file that specifies the type of intents that the component would like to receive.<br>" +
                    "<br>" +
                    "When you create an implicit intent, the Android system finds the appropriate component to start by comparing the contents of the intent to the intent filters declared in the manifest file of other apps on the device. If the intent matches an intent filter, the system starts that component and delivers it the Intent object.<br>" +
                    "<br><activity android:name=”.HelloWorld”<br>" +
                    "    android:label=”@string/app_name”><br>" +
                    "    <intent-filter><br>" +
                    "        <action android:name=”android.intent.action.VIEW”/><br>" +
                    "        <category android:name=”android.intent.category.DEFAULT”/><br>" +
                    "        <category android:name=”android.intent.category.BROWSABLE”/><br>" +
                    "        <data android:scheme=”http” android:host=”androidium.org”/><br>" +
                    "    </intent-filter><br>" +
                    "</activity>"));
            topics.add(new Topic(27, "loader", "Loaders run on separate threads to prevent janky or unresponsive UI.<br>" +
                    "Loaders simplify thread management by providing callback methods when events occur.<br>" +
                    "Loaders persist and cache results across configuration changes to prevent duplicate queries.<br>" +
                    "Loaders can implement an observer to monitor for changes in the underlying data source. For example, CursorLoader automatically registers a ContentObserver to trigger a reload when data changes.<br>"));
            topics.add(new Topic(28, "Data", "Store/transfer data<br>" +
                    "persistent vs transient objects<br>Persistent means that the object has been saved to the database whereas transient means that it hasn't been saved yet. So for example when you get an entity from a repository, that entity is persistent. When you create a new entity, it is transient until persisted.<br>" +
                    "<br>" +
                    "a) These terms are more affiliated with ORMs than they are with DDD so they apply to anything that is not DDD. Within DDD persisted/transient apply to entities and aggregate roots because these are the objects that are persisted with repositories.<br>" +
                    "<br>" +
                    "b) No, DTOs are designed to carry data across process boundaries and don't have a life-cycle that objects that you wish to persist to a database do.<br>" +
                    "<br>" +
                    "c) No because value objects don't have an identity and can only be persisted as part of an entity or aggregate root. A value object is just a value, sort like 1 is a integer value and it doesn't make sense to speak about whether it is persisted or not.<br>" +
                    "large objects"));
            topics.add(new Topic(29, "putExtras() vs setData()", "setData() is used to point to the location of a data object (like a file for example), while putExtra() adds simple data types (such as an SMS text string for example).<br>" +
                    "<br>File fileToShare = new File(\"/sdcard/somefile.dat\");<br>" +
                    "Intent i = new Intent();<br>" +
                    "i.setAction(Intent.ACTION_SEND);<br>" +
                    "i.setData(Uri.fromFile(fileToShare));<br>" +
                    "startActivity(i);<br>Intent i = new Intent();<br>" +
                    "i.setAction(Intent.ACTION_SEND);<br>" +
                    "string textBodyString = \"some text\";<br>" +
                    "i.putExtra(Intent.EXTRA_TEXT, textBodyString);<br>" +
                    "i.setType(HTTP.PLAIN_TEXT_TYPE);"));
            topics.add(new Topic(30, "AsyncTask vs AsyncHandler vs AsyncLoader", "No. of threads for each<br>" +
                    "AsyncTaskLoader performs the same function as the AsyncTask, but a bit better. It can handle Activity configuration changes more easily, and it behaves within the life cycles of Fragments and Activities. The nice thing is that the AsyncTaskLoader can be used in any situation that the AsyncTask is being used. Anytime data needs to be loaded into memory for the Activity/Fragment to handle, The AsyncTaskLoader can do the job better.<br>" +
                    "<br>" +
                    "There are a few issues with using AsyncTasks, though:<br>" +
                    "<br>" +
                    "Configuration changes can mess things up<br>" +
                    "Pausing an activity doesn’t pause the AsyncTask<br>" +
                    "A fair amount of boilerplate code (which means more possible errors)<br><br><br>" +
                    "http://www.vogella.com/tutorials/AndroidBackgroundProcessing/article.html"));
            topics.add(new Topic(31, "Retrofit vs volley", "load balancing<br>" +
                    "multiple url<br><br>" +
                    "1) Request Execution<br>" +
                    "One of the most important factors effecting the code complexity is, how a request is executed in your code. In background or in foreground? As you may know that Android OS does not allow the network interaction on main thread, it throws a NetworkOnMainThreadException. To avoid this you may need to do all the network processing in background. As a matter of fact both Android Volley and Retrofit support the background requests. Also both of them are designed in a way, that you may not have to write huge amounts of code to perform such requests. Although if you wish to do a request in foreground, even that it possible in both. As there are situations when you may want to block user from going further ahead in your app until a response is captured from web API.<br>" +
                    "<br>" +
                    "2) In-Built Request Types<br>" +
                    "The data returned from a web service always complicates the implementation, but thankfully now with help of these libraries almost all types of responses can be captured. Android Volley can capture four types of responses automatically through these requests:<br>" +
                    "<br>" +
                    "StringRequest – Make this type of request and the returned data is parsed and converted in to a String.<br>" +
                    "JsonObjectRequest – This type of request converts the response in to a JSONObject.<br>" +
                    "JsonArrayRequest – Make this type of request and response is automatically converted into a JSONArray.<br>" +
                    "ImageRequest – This type of request converts the response into a decoded bitmap automatically.<br>" +
                    "On the other hand Retrofit can parse many other types of responses automatically like:<br>" +
                    "<br>" +
                    "Boolean – Web API response needs to be a String boolean.<br>" +
                    "Integer – Web API response needs to be an integer.<br>" +
                    "Date– Web API response should be Long format date.<br>" +
                    "String – Web API response needs to be in String format.<br>" +
                    "Object – Web API response needs to be in Json object.<br>" +
                    "Collections – Web API response needs to be in a String Format.<br>" +
                    "Now when comparing Android Volley vs Retrofit, volley may have image parsing feature but it cannot convert a Json object directly into a POJO (Plain Old Java Object). On the other hand retrofit can automatically convert a JSON object into a POJO, but lacks image parsing.<br>" +
                    "<br>" +
                    "3) Retry Mechanism<br>" +
                    "One of the great things about volley is that it supports retries on request timeout. While creating requests with volley, we can set a retry policy by using setRetryPolicy method. By default a volley request timeout time is set to 5 seconds. But if you wish to change the policy, it supports that too. You can specify these parameters according to your needs:<br>" +
                    "<br>" +
                    "Timeout<br>" +
                    "Number Of Retries<br>" +
                    "Back Off Multiplier<br>" +
                    "Retrofit on the other hand does not have a retry mechanism as of now. Although I just saw their road map for 2.0 version, they might have a retry mechanism then. Therefore as of now when comparing Android Volley vs Retrofit, Retrofit loses this one.<br>" +
                    "<br>" +
                    "4) Caching<br>" +
                    "Android Volley library has a very elaborate caching mechanism. This is one of the best features of volley. When a request is made through volley first it is checked in the cache. If an appropriate response is present in cache then it is parsed and returned directly to main thread, else a network request is made. This whole functionality can be customized, to support your requirements. If you wish to learn more about it please go through this document.<br>" +
                    "<br>" +
                    "Retrofit on the hand, does not support caching. Although it can implement RFC 2616 caching which is the spec for HTTP caching, through the OkHttpClient. As stated in this document. Therefore when comparing caching between Android Volley and Retrofit, Volley takes this one too.<br>" +
                    "<br>" +
                    "5) Loading Images<br>" +
                    "Volley library has a special type of request to get images from network called ImageRequest. When this type of request is made, response is captured as a bitmap. Also it supports the resizing of returned image in the worker thread itself, which saves a lot of coding. Volley also has a NetworkImageView class which can be used with ImageLoader class, to automatically load images, whenever the NetworkImageView appears. Read this tutorial for more information about it.<br>" +
                    "<br>" +
                    "As of now Retrofit does not support the loading of images, the way they are loaded in Volley. But it can be combined with OkHttpClient to support the loading of images. Hence volley takes this one too.<br>" +
                    "<br>" +
                    "6) Code Complexity<br>" +
                    "Both the libraries Android Volley and Retrofit are very easy to implement. If you compare them with primitive ways of accessing a web API, both of them would come out as a winner as they can phenomenally reduce your code base. But in my opinion when you compare the Android Volley vs Retrofit, the later one- Retrofit wins this one. As there is not much to customize in Retrofit. Its a simple yet powerful library. Volley on the other hand is highly customizable and has a greater code complexity."));
            topics.add(new Topic(32, "Picasso vs glide vs fresco vs universal image loader", "<br>" +
                    "51<br>" +
                    "down vote<br>" +
                    "Fresco sources | off site<br>" +
                    "stackoverflow documentation<br>" +
                    "(-)<br>" +
                    "- Huge size of library<br>" +
                    "- No Callback with View, Bitmap parameters<br>" +
                    "- SimpleDraweeView doesn't support wrap_content<br>" +
                    "- Huge size of cache<br>" +
                    "(+)<br>" +
                    "- Pretty fast image loader (for small && medium images)<br>" +
                    "- A lot of functionality(streaming, drawing tools, memory management, etc)<br>" +
                    "- Possibility to setup directly in xml (for example round corners)<br>" +
                    "- GIF support<br>" +
                    "- WebP support<br>" +
                    "<br>" +
                    "<br>" +
                    "Picasso sources | off site<br>" +
                    "stackoverflow documentation<br>" +
                    "(-)<br>" +
                    "- Slow loading big images from internet into ListView<br>" +
                    "(+)<br>" +
                    "- Tinny size of library<br>" +
                    "- Small size of cache<br>" +
                    "- Simple in use<br>" +
                    "- UI is not freeze<br>" +
                    "- WebP support<br>" +
                    "<br>" +
                    "<br>" +
                    "Glide sources<br>" +
                    "stackoverflow documentation <br>" +
                    "(-)<br>" +
                    "- Big size of library<br>" +
                    "(+)<br>" +
                    "- Tinny size of cache<br>" +
                    "- Simple in use<br>" +
                    "- GIF support<br>" +
                    "- WebP support<br>" +
                    "- Fast loading big images from internet into ListView<br>" +
                    "- UI is not freeze<br>" +
                    "- BitmapPool to re-use memory and thus lesser GC events"));
            topics.add(new Topic(33, "assert", "where is it used"));
            topics.add(new Topic(34, "native android actions", ""));
            topics.add(new Topic(35, "UI components", "Containers(Linear,recycler, frame,...)<br>" +
                    "Edittext(active component)<br>" +
                    "Button(What detects user click and taps)"));
            topics.add(new Topic(36, "Significance of xml based layouts", "The use of XML-based layouts provides a consistent and somewhat standard means of setting GUI definition format. In common practice, layout details are placed in XML files while other items are placed in source files."));
            topics.add(new Topic(37, "Android Exceptions", "OutOfMemoryError, Application Not Responding, NullPointerException, StackOverflowError, "));
            topics.add(new Topic(38, "Localization", "How to achieve it. -fr -en etc values"));
            topics.add(new Topic(39, "Kinds of log", "Debugger and debugger configuration"));
            topics.add(new Topic(40, "Binder vs serial vs parcel", "Serializable is a standard Java interface. You simply mark a class Serializable by implementing the interface, and Java will automatically serialize it in certain situations.<br>" +
                    "<br>" +
                    "Parcelable is an Android specific interface where you implement the serialization yourself. It was created to be far more efficient that Serializable, and to get around some problems with the default Java serialization scheme.<br>" +
                    "<br>" +
                    "I believe that Binder and AIDL work with Parcelable objects.<br>" +
                    "<br>" +
                    "However, you can use Serializable objects in Intents.<br>This class is just a basic IPC primitive; it has no impact on an application's lifecycle, and is valid only as long as the process that created it continues to run. To use this correctly, you must be doing so within the context of a top-level application component (a Service, Activity, or ContentProvider) that lets the system know your process should remain running.<br>derive directly from Binder to implement your own custom RPC protocol or simply instantiate a raw Binder object directly to use as a token that can be shared across processes."));
            topics.add(new Topic(41, "NDK", "NDK vs SDK<br>The only reasons to use the NDK as far as I know is to squeeze extra performance out of your application and get closer to the bare metal. If you don't need to do either of these things, you should probably stay away from the NDK.<br>" +
                    "<br>" +
                    "Also note that the Dalvik VM already has some pretty awesome performance and comparatively simpler."));
            topics.add(new Topic(42, "Java GC in android", "takes twice to thrice size of ram"));
            topics.add(new Topic(43, "Qualifiers", ""));
            topics.add(new Topic(44, "Locale", ""));
            topics.add(new Topic(45, "MCC Vs MNC", ""));
            topics.add(new Topic(46, "Deeplink", ""));
            topics.add(new Topic(47, "Geofence", ""));
            topics.add(new Topic(48, "Google Play Services", "Find length, nearest points etc"));
            topics.add(new Topic(49, "Material UI", "Coordinator Layout...<br>," +
                    "Fab button"));

            topics.add(new Topic(0, "Java", ""));

            topics.add(new Topic(0, "SQL/SQLITE", "abs(X)<br>" +
                    "changes()<br>" +
                    "char(X1,X2,...,XN)<br>" +
                    "coalesce(X,Y,...)<br>" +
                    "glob(X,Y)<br>" +
                    "hex(X)<br>" +
                    "ifnull(X,Y)<br>" +
                    "instr(X,Y)<br>" +
                    "last_insert_rowid()<br>" +
                    "length(X)<br>" +
                    "like(X,Y)<br>" +
                    "like(X,Y,Z)<br>" +
                    "likelihood(X,Y)<br>" +
                    "likely(X)<br>" +
                    "load_extension(X)<br>" +
                    "load_extension(X,Y)<br>" +
                    "lower(X)<br>" +
                    "ltrim(X)<br>" +
                    "ltrim(X,Y)<br>" +
                    "max(X,Y,...)<br>" +
                    "min(X,Y,...)<br>" +
                    "nullif(X,Y)<br>" +
                    "printf(FORMAT,...)<br>" +
                    "quote(X)<br>" +
                    "random()<br>" +
                    "randomblob(N)<br>" +
                    "replace(X,Y,Z)<br>" +
                    "round(X)<br>" +
                    "round(X,Y)<br>" +
                    "rtrim(X)<br>" +
                    "rtrim(X,Y)<br>" +
                    "soundex(X)<br>" +
                    "sqlite_compileoption_get(N)<br>" +
                    "sqlite_compileoption_used(X)<br>" +
                    "sqlite_source_id()<br>" +
                    "sqlite_version()<br>" +
                    "substr(X,Y)<br>" +
                    "substr(X,Y,Z)<br>" +
                    "total_changes()<br>" +
                    "trim(X)"));

            topics.add(new Topic(0, "Version Control", "Git, SVN<br><br>Git has a 'clean' command. SVN desperately needs this command, considering how frequently it will dump extra files on your disk.<br>" +
                    "Git has the 'bisect' command. It's nice.<br>" +
                    "SVN creates .svn directories in every single folder (Git only creates one .git directory). Every script you write, and every grep you do, will need to be written to ignore these .svn directories. You also need an entire command (\"svn export\") just to get a sane copy of your files.<br>" +
                    "In SVN, each file & folder can come from a different revision or branch. At first, it sounds nice to have this freedom. But what this actually means is that there is a million different ways for your local checkout to be completely screwed up. (for example, if \"svn switch\" fails halfway through, or if you enter a command wrong). And the worst part is: if you ever get into a situation where some of your files are coming from one place, and some of them from another, the \"svn status\" will tell you that everything is normal. You'll need to do \"svn info\" on each file/directory to discover how weird things are. If \"git status\" tells you that things are normal, then you can trust that things really are normal.<br>" +
                    "You have to tell SVN whenever you move or delete something. Git will just figure it out.<br>" +
                    "Ignore semantics are easier in Git. If you ignore a pattern (such as *.pyc), it will be ignored for all subdirectories. (But if you really want to ignore something for just one directory, you can). With SVN, it seems that there is no easy way to ignore a pattern across all subdirectories.<br>" +
                    "Another item involving ignore files. Git makes it possible to have \"private\" ignore settings (using the file .git/info/exclude), which won't affect anyone else."));

            topics.add(new Topic(0, "Terms", "Web scraping<br>" +
                    "Android studio vs Eclipse<br>" +
                    "Gradle<br>" +
                    ""));

            topics.add(new Topic(0, "React/javascript", "https://www.codementor.io/reactjs/tutorial/5-essential-reactjs-interview-questions"));

            topics.add(new Topic(0, "Design Patterns", "MVC VS MVP<br>" +
                    "Eventbus"));

            topics.add(new Topic(0, "B2C, B2B and B2E domain", ""));

            topics.add(new Topic(0, "Ques", "How to do secure frm xss attacks in webview.   How to disallow users from sqlite access.	Proguard safe, debug safe"));

topics.add("You need to override onSaveInstanceState(Bundle savedInstanceState) and write the application state values you want to change to the Bundle parameter like this:

@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
  super.onSaveInstanceState(savedInstanceState);
  // Save UI state changes to the savedInstanceState.
  // This bundle will be passed to onCreate if the process is
  // killed and restarted.
  savedInstanceState.putBoolean("MyBoolean", true);
  savedInstanceState.putDouble("myDouble", 1.9);
  savedInstanceState.putInt("MyInt", 1);
  savedInstanceState.putString("MyString", "Welcome back to Android");
  // etc.
}
The Bundle is essentially a way of storing a NVP ("Name-Value Pair") map, and it will get passed in to onCreate() and also onRestoreInstanceState() where you'd extract the values like this:

@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
  super.onRestoreInstanceState(savedInstanceState);
  // Restore UI state from the savedInstanceState.
  // This bundle has also been passed to onCreate.
  boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
  double myDouble = savedInstanceState.getDouble("myDouble");
  int myInt = savedInstanceState.getInt("MyInt");
  String myString = savedInstanceState.getString("MyString");
}")


            return topics;
        }

        @Override
        protected void onPostExecute(List<Topic> topics) {
            super.onPostExecute(topics);
            initList(topics);
        }
    }
}

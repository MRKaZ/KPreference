# KPreference, Simple SharedPreference Library!
[![](https://jitpack.io/v/MRKaZ/KPreference.svg)](https://jitpack.io/#MRKaZ/KPreference) ![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg) 
![API](https://img.shields.io/badge/KPreference-v1.0-blueviolet) ![API](https://shields.io/badge/license-Apache%202-blue)


<div align="center">
	<img src="app/src/main/ic_launcher-playstore.png" width="128">
</div>


## Prerequisites

Add this in your root `build.gradle` file (**not** in your `build.gradle.app` add it into your module `build.gradle` file):

```gradle
allprojects {
      repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file:

```gradle
dependencies {
      ...  
    implementation 'com.github.MRKaZ:KPreference:1.0'

}
```

## Usage

KPreference Library uses Simple SharedPreference Database to perform actions, Simply you can use the as normally, 😀😉

**To Save Data**
- **Put - Int, String, Boolean, Float, Long, Object, Object List**

**To Retrieve Data from the Database**
- **Get - Int, String, Boolean, Float, Long, Object, Object List**

- **#Extra - ``ClearSession``, ``DeleteValue``, Check if ``IsKeyExists`` already exists**

Simply introduce the KPreference library `onCreate` to initiate the Preference Database,

```java
public class YOUR_ACTIVITY extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {

      // KPreference.Initiate(YOUR_CONTEXT)
      KPreference.Initiate(this);
      
      }
}
```

Save Value's with your Key's, Use **Put** statement in **KPreference**,

```java

      // Save Data in Database
      // Put Int Value
      KPreference.getInstance().PutInt(Your_Key, Your_Value);
      // Put String Value
      KPreference.getInstance().PutString(Your_Key, Your_Value);
      // Put Boolean Value
      KPreference.getInstance().PutBoolean(Your_Key, Your_Value);
      // Put Float Value
      KPreference.getInstance().PutFloat(Your_Key, Your_Value);
      // Put Long Value
      KPreference.getInstance().PutLong(Your_Key, Your_Value);
      // Put Object Value
      KPreference.getInstance().PutObject(Your_Key, Your_Value);
      // Put ObjectsList Value
      KPreference.getInstance().PutObjectsList(Your_Key, Your_Value);

```

Retrieving Value's with your Key's, Use **Get** statement in **KPreference**,

```java 
      // Receive Data from the Database
      // Get Int Value
      KPreference.getInstance().GetInt(Your_Key, Your_Value);
      // Get String Value
      KPreference.getInstance().GetString(Your_Key, Your_Value);
      // Get Boolean Value
      KPreference.getInstance().GetBoolean(Your_Key, Your_Value);
      // Get Float Value
      KPreference.getInstance().GetFloat(Your_Key, Your_Value);
      // Get Long Value
      KPreference.getInstance().GetLong(Your_Key, Your_Value);
      // Get Object Value
      KPreference.getInstance().GetObject(Your_Key, Your_Value);
      // Get ObjectsList Value
      KPreference.getInstance().GetObjectsList(Your_Key, Your_Value);

```
**#Extra**,

```java
      // #Extra

      // Clear Session to Clear all the Key's & Value's,
      // Simply Clearing Database
      KPreference.getInstance().ClearSession();

      // Remove Value's by the Key
      KPreference.getInstance().DeleteValue(Your_Key);

      // To Check the Key if Already Exists Ose boolean and Your Key Name
      boolean isExists = KPreference.getInstance().IsKeyExists(KeyAge);

      if (isExists){

            // Do Something Here If Key Already Exists

      } else {

            // Do Something Here If Not Exists
      }

```

## Preview

**Quick Preview GIF**

<div align="center">
	<img src="https://github.com/MRKaZ/KPreference/blob/master/Preview/GIF.gif">
</div>


## License 
This Open Source is available under the **Apache 2.0 ** LICENSE.
![API](https://shields.io/badge/license-Apache%202-blue)

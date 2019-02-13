# Album Project

[![Build Status](https://travis-ci.org/anfederico/Clairvoyant.svg?branch=master)](https://travis-ci.org/anfederico/Clairvoyant)

## Basic Overview

 This app will download a list of albums that can be accessed using an HTTP REST API. The endpoint for this exercise is located at https://static.leboncoin.fr/img/shared/technical-test.json.
 
 ![](header.png)

## Implemented Features
- Download a list of albums using a http request and displaying it in a recyclerview

## App Architecture

Here is an architecture diagram of the system. The first one is an overview of the components using MVVM android arch.

![alt text](https://github.com/dirceudn/Album/blob/dev/MVVM-AlbumProject.png)

## Libraries and technical decisions

### Kotlin

Kotlin has fixed many issues present in the the Java language. For example, the null references in Kotlin are controlled by the type system. Kotlin has proper function types and it has no raw types. Kotlin is less verbose in comparison to Java. 

### Room Persistence Library 
Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite. Is very easy to use.
- Database
- Entity
- DAO

### Live Data
- Some advantages of using LiveData:
  - Ensures your UI matches your data state
  - No memory leaks
  - No crashes due to stopped activities
  - Sharing resources

### RxJava

 Provides easier way to handle asynchronous operations and manages the concurrency. If you have multiples asynchronous operation in background RxJava can manage this.
 
### Retrofit 2

- Easy to connect to web-services by translating the API into Java or Kotlin.
- Easy to add Headers and request types.
- Easily Customisable, you can customise it and add say any convertors like Gson, JackSon, Moshi, Prtobuf, XML etc.
- It provides additional functionalities such as custom headers, file uploads, downloads, mocking responses (for testing).
 
### Glide

The glide library in terms of optimization is superior to picasso and still supports animated gifs.Also, because of Glide integrates with the activity life-cycle, animated GIFs are also paused in onStop() to avoid draining the battery in the background. I used the library in my app without handle with large images and loading.
#### Some features that Glide support but not Picasso:
* Animated GIF support
* Thumbnail support
* Configurations & Customization


```java
 //TODO implements the GlideImageLoader to handle with large images, progress and cache.
        Glide.with(this)
                .load(Objects.requireNonNull(imageNode).getUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
```

### Dependency Injection

I prefer using Dagger 2 for dependency injection in complex projects. But with the small or a simple projects Dagger 2 is not mandatory. 

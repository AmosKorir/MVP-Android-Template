# MVP-Android-Template with Clean Architecture

Android Template Using MVP with clean Architecture.
The application has the following modules

**app**

This is the top module that contains all the ui components of the application and android related refeatures

**Presenters**

This a module all the bussiness logics. The presentes help to update the UI views with the app module.
Using Dagger 2, the presenters are injected to the app module.

**data**

This is the data source module, that has data repositories. It handles data from both the local storage managed with Room and API data managed with Retrofit.

**domain**

This module contains the use-case, the model classes used accoss all the modules of the application. Global util classes are also included within this module.

**The following libraries have been used**

1. RXjava
2. Dagger2
3. Room
4. Retrofit
5. Stetho
6. ButterKnife

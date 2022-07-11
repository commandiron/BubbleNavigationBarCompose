# BubbleNavigationBarCompose

## How it looks

<img src="https://user-images.githubusercontent.com/50905347/178168860-a312f8bb-d179-48f1-9d8c-16026763d622.png" width="250" height="530">

## Setup
1. Open the file `settings.gradle` (it looks like that)
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // add jitpack here 👇🏽
        maven { url 'https://jitpack.io' }
       ...
    }
} 
...
```
2. Sync the project
3. Add dependency
```groovy
dependencies {
        implementation 'com.github.commandiron:BubbleNavigationBarCompose:1.0'
}
```

## Usage
```kotlin  
Boş
```

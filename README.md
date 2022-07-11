# BubbleNavigationBarCompose

## How it looks

<img src="https://user-images.githubusercontent.com/50905347/178169542-c3b8a85f-d068-4b51-b595-30365f932dd5.png" width="596" height="300">

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
BubbleNavigationBar{
    navigationItems.forEach { navigationItem ->
        BubbleNavigationBarItem(
            selected = currentRoute == navigationItem.route,
            onClick = {},
            icon = navigationItem.icon,
            title = navigationItem.title,
            selectedColor = navigationItem.selectedColor
        )
    }
}
```

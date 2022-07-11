# BubbleNavigationBarCompose

## How it looks

<img src="https://user-images.githubusercontent.com/50905347/176656028-735c1557-9a0f-459c-ae18-42e8791f841c.gif" width="250" height="530">

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
val items by remember { mutableStateOf(listOf("item 1", "item 2", "item 3")) }

OutlinedDropDownMenu(
    label = "label",
    items = items,
    unit = " unit",
    onSelect = {
        //SelectedItem
    }
)
```

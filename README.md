# AndroidJetpackMyDebut

Here is my debut on android jetpack, recyclerview, in using api.

Theme : Find a theater around you, search the theater you want, and find the film's shows of your favorite theaters.

My Android debut (Quiz App) : https://github.com/Thomas-Julien-SAHUT/Android_debut

Android App with Kotlin (incomplete) : https://github.com/Thomas-Julien-SAHUT/MyTheaterApp

Android App with Java (complete) : https://github.com/Thomas-Julien-SAHUT/MyTheaterJava

# What I know from RecyclerView : 
RecyclerView facilitates the efficient display of large data sets.
We provide the data and give the appearance of each item.
The RecyclerView library dynamically creates items when they are needed.

What does a RecyclerView recycle?
RecyclerView recycles these items.
When an item scrolls off the screen, RecyclerView does not destroy its view.
Instead, RecyclerView reuses the view for new items that need to scroll across the screen.
Reusing the view improves the performance and responsiveness of the application and therefore reduces energy consumption.

# RecylerView VS ListView : 

RecyclerView was created as an improvement of ListView, one can create an attached list with the ListView control, but using RecyclerView is simpler because it:

 - Reuse cells by scrolling up / down this is possible with the ViewHolder implementation in the ListView adapter, but it was optional, whereas in RecycleView this is the default way to write the adapter.

 - Splits the list from its container so that you can easily place list items at runtime in the different containers with the LayoutManager parameter.
 
 - In the case of ListViews, dynamically decorating elements like adding borders or separators has never been easy.
But in the case of RecyclerView, the RecyclerView.ItemDecorator class gives developers full control but makes things a bit longer and more complex.

 - Intercepting clicks on a ListView item was easy, thanks to its AdapterView.OnItemClickListener interface.
But the RecyclerView gives much more power and control to its developers through the RecyclerView.OnItemTouchListener but it complicates things a bit for the developer.
Simply put, the RecyclerView is much more customizable than the ListView and gives its developers a lot of control and power.

 - RecyclerView prepares the view just in front of and behind the visible entries, which is ideal if you are collecting bitmaps in the background.

The ListView assumes that there is no way to precompute or cache the size of the entries in the list,
which leads to complications when scrolling and layout.

So in conclusion, RecyclerView is a more flexible, it give us a lot of control but it's complex tool to use. Instead of the ListView which is easier to use but we have much less control on it.

![Recycler_VS_List](https://github.com/Thomas-Julien-SAHUT/JetpackDebut/blob/main/Recycler_VS_List.png)

# What I know from Jetpack : 

Jetpack is a collection of libraries that are used to collapse standard code and write code that works consistently across Android versions and devices.
Jetpack is not only a collection of libraries, we can find some guides that bring together all the good practices of the community.

Jetpack documentation : https://developer.android.com/jetpack/

Jetpack libraries release : https://developer.android.com/jetpack/androidx/versions#version-table

# API used : 

AlloCiné is a company of French origin providing online cinematographic services and information.
We can use their website to find some informations from :  movies, theaters, series, actors, director,...
I used their api : API AlloCiné v3
You can find a example of this here : https://wiki.gromez.fr/dev/api/allocine_v3

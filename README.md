#TitleSender​

Hey !

Here's my new API to send titles/subtitles to a player using reflections :D
If you use it, it would be nice to put my name in the credits, and say it in this thread :)

<b>Installation:</b>

This api is using the DarkBlade12's Reflection Util class:
https://github.com/DarkBlade12/Part...rkblade12/particleeffect/ReflectionUtils.java

Just add the 2 classes (TitleSender.java & ReflectionUtils.java) to your plugin.

<b>Usage:</b>

The titles and subtitles are in the minecraft Chat JSON format !

If you don't know how to use it, you may create them with the JSONString() function.

You have 3 options to use the api:

1) Send a title to a player

2) Send a subtitle to a player

3) Send a subtitle and a title to a player

<b>Other params will be needed:</b>

- fadeIn: the time in which the title/subtitle will appear in a fade effect.

- stay: thie time in which the title/subtitle will stay on the screen.

- fadeOut: the time in which the title/subtitle will disappear in a fade effect.

Important note:
The times are in ticks (1sec = 20ticks) !!!

<b>Exemple to send Title and subtitle with JSONString:</>

List<JSONPart> list = new LinkedList<JSONPart>();
  list.add(new JSONPart("Hey ", ChatColor.GREEN));
  list.add(new JSONPart("gpotter2", ChatColor.BLUE));
  list.add(new JSONPart(" !", ChatColor.DARK_AQUA));
 
  List<JSONPart> list2 = new LinkedList<JSONPart>();
  list2.add(new JSONPart("How ", ChatColor.GREEN));
  list2.add(new JSONPart("are", ChatColor.BLUE));
  list2.add(new JSONPart("you !", ChatColor.DARK_AQUA));
  TitleSender.sendTitleAndSubTitle(player, TitleSender.JSONString(list), TitleSender.JSONString(list2), 10, 60, 10);

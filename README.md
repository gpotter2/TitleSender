# TitleSender
A easy api to send titles and subtitles from bukkit/spigot with reflection !

<b>Installation:</b>

This api is using the DarkBlade12's Reflection Util class: https://github.com/DarkBlade12/ParticleEffect/blob/master/src/main/java/com/darkblade12/particleeffect/ReflectionUtils.java

Just add the 2 classes (TitleSender.java & ReflectionUtils.java) to your plugin.

<b>USAGE:</b>

You have 3 options to use it:

1) Send a title to a player

2) Send a subtitle to a player

3) Send a subtitle and a title to a player

About the JSONMessages, if you don't know how to use it, you may create them with the JSONString() function.

<b>JSONString:</b>

JsonString() is a function to combine the JSONPart text into a JSONString that you can send to the player.
A JSONPart is customizable with a String, a color and you can add a font with setParam().

<b>Usage exemple to send Title and subtitle with JSONString:</b>

    List<JSONPart> list = new LinkedList<JSONPart>();
	  list.add(new JSONPart("Hey ", ChatColor.GREEN));
	  list.add(new JSONPart("gpotter2", ChatColor.BLUE).setParam(JSONParam.BOLD, JSONParam.UNDERLINED));
	  list.add(new JSONPart(" !", ChatColor.DARK_AQUA));
	  
	  List<JSONPart> list2 = new LinkedList<JSONPart>();
	  list2.add(new JSONPart("How ", ChatColor.GREEN));
	  list2.add(new JSONPart("are", ChatColor.BLUE));
	  list2.add(new JSONPart("you !", ChatColor.DARK_AQUA));
	  TitleSender.sendTitleAndSubTitle(player, TitleSender.JSONString(list), TitleSender.JSONString(list2), 10, 60, 10);

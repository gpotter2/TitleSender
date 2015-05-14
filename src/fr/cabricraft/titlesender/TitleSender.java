/*
 *  Copyright (C) 2015 Gabriel POTTER (gpotter2)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package fr.cabricraft.batofb.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.cabricraft.batofb.util.ReflectionUtils.PackageType;

/**
 * <b>TitleSender API</b><br/>
 * <p>This API was created by @gpotter2 !</p>
 * <p>This api is using the Reflection Util class, Download it there:<br/>
 * https://github.com/DarkBlade12/ParticleEffect/blob/master/src/com/darkblade12/particleeffect/ReflectionUtils.java</p>
 * <p>
 * You are welcome to use it, modify it and redistribute it under the following conditions:
 * <ul>
 * <li>Don't claim this class as your own
 * <li>Don't remove this disclaimer
 * </ul>
 * </p>
 * 
 * @author gpotter2
 * @version 1.1
 *
 */
public class TitleSender {
	/**
	 * A util to create JSON messages.
	 * 
	 * @author gpotter2
	 *
	 */
	public static class JSONPart {
		ChatColor color;
		String string;
		/**
		 * A util to create a JSON part message, with a text and color.
		 * 
		 * @author gpotter2
		 *
		 */
		public JSONPart(String string, ChatColor color){
			if(string == null){
				new NullPointerException("The string cannot be null !").printStackTrace();
				return;
			}
			this.string = string.replaceAll("'", "").replaceAll('"'+"", "");
			if(color != null){
				this.color = color;
			} else {
				color = ChatColor.WHITE;
			}
		}
		public String getString(){
			return string;
		}
		public ChatColor getColor(){
			return color;
		}
		public String getJSONPart(){
			return "{text:'" + string + "',color:'" + color.name().toLowerCase() + "'}";
		}
		public String __INVALID__getJSONPartExtra(){
			return "{text:'" + string + "',color:'" + color.name().toLowerCase() + "',extra:[";
		}
		public boolean isValid(){
			return (string != null && color != null);
		}
	}
	
	public static String JSONString(List<JSONPart> list){
		if(list == null){
			new NullPointerException("The list cannot be null !").printStackTrace();
			return null;
		}
		if(list.size() < 1){
			new IndexOutOfBoundsException("The must contains at least 1 element !").printStackTrace();
			return null;
		}
		if(list.size() > 1){
			String result = "";
			boolean first_done = false;
			for(int i = 0; i < list.size(); i++){
				JSONPart json_part = list.get(i);
				if(!first_done){
					result = json_part.__INVALID__getJSONPartExtra();
					first_done = true;
				} else {
					if(list.size() >= (i+2)){
						result = result + json_part.__INVALID__getJSONPartExtra();
					} else {
						result = result + json_part.getJSONPart();
						for(int end = 0; end < i; end++){
							result = result + "]}";
						}
						return result;
					}
				}
			}
		} else {
			return list.get(0).getJSONPart();
		}
		return null;
	}
	
	/**
	 * Send a subtitle to a player during a specified time.
	 * 
	 * @author gpotter2
	 * 
	 * @param player The player to sent the title to
	 * @param JSONsubtitle The subtitle to set
	 * @param fadeIn The time during the title will appear (in ticks)
	 * @param stay The time during the title will stay (in ticks)
	 * @param fadeOut The time during the title will disappear (in ticks)
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	public static void sendSubTitle(Player player, String JSONsubtitle, Integer fadeIn, Integer stay, Integer fadeOut)
			throws IllegalAccessException, IllegalArgumentException,
				InvocationTargetException, NoSuchFieldException,
				SecurityException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
		if(player != null && JSONsubtitle != null){
			sendTitle(player, null, JSONsubtitle, fadeIn, stay, fadeOut);
		}  else {
			new NullPointerException("The vars: 'player' and 'JSONsubtitle' musn't be null !").printStackTrace();
		}
	}
	
	/**
	 * Send a title to a player during a specified time.
	 * 
	 * @author gpotter2
	 * 
	 * @param player The player to sent the title to
	 * @param JSONtitle The title to set
	 * @param fadeIn The time during the title will appear (in ticks)
	 * @param stay The time during the title will stay (in ticks)
	 * @param fadeOut The time during the title will disappear (in ticks)
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	public static void sendTitle(Player player, String JSONtitle, Integer fadeIn, Integer stay, Integer fadeOut)
			throws IllegalAccessException, IllegalArgumentException,
				InvocationTargetException, NoSuchFieldException,
				SecurityException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
		if(player != null && JSONtitle != null){
			sendTitle(player, JSONtitle, null, fadeIn, stay, fadeOut);
		} else {
			new NullPointerException("The vars: 'player' and 'JSONtitle' musn't be null !").printStackTrace();
		}
	}
	
	/**
	 * Send a title and a subtitle to a player during a specified time.
	 * 
	 * @author gpotter2
	 * 
	 * @param player The player to sent the title to
	 * @param JSONtitle The title to set
	 * @param JSONsubtitle The subtitle to set
	 * @param fadeIn The time during the title will appear (in ticks)
	 * @param stay The time during the title will stay (in ticks)
	 * @param fadeOut The time during the title will disappear (in ticks)
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	public static void sendTitleAndSubTitle(Player player, String JSONtitle, String JSONsubtitle, Integer fadeIn, Integer stay, Integer fadeOut)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchFieldException,
			SecurityException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
		if(player != null && JSONtitle != null && JSONsubtitle != null){
			sendTitle(player, JSONtitle, JSONsubtitle, fadeIn, stay, fadeOut);
		} else {
			new NullPointerException("The vars: 'player', 'JSONtitle' and 'JSONsubtitle' musn't be null !").printStackTrace();
		}
	}
	
	private static void sendTitle(Player player, String JSONtitle, String JSONsubtitle, Integer fadeIn, Integer stay, Integer fadeOut)
			throws IllegalAccessException, IllegalArgumentException,
				InvocationTargetException, NoSuchFieldException,
				SecurityException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
		
		Field playerConnection = ReflectionUtils.getField("EntityPlayer", PackageType.MINECRAFT_SERVER, false, "playerConnection");
		Constructor<?> packetConstructor = ReflectionUtils.getConstructor(PackageType.MINECRAFT_SERVER.getClass("PacketPlayOutTitle"));
		Method getIChatBaseComponent = ReflectionUtils.getMethod("ChatSerializer", PackageType.MINECRAFT_SERVER, "a", String.class);
		Method getHandle = ReflectionUtils.getMethod("CraftPlayer", PackageType.CRAFTBUKKIT_ENTITY, "getHandle");
		Method sendPacket = ReflectionUtils.getMethod(playerConnection.getType(), "sendPacket", PackageType.MINECRAFT_SERVER.getClass("Packet"));
		
		Class<?> enum_titleaction = PackageType.MINECRAFT_SERVER.getClass("EnumTitleAction");
		Class<?> IChatBaseComponent_class = PackageType.MINECRAFT_SERVER.getClass("IChatBaseComponent");
		
		Object JSONsubtitle_component = null;
		Object JSONtitle_component = null;
		if(JSONtitle != null){
			JSONtitle_component = getIChatBaseComponent.invoke(IChatBaseComponent_class, JSONtitle);
		} else {
			JSONtitle_component = getIChatBaseComponent.invoke(IChatBaseComponent_class, "{text:''}");
		}
		if(JSONsubtitle != null){
			JSONsubtitle_component = getIChatBaseComponent.invoke(IChatBaseComponent_class, JSONsubtitle);
		}
		
		sendPacket.invoke(playerConnection.get(getHandle.invoke(player)), instancePacket(packetConstructor, enum_titleaction.getEnumConstants()[2], null, fadeIn, stay, fadeOut));
		sendPacket.invoke(playerConnection.get(getHandle.invoke(player)), instancePacket(packetConstructor, enum_titleaction.getEnumConstants()[0], JSONtitle_component, -1, -1, -1));
		if(JSONsubtitle != null){
			sendPacket.invoke(playerConnection.get(getHandle.invoke(player)), instancePacket(packetConstructor, enum_titleaction.getEnumConstants()[1], JSONsubtitle_component, -1, -1, -1));
		}
    }
	
	private static Object instancePacket(Constructor<?> packetConstructor, Object a, Object b, Object c, Object d, Object e)
			throws InstantiationException, IllegalAccessException,
				IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		Object packet = null;
		packet = packetConstructor.newInstance();
		
		ReflectionUtils.setValue(packet, true, "a", a);
		ReflectionUtils.setValue(packet, true, "b", b);
		ReflectionUtils.setValue(packet, true, "c", c);
		ReflectionUtils.setValue(packet, true, "d", d);
		ReflectionUtils.setValue(packet, true, "e", e);
		return packet;
	}
}

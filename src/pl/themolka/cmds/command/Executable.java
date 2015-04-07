/*
 * Copyright 2015 Aleksander.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.themolka.cmds.command;

import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Aleksander
 */
public interface Executable {
	List<String> completer(CommandSender sender, String label, String[] args);
	
	void handle(CommandSender sender, String label, String[] args) throws CommandException;
	
	void handle(Player player, String label, String[] args) throws CommandException;
}

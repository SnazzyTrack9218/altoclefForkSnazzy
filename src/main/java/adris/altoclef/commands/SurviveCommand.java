package adris.altoclef.commands;

import adris.altoclef.AltoClef;
import adris.altoclef.commandsystem.Command;
import adris.altoclef.commandsystem.ArgParser;
import adris.altoclef.tasks.resources.GetItemTask;
import adris.altoclef.tasks.resources.GetBlockTask;
import adris.altoclef.tasks.resources.EquipItemTask;

public class SurviveCommand extends Command {

    public SurviveCommand() {
        super("survive", "Equips the player with essential survival items.");
    }

    @Override
    protected void call(AltoClef mod, ArgParser parser) {
        // Obtain a diamond chestplate
        mod.runUserTask(new GetItemTask("diamond_chestplate", 1));

        // Equip the diamond chestplate
        mod.runUserTask(new EquipItemTask("diamond_chestplate"));

        // Gather 20 wood logs
        mod.runUserTask(new GetBlockTask("log", 20));

        // Additional tasks can be added here
    }
}

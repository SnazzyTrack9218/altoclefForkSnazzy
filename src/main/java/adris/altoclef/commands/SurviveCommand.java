package adris.altoclef.commands;

import adris.altoclef.AltoClef;
import adris.altoclef.commandsystem.Command;
import adris.altoclef.commandsystem.ArgParser;
import adris.altoclef.tasks.survival.SurviveTask;

public class SurviveCommand extends Command {

    public SurviveCommand() {
        super("survive", "Equips the player with essential survival items.");
    }

    @Override
    protected void call(AltoClef mod, ArgParser parser) {
        mod.runUserTask(new SurviveTask(), this::finish);
    }
}

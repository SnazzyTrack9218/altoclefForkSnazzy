package adris.altoclef.commands;

import adris.altoclef.AltoClef;
import adris.altoclef.commandsystem.Command;
import adris.altoclef.commandsystem.CommandException;
import adris.altoclef.tasks.SurviveTask;

public class SurviveCommand extends Command {

    public SurviveCommand() throws CommandException {
        super("survive", "Initiates survival mode: gathers resources, food, and gear.");
    }

    @Override
    protected void call(AltoClef mod, ArgParser parser) throws CommandException {
        mod.runUserTask(new SurviveTask(), this::finish);
    }
}

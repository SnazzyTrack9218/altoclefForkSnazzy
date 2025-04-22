package adris.altoclef.commands;

import adris.altoclef.AltoClef;
import adris.altoclef.commandsystem.Arg;
import adris.altoclef.commandsystem.ArgParser;
import adris.altoclef.commandsystem.Command;
import adris.altoclef.commandsystem.CommandException;
import adris.altoclef.tasks.resources.GetItemTask;
import adris.altoclef.tasks.resources.FoodTask;
import adris.altoclef.tasks.movement.EquipTask;

public class SurviveCommand extends Command {

    public SurviveCommand() throws CommandException {
        super("survive", "Gathers essential survival items for anarchy gameplay", new Arg(String.class, "item", null, 0));
    }

    @Override
    protected void call(AltoClef mod, ArgParser parser) throws CommandException {
        String item = parser.get(String.class);
        if (item == null) {
            throw new CommandException("No item specified for survival.");
        }

        // Gather essential items
        mod.runUserTask(new GetItemTask("diamond_sword", 1), () -> {
            mod.runUserTask(new GetItemTask("diamond_pickaxe", 1), () -> {
                mod.runUserTask(new GetItemTask("diamond_axe", 1), () -> {
                    mod.runUserTask(new GetItemTask("diamond_shovel", 1), () -> {
                        mod.runUserTask(new GetItemTask("diamond_helmet", 1), () -> {
                            mod.runUserTask(new GetItemTask("diamond_chestplate", 1), () -> {
                                mod.runUserTask(new GetItemTask("diamond_leggings", 1), () -> {
                                    mod.runUserTask(new GetItemTask("diamond_boots", 1), () -> {
                                        mod.runUserTask(new GetItemTask("bucket", 1), () -> {
                                            mod.runUserTask(new GetItemTask("bread", 64), () -> {
                                                mod.runUserTask(new GetItemTask("cooked_beef", 64), () -> {
                                                    mod.runUserTask(new GetItemTask("wooden_planks", 64), () -> {
                                                        mod.runUserTask(new GetItemTask("stone", 64), () -> {
                                                            mod.runUserTask(new FoodTask(), () -> {
                                                                mod.runUserTask(new EquipTask(), this::finish);
                                                            });
                                                        });
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
    }
}

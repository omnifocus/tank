package com.shilei.dp.command;

import java.util.ArrayList;
import java.util.List;

public class UndoChain {
    private List<ICommand> commands = new ArrayList<>();
    int i = 0;
    public UndoChain add(ICommand command) {
        commands.add(command);
        i++;
        return this;
    }
//逆序
    public void doUndo() {
        if (--i >= 0) {
            commands.get(i).undo(this);
        }

    }
}

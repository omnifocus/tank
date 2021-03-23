package com.shilei.dp.command;

public interface ICommand {
    void doit();
    void undo(UndoChain chain);
}

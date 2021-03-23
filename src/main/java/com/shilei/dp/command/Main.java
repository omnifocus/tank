package com.shilei.dp.command;

public class Main {
    public static void main(String[] args) {
        ICommand insert = new InsertCommand();
        ICommand delete = new DeleteCommand();
        ICommand update = new UpdateCommand();

        UndoChain chain = new UndoChain();
        chain.add(insert).add(update).add(delete);
        insert.doit();
        update.doit();
        delete.doit();
        chain.doUndo();
    }
}

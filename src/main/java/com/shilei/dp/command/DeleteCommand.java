package com.shilei.dp.command;

public class DeleteCommand implements ICommand{
    private String str = "abc";
    private String before;
    @Override
    public void doit() {
        before = str;
        str = "";
        System.out.println(str);
    }

    @Override
    public void undo(UndoChain chain) {
        str = before;
        System.out.println(str);
        chain.doUndo();
    }
}

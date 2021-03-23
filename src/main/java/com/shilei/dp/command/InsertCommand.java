package com.shilei.dp.command;

public class InsertCommand implements ICommand{
    private String str = "a";
    private String before ;
    @Override
    public void doit() {
        before = str;
        str += "b";
        System.out.println(str);
    }

    @Override
    public void undo(UndoChain chain) {
        str = before;
        System.out.println(str);
        chain.doUndo();
    }
}

package com.shilei.dp.command;

public class UpdateCommand implements ICommand{
    String updateStr ;
    String str = "abcde";
    @Override
    public void doit() {
        updateStr = str;
        str = str.replace("a","d");
        System.out.println(str);
    }

    @Override
    public void undo(UndoChain chain) {
        str = updateStr;
        System.out.println(str);
        chain.doUndo();
    }
}

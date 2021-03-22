package com.shilei.dp.visitor;

public abstract class ComputerPart {
     void  accept(Visitor visitor) {
         visitor.visit(this);
     }
    abstract double getPrice();
}

package com.shilei.dp.visitor;

public class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();


    public void accept(Visitor visitor) {
        cpu.accept(visitor);
        memory.accept(visitor);
        board.accept(visitor);
    }


    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new Visitor() {
            @Override
            public void visit(ComputerPart computerPart) {
                System.out.println("visiting " + computerPart);
            }
        });
    }
}
